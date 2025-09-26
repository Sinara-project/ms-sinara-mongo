package com.example.mssinaramobile.model;

import com.example.mssinaramobile.auxiliares.Resposta;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;

public class RespostaFormularioPersonalizado {
    @Field("_id")
    private String id;

    @Field("form_id")
    private String formId;

    @Field("user_id")
    private String userId;

    private ArrayList<Resposta> respostas;

    private Date data;
}
