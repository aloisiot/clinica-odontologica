package dev.aloisiot.clinicaodontologica.service.impl;

import dev.aloisiot.clinicaodontologica.model.Dentista;
import dev.aloisiot.clinicaodontologica.repository.DentistaRepository;
import dev.aloisiot.clinicaodontologica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DentistaService extends TemplateService<Dentista>
        implements IService<Dentista> {

    @Autowired
    public DentistaService(DentistaRepository repository) {
        this.setRepository(repository);
    }

    public Optional<Dentista> buscarPorMatricula(String matricula){
        DentistaRepository repository = (DentistaRepository) this.getRepository();
        return repository.findByMatricula(matricula);
    }
}