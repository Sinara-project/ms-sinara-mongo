package com.example.mssinaramongo.auxiliares;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.mongodb.core.mapping.Field;

public class Resposta {

    @Field("campo_label")
    @Schema(description = "Nome do campo do formulário", example = "pH")
    private String campoLabel;

    @Field("campo_tipo")
    @Schema(description = "Tipo do campo do formulário", example = "number")
    private String campoTipo;

    @Schema(description = "Valor do campo do formulário", example = "7.4")
    private String valor;

    public Resposta(String campoLabel, String campoTipo, String valor) {
        this.campoLabel = campoLabel;
        this.campoTipo = campoTipo;
        this.valor = valor;
    }

    public String getCampoLabel() {
        return campoLabel;
    }

    public void setCampoLabel(String campoLabel) {
        this.campoLabel = campoLabel;
    }

    public String getCampoTipo() {
        return campoTipo;
    }

    public void setCampoTipo(String campoTipo) {
        this.campoTipo = campoTipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
