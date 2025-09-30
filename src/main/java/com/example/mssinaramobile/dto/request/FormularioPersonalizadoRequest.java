package com.example.mssinaramobile.dto.request;

import com.example.mssinaramobile.auxiliares.Pergunta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;

public class FormularioPersonalizadoRequest {

    @NotBlank(message = "O ID do criador é obrigatório")
    private String idCriador;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    private String descricao;

    @NotEmpty(message = "O formulário deve conter pelo menos uma pergunta")
    private ArrayList<Pergunta> campos;

    public FormularioPersonalizadoRequest(String idCriador,
                                          String titulo,
                                          String descricao,
                                          ArrayList<Pergunta> campos) {
        this.idCriador = idCriador;
        this.titulo = titulo;
        this.descricao = descricao;
        this.campos = campos;
    }

    public String getIdCriador() { return idCriador; }
    public void setIdCriador(String idCriador) { this.idCriador = idCriador; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public ArrayList<Pergunta> getCampos() { return campos; }
    public void setCampos(ArrayList<Pergunta> campos) { this.campos = campos; }
}
