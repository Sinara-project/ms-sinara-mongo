package com.example.mssinaramongo.dto.request;

import com.example.mssinaramongo.auxiliares.Campo;
import com.example.mssinaramongo.validation.OnCreate;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "Payload de criação/atualização de um formulário personalizado")
public class FormularioPersonalizadoRequestDTO {

    @NotNull(message = "O ID do criador é obrigatório", groups = OnCreate.class)
    @Schema(description = "ID do criador", example = "1234")
    private Integer idCriador;

    @NotBlank(message = "O título é obrigatório", groups = OnCreate.class)
    @Schema(description = "Título do formulário personalizado", example = "Formulário referente ao dia 12/10")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória", groups = OnCreate.class)
    @Schema(description = "Descrição do formulário personalizado", example = "Formulário da equipe X referente ao dia 12/10")
    private String descricao;

    @NotNull(message = "Os campos não podem ser vazios", groups = OnCreate.class)
    @ArraySchema(
            schema = @Schema(description = "Campo do formulário", implementation = Campo.class),
            arraySchema = @Schema(description = "Lista de campos do formulário", example = "[{\"label\":\"Nome\",\"tipo\":\"texto\",\"obrigatorio\":true}]")
    )
    private List<Campo> campos;

    @ArraySchema(
            schema = @Schema(description = "ID de permissão individual", example = "abc123"),
            arraySchema = @Schema(description = "Lista de IDs de permissão", example = "[\"abc123\", \"def456\"]")
    )
    private List<String> idPermissao;

    public FormularioPersonalizadoRequestDTO(Integer idCriador,
                                             String titulo,
                                             String descricao,
                                             List<Campo> campos,
                                             List<String> idPermissao) {
        this.idCriador = idCriador;
        this.titulo = titulo;
        this.descricao = descricao;
        this.campos = campos;
        this.idPermissao = idPermissao;
    }

    public Integer getIdCriador() {
        return idCriador;
    }

    public void setIdCriador(Integer idCriador) {
        this.idCriador = idCriador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    public List<String> getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(List<String> idPermissao) {
        this.idPermissao = idPermissao;
    }
}