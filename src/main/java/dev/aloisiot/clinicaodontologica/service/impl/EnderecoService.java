package dev.aloisiot.clinicaodontologica.service.impl;

import dev.aloisiot.clinicaodontologica.model.Endereco;
import dev.aloisiot.clinicaodontologica.repository.EnderecoRepository;
import dev.aloisiot.clinicaodontologica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends TemplateService<Endereco>
        implements IService<Endereco> {

    @Autowired
    public EnderecoService(EnderecoRepository repository) {
        this.setRepository(repository);
    }
}
