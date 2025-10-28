package com.example.mssinaramongo.model;

import com.example.mssinaramongo.auxiliares.Resposta;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.lang.String;
import java.util.ArrayList;
import java.util.Date;

@Document(collection = "resposta_formulario_personalizado")
public class RespostaFormularioPersonalizado {
    @Id
    private String id;

    private ArrayList<Resposta> respostas;

    private Date data;

    @Field("id_form")
        private String idForm;

    @Field("id_operario")
    private Integer idOperario;

    @Field("id_empresa")
    private Integer idEmpresa;

    public RespostaFormularioPersonalizado() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getIdForm() {
        return idForm;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public Integer getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(Integer idOperario) {
        this.idOperario = idOperario;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
