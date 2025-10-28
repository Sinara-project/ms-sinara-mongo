package com.example.mssinaramongo.dto.response;

import com.example.mssinaramongo.auxiliares.CamposComRespostas;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormularioPersonalizadoComRespostasResponseDTO {
    @Schema(description = "ID único do formulário personalizado", example = "64c13ab08edf48a008793cac")
    private String id;

    @Schema(description = "ID único da empresa", example = "123")
    private Integer idEmpresa;

    @Schema(description = "Título do formulário", example = "Captação de água")
    private String titulo;

    @Schema(description = "Descrição do formulário", example = "Captação de água do dia 22/10")
    private String descricao;

    @Schema(type = "array",
            description = "Lista de campos e respostas do formulário",
            implementation = CamposComRespostas.class)
    private List<CamposComRespostas> campos;

    @Schema(type = "array",
            description = "Lista de ids de permissão",
            implementation = String.class)
    private List<String> idPermissao;

    @Schema(description = "Data da resposta", example = "2025-09-29T13:10:00.000+00:00")
    private Date data;

    @Schema(description = "ID único do operário que respondeu", example = "123")
    private Integer idOperario;

    @Schema(description = "Status do formulário", example = "true")
    private Boolean status;

    public FormularioPersonalizadoComRespostasResponseDTO(String id,
                                                          Integer idEmpresa,
                                                          String titulo,
                                                          String descricao,
                                                          List<CamposComRespostas> campos,
                                                          List<String> idPermissao,
                                                          Date data,
                                                          Integer idOperario,
                                                          Boolean status) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.titulo = titulo;
        this.descricao = descricao;
        this.campos = campos;
        this.idPermissao = idPermissao;
        this.data = data;
        this.idOperario = idOperario;
        this.status = status;
    }

    public FormularioPersonalizadoComRespostasResponseDTO() {

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

    public List<CamposComRespostas> getCampos() {
        return campos;
    }

    public void setCampos(List<CamposComRespostas> campos) {
        this.campos = campos;
    }

    public List<String> getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(List<String> idPermissao) {
        this.idPermissao = idPermissao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(Integer idOperario) {
        this.idOperario = idOperario;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
