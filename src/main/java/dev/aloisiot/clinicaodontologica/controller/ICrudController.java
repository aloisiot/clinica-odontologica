package dev.aloisiot.clinicaodontologica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface ICrudController<T> {
    ResponseEntity criar(T t);
    ResponseEntity atualizar(T t);
    ResponseEntity<T> buscarPorId(Long id);
    ResponseEntity<List<T>> buscarTodos();
    ResponseEntity excluirPorId(Long id);
}