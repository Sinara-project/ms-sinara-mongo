package com.example.mssinaramongo.service;

import com.example.mssinaramongo.dto.request.NotificacaoRequestDTO;
import com.example.mssinaramongo.dto.response.NotificacaoResponseDTO;
import com.example.mssinaramongo.exception.EntidadeNaoEncontradaException;
import com.example.mssinaramongo.model.Notificacao;
import com.example.mssinaramongo.repository.NotificacaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificacaoService {

    private final NotificacaoRepository repository;
    private final ObjectMapper objectMapper;
    private final NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository repository, ObjectMapper objectMapper, NotificacaoRepository notificacaoRepository) {
        this.repository = repository;
        this.objectMapper = objectMapper;
        this.notificacaoRepository = notificacaoRepository;
    }

    public List<NotificacaoResponseDTO> listarNotificacoes() {
        List<Notificacao> notificacoes = notificacaoRepository.findAll();
        List<NotificacaoResponseDTO> notificacaoResponses = new ArrayList<>();

        for (int i = 0; i < notificacoes.size(); i++) {
            notificacaoResponses.add(objectMapper.convertValue(notificacoes.get(i), NotificacaoResponseDTO.class));
        }

        return notificacaoResponses;
    }
    public NotificacaoResponseDTO buscarPorId(String id) {
        Notificacao notificacao = notificacaoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Notificacao", id));
        return objectMapper.convertValue(notificacao, NotificacaoResponseDTO.class);
    }

    @Transactional
    public NotificacaoResponseDTO inserirNotificacao(NotificacaoRequestDTO notificacaoRequest) {
        Notificacao notificacao = objectMapper.convertValue(notificacaoRequest, Notificacao.class);
        Notificacao formularioSalvo = notificacaoRepository.save(notificacao);
        return objectMapper.convertValue(formularioSalvo, NotificacaoResponseDTO.class);
    }

    @Transactional
    public void excluirNotificacao(String id) {
        if (!notificacaoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Notificacao", id);
        }
        notificacaoRepository.deleteById(id);
    }

    public List<NotificacaoResponseDTO> buscarPorIdEnvio(String idEnvio) {
        List<Notificacao> notificacoes = notificacaoRepository.findByIdEnvioContainingOrderByDataDesc(idEnvio);
        List<NotificacaoResponseDTO> notificacaoResponses = new ArrayList<>();

        for (int i = 0; i < notificacoes.size(); i++) {
            notificacaoResponses.add(objectMapper.convertValue(notificacoes.get(i), NotificacaoResponseDTO.class));
        }

        return notificacaoResponses;
    }
}
