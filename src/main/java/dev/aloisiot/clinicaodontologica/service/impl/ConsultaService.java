package dev.aloisiot.clinicaodontologica.service.impl;

import dev.aloisiot.clinicaodontologica.model.Consulta;
import dev.aloisiot.clinicaodontologica.model.Dentista;
import dev.aloisiot.clinicaodontologica.model.Paciente;
import dev.aloisiot.clinicaodontologica.repository.ConsultaRepository;
import dev.aloisiot.clinicaodontologica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService extends TemplateService<Consulta>
        implements IService<Consulta> {
    @Autowired
    public ConsultaService(ConsultaRepository repository){
        this.setRepository(repository);
    }

    public List<Consulta> buscarTodosPorDentista(Dentista dentista){
        ConsultaRepository repository = (ConsultaRepository) this.getRepository();
        return repository.findAllByDentista(dentista);
    }

    public List<Consulta> buscarTodosPorPaciente(Paciente paciente){
        ConsultaRepository repository = (ConsultaRepository) this.getRepository();
        return repository.findAllByPaciente(paciente);
    }
}
