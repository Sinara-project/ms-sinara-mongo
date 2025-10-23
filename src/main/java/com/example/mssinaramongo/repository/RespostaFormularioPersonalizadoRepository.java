package com.example.mssinaramongo.repository;

import com.example.mssinaramongo.model.RespostaFormularioPersonalizado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RespostaFormularioPersonalizadoRepository extends MongoRepository<RespostaFormularioPersonalizado, String> {
    @Query("{ 'id_form': { $oid: ?0 } }")
    RespostaFormularioPersonalizado findByIdForm(String idForm);

    Integer countByIdOperario(Integer idOperario);

    List<RespostaFormularioPersonalizado> findByIdFormIn(List<String> formIds);
}
