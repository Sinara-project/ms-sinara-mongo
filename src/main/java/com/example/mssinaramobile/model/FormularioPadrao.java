package com.example.mssinaramobile.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "formulario_padrao")
public class FormularioPadrao {
    @Id
    @Field("_id")
    private String id;

    @Field("empresa_id")
    private String empresaId;

    @Field("data_preenchimento")
    private Date dataPreenchimento;

    private double ph;

    @Field("cloro_residual")
    private double cloroResidual;

    @Field("cor_agua_bruta")
    private int corAguaBruta;

    @Field("cor_agua_tratada")
    private int corAguaTratada;

    private double fluoreto;

    private double nitrato;

    @Field("ph_agua_bruta")
    private double phAguaBruta;

    @Field("ph_agua_tratada")
    private double phAguaTratada;

    @Field("turbidez_agua_bruta")
    private double turbinezAguaBruta;

    @Field("tubidez_agua_tratada")
    private double turbidezAguaTratada;

    public FormularioPadrao(String id,
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
