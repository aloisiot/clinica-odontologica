package dev.aloisiot.clinicaodontologica.repository;

import dev.aloisiot.clinicaodontologica.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
