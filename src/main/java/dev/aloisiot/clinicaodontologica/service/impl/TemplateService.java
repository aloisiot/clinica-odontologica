package dev.aloisiot.clinicaodontologica.service.impl;

import dev.aloisiot.clinicaodontologica.service.IService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class TemplateService<T>
        implements IService<T> {

    private JpaRepository<T, Long> repository;

    public void setRepository(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public JpaRepository<T, Long> getRepository() {
        return repository;
    }

    @Override
    public T criar(T t) {
        return (T) repository.save(t);
    }

    @Override
    public T atualizar(T t) {
        return (T) repository.save(t);
    }

    @Override
    public Optional<T> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<T> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public boolean excluir(Long id) {
        try {
            repository.delete(repository.findById(id).get());
            return true;
        } catch (Exception e){
            return false;
        }
    }
}