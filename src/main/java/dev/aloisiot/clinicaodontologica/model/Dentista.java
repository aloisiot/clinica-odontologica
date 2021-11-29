package dev.aloisiot.clinicaodontologica.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tb_dentistas", uniqueConstraints={@UniqueConstraint(columnNames={"matricula"})})
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome nao pode ser nulo")
    @Size(min = 2)
    private String nome;

    @NotNull(message = "Sobrenome nao pode ser nulo")
    private String sobrenome;

//    @NotNull(message = "Matricula nao pode ser nulo")
    private String matricula;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro = new Date(System.currentTimeMillis());

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
