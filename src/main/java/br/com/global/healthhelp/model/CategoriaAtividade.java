package br.com.global.healthhelp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORIA_ATIVIDADE")
public class CategoriaAtividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 60)
    private String nome;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
