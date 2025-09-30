package com.example.mssinaramobile.auxiliares;

public class Resposta {
    private String campoLabel;
    private String campoTipo;
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
