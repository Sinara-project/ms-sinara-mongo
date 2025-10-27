package com.example.mssinaramongo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissaoResponseDTO {

    @Schema(description = "ID único da permissão", example = "64c13ab08edf48a008793cac")
    private String id;

    @Schema(description = "ID único da empresa", example = "1234567")
    private Integer idEmpresa;

    @Schema(description = "Nome da permissão", example = "Captação")
    private String nomePermissao;

    @Schema(description = "ID único dos operários abilitados", example = "12345")
    private List<Integer> idOperario;

    public PermissaoResponseDTO(String id,
                                Integer idEmpresa,
                                String nomePermissao,
                                List<Integer> idOperario) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.nomePermissao = nomePermissao;
        this.idOperario = idOperario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Integer> getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(List<Integer> idOperario) {
        this.idOperario = idOperario;
    }
}
