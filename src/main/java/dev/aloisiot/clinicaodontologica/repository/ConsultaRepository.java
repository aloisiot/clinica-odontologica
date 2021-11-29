package dev.aloisiot.clinicaodontologica.repository;

import dev.aloisiot.clinicaodontologica.model.Consulta;
import dev.aloisiot.clinicaodontologica.model.Dentista;
import dev.aloisiot.clinicaodontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query("select c from Consulta c where c.dentista = :dentista")
    List<Consulta> findAllByDentista(@Param("dentista") Dentista dentista);

    @Query("select c from Consulta c where c.paciente = :paciente")
    List<Consulta> findAllByPaciente(@Param("paciente") Paciente paciente);
}
