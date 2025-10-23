package com.example.mssinaramongo.dto.request;

import com.example.mssinaramongo.auxiliares.Resposta;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public class RespostaFormularioPersonalizadoRequestDTO {
    @NotEmpty(message = "É origatório pelo menos 1 resposta")
    @ArraySchema(
            schema = @Schema(description = "Respostas do formulário", implementation = Resposta.class),
            arraySchema = @Schema(description = "Lista de respostas do formulário", example = "[{\"campoLabel\":\"Nome\",\"campoTipo\":\"texto\",\"valor\":João Carlos}]")
    )
    private List<Resposta> respostas;

    @NotNull(message = "A data é obrigatória")
    @Schema(description = "Data da resposta", example = "2025-09-29T13:10:00.000+00:00")
    private Date data;

    @NotBlank(message = "O ID do fomrulário é obrigatório")
    @Schema(description = "ID único do formulário", example = "64f7a1b2d3e4f5a6b7c8d9e0")
    private String idForm;

    @NotNull(message = "O ID do operário que respondeu o formulário é obrigatório")
    @Schema(description = "ID único do operário", example = "1233")
    private Integer idOperario;

    public RespostaFormularioPersonalizadoRequestDTO(List<Resposta> respostas,
                                                     Date data,
                                                     String idForm,
                                                     Integer idOperario) {
        this.respostas = respostas;
        this.data = data;
        this.idForm = idForm;
        this.idOperario = idOperario;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
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
}
