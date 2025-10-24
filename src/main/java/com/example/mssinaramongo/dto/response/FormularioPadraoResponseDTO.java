package com.example.mssinaramongo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Objeto de response com dados do formulário padrão")
public class FormularioPadraoResponseDTO {

    @Schema(description = "ID único do formulário padrão", example = "64c13ab08edf48a008793cac")
    private String id;

    @Schema(description = "ID da empresa", example = "1234")
    private Integer idEmpresa;

    @Schema(description = "Data de preenchimento", example = "12/10/2025 11:59")
    private Date dataPreenchimento;

    @Schema(description = "Cloro residual da água", example = "1.7")
    private Double cloroResidual;

    @Schema(description = "Cor da água bruta (antes do tratamento)", example = "14")
    private Integer corAguaBruta;

    @Schema(description = "Cor da água tratada (pós-tratamento)", example = "5")
    private Integer corAguaTratada;

    @Schema(description = "Nível de fluoreto da água", example = "1.3")
    private Double fluoreto;

    @Schema(description = "Nível de nitrato da água", example = "5")
    private Double nitrato;

    @Schema(description = "pH da água bruta (antes do tratamento)", example = "9.5")
    private Double phAguaBruta;

    @Schema(description = "pH da água tratada (pós-tratamento)", example = "7.5")
    private Double phAguaTratada;

    @Schema(description = "Turbidez da água bruta (antes do tratamento)", example = "5")
    private Double turbidezAguaBruta;

    @Schema(description = "Turbidez da água tratada (pós-tratamento)", example = "1.3")
    private Double turbidezAguaTratada;

    @Schema(description = "ID do funcionário", example = "1234")
    private Integer idOperario;

    @Schema(description = "Qualidade da água", example = "ruim")
    private String qualidade;


    public FormularioPadraoResponseDTO() {
    }

    public FormularioPadraoResponseDTO(String id,
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

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Integer getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(Integer idEmpresa) { this.idEmpresa = idEmpresa; }

    public Date getDataPreenchimento() { return dataPreenchimento; }
    public void setDataPreenchimento(Date dataPreenchimento) { this.dataPreenchimento = dataPreenchimento; }

    public Double getCloroResidual() { return cloroResidual; }
    public void setCloroResidual(Double cloroResidual) { this.cloroResidual = cloroResidual; }

    public Integer getCorAguaBruta() { return corAguaBruta; }
    public void setCorAguaBruta(Integer corAguaBruta) { this.corAguaBruta = corAguaBruta; }

    public Integer getCorAguaTratada() { return corAguaTratada; }
    public void setCorAguaTratada(Integer corAguaTratada) { this.corAguaTratada = corAguaTratada; }

    public Double getFluoreto() { return fluoreto; }
    public void setFluoreto(Double fluoreto) { this.fluoreto = fluoreto; }

    public Double getNitrato() { return nitrato; }
    public void setNitrato(Double nitrato) { this.nitrato = nitrato; }

    public Double getPhAguaBruta() { return phAguaBruta; }
    public void setPhAguaBruta(Double phAguaBruta) { this.phAguaBruta = phAguaBruta; }

    public Double getPhAguaTratada() { return phAguaTratada; }
    public void setPhAguaTratada(Double phAguaTratada) { this.phAguaTratada = phAguaTratada; }

    public Double getTurbidezAguaBruta() { return turbidezAguaBruta; }
    public void setturbidezAguaBruta(Double turbidezAguaBruta) { this.turbidezAguaBruta = turbidezAguaBruta; }

    public Double getTurbidezAguaTratada() { return turbidezAguaTratada; }
    public void setTurbidezAguaTratada(Double turbidezAguaTratada) { this.turbidezAguaTratada = turbidezAguaTratada; }

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
