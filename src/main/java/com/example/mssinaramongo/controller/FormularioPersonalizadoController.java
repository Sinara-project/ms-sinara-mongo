package com.example.mssinaramongo.controller;

import com.example.mssinaramongo.dto.request.FormularioPersonalizadoRequestDTO;
import com.example.mssinaramongo.dto.response.FormularioPersonalizadoResponseDTO;
import com.example.mssinaramongo.openAPI.FormularioPersonalizadoOpenAPI;
import com.example.mssinaramongo.service.FormularioPersonalizadoService;
import com.example.mssinaramongo.validation.OnCreate;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formulario-personalizado")
public class FormularioPersonalizadoController implements FormularioPersonalizadoOpenAPI {

    private final FormularioPersonalizadoService formularioPersonalizadoService;

    public FormularioPersonalizadoController(FormularioPersonalizadoService service) {
        this.formularioPersonalizadoService = service;
    }

    // Listar todos
    @GetMapping("/listar")
    public List<FormularioPersonalizadoResponseDTO> listarFormulariosPersonalizados() {
        return formularioPersonalizadoService.buscarTodosFormulariosPersonalizados();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<FormularioPersonalizadoResponseDTO> buscarFormularioPersonalizadoPorId(@PathVariable String id) {
        FormularioPersonalizadoResponseDTO formularioPersonalizado = formularioPersonalizadoService.buscarFormularioPersonalizadoPorId(id);
        return ResponseEntity.ok(formularioPersonalizado);
    }

    // Criar novo
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirFormularioPersonalizado(@Validated({OnCreate.class, Default.class}) @RequestBody FormularioPersonalizadoRequestDTO dto) {
        formularioPersonalizadoService.inserirFormularioPersonalizado(dto);
        return ResponseEntity.ok("Formulario personalizado inserido com sucesso!");
    }

    // Excluir
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirFormularioPersonalizado(@PathVariable String id) {
        formularioPersonalizadoService.excluirFormularioPersonalizado(id);
        return ResponseEntity.ok("Formulario excluído com sucesso!");
    }

    // Buscar por criador
    @GetMapping("/buscar-por-criador/{idEmpresa}")
    public ResponseEntity<List<FormularioPersonalizadoResponseDTO>> buscarPorCriador(@PathVariable Integer idEmpresa) {
        List<FormularioPersonalizadoResponseDTO> formulariosPersonalizados = formularioPersonalizadoService.buscarPorCriador(idEmpresa);
        return ResponseEntity.ok(formulariosPersonalizados);
    }

    // Buscar por Título
    @GetMapping("/buscar-por-titulo/{titulo}")
    public ResponseEntity<List<FormularioPersonalizadoResponseDTO>> buscarPorTitulo(@PathVariable String titulo) {
        List<FormularioPersonalizadoResponseDTO> formulariosPersonalizados = formularioPersonalizadoService.buscarPorTitulo(titulo);
        return ResponseEntity.ok(formulariosPersonalizados);
    }

    // Buscar por parte título
    @GetMapping("/buscar-por-parte-titulo/{parteTitulo}")
    public ResponseEntity<List<FormularioPersonalizadoResponseDTO>> buscarPorParteTitulo(@PathVariable String parteTitulo) {
        List<FormularioPersonalizadoResponseDTO> formulariosPersonalizados = formularioPersonalizadoService.buscarPorParteTitulo(parteTitulo);
        return ResponseEntity.ok(formulariosPersonalizados);
    }

    // Contar por empresa
    @GetMapping("/contar-por-criador/{idEmpresa}")
    public ResponseEntity<Integer> contarPorEmpresa(Integer idEmpresa) {
        Integer quantidadeFormulariosPersonalizados = formularioPersonalizadoService.contarPorCriador(idEmpresa);
        return ResponseEntity.ok(quantidadeFormulariosPersonalizados);
    }

    // Buscar status
    @GetMapping("/buscar-status/{idForm}")
    public Boolean buscarStatus(@PathVariable String idForm) {
        return formularioPersonalizadoService.buscarStatus(idForm);
    }

    // Buscar pendentes por permissão
    @GetMapping("/buscar-formularios-pendentes-por-permissao/{idPermissao}")
    public ResponseEntity<List<FormularioPersonalizadoResponseDTO>> buscarFormulariosPendentesPorPermissao(@PathVariable String idPermissao) {
        List<FormularioPersonalizadoResponseDTO> formulariosPersonalizadoResponse = formularioPersonalizadoService.buscarPendentesPorPermissao(idPermissao);
        return ResponseEntity.ok(formulariosPersonalizadoResponse);
    }

    // Buscar forms por permissão
    @GetMapping("/buscar-formularios-por-permissao/{idPermissao}")
    public ResponseEntity<List<FormularioPersonalizadoResponseDTO>> buscarFormulariosPorPermissao(@PathVariable String idPermissao) {
        List<FormularioPersonalizadoResponseDTO> formulariosPersonalizado = formularioPersonalizadoService.buscarFormulariosPorPermissao(idPermissao);
        return ResponseEntity.ok(formulariosPersonalizado);
    }
}

