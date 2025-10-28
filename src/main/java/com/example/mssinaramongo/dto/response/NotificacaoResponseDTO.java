package com.example.mssinaramongo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Objeto de resposta com dados da notificação")
public class NotificacaoResponseDTO {

    @Schema(description = "ID único da notificação", example = "asdfghj123456")
    private String id;

    @Schema(description = "Data da notificação", example = "2025-09-29T13:10:00.000+00:00")
    private Date data;

    @Schema(description = "Mensagem da notificação", example = "Novo formulário de controle de cloração disponível.")
    private String mensagem;

    @Schema(description = "Tipo de notificação (ADM ou Operário)", example = "ADM")
    private String tipo;

    @Schema(description = "Categoria da notificação", example = "Formulário registrado")
    private String categoria;

    @Schema(type = "array",
            description = "Lista de ids de permissão",
            implementation = String.class)
    private List<String> idEnvio;

    @Schema(description = "ID único da empresa", example = "1234")
    private Integer idEmpresa;

    public NotificacaoResponseDTO(String id,
                                  Date data,
                                  String mensagem,
                                  String tipo,
                                  String categoria,
                                  List<String> idEnvio,
                                  Integer idEmpresa) {
        this.id = id;
        this.data = data;
        this.mensagem = mensagem;
        this.tipo = tipo;
        this.categoria = categoria;
        this.idEnvio = idEnvio;
        this.idEmpresa = idEmpresa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<String> getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(List<String> idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
