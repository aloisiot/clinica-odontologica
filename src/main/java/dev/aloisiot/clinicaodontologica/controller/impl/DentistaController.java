package dev.aloisiot.clinicaodontologica.controller.impl;

import dev.aloisiot.clinicaodontologica.controller.ICrudController;
import dev.aloisiot.clinicaodontologica.model.Dentista;
import dev.aloisiot.clinicaodontologica.service.impl.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dentista")
public class DentistaController extends TemplateController<Dentista>
        implements ICrudController<Dentista> {

    @Autowired
    public DentistaController(DentistaService service) {
        this.setService(service);
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Dentista> buscarPorMatricula(@PathVariable String matricula){
        DentistaService service = (DentistaService) this.getService();
        return ResponseEntity.ok(service.buscarPorMatricula(matricula).orElse(null));
    }
}