package dev.aloisiot.clinicaodontologica.repository;

import dev.aloisiot.clinicaodontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("select p from Paciente p where p.rg = :rg")
    Optional<Paciente> findByRg(@Param("rg") String rg);
}
