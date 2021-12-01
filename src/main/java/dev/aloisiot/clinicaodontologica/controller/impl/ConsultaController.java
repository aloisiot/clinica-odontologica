package dev.aloisiot.clinicaodontologica.controller.impl;

import dev.aloisiot.clinicaodontologica.controller.ICrudController;
import dev.aloisiot.clinicaodontologica.model.Consulta;
import dev.aloisiot.clinicaodontologica.service.impl.ConsultaService;
import dev.aloisiot.clinicaodontologica.service.impl.DentistaService;
import dev.aloisiot.clinicaodontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaController extends TemplateController<Consulta>
        implements ICrudController<Consulta> {

    private PacienteService pacienteService;
    private DentistaService dentistaService;

    @Autowired
    public ConsultaController(ConsultaService service, PacienteService pacienteService, DentistaService dentistaService){
        this.setService(service);
        this.pacienteService = pacienteService;
        this.dentistaService = dentistaService;
    }

    @PostMapping("/pacienteId/{pacienteId}/dentistaId/{dentistaId}")
    public ResponseEntity criar(@PathVariable Long pacienteId, @PathVariable Long dentistaId) {
        Consulta consulta = new Consulta();
        consulta.setPaciente(pacienteService.buscarPorId(pacienteId).get());
        consulta.setDentista(dentistaService.buscarPorId(dentistaId).get());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(super.getService().criar(consulta));
    }
}
