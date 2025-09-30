package com.example.mssinaramobile.dto.response;

import com.example.mssinaramobile.auxiliares.Resposta;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespostaFormularioPersonalizadoResponse {

    private String id;
    private String formId;
    private String userId;
    private ArrayList<Resposta> respostas;
    private Date data;

    public RespostaFormularioPersonalizadoResponse(String id,
                                      String formId,
                                      String userId,
                                      ArrayList<Resposta> respostas,
                                      Date data) {
        this.id = id;
        this.formId = formId;
        this.userId = userId;
        this.respostas = respostas;
        this.data = data;
    }

    // getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
