package com.example.mssinaramongo.model;

import com.example.mssinaramongo.auxiliares.Campo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "formulario_personalizado")
public class FormularioPersonalizado {

    @Id
    private String id;

    @Field("id_criador")
    private Integer idCriador;

    private String titulo;

    private String descricao;

    private List<Campo> campos;

    @Field("id_permissao")
    private List<String> idPermissao;

    public FormularioPersonalizado() {
    }

    public FormularioPersonalizado(String id,
                                   Integer idCriador,
                                   String titulo,
                                   String descricao,
                                   List<Campo> campos,
                                   List<String> idPermissao) {
        this.id = id;
        this.idCriador = idCriador;
        this.titulo = titulo;
        this.descricao = descricao;
        this.campos = campos;
        this.idPermissao = idPermissao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdCriador() {
        return idCriador;
    }

    public void setIdCriador(Integer idCriador) {
        this.idCriador = idCriador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    public List<String> getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(List<String> idPermissao) {
        this.idPermissao = idPermissao;
    }
}
