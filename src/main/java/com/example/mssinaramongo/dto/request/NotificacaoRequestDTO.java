package com.example.mssinaramongo.dto.request;

import com.example.mssinaramongo.validation.OnCreate;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Schema(description = "Payload de criação/atualização de uma notificação")
public class NotificacaoRequestDTO {

    @NotNull(message = "A data é obrigatória", groups = OnCreate.class)
    @Schema(description = "Data da notificação", example = "2025-09-29T13:10:00.000+00:00")
    private Date data;

    @NotBlank(message = "A mensagem é obrigatória", groups = OnCreate.class)
    @Schema(description = "Mensagem da notificação", example = "Novo formulário de controle de cloração disponível.")
    private String mensagem;

    @NotBlank(message = "O tipo é obrigatório", groups = OnCreate.class)
    @Schema(description = "Tipo de notificação (ADM ou Operário)", example = "ADM")
    private String tipo;

    @NotBlank(message = "A categoria é obrigatória", groups = OnCreate.class)
    @Schema(description = "Categoria da notificação", example = "Formulário registrado")
    private String categoria;

    @NotEmpty(message = "O idEnvio é obrigatório", groups = OnCreate.class)
    @ArraySchema(
            schema = @Schema(description = "id referente a quem receberá a notificação", example = "abc234"),
            arraySchema = @Schema(description = "Lista de IDs de quem receberá a notificação", example = "[\"abc3\", \"def23\"]")
    )
    private List<String> idEnvio;

    @NotNull(message = "o ID da empresa é obrigatório", groups = OnCreate.class)
    @Schema(description = "ID único da empresa", example = "1234")
    private Integer idEmpresa;

    public NotificacaoRequestDTO(Date data,
                                 String mensagem,
                                 String tipo,
                                 String categoria,
                                 List<String> idEnvio,
                                 Integer idEmpresa) {
        this.data = data;
        this.mensagem = mensagem;
        this.tipo = tipo;
        this.categoria = categoria;
        this.idEnvio = idEnvio;
        this.idEmpresa = idEmpresa;
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
