package com.example.mssinaramongo.service;

import com.example.mssinaramongo.dto.request.PermissaoRequestDTO;
import com.example.mssinaramongo.dto.response.PermissaoResponseDTO;
import com.example.mssinaramongo.exception.EntidadeNaoEncontradaException;
import com.example.mssinaramongo.model.Permissao;
import com.example.mssinaramongo.repository.PermissaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


@Service
public class PermissaoService {

    private final PermissaoRepository repository;
    private final ObjectMapper objectMapper;
    private final PermissaoRepository permissaoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    public PermissaoService(PermissaoRepository repository, ObjectMapper objectMapper, PermissaoRepository permissaoRepository) {
        this.repository = repository;
        this.objectMapper = objectMapper;
        this.permissaoRepository = permissaoRepository;
    }

    public List<PermissaoResponseDTO> listarPermissoes() {
        List<Permissao> permissoes = permissaoRepository.findAll();
        List<PermissaoResponseDTO> permissaoResponses = new ArrayList<>();

        for (int i = 0; i < permissoes.size(); i++) {
            permissaoResponses.add(objectMapper.convertValue(permissoes.get(i), PermissaoResponseDTO.class));
        }

        return permissaoResponses;

    }

    public PermissaoResponseDTO buscarPorId(String id) {
        Permissao permissao = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Permissao", id));
        return objectMapper.convertValue(permissao, PermissaoResponseDTO.class);
    }

    public PermissaoResponseDTO inserirPermissao(PermissaoRequestDTO request) {
        Permissao permissao = objectMapper.convertValue(request, Permissao.class);
        Permissao permissaoSalva = repository.save(permissao);
        return objectMapper.convertValue(permissaoSalva, PermissaoResponseDTO.class);
    }

    public PermissaoResponseDTO atualizarPermissao(String id, PermissaoRequestDTO updates) {
        Permissao permissao = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Permissao", id));

        if (updates.getIdEmpresa() != null) permissao.setIdEmpresa(updates.getIdEmpresa());
        if (updates.getNomePermissao() != null) permissao.setNomePermissao(updates.getNomePermissao());
        if (updates.getIdOperario() != null) permissao.setIdOperario(updates.getIdOperario());

        Permissao permissaoAtualizada = repository.save(permissao);
        return objectMapper.convertValue(permissaoAtualizada, PermissaoResponseDTO.class);
    }

    public void excluirPermissao(String id) {
        if (!repository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Permissao", id);
        }
        repository.deleteById(id);
    }

    public List<PermissaoResponseDTO> buscarPorEmpresa(Integer idEmpresa) {
        List<Permissao> permissoes = permissaoRepository.findByIdEmpresa(idEmpresa);
        List<PermissaoResponseDTO> permissaoResponses = new ArrayList<>();

        for (int i = 0; i < permissoes.size(); i++) {
            permissaoResponses.add(objectMapper.convertValue(permissoes.get(i), PermissaoResponseDTO.class));
        }

        return permissaoResponses;
    }

    public List<PermissaoResponseDTO> buscarPorNome(String nomePermissao) {
        List<Permissao> permissoes = permissaoRepository.buscarPorParteNome(nomePermissao);
        List<PermissaoResponseDTO> permissaoResponses = new ArrayList<>();

        for (int i = 0; i < permissoes.size(); i++) {
            permissaoResponses.add(objectMapper.convertValue(permissoes.get(i), PermissaoResponseDTO.class));
        }

        return permissaoResponses;
    }

    public void adicionarOperarios(String idPermissao, List<Integer> novosOperarios) {
        Query query = new Query(Criteria.where("_id").is(idPermissao));
        Update update = new Update().addToSet("id_operario").each(novosOperarios.toArray());

        mongoTemplate.updateFirst(query, update, Permissao.class);
    }

    public void removerOperarios(String idPermissao, List<Integer> operariosRemover) {
        if (operariosRemover == null || operariosRemover.isEmpty()) {
            throw new IllegalArgumentException("A lista de operários para remover não pode estar vazia");
        }

        Query query = new Query(Criteria.where("_id").is(idPermissao));
        Update update = new Update().pullAll("id_operario", operariosRemover.toArray());

        UpdateResult result = mongoTemplate.updateFirst(query, update, Permissao.class);

        if (result.getMatchedCount() == 0) {
            throw new RuntimeException("Permissão não encontrada");
        }
    }
}
