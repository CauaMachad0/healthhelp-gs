package br.com.global.healthhelp.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "REGISTRO_DIARIO")
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REGISTRO")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @Column(name = "DATA_REGISTRO", nullable = false)
    private LocalDate dataRegistro;

    @Column(name = "PONTUACAO_EQUIBRIO")
    private Integer pontuacaoEquilibrio;

    @Column(name = "OBSERVACOES", length = 500)
    private String observacoes;

    @Column(name = "CRIADO_EM", nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getPontuacaoEquilibrio() {
        return pontuacaoEquilibrio;
    }

    public void setPontuacaoEquilibrio(Integer pontuacaoEquilibrio) {
        this.pontuacaoEquilibrio = pontuacaoEquilibrio;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
