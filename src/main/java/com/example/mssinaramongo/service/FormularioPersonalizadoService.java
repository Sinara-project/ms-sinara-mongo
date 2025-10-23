package com.example.mssinaramongo.service;

import com.example.mssinaramongo.dto.request.FormularioPersonalizadoRequestDTO;
import com.example.mssinaramongo.dto.response.FormularioPersonalizadoResponseDTO;
import com.example.mssinaramongo.exception.EntidadeNaoEncontradaException;
import com.example.mssinaramongo.model.FormularioPersonalizado;
import com.example.mssinaramongo.model.RespostaFormularioPersonalizado;
import com.example.mssinaramongo.repository.FormularioPersonalizadoRepository;
import com.example.mssinaramongo.repository.RespostaFormularioPersonalizadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormularioPersonalizadoService {

    private final FormularioPersonalizadoRepository formularioPersonalizadoRepository;
    private final RespostaFormularioPersonalizadoRepository respostaFormularioPersonalizadoRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public FormularioPersonalizadoService(FormularioPersonalizadoRepository formularioPersonalizadoRepository, RespostaFormularioPersonalizadoRepository respostaFormularioPersonalizadoRepository, ObjectMapper objectMapper) {
        this.formularioPersonalizadoRepository = formularioPersonalizadoRepository;
        this.respostaFormularioPersonalizadoRepository = respostaFormularioPersonalizadoRepository;
        this.objectMapper = objectMapper;
    }

    public List<FormularioPersonalizadoResponseDTO> buscarTodosFormulariosPersonalizados() {
        List<FormularioPersonalizado> formularios = formularioPersonalizadoRepository.findAll();
        List<FormularioPersonalizadoResponseDTO> formularioResponses = new ArrayList<FormularioPersonalizadoResponseDTO>();

        for (int i = 0; i < formularios.size(); i++) {
            formularioResponses.add(objectMapper.convertValue(formularios.get(i), FormularioPersonalizadoResponseDTO.class));
        }

        return formularioResponses;
    }

    public FormularioPersonalizadoResponseDTO buscarFormularioPersonalizadoPorId(String id) {
        FormularioPersonalizado formulario = formularioPersonalizadoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("FormularioPersonalizado", id));
        return objectMapper.convertValue(formulario, FormularioPersonalizadoResponseDTO.class);
    }

    @Transactional
    public FormularioPersonalizadoResponseDTO inserirFormularioPersonalizado(FormularioPersonalizadoRequestDTO formularioPersonalizadoRequest) {
        FormularioPersonalizado formularioPersonalizado = objectMapper.convertValue(formularioPersonalizadoRequest, FormularioPersonalizado.class);
        FormularioPersonalizado formularioSalvo = formularioPersonalizadoRepository.save(formularioPersonalizado);
        return objectMapper.convertValue(formularioSalvo, FormularioPersonalizadoResponseDTO.class);
    }

    @Transactional
    public void excluirFormularioPersonalizado(String id) {
        if (!formularioPersonalizadoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("FormularioPersonalizado", id);
        }
        formularioPersonalizadoRepository.deleteById(id);
    }

    public List<FormularioPersonalizadoResponseDTO> buscarPorCriador(Integer idCriador) {
        List<FormularioPersonalizado> formularios = formularioPersonalizadoRepository.findByIdCriador(idCriador);
        List<FormularioPersonalizadoResponseDTO> formularioResponses = new ArrayList<>();

        for (int i = 0; i < formularios.size(); i++) {
            formularioResponses.add(objectMapper.convertValue(formularios.get(i), FormularioPersonalizadoResponseDTO.class));
        }

        return formularioResponses;
    }

    public List<FormularioPersonalizadoResponseDTO> buscarPorTitulo(String titulo) {
        List<FormularioPersonalizado> formularios = formularioPersonalizadoRepository.findByTitulo(titulo);
        List<FormularioPersonalizadoResponseDTO> formularioResponses = new ArrayList<>();

        for (int i = 0; i < formularios.size(); i++) {
            formularioResponses.add(objectMapper.convertValue(formularios.get(i), FormularioPersonalizadoResponseDTO.class));
        }

        return formularioResponses;
    }

    public List<FormularioPersonalizadoResponseDTO> buscarPorParteTitulo(String titulo) {
        List<FormularioPersonalizado> formularios = formularioPersonalizadoRepository.buscarPorParteTitulo(titulo);
        List<FormularioPersonalizadoResponseDTO> formularioResponses = new ArrayList<>();

        for (int i = 0; i < formularios.size(); i++) {
            formularioResponses.add(objectMapper.convertValue(formularios.get(i), FormularioPersonalizadoResponseDTO.class));
        }

        return formularioResponses;
    }

    public Integer contarPorCriador(Integer idCriador) {
        Integer count = formularioPersonalizadoRepository.countByIdCriador(idCriador);
        return count;
    }

    public Boolean buscarStatus(String idForm) {
        RespostaFormularioPersonalizado resposta = respostaFormularioPersonalizadoRepository.findByIdForm(idForm);

        if (resposta != null) {
            return true;
        } else {
            return false;
        }
    }

    public List<FormularioPersonalizadoResponseDTO> buscarPendentesPorPermissao (String idPermissao ) {
        List<FormularioPersonalizado> forms = formularioPersonalizadoRepository.findByIdPermissao(idPermissao);

        List<FormularioPersonalizadoResponseDTO> formulariosResponse = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            if (buscarStatus(forms.get(i).getId()) == false) {
                formulariosResponse.add(objectMapper.convertValue(forms.get(i), FormularioPersonalizadoResponseDTO.class));
            }
        }

        return formulariosResponse;
    }

    public List<FormularioPersonalizadoResponseDTO> buscarFormulariosPorPermissao (String idPermissao ) {
        List<FormularioPersonalizado> forms = formularioPersonalizadoRepository.findByIdPermissao(idPermissao);
        List<FormularioPersonalizadoResponseDTO> formulariosResponse = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            formulariosResponse.add(objectMapper.convertValue(forms.get(i), FormularioPersonalizadoResponseDTO.class));
        }

        return formulariosResponse;
    }
}
