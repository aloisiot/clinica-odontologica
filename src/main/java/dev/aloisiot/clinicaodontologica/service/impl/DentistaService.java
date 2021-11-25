package dev.aloisiot.clinicaodontologica.service.impl;

import dev.aloisiot.clinicaodontologica.model.Dentista;
import dev.aloisiot.clinicaodontologica.repository.DestistaRepository;
import dev.aloisiot.clinicaodontologica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistaService extends TemplateService<Dentista>
        implements IService<Dentista> {

    @Autowired
    public DentistaService(DestistaRepository repository) {
        this.setRepository(repository);
    }
}
