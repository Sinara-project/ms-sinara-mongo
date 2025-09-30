package com.example.mssinaramobile.dto.request;

import com.example.mssinaramobile.auxiliares.Resposta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;

public class RespostaFormularioPersonalizadoRequest {

    @NotBlank(message = "O ID do formulário é obrigatório")
    private String formId;

    @NotBlank(message = "O ID do usuário é obrigatório")
    private String userId;

    @NotEmpty(message = "As respostas não podem estar vazias")
    private ArrayList<Resposta> respostas;

    public RespostaFormularioPersonalizadoRequest(String formId,
                                                  String userId,
                                                  ArrayList<Resposta> respostas) {
        this.formId = formId;
        this.userId = userId;
        this.respostas = respostas;
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
}
