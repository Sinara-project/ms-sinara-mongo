package com.example.mssinaramongo.service;

import com.example.mssinaramongo.dto.request.FormularioPadraoRequestDTO;
import com.example.mssinaramongo.dto.response.FormularioPadraoResponseDTO;
import com.example.mssinaramongo.exception.EntidadeNaoEncontradaException;
import com.example.mssinaramongo.model.FormularioPadrao;
import com.example.mssinaramongo.repository.FormularioPadraoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FormularioPadraoService {

    private final FormularioPadraoRepository formularioPadraoRepository;
    private final ObjectMapper objectMapper;
    private static final String apiUrlQualidadeAgua = "http://98.94.90.8:5000/agua/prever";
    private final RestTemplate restTemplate;

    @Autowired
    public FormularioPadraoService(FormularioPadraoRepository formularioPadraoRepository, ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.formularioPadraoRepository = formularioPadraoRepository;
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    public List<FormularioPadraoResponseDTO> listarFormulariosPadrao() {
        List<FormularioPadrao> formularios = formularioPadraoRepository.findAll();
        return formularios.stream()
                .map(form -> objectMapper.convertValue(form, FormularioPadraoResponseDTO.class))
                .collect(Collectors.toList());
    }

    public FormularioPadraoResponseDTO buscarFormularioPadraoPorId(String id) {
        FormularioPadrao formularioPadrao = formularioPadraoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("FormularioPadrao", id));
        return objectMapper.convertValue(formularioPadrao, FormularioPadraoResponseDTO.class);
    }

    @Transactional
    public FormularioPadraoResponseDTO inserirFormularioPadrao(FormularioPadraoRequestDTO formularioPadraoRequest) {
        FormularioPadrao formularioPadrao = objectMapper.convertValue(formularioPadraoRequest, FormularioPadrao.class);

        Map<String, Object> dadosAgua = new HashMap<>();
        dadosAgua.put("cloro_residual", formularioPadrao.getCloroResidual());
        dadosAgua.put("cor_agua_bruta", formularioPadrao.getCorAguaBruta());
        dadosAgua.put("cor_agua_tratada", formularioPadrao.getCorAguaTratada());
        dadosAgua.put("fluoreto", formularioPadrao.getFluoreto());
        dadosAgua.put("nitrato", formularioPadrao.getNitrato());
        dadosAgua.put("ph_agua_bruta", formularioPadrao.getPhAguaBruta());
        dadosAgua.put("ph_agua_tratada", formularioPadrao.getPhAguaTratada());
        dadosAgua.put("turbidez_agua_bruta", formularioPadrao.getTurbidezAguaBruta());
        dadosAgua.put("turbidez_agua_tratada", formularioPadrao.getTurbidezAguaTratada());

        // Chama o método de previsão
        String qualidadePrevista = preverQualidadeAgua(dadosAgua);

        // Seta a qualidade prevista no formulário
        formularioPadrao.setQualidade(qualidadePrevista);

        FormularioPadrao formularioSalvo = formularioPadraoRepository.save(formularioPadrao);
        return objectMapper.convertValue(formularioSalvo, FormularioPadraoResponseDTO.class);
    }

    public FormularioPadraoResponseDTO atualizarFormularioPadrao(String id, FormularioPadraoRequestDTO updates) {
        Optional<FormularioPadrao> formularioOptional = Optional.ofNullable(formularioPadraoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("FormularioPadrao", id)));

        FormularioPadrao formulario = formularioOptional.get();

        if (updates.getIdEmpresa() != null) {
            formulario.setidEmpresa(updates.getIdEmpresa());
        }
        if (updates.getDataPreenchimento() != null) {
            formulario.setDataPreenchimento(updates.getDataPreenchimento());
        }
        if (updates.getCloroResidual() >= 0) {
            formulario.setCloroResidual(updates.getCloroResidual());
        }
        if (updates.getCorAguaBruta() >= 0) {
            formulario.setCorAguaBruta(updates.getCorAguaBruta());
        }
        if (updates.getCorAguaTratada() >= 0) {
            formulario.setCorAguaTratada(updates.getCorAguaTratada());
        }
        if (updates.getFluoreto() >= 0) {
            formulario.setFluoreto(updates.getFluoreto());
        }
        if (updates.getNitrato() >= 0) {
            formulario.setNitrato(updates.getNitrato());
        }
        if (updates.getPhAguaBruta() >= 0) {
            formulario.setPhAguaBruta(updates.getPhAguaBruta());
        }
        if (updates.getPhAguaTratada() >= 0) {
            formulario.setPhAguaTratada(updates.getPhAguaTratada());
        }
        if (updates.getTurbidezAguaBruta() >= 0) {
            formulario.setturbidezAguaBruta(updates.getTurbidezAguaBruta());
        }
        if (updates.getTurbidezAguaTratada() >= 0) {
            formulario.setTurbidezAguaTratada(updates.getTurbidezAguaTratada());
        }
        if (updates.getIdOperario() != null) {
            formulario.setIdOperario(updates.getIdOperario());
        }

        return objectMapper.convertValue(formularioPadraoRepository.save(formulario), FormularioPadraoResponseDTO.class);
    }

    @Transactional
    public void excluirFormularioPadrao(String id) {
        if (!formularioPadraoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("FormularioPadrao", id);
        }
        formularioPadraoRepository.deleteById(id);
    }

    public List<FormularioPadraoResponseDTO> buscarFormularioPadraoPorEmpresa(Integer idEmpresa) {
        List<FormularioPadrao> formularios = formularioPadraoRepository.findByidEmpresa(idEmpresa);
        List<FormularioPadraoResponseDTO> formularioResponses = new ArrayList<>();

        for (int i = 0; i < formularios.size(); i++) {
            formularioResponses.add(objectMapper.convertValue(formularios.get(i), FormularioPadraoResponseDTO.class));
        }

        return formularioResponses;
    }

    public List<FormularioPadraoResponseDTO> buscarFormularioPadraoPorData(Date data) {
        List<FormularioPadrao> formularios = formularioPadraoRepository.findByDataPreenchimento(data);
        List<FormularioPadraoResponseDTO> formularioResponses = new ArrayList<>();

        for (int i = 0; i < formularios.size(); i++) {
            formularioResponses.add(objectMapper.convertValue(formularios.get(i), FormularioPadraoResponseDTO.class));
        }

        return formularioResponses;
    }

    public String preverQualidadeAgua(Map<String, Object> dadosAgua) {
        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(
                    apiUrlQualidadeAgua,
                    dadosAgua,
                    Map.class
            );

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Map<String, Object> responseBody = response.getBody();
                return (String) responseBody.get("qualidade");
            } else {
                return "Erro: Não foi possível obter a previsão - Status: " + response.getStatusCode();
            }

        } catch (Exception e) {
            return "Erro na conexão com serviço de previsão: " + e.getMessage();
        }
    }
}
