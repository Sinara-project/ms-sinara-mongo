package com.example.mssinaramongo.repository;

import com.example.mssinaramongo.model.FormularioPadrao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FormularioPadraoRepository extends MongoRepository<FormularioPadrao, String> {

    List<FormularioPadrao> findByidEmpresa(Integer idEmpresa);

    List<FormularioPadrao> findByDataPreenchimento(Date dataPreenchimento);

    List<FormularioPadrao> findByidEmpresaAndDataPreenchimentoBetween(String idEmpresa, Date dataInicio, Date dataFim);
}
