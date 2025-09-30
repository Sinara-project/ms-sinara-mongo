package com.example.mssinaramobile.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormularioPadraoResponse {

    private String id;
    private String empresaId;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private Date dataPreenchimento;

    private double ph;
    private double cloroResidual;
    private int corAguaBruta;
    private int corAguaTratada;
    private double fluoreto;
    private double nitrato;
    private double phAguaBruta;
    private double phAguaTratada;
    private double turbinezAguaBruta;
    private double turbidezAguaTratada;

    public FormularioPadraoResponse(String id,
                                    String empresaId,
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
        this.id = id;
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

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmpresaId() { return empresaId; }
    public void setEmpresaId(String empresaId) { this.empresaId = empresaId; }

    public Date getDataPreenchimento() { return dataPreenchimento; }
    public void setDataPreenchimento(Date dataPreenchimento) { this.dataPreenchimento = dataPreenchimento; }

    public double getPh() { return ph; }
    public void setPh(double ph) { this.ph = ph; }

    public double getCloroResidual() { return cloroResidual; }
    public void setCloroResidual(double cloroResidual) { this.cloroResidual = cloroResidual; }

    public int getCorAguaBruta() { return corAguaBruta; }
    public void setCorAguaBruta(int corAguaBruta) { this.corAguaBruta = corAguaBruta; }

    public int getCorAguaTratada() { return corAguaTratada; }
    public void setCorAguaTratada(int corAguaTratada) { this.corAguaTratada = corAguaTratada; }

    public double getFluoreto() { return fluoreto; }
    public void setFluoreto(double fluoreto) { this.fluoreto = fluoreto; }

    public double getNitrato() { return nitrato; }
    public void setNitrato(double nitrato) { this.nitrato = nitrato; }

    public double getPhAguaBruta() { return phAguaBruta; }
    public void setPhAguaBruta(double phAguaBruta) { this.phAguaBruta = phAguaBruta; }

    public double getPhAguaTratada() { return phAguaTratada; }
    public void setPhAguaTratada(double phAguaTratada) { this.phAguaTratada = phAguaTratada; }

    public double getTurbinezAguaBruta() { return turbinezAguaBruta; }
    public void setTurbinezAguaBruta(double turbinezAguaBruta) { this.turbinezAguaBruta = turbinezAguaBruta; }

    public double getTurbidezAguaTratada() { return turbidezAguaTratada; }
    public void setTurbidezAguaTratada(double turbidezAguaTratada) { this.turbidezAguaTratada = turbidezAguaTratada; }
}
