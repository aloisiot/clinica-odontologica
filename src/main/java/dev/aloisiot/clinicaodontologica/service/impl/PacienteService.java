package dev.aloisiot.clinicaodontologica.service.impl;

import dev.aloisiot.clinicaodontologica.model.Paciente;
import dev.aloisiot.clinicaodontologica.repository.PacienteRepository;
import dev.aloisiot.clinicaodontologica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService extends TemplateService<Paciente>
        implements IService<Paciente> {

    @Autowired
    public PacienteService(PacienteRepository repository) {
        this.setRepository(repository);
    }
}