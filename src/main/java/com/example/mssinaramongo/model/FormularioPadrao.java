package com.example.mssinaramongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "formulario_padrao")
public class FormularioPadrao {
    @Id
    private String id;

    @Field("id_empresa")
    private Integer idEmpresa;

    @Field("data_preenchimento")
    private Date dataPreenchimento;

    @Field("cloro_residual")
    private double cloroResidual;

    @Field("cor_agua_bruta")
    private Integer corAguaBruta;

    @Field("cor_agua_tratada")
    private Integer corAguaTratada;

    private double fluoreto;

    private double nitrato;

    @Field("ph_agua_bruta")
    private double phAguaBruta;

    @Field("ph_agua_tratada")
    private double phAguaTratada;

    @Field("turbidez_agua_bruta")
    private double turbidezAguaBruta;

    @Field("tubidez_agua_tratada")
    private double turbidezAguaTratada;

    @Field("id_operario")
    private Integer idOperario;

    private String qualidade;

    public FormularioPadrao() {
    }

    public FormularioPadrao(String id,
                            Integer idEmpresa,
                            Date dataPreenchimento,
                            Double cloroResidual,
                            Integer corAguaBruta,
                            Integer corAguaTratada,
                            Double fluoreto,
                            Double nitrato,
                            Double phAguaBruta,
                            Double phAguaTratada,
                            Double turbidezAguaBruta,
                            Double turbidezAguaTratada,
                            Integer idOperario,
                            String qualidade) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.dataPreenchimento = dataPreenchimento;
        this.cloroResidual = cloroResidual;
        this.corAguaBruta = corAguaBruta;
        this.corAguaTratada = corAguaTratada;
        this.fluoreto = fluoreto;
        this.nitrato = nitrato;
        this.phAguaBruta = phAguaBruta;
        this.phAguaTratada = phAguaTratada;
        this.turbidezAguaBruta = turbidezAguaBruta;
        this.turbidezAguaTratada = turbidezAguaTratada;
        this.idOperario = idOperario;
        this.qualidade = qualidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getidEmpresa() {
        return idEmpresa;
    }

    public void setidEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Date getDataPreenchimento() {
        return dataPreenchimento;
    }

    public void setDataPreenchimento(Date dataPreenchimento) {
        this.dataPreenchimento = dataPreenchimento;
    }

    public Double getCloroResidual() {
        return cloroResidual;
    }

    public void setCloroResidual(Double cloroResidual) {
        this.cloroResidual = cloroResidual;
    }

    public Integer getCorAguaBruta() {
        return corAguaBruta;
    }

    public void setCorAguaBruta(Integer corAguaBruta) {
        this.corAguaBruta = corAguaBruta;
    }

    public Integer getCorAguaTratada() {
        return corAguaTratada;
    }

    public void setCorAguaTratada(Integer corAguaTratada) {
        this.corAguaTratada = corAguaTratada;
    }

    public Double getFluoreto() {
        return fluoreto;
    }

    public void setFluoreto(Double fluoreto) {
        this.fluoreto = fluoreto;
    }

    public Double getNitrato() {
        return nitrato;
    }

    public void setNitrato(Double nitrato) {
        this.nitrato = nitrato;
    }

    public Double getPhAguaBruta() {
        return phAguaBruta;
    }

    public void setPhAguaBruta(Double phAguaBruta) {
        this.phAguaBruta = phAguaBruta;
    }

    public Double getPhAguaTratada() {
        return phAguaTratada;
    }

    public void setPhAguaTratada(Double phAguaTratada) {
        this.phAguaTratada = phAguaTratada;
    }

    public Double getTurbidezAguaBruta() {
        return turbidezAguaBruta;
    }

    public void setturbidezAguaBruta(Double turbidezAguaBruta) {
        this.turbidezAguaBruta = turbidezAguaBruta;
    }

    public Double getTurbidezAguaTratada() {
        return turbidezAguaTratada;
    }

    public void setTurbidezAguaTratada(Double turbidezAguaTratada) {
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
