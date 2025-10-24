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

    @DecimalMin(value = "0.2", message ="O cloro residual deve ser maior ou igual a 0.2 mg/L")
    @DecimalMax(value = "2.0", message = "O cloro residual deve ser menor ou igual a 2.0 mg/L")
    @Schema(description = "Cloro residual da água", example = "1.7")
    private double cloroResidual;

    @Min(value = 0, message = "A cor da água deve ser maior ou igual a 0 uH")
    @Max(value = 15, message = "A cor da água deve ser maior ou igual a 15 uH")
    @Schema(description = "Cor da água bruta (antes do tratamento)", example = "14")
    private int corAguaBruta;

    @Min(value = 0, message = "A cor da água deve ser maior ou igual a 0 uH")
    @Max(value = 15, message = "A cor da água deve ser maior ou igual a 15 uH")
    @Schema(description = "Cor da água tratada (pós-tratamento)", example = "5")
    private int corAguaTratada;

    @DecimalMin(value = "0.0", message = "O valor do nitrato deve ser maior ou igual a 0,0 mg/L")
    @DecimalMax(value = "1.5", message = "O valor do fluoreto deve ser menor ou igual a 1,5 mg/L")
    @Schema(description = "Nível de fluoreto da água", example = "1.3")
    private double fluoreto;

    @DecimalMin(value = "0.0",  message = "O pH da água bruta deve ser >= 0")
    @DecimalMax(value = "10.0", message = "o valor do nitrato deve ser menor ou igual a 10 mg/L")
    @Schema(description = "Nível de nitrato da água", example = "5")
    private double nitrato;

    @DecimalMin(value = "0.0", message = "O pH deve ser maior ou igual a 0")
    @DecimalMax(value = "14.0", message = "O pH deve ser menor ou igual a 14")
    @Schema(description = "pH da água bruta (antes do tratamento)", example = "9.5")
    private double phAguaBruta;

    @DecimalMin(value = "0.0", message = "O pH deve ser maior ou igual a 0")
    @DecimalMax(value = "14.0", message = "O pH deve ser menor ou igual a 14")
    @Schema(description = "pH da água tratada (pós-tratamento)", example = "7.5")
    private double phAguaTratada;

    @DecimalMin(value = "0.0", message = "A turbidez da água deve ser maior ou igual a 0")
    @DecimalMax(value = "5.0", message = "A turbidez da água deve ser menor ou igual a 5")
    @Schema(description = "Turbidez da água bruta (antes do tratamento)", example = "5")
    private double turbidezAguaBruta;

    @DecimalMin(value = "0.0", message = "A turbidez da água deve ser maior ou igual a 0")
    @DecimalMax(value = "5.0", message = "A turbidez da água deve ser menor ou igual a 5")
    @Schema(description = "Turbidez da água tratada (pós-tratamento)", example = "1.3")
    private double turbidezAguaTratada;

    @NotNull(message = "O ID do funcionário é obrigatório", groups = OnCreate.class)
    @Schema(description = "ID do funcionário", example = "1234")
    private Integer idOperario;

    @NotBlank(message = "A qualidade é obrigatória", groups = OnCreate.class)
    @Schema(description = "Qualidade da água", example = "Ruim")
    private String qualidade;

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

    public Integer getIdFuncionario() {
        return idOperario;
    }

    public void setIdFuncionario(Integer idOperario) {
        this.idOperario = idOperario;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }
}
