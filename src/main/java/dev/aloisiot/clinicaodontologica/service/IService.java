package dev.aloisiot.clinicaodontologica.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IService<T> {
    T criar(T t);
    T atualizar(T t);
    Optional<T> buscarPorId(Long id);
    List<T> buscarTodos();
    boolean excluir(Long id);
}