package dev.aloisiot.clinicaodontologica.repository;

import dev.aloisiot.clinicaodontologica.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {

    @Query("select d from Dentista d where d.matricula = :matricula")
    Optional<Dentista> findByMatricula(@Param("matricula") String matricula);
}