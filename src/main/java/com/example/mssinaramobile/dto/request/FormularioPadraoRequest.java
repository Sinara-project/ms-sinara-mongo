package com.example.mssinaramobile.dto.request;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

public class FormularioPadraoRequest {

    @NotBlank(message = "O ID da empresa é obrigatório")
    private String empresaId;

    @NotNull(message = "A data de preenchimento é obrigatória")
    private Date dataPreenchimento;

    @DecimalMin(value = "0.0",  message = "O pH deve ser maior ou igual ou igual a 0")
    @DecimalMax(value = "14.0",  message = "O pH deve ser menor ou igual a 14")
    private double ph;

    @DecimalMin(value = "0.2", message ="O cloro residual deve ser maior ou igual a 0.2 mg/L")
    @DecimalMax(value = "2.0", message = "O cloro residual deve ser menor ou igual a 2.0 mg/L")
    private double cloroResidual;

    @Min(value = 0, message = "A cor da água deve ser maior ou igual a 0 uH")
    @Max(value = 15, message = "A cor da água deve ser maior ou igual a 15 uH")
    private int corAguaBruta;

    @Min(value = 0, message = "A cor da água deve ser maior ou igual a 0 uH")
    @Max(value = 15, message = "A cor da água deve ser maior ou igual a 15 uH")
    private int corAguaTratada;

    @DecimalMin(value = "0.0", message = "O valor do nitrato deve ser maior ou igual a 0,0 mg/L")
    @DecimalMax(value = "1.5", message = "O valor do fluoreto deve ser menor ou igual a 1,5 mg/L")
    private double fluoreto;

    @DecimalMin(value = "0.0",  message = "O pH da água bruta deve ser >= 0")
    @DecimalMax(value = "10.0", message = "o valor do nitrato deve ser menor ou igual a 10 mg/L")
    private double nitrato;

    @DecimalMin(value = "0.0", message = "O pH deve ser maior ou igual a 0")
    @DecimalMax(value = "14.0", message = "O pH deve ser menor ou igual a 14")
    private double phAguaBruta;

    @DecimalMin(value = "0.0", message = "O pH deve ser maior ou igual a 0")
    @DecimalMax(value = "14.0", message = "O pH deve ser menor ou igual a 14")
    private double phAguaTratada;

    @DecimalMin(value = "0.0", message = "A turbidez da água deve ser maior ou igual a 0")
    @DecimalMax(value = "5.0", message = "A turbidez da água deve ser menor ou igual a 5")
    private double turbinezAguaBruta;

    @NotNull
    @DecimalMin(value = "0.0", message = "A turbidez da água deve ser maior ou igual a 0")
    @DecimalMax(value = "5.0", message = "A turbidez da água deve ser menor ou igual a 5")
    private double turbidezAguaTratada;

    public FormularioPadraoRequest(String empresaId,
                                   Date dataPreenchimento,
                                   double ph,
                                   double cloroResidual,
                                   int corAguaBruta,
                                   int corAguaTratada,
                                   double fluoreto,
                                   double nitrato,
                                   double phAguaBruta,
                                   double phAguaTratada,
                                   double turbinezAguaBruta,
                                   double turbidezAguaTratada) {
        this.empresaId = empresaId;
        this.dataPreenchimento = dataPreenchimento;
        this.ph = ph;
        this.cloroResidual = cloroResidual;
        this.corAguaBruta = corAguaBruta;
        this.corAguaTratada = corAguaTratada;
        this.fluoreto = fluoreto;
        this.nitrato = nitrato;
        this.phAguaBruta = phAguaBruta;
        this.phAguaTratada = phAguaTratada;
        this.turbinezAguaBruta = turbinezAguaBruta;
        this.turbidezAguaTratada = turbidezAguaTratada;
    }

    public String getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(String empresaId) {
        this.empresaId = empresaId;
    }

    public Date getDataPreenchimento() {
        return dataPreenchimento;
    }

    public void setDataPreenchimento(Date dataPreenchimento) {
        this.dataPreenchimento = dataPreenchimento;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
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

    public double getTurbinezAguaBruta() {
        return turbinezAguaBruta;
    }

    public void setTurbinezAguaBruta(double turbinezAguaBruta) {
        this.turbinezAguaBruta = turbinezAguaBruta;
    }

    public double getTurbidezAguaTratada() {
        return turbidezAguaTratada;
    }

    public void setTurbidezAguaTratada(double turbidezAguaTratada) {
        this.turbidezAguaTratada = turbidezAguaTratada;
    }
}
