package com.example.mssinaramongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "notificacao")
public class Notificacao {

    @Id
    private String id;

    private Date data;

    private String mensagem;

    private String tipo;

    private String categoria;

    @Field("id_envio")
    private List<Integer> idEnvio;

    public Notificacao(String id,
                       Date data,
                       String mensagem,
                       String tipo,
                       String categoria,
                       List<Integer> idEnvio) {
        this.id = id;
        this.data = data;
        this.mensagem = mensagem;
        this.tipo = tipo;
        this.categoria = categoria;
        this.idEnvio = idEnvio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Integer> getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(List<Integer> idEnvio) {
        this.idEnvio = idEnvio;
    }
}
