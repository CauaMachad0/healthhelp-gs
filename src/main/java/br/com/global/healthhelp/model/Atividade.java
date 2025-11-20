package br.com.global.healthhelp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ATIVIDADE")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ATIVIDADE")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_REGISTRO")
    private RegistroDiario registroDiario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CATEGORIA")
    private CategoriaAtividade categoria;

    @Column(name = "INICIO", nullable = false)
    private LocalDateTime inicio;

    @Column(name = "FIM", nullable = false)
    private LocalDateTime fim;

    @Column(name = "DESCRICAO", length = 255)
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public CategoriaAtividade getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAtividade categoria) {
        this.categoria = categoria;
    }

    public RegistroDiario getRegistroDiario() {
        return registroDiario;
    }

    public void setRegistroDiario(RegistroDiario registroDiario) {
        this.registroDiario = registroDiario;
    }
}
