package dev.aloisiot.clinicaodontologica.service.impl;

import dev.aloisiot.clinicaodontologica.model.Consulta;
import dev.aloisiot.clinicaodontologica.repository.ConsultaRepository;
import dev.aloisiot.clinicaodontologica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService extends TemplateService<Consulta>
        implements IService<Consulta> {

    @Autowired
    public ConsultaService(ConsultaRepository repository){
        this.setRepository(repository);
    }
}
