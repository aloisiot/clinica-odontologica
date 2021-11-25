package dev.aloisiot.clinicaodontologica.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICrudController<T> {
    ResponseEntity criar(T t);
    ResponseEntity<T> buscarPorId(Long id);
    ResponseEntity<List<T>> buscarTodos();
    ResponseEntity excluir(Long id);
}
