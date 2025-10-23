package com.example.mssinaramongo.repository;

import com.example.mssinaramongo.model.Notificacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificacaoRepository extends MongoRepository<Notificacao, String> {
    List<Notificacao> findByIdEnvioContainingOrderByDataDesc(Integer idEnvio);
}
