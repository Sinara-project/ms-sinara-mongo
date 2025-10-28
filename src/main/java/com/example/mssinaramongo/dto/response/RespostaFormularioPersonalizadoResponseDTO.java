package com.example.mssinaramongo.dto.response;

import com.example.mssinaramongo.auxiliares.Resposta;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespostaFormularioPersonalizadoResponseDTO {

    @Schema(description = "ID único da resposta do formulário personalizado", example = "64c13ab08edf48a008793cac")
    private String id;

    @Schema(type = "array",
            description = "Lista de respostas do formulário",
            implementation = Resposta.class)
    private ArrayList<Resposta> respostas;

    @Schema(description = "Data da resposta", example = "2025-09-29T13:10:00.000+00:00")
    private Date data;

    @Schema(description = "ID único do formulário", example = "64c13ab08edf48a008793cac")
    private String idForm;

    @Schema(description = "ID único do operário", example = "1234")
    private Integer idOperario;

    @Schema(description = "ID único da empresa", example = "1234")
    private Integer idEmpresa;

    public RespostaFormularioPersonalizadoResponseDTO(String id,
                                                      ArrayList<Resposta> respostas,
                                                      Date data,
                                                      String idForm,
                                                      Integer idOperario,
                                                      Integer idEmpresa) {
        this.id = id;
        this.respostas = respostas;
        this.data = data;
        this.idForm = idForm;
        this.idOperario = idOperario;
        this.idEmpresa = idEmpresa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIdForm() {
        return idForm;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public Integer getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(Integer idOperario) {
        this.idOperario = idOperario;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
