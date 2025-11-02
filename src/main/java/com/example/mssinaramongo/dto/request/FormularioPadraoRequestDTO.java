package com.example.mssinaramongo.dto.request;

import com.example.mssinaramongo.validation.OnCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@Schema(description = "Objeto de request com dados do formulário padrão")
public class FormularioPadraoRequestDTO {

    @NotNull(message = "O ID da empresa é obrigatório", groups = OnCreate.class)
    @Schema(description = "ID da empresa", example = "1234")
    private Integer idEmpresa;

    @NotNull(message = "A data de preenchimento é obrigatória", groups = OnCreate.class)
    @Schema(description = "Data de preenchimento", example = "2025-10-12T16:44:35.614Z")
    private Date dataPreenchimento;

    @Schema(description = "Cloro residual da água", example = "1.7")
    private double cloroResidual;

    @Schema(description = "Cor da água bruta (antes do tratamento)", example = "14")
    private int corAguaBruta;

    @Schema(description = "Cor da água tratada (após o tratamento)", example = "5")
    private int corAguaTratada;

    @Schema(description = "Nível de fluoreto da água", example = "1.3")
    private double fluoreto;

    @Schema(description = "Nível de nitrato da água", example = "5")
    private double nitrato;

    @Schema(description = "pH da água bruta (antes do tratamento)", example = "9.5")
    private double phAguaBruta;

    @Schema(description = "pH da água tratada (após o tratamento)", example = "7.5")
    private double phAguaTratada;

    @Schema(description = "Turbidez da água bruta (antes do tratamento)", example = "5")
    private double turbidezAguaBruta;

    @Schema(description = "Turbidez da água tratada (pós-tratamento)", example = "1.3")
    private double turbidezAguaTratada;

    @NotNull(message = "O ID do funcionário é obrigatório", groups = OnCreate.class)
    @Schema(description = "ID do funcionário", example = "1234")
    private Integer idOperario;

    public FormularioPadraoRequestDTO() {
    }

    // getters e setters
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Date getDataPreenchimento() {
        return dataPreenchimento;
    }

    public void setDataPreenchimento(Date dataPreenchimento) {
        this.dataPreenchimento = dataPreenchimento;
    }

    public double getCloroResidual() {
        return cloroResidual;
    }

    public void setCloroResidual(double cloroResidual) {
        this.cloroResidual = cloroResidual;
    }

    public int getCorAguaBruta() {
        return corAguaBruta;
    }

    public void setCorAguaBruta(int corAguaBruta) {
        this.corAguaBruta = corAguaBruta;
    }

    public int getCorAguaTratada() {
        return corAguaTratada;
    }

    public void setCorAguaTratada(int corAguaTratada) {
        this.corAguaTratada = corAguaTratada;
    }

    public double getFluoreto() {
        return fluoreto;
    }

    public void setFluoreto(double fluoreto) {
        this.fluoreto = fluoreto;
    }

    public double getNitrato() {
        return nitrato;
    }

    public void setNitrato(double nitrato) {
        this.nitrato = nitrato;
    }

    public double getPhAguaBruta() {
        return phAguaBruta;
    }

    public void setPhAguaBruta(double phAguaBruta) {
        this.phAguaBruta = phAguaBruta;
    }

    public double getPhAguaTratada() {
        return phAguaTratada;
    }

    public void setPhAguaTratada(double phAguaTratada) {
        this.phAguaTratada = phAguaTratada;
    }

    public double getTurbidezAguaBruta() {
        return turbidezAguaBruta;
    }

    public void setturbidezAguaBruta(double turbidezAguaBruta) {
        this.turbidezAguaBruta = turbidezAguaBruta;
    }

    public double getTurbidezAguaTratada() {
        return turbidezAguaTratada;
    }

    public void setTurbidezAguaTratada(double turbidezAguaTratada) {
        this.turbidezAguaTratada = turbidezAguaTratada;
    }

    public Integer getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(Integer idOperario) {
        this.idOperario = idOperario;
    }
}
