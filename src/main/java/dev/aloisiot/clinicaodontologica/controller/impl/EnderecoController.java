package dev.aloisiot.clinicaodontologica.controller.impl;

import dev.aloisiot.clinicaodontologica.controller.ICrudController;
import dev.aloisiot.clinicaodontologica.model.Endereco;
import dev.aloisiot.clinicaodontologica.service.impl.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController extends TemplateController<Endereco>
        implements ICrudController<Endereco> {

    @Autowired
    public EnderecoController(EnderecoService service) {
        this.setService(service);
    }
}
