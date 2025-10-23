package com.example.mssinaramongo.auxiliares;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Campo dinâmico de um formulário personalizado")
public class Campo {

    @Schema(description = "Rótulo exibido no campo do formulário", example = "Operador")
    private String label;

    @Schema(description = "Tipo do campo (ex: text, number ou select)", example = "select")
    private String tipo;

    @Schema(description = "Indica se o campo é obrigatório", example = "true")
    private Boolean obrigatorio;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(
            example = "[\"Manhã\", \"Tarde\", \"Noite\"]",
            description = "Lista de opções (somente se o tipo for 'select')",
            nullable = true
    )
    private List<String> opcoes;

    // Getters e Setters
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Boolean getObrigatorio() { return obrigatorio; }
    public void setObrigatorio(Boolean obrigatorio) { this.obrigatorio = obrigatorio; }

    public List<String> getOpcoes() { return opcoes; }
    public void setOpcoes(List<String> opcoes) { this.opcoes = opcoes; }
}
