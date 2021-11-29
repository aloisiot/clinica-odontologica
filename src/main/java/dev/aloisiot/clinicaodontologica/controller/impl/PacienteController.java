package dev.aloisiot.clinicaodontologica.controller.impl;

import dev.aloisiot.clinicaodontologica.controller.ICrudController;
import dev.aloisiot.clinicaodontologica.model.Paciente;
import dev.aloisiot.clinicaodontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController extends TemplateController<Paciente>
        implements ICrudController<Paciente> {

    @Autowired
    public PacienteController(PacienteService service) {
        this.setService(service);
    }

    @GetMapping("/rg/{rg}")
    public ResponseEntity<Paciente> buscarPorRg(@PathVariable String rg){
        PacienteService service = (PacienteService) this.getService();
        return ResponseEntity.ok(service.buscarPorRg(rg).orElse(null));
    }
}
