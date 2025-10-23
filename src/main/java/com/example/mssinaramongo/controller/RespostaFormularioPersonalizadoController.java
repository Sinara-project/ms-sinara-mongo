package com.example.mssinaramongo.controller;

import com.example.mssinaramongo.dto.request.RespostaFormularioPersonalizadoRequestDTO;
import com.example.mssinaramongo.dto.response.FormularioPersonalizadoComRespostasResponseDTO;
import com.example.mssinaramongo.dto.response.RespostaFormularioPersonalizadoResponseDTO;
import com.example.mssinaramongo.openAPI.RespostaFormularioPersonalizadoOpenAPI;
import com.example.mssinaramongo.service.RespostaFormularioPersonalizadoService;
import com.example.mssinaramongo.validation.OnCreate;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-sinara-mongo/resposta-formulario-personalizado")
public class RespostaFormularioPersonalizadoController implements RespostaFormularioPersonalizadoOpenAPI {
    private final RespostaFormularioPersonalizadoService respostaFormularioPersonalizadoService;

    public RespostaFormularioPersonalizadoController(RespostaFormularioPersonalizadoService respostaFormularioPersonalizadoService) {
        this.respostaFormularioPersonalizadoService = respostaFormularioPersonalizadoService;
    }

    // Listar todos
    @GetMapping("/listar")
    public List<RespostaFormularioPersonalizadoResponseDTO> listarRespostasFormularioPersonalizados() {
        return respostaFormularioPersonalizadoService.listarTodas();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<RespostaFormularioPersonalizadoResponseDTO> buscarRespostaFormularioPersonalizadoPorId(@PathVariable String id) {
        RespostaFormularioPersonalizadoResponseDTO respostaFormularioPersonalizado = respostaFormularioPersonalizadoService.buscarRespostaFormularioPersonalizadoPorId(id);
        return ResponseEntity.ok(respostaFormularioPersonalizado);
    }

    // Criar novo
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirRespostaFormularioPersonalizado(@Validated({OnCreate.class, Default.class}) @RequestBody RespostaFormularioPersonalizadoRequestDTO dto) {
        respostaFormularioPersonalizadoService.inserirRespostaFormularioPersonalizado(dto);
        return ResponseEntity.ok("Resposta de formulário inserida com sucesso!");
    }

    // Excluir
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirRespostaFormularioPersonalizado(@PathVariable String id) {
        respostaFormularioPersonalizadoService.excluirRespostaFormularioPersonalizado(id);
        return ResponseEntity.ok("resposta de formulario excluída com sucesso!");
    }

    // buscar forms completo
    @GetMapping("/formulario-completo/{idForm}")
    public FormularioPersonalizadoComRespostasResponseDTO formularioCompleto(@PathVariable String idForm) {
        return respostaFormularioPersonalizadoService.buscarFormularioComRespostas(idForm);
    }

    // contar por operario
    @GetMapping("/contar-respostas-por-operario/{idOperario}")
    public ResponseEntity<Integer> contarRespostasPorOperario(@PathVariable Integer idOperario) {
        Integer quantidadeRespostas = respostaFormularioPersonalizadoService.contarRespostasPorOperario(idOperario);
        return ResponseEntity.ok(quantidadeRespostas);
    }

    // buscar respondidos por permissao
    @GetMapping("/buscar-respondidos-por-permissao/{idPermissao}")
    public ResponseEntity<List<FormularioPersonalizadoComRespostasResponseDTO>> buscarFormulariosRespondidosPorPermissao(@PathVariable String idPermissao) {
        List<FormularioPersonalizadoComRespostasResponseDTO> formulariosRespondidos = respostaFormularioPersonalizadoService.buscarFormulariosRespondidosPorPermissao(idPermissao);
        return ResponseEntity.ok(formulariosRespondidos);
    }
}