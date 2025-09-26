package com.example.mssinaramobile.model;

import com.example.mssinaramobile.auxiliares.Pergunta;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection = "formulario_personalizado")
public class FormularioPersonalizado {
    @Id
    @Field("_id")
    private String id;

    @Field("id_criador")
    private String idCriador;

    private String titulo;

    private String descricao;

    private ArrayList<Pergunta> campos;

    public FormularioPersonalizado(String id,
                                   String idCriador,
                                   String titulo,
                                   String descricao,
                                   ArrayList campos) {
        this.id = id;
        this.idCriador = idCriador;
        this.titulo = titulo;
        this.descricao = descricao;
        this.campos = campos;
    }
}
