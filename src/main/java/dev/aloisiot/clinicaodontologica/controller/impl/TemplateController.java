package dev.aloisiot.clinicaodontologica.controller.impl;

import dev.aloisiot.clinicaodontologica.controller.ICrudController;
import dev.aloisiot.clinicaodontologica.service.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class TemplateController<T>
        implements ICrudController<T> {

    private IService<T> service;

    public void setService(IService<T> service) {
        this.service = service;
    }

    public IService<T> getService() {
        return service;
    }

    @Override
    @PostMapping
    public ResponseEntity criar(@RequestBody T t) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(t));
    }

    @Override
    public ResponseEntity atualizar(T t) {
        return ResponseEntity.ok(service.atualizar(t));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<T> buscarPorId(@PathVariable Long id) {
        Optional response = service.buscarPorId(id);
        if(response.isPresent())
            return ResponseEntity.ok((T) response.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<T>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }


    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        if(service.excluir(id))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
