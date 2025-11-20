package br.com.global.healthhelp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ATIVIDADE", schema = "RM558024")
@SequenceGenerator(
        name = "seq_atividade",
        sequenceName = "ATIVIDADE_ID_SEQ",
        allocationSize = 1,
        schema = "RM558024"
)
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade")
    @Column(name = "ATIVIDADE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTRO_ID")
    private RegistroDiario registroDiario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORIA_ID")
    private CategoriaAtividade categoria;

    @Column(name = "INICIO")
    private LocalDateTime inicio;

    @Column(name = "FIM")
    private LocalDateTime fim;

    @Column(name = "DESCRICAO")
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

