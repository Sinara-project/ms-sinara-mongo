package com.example.mssinaramongo.auxiliares;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class CamposComRespostas {

    @Schema(description = "Rótulo exibido no campo do formulário", example = "Operador")
    private String label;

    @Schema(description = "Tipo do campo (ex: text, number ou select)", example = "select")
    private String tipo;

    @Schema(description = "Indica se o campo é obrigatório", example = "true")
    private Boolean obrigatorio;

    @Schema(
            example = "[\"Manhã\", \"Tarde\", \"Noite\"]",
            description = "Lista de opções (somente se o tipo for 'select')",
            nullable = true
    )
    private List<String> opcoes;

    @Schema(description = "Resposta", example = "Manhã")
    private String valor;

    public CamposComRespostas() {
    }

    public CamposComRespostas(String label, String tipo, Boolean obrigatorio, List<String> opcoes, String valor) {
        this.label = label;
        this.tipo = tipo;
        this.obrigatorio = obrigatorio;
        this.opcoes = opcoes;
        this.valor = valor;
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

    public Boolean getObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(Boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    public List<String> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<String> opcoes) {
        this.opcoes = opcoes;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
