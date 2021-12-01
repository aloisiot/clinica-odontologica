package dev.aloisiot.clinicaodontologica.serviceTest;

import dev.aloisiot.clinicaodontologica.model.Paciente;
import dev.aloisiot.clinicaodontologica.service.impl.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @BeforeEach
    public void instanciarPaciente(){
        Paciente paciente = new Paciente();
        paciente.setNome("Marcia");
        paciente.setSobrenome("Sa");
        pacienteService.criar(paciente);
    }

    @Test
    public void buscarPorId(){
        Long id = pacienteService.buscarTodos().get(0).getId();
        assertThat(pacienteService.buscarPorId(id)).isNotNull();
    }

    @Test
    public void criar(){
        Paciente paciente = new Paciente();
        paciente.setNome("Marcia");
        paciente.setSobrenome("Sa");

        paciente = pacienteService.criar(paciente);
        assertThat(paciente).isNotNull();
        assertThat(paciente.getId()).isNotNull();
    }

    @Test
    public void buscarTodos(){
        List<Paciente> pacientes = pacienteService.buscarTodos();
        assertThat(pacientes).isNotNull();
        assertThat(pacientes.isEmpty()).isFalse();
    }

    @Test
    public void atualizar(){
        List <Paciente> pacientes = pacienteService.buscarTodos();

        Paciente paciente = pacientes.get(pacientes.size() - 1);
        paciente.setNome("NovoNome");

        assertThat(pacienteService.atualizar(paciente).getNome()).isEqualTo("NovoNome");
    }

    @Test
    public void excluir(){
        List <Paciente> pacientes = pacienteService.buscarTodos();
        Long id = pacientes.get(pacientes.size() - 1).getId();

        pacienteService.excluir(id);
        assertThat(pacienteService.buscarPorId(id).isEmpty()).isTrue();
    }
}