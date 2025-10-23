package com.example.mssinaramongo.repository;

import com.example.mssinaramongo.model.Permissao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PermissaoRepository extends MongoRepository<Permissao, String> {
    List<Permissao> findByIdEmpresa(Integer idEmpresa);

    List<Permissao> findByNomePermissaoIgnoreCase(String nomePermissao);

    @Query("{ 'nome_permissao': { $regex: ?0, $options: 'i' } }")
    List<Permissao> buscarPorParteNome(String nomePermissao);
}
