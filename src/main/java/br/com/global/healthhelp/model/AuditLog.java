package br.com.global.healthhelp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AUDIT_LOG")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AUDIT")
    private Long id;

    @Column(name = "TABELA", nullable = false, length = 60)
    private String tabela;

    @Column(name = "OPERACAO", nullable = false, length = 10)
    private String operacao;

    @Column(name = "REGISTRO_ID")
    private Long registroId;

    @Column(name = "USUARIO_APP", length = 80)
    private String usuarioApp;

    @Column(name = "DADOS_ANTES", length = 2000)
    private String dadosAntes;

    @Column(name = "DADOS_DEPOIS", length = 2000)
    private String dadosDepois;

    @Column(name = "DATA_EVENTO", nullable = false)
    private LocalDateTime dataEvento = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDadosDepois() {
        return dadosDepois;
    }

    public void setDadosDepois(String dadosDepois) {
        this.dadosDepois = dadosDepois;
    }

    public String getDadosAntes() {
        return dadosAntes;
    }

    public void setDadosAntes(String dadosAntes) {
        this.dadosAntes = dadosAntes;
    }

    public String getUsuarioApp() {
        return usuarioApp;
    }

    public void setUsuarioApp(String usuarioApp) {
        this.usuarioApp = usuarioApp;
    }

    public Long getRegistroId() {
        return registroId;
    }

    public void setRegistroId(Long registroId) {
        this.registroId = registroId;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }
}
