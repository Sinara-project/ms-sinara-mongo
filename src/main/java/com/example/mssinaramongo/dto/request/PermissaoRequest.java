package com.example.mssinaramongo.dto.request;

import com.example.mssinaramongo.validation.OnCreate;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "Payload de criação/atualização de uma permissão")
public class PermissaoRequest {

    @NotNull(message = "O id da empresa é obrigatório", groups = OnCreate.class)
    @Schema(description = "ID único da empresa", example = "2345")
    private Integer idEmpresa;

    @NotBlank(message = "O nome da permissão é obrigatório", groups = OnCreate.class)
    @Schema(description = "Nome da permissão", example = "Captação")
    private String nomePermissao;

    @NotEmpty(message = "Deve ter pelo menos um operário abilitado")
    @ArraySchema(
            schema = @Schema(description = "ID dos operários abilitados a essa permissão", example = "abc123"),
            arraySchema = @Schema(description = "Lista de IDs de operários", example = "[\"1\", \"2\"]")
    )
    private List<Integer> idOperario;

    public PermissaoRequest(Integer idEmpresa,
                            String nomePermissao,
                            List<Integer> idOperario) {
        this.idEmpresa = idEmpresa;
        this.nomePermissao = nomePermissao;
        this.idOperario = idOperario;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomePermissao() {
        return nomePermissao;
    }

    public void setNomePermissao(String nomePermissao) {
        this.nomePermissao = nomePermissao;
    }

    public List<Integer> getIdFuncionario() {
        return idOperario;
    }

    public void setIdFuncionario(List<Integer> idOperario) {
        this.idOperario = idOperario;
    }
}
