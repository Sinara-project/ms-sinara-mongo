package com.example.mssinaramongo.controller;

import com.example.mssinaramongo.dto.request.FormularioPadraoRequestDTO;
import com.example.mssinaramongo.dto.response.FormularioPadraoResponseDTO;
import com.example.mssinaramongo.openAPI.FormularioPadraoOpenAPI;
import com.example.mssinaramongo.service.FormularioPadraoService;
import com.example.mssinaramongo.validation.OnCreate;
import jakarta.validation.groups.Default;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/formulario-padrao")
public class FormularioPadraoController implements FormularioPadraoOpenAPI {

    private final FormularioPadraoService formularioPadraoService;

    public FormularioPadraoController(FormularioPadraoService formularioPadraoService) {
        this.formularioPadraoService = formularioPadraoService;
    }

    // Buscar todos
    @GetMapping("/listar")
    public List<FormularioPadraoResponseDTO> listarFormulariosPadrao(){
        return formularioPadraoService.listarFormulariosPadrao();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<FormularioPadraoResponseDTO> buscarFormularioPadraoPorId(@PathVariable String id) {
        FormularioPadraoResponseDTO formularioPadrao = formularioPadraoService.buscarFormularioPadraoPorId(id);
        return ResponseEntity.ok(formularioPadrao);
    }

    // Criar novo formulário
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirFormularioPadrao(@Validated({OnCreate.class, Default.class}) @RequestBody FormularioPadraoRequestDTO dto) {
        formularioPadraoService.inserirFormularioPadrao(dto);
        return ResponseEntity.ok("Formulário padrão criado com sucesso!");
    }

    // Excluir um formulário
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirFormularioPadrao(@PathVariable String id) {
        formularioPadraoService.excluirFormularioPadrao(id);
        return ResponseEntity.ok("Formulário padrão excluído com sucesso");
    }

    // Buscar por empresa
    @GetMapping("/buscar-por-empresa/{idEmpresa}")
    public ResponseEntity<List<FormularioPadraoResponseDTO>> buscarFormularioPadraoPorEmpresa(@PathVariable Integer idEmpresa) {
        List<FormularioPadraoResponseDTO> lista = formularioPadraoService.buscarFormularioPadraoPorEmpresa(idEmpresa);
        return ResponseEntity.ok(lista);
    }



    // Buscar por data
    @GetMapping("/buscar-por-data/{data}")
    public List<FormularioPadraoResponseDTO> buscarFormularioPadraoPorData(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date data) {
        return formularioPadraoService.buscarFormularioPadraoPorData(data);
    }
}
