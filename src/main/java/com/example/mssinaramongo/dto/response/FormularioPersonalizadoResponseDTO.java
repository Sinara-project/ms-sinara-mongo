package com.example.mssinaramongo.dto.response;

import com.example.mssinaramongo.auxiliares.Campo;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Objeto de resposta com dados do formulário personalizado")
public class FormularioPersonalizadoResponseDTO {

    @Schema(description = "ID único do formulário personalizado", example = "64c13ab08edf48a008793cac")
    private String id;

    @Schema(description = "ID único do criador", example = "1234")
    private Integer idEmpresa;

    @Schema(description = "Título do formulário personalizado", example = "Monitoramento referente ao dia 12/10")
    private String titulo;

    @Schema(description = "Descrição do formulário personalizado", example = "Monitoramento do time X referente ao dia 12/10")
    private String descricao;

    @Schema(type = "array",
            description = "Lista de campos do formulário",
            implementation = Campo.class)
    private List<Campo> campos;

    @Schema(type = "array",
            description = "Lista de ids de permissão",
            implementation = String.class)
    private List<String> idPermissao;

    public FormularioPersonalizadoResponseDTO(String id,
                                              Integer idEmpresa,
                                              String titulo,
                                              String descricao,
                                              List<Campo> campos,
                                              List<String> idPermissao) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.titulo = titulo;
        this.descricao = descricao;
        this.campos = campos;
        this.idPermissao = idPermissao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
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
