package dev.aloisiot.clinicaodontologica.serviceTest;

import dev.aloisiot.clinicaodontologica.model.Consulta;
import dev.aloisiot.clinicaodontologica.model.Dentista;
import dev.aloisiot.clinicaodontologica.model.Paciente;
import dev.aloisiot.clinicaodontologica.service.impl.ConsultaService;
import dev.aloisiot.clinicaodontologica.service.impl.DentistaService;
import dev.aloisiot.clinicaodontologica.service.impl.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ConsultaServiceTest {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    DentistaService dentistaService;

    @Autowired
    PacienteService pacienteService;

    @BeforeEach
    public void instanciarConsulta(){
        Dentista dentista = dentistaService.buscarTodos().get(0);
        Paciente paciente = pacienteService.buscarTodos().get(0);

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setDentista(dentista);

        consultaService.criar(consulta);
    }

    @Test
    public void buscarPorId(){
        Long id = consultaService.buscarTodos().get(0).getId();
        assertThat(consultaService.buscarPorId(id)).isNotNull();
    }

    @Test
    public void criar(){
        Dentista dentista = dentistaService.buscarTodos().get(0);
        Paciente paciente = pacienteService.buscarTodos().get(0);

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setDentista(dentista);

        assertThat(consultaService.criar(consulta)).isNotNull();
        assertThat(consulta.getId()).isNotNull();
    }

    @Test
    public void buscarTodos(){
        List <Consulta> consultas = consultaService.buscarTodos();
        assertThat(consultas).isNotNull();
        assertThat(consultas.isEmpty()).isFalse();
    }

    @Test
    public void atualizar(){
        Long idDentista =  dentistaService.buscarTodos().get(0).getId();
        Dentista dentista = dentistaService.buscarPorId(idDentista).get();

        Consulta consulta = consultaService.buscarTodos().get(0);
        consulta.setDentista(dentista);

        assertThat(consultaService.atualizar(consulta).getDentista().getId())
                .isEqualTo(dentista.getId());
    }

    @Test
    public void excluir(){
        List <Consulta> consultas = consultaService.buscarTodos();
        Long id = consultas.get(consultas.size() - 1).getId();

        consultaService.excluir(id);
        assertThat(consultaService.buscarPorId(id).isEmpty()).isTrue();
    }
}
