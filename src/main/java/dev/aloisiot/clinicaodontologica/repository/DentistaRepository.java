package dev.aloisiot.clinicaodontologica.repository;

import dev.aloisiot.clinicaodontologica.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {
}
