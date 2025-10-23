package com.example.mssinaramongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "permissao")
public class Permissao {

    @Id
    private String id;

    @Field("id_empresa")
    private Integer idEmpresa;

    @Field("nome_permissao")
    private String nomePermissao;

    @Field("id_operario")
    private List<Integer> idOperario;

    public Permissao() {
    }

    public Permissao(String id,
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

    public List<Integer> getIdFuncionario() {
        return idOperario;
    }

    public void setIdFuncionario(List<Integer> idOperario) {
        this.idOperario = idOperario;
    }
}
