package com.example.mssinaramongo.repository;

import com.example.mssinaramongo.auxiliares.Campo;
import com.example.mssinaramongo.model.FormularioPersonalizado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormularioPersonalizadoRepository extends MongoRepository<FormularioPersonalizado, String> {
    List<FormularioPersonalizado> findByIdEmpresa(Integer idEmpresa);

    List<FormularioPersonalizado> findByTitulo(String titulo);

    @Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
    List<FormularioPersonalizado> buscarPorParteTitulo(String partTitulo);

    Integer countByIdEmpresa(Integer idEmpresa);

    @Query(value = "{ '_id': ObjectId(?0) }", fields = "{ 'campos': 1, '_id': 0 }")
    List<Campo> findCamposByIdForm(String id);

    List<FormularioPersonalizado> findByIdPermissao(String idPermissao);
}
