package dev.aloisiot.clinicaodontologica.serviceTest;

import dev.aloisiot.clinicaodontologica.model.Dentista;
import dev.aloisiot.clinicaodontologica.service.impl.DentistaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DentistaServiceTest {

    @Autowired
    private DentistaService dentistaService;

    @BeforeEach
    public void instanciarDentista(){
        Dentista dentista = new Dentista();
        dentista.setNome("Joao");
        dentista.setSobrenome("Junior");
        dentistaService.criar(dentista);
    }

    @Test
    public void buscarPorId(){
        Long id = dentistaService.buscarTodos().get(0).getId();
        assertThat(dentistaService.buscarPorId(id)).isNotNull();
    }

    @Test
    public void criar(){
        Dentista dentista = new Dentista();
        dentista.setNome("Joao");
        dentista.setSobrenome("Junior");

        dentista = dentistaService.criar(dentista);
        assertThat(dentista).isNotNull();
        assertThat(dentista.getId()).isNotNull();
    }

    @Test
    public void buscarTodos(){
        List <Dentista> dentustas = dentistaService.buscarTodos();
        assertThat(dentustas).isNotNull();
        assertThat(dentustas.isEmpty()).isFalse();
    }

    @Test
    public void atualizar(){
        List <Dentista >dentistas = dentistaService.buscarTodos();

        Dentista dentista = dentistas.get(dentistas.size() -1);
        dentista.setNome("NovoNome");

        assertThat(dentistaService.atualizar(dentista).getNome()).isEqualTo("NovoNome");
    }

    @Test
    public void excluir(){
        List <Dentista> dentistas = dentistaService.buscarTodos();
        Long id = dentistas.get(dentistas.size() -1).getId();

        dentistaService.excluir(id);
        assertThat(dentistaService.buscarPorId(id).isEmpty()).isTrue();
    }
}