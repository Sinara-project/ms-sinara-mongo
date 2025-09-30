package com.example.mssinaramobile.dto.response;

import com.example.mssinaramobile.auxiliares.Pergunta;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormularioPersonalizadoResponse {

    private String id;
    private String idCriador;
    private String titulo;
    private String descricao;
    private ArrayList<Pergunta> campos;

    public FormularioPersonalizadoResponse(String id,
                                           String idCriador,
                                           String titulo,
                                           String descricao,
                                           ArrayList<Pergunta> campos) {
        this.id = id;
        this.idCriador = idCriador;
        this.titulo = titulo;
        this.descricao = descricao;
        this.campos = campos;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getIdCriador() { return idCriador; }
    public void setIdCriador(String idCriador) { this.idCriador = idCriador; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public ArrayList<Pergunta> getCampos() { return campos; }
    public void setCampos(ArrayList<Pergunta> campos) { this.campos = campos; }
}
