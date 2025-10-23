package com.example.mssinaramongo.service;

import com.example.mssinaramongo.dto.request.FormularioPadraoRequestDTO;
import com.example.mssinaramongo.dto.response.FormularioPadraoResponseDTO;
import com.example.mssinaramongo.exception.EntidadeNaoEncontradaException;
import com.example.mssinaramongo.model.FormularioPadrao;
import com.example.mssinaramongo.repository.FormularioPadraoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormularioPadraoService {

    private final FormularioPadraoRepository formularioPadraoRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public FormularioPadraoService(FormularioPadraoRepository formularioPadraoRepository, ObjectMapper objectMapper) {
        this.formularioPadraoRepository = formularioPadraoRepository;
        this.objectMapper = objectMapper;
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
        if (updates.getTurbinezAguaBruta() >= 0) {
            formulario.setTurbinezAguaBruta(updates.getTurbinezAguaBruta());
        }
        if (updates.getTurbidezAguaTratada() >= 0) {
            formulario.setTurbidezAguaTratada(updates.getTurbidezAguaTratada());
        }
        if (updates.getIdFuncionario() != null) {
            formulario.setIdFuncionario(updates.getIdFuncionario());
        }
        if (updates.getQualidade() != null && !updates.getQualidade().isEmpty()) {
            formulario.setQualidade(updates.getQualidade());
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
}
