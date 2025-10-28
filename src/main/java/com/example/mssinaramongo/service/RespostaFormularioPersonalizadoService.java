package com.example.mssinaramongo.service;

import com.example.mssinaramongo.auxiliares.Campo;
import com.example.mssinaramongo.auxiliares.CamposComRespostas;
import com.example.mssinaramongo.auxiliares.Resposta;
import com.example.mssinaramongo.dto.request.RespostaFormularioPersonalizadoRequestDTO;
import com.example.mssinaramongo.dto.response.FormularioPersonalizadoComRespostasResponseDTO;
import com.example.mssinaramongo.dto.response.RespostaFormularioPersonalizadoResponseDTO;
import com.example.mssinaramongo.exception.EntidadeNaoEncontradaException;
import com.example.mssinaramongo.model.FormularioPersonalizado;
import com.example.mssinaramongo.model.RespostaFormularioPersonalizado;
import com.example.mssinaramongo.repository.FormularioPersonalizadoRepository;
import com.example.mssinaramongo.repository.RespostaFormularioPersonalizadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RespostaFormularioPersonalizadoService {
    private final RespostaFormularioPersonalizadoRepository respostaFormularioPersonalizadoRepository;
    private final FormularioPersonalizadoRepository formularioPersonalizadoRepository;
    private final FormularioPersonalizadoService formularioPersonalizadoService;
    private final ObjectMapper objectMapper;

    @Autowired
    public RespostaFormularioPersonalizadoService(RespostaFormularioPersonalizadoRepository respostaFormularioPersonalizadoRepository, FormularioPersonalizadoRepository formularioPersonalizadoRepository, FormularioPersonalizadoService formularioPersonalizadoService, ObjectMapper objectMapper) {
        this.respostaFormularioPersonalizadoRepository = respostaFormularioPersonalizadoRepository;
        this.formularioPersonalizadoRepository = formularioPersonalizadoRepository;
        this.formularioPersonalizadoService = formularioPersonalizadoService;
        this.objectMapper = objectMapper;
    }

    public List<RespostaFormularioPersonalizadoResponseDTO> listarTodas() {
        List<RespostaFormularioPersonalizado> respostas = respostaFormularioPersonalizadoRepository.findAll();
        List<RespostaFormularioPersonalizadoResponseDTO> respostaFormularioResponse = new ArrayList<>();

        for (int i = 0; i < respostas.size(); i++) {
            respostaFormularioResponse.add(objectMapper.convertValue(respostas.get(i), RespostaFormularioPersonalizadoResponseDTO.class));
        }

        return respostaFormularioResponse;
    }

    public RespostaFormularioPersonalizadoResponseDTO buscarRespostaFormularioPersonalizadoPorId(String id) {
        RespostaFormularioPersonalizado respostas = respostaFormularioPersonalizadoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("RespostaFormularioPersonalizado", id));
        return objectMapper.convertValue(respostas, RespostaFormularioPersonalizadoResponseDTO.class);
    }

    @Transactional
    public RespostaFormularioPersonalizadoResponseDTO inserirRespostaFormularioPersonalizado(RespostaFormularioPersonalizadoRequestDTO respostaFormularioPersonalizadoRequest) {
        RespostaFormularioPersonalizado respostaFormularioPersonalizado = objectMapper.convertValue(respostaFormularioPersonalizadoRequest, RespostaFormularioPersonalizado.class);
        RespostaFormularioPersonalizado respostasSalvas = respostaFormularioPersonalizadoRepository.save(respostaFormularioPersonalizado);
        return objectMapper.convertValue(respostasSalvas, RespostaFormularioPersonalizadoResponseDTO.class);
    }

    @Transactional
    public void excluirRespostaFormularioPersonalizado(String id) {
        if (!respostaFormularioPersonalizadoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("RespostaFormularioPersonalizado", id);
        }
        respostaFormularioPersonalizadoRepository.deleteById(id);
    }

    public FormularioPersonalizadoComRespostasResponseDTO buscarFormularioComRespostas(String idForm) {
        Optional<FormularioPersonalizado> infoForms = formularioPersonalizadoRepository.findById(idForm);
        RespostaFormularioPersonalizado infoResposta = respostaFormularioPersonalizadoRepository.findByIdForm(idForm);

        List<Campo> perguntas = infoForms.get().getCampos();
        List<Resposta> respostas = infoResposta.getRespostas();
        if (infoForms.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Formulário com ID " + idForm + " não encontrado");
        }

        FormularioPersonalizadoComRespostasResponseDTO formularioCompleto = new FormularioPersonalizadoComRespostasResponseDTO();

        List<CamposComRespostas> camposComRespostas = new ArrayList<>();

        formularioCompleto.setId(infoForms.get().getId());
        formularioCompleto.setData(infoResposta.getData());
        formularioCompleto.setTitulo(infoForms.get().getTitulo());
        formularioCompleto.setDescricao(infoForms.get().getDescricao());
        formularioCompleto.setIdEmpresa(infoForms.get().getIdEmpresa());
        formularioCompleto.setIdOperario(infoResposta.getIdOperario());
        formularioCompleto.setIdPermissao(infoForms.get().getIdPermissao());
        formularioCompleto.setStatus(formularioPersonalizadoService.buscarStatus(idForm));

        for (Campo campo : perguntas) {
            Resposta resposta = respostas.stream()
                    .filter(r -> r.getCampoLabel().equalsIgnoreCase(campo.getLabel()))
                    .findFirst()
                    .orElse(null);

            CamposComRespostas campoCompleto = new CamposComRespostas(
                    campo.getLabel(),
                    campo.getTipo(),
                    campo.getObrigatorio(),
                    campo.getOpcoes(),
                    resposta != null ? resposta.getValor() : null
            );

            camposComRespostas.add(campoCompleto);
        }

        formularioCompleto.setCampos(camposComRespostas);
        return formularioCompleto;
    }

    public Integer contarRespostasPorOperario(Integer idOperario) {
        Integer count = respostaFormularioPersonalizadoRepository.countByIdOperario(idOperario);
        return count;
    }

    public List<FormularioPersonalizadoComRespostasResponseDTO> buscarFormulariosRespondidosPorPermissao(String idPermissao) {
        // Busca todas as respostas existentes
        List<RespostaFormularioPersonalizado> respostas = respostaFormularioPersonalizadoRepository.findAll();

        List<FormularioPersonalizadoComRespostasResponseDTO> result = new ArrayList<>();

        for (RespostaFormularioPersonalizado resposta : respostas) {
            // Busca o form correspondente a cada resposta
            Optional<FormularioPersonalizado> optForm = formularioPersonalizadoRepository.findById(resposta.getIdForm());

            if (optForm.isPresent()) {
                FormularioPersonalizado form = optForm.get();

                // Só adiciona se a permissão bater
                if (form.getIdPermissao() != null && form.getIdPermissao().contains(idPermissao)) {
                    result.add(buscarFormularioComRespostas(form.getId()));
                }
            }
        }

        return result;
    }

    public Integer buscarUltimoOperario(Integer idEmpresa) {
        List<RespostaFormularioPersonalizado> lista = respostaFormularioPersonalizadoRepository.findByIdEmpresaOrderByDataDesc(idEmpresa);

        if (lista.isEmpty()) {
            return 0;
        } else {
            RespostaFormularioPersonalizado formularioPersonalizado = lista.getFirst();
            return formularioPersonalizado.getIdOperario();
        }
    }
}