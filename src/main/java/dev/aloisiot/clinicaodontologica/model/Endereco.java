package dev.aloisiot.clinicaodontologica.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_enderecos")
public class Endereco {

    @Id
    private Long id;
    private String rua;
    private String bairro;
    private String cidade;
    private Integer numero;
}
