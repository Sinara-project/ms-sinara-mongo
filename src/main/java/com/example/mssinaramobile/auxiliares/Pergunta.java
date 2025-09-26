package com.example.mssinaramobile.auxiliares;

public class Pergunta {
    private String label;
    private String tipo;
    private boolean obrigatorio;

    public Pergunta(String label, String tipo, boolean obrigatorio) {
        this.label = label;
        this.tipo = tipo;
        this.obrigatorio = obrigatorio;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }
}
