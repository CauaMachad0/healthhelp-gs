package br.com.global.healthhelp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RECOMENDACAO")
public class Recomendacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECOMENDACAO")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @Column(name = "MENSAGEM", nullable = false, length = 1000)
    private String mensagem;

    @Column(name = "PONTUACAO_RELEVANCIA")
    private Integer pontuacaoRelevancia;

    @Column(name = "CRIADA_EM", nullable = false)
    private LocalDateTime criadaEm = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    public void setCriadaEm(LocalDateTime criadaEm) {
        this.criadaEm = criadaEm;
    }

    public Integer getPontuacaoRelevancia() {
        return pontuacaoRelevancia;
    }

    public void setPontuacaoRelevancia(Integer pontuacaoRelevancia) {
        this.pontuacaoRelevancia = pontuacaoRelevancia;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
