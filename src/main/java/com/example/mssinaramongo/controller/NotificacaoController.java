package com.example.mssinaramongo.controller;

import com.example.mssinaramongo.dto.request.NotificacaoRequestDTO;
import com.example.mssinaramongo.dto.response.NotificacaoResponseDTO;
import com.example.mssinaramongo.openAPI.NotificacaoOpenAPI;
import com.example.mssinaramongo.service.NotificacaoService;
import com.example.mssinaramongo.validation.OnCreate;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController implements NotificacaoOpenAPI {

    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    // Listar todas
    @GetMapping("/listar")
    public List<NotificacaoResponseDTO> listarNotificacoes() {
        return notificacaoService.listarNotificacoes();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<NotificacaoResponseDTO> buscarPorId(@PathVariable String id) {
        NotificacaoResponseDTO notificacaoResponse = notificacaoService.buscarPorId(id);

        return ResponseEntity.ok(notificacaoResponse);
    }

    // Criar nova notificação
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirNotificacao(@Validated({OnCreate.class, Default.class}) @RequestBody NotificacaoRequestDTO dto) {
        notificacaoService.inserirNotificacao(dto);

        return ResponseEntity.ok("Notificação inserida com sucesso!");
    }

    // Excluir
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirNotificacao(@PathVariable String id) {
        notificacaoService.excluirNotificacao(id);

        return ResponseEntity.ok("Notificação excluída com sucesso!");
    }

    // Listar notificações por idEnvio
    @GetMapping("/buscar-por-usuario/{idEnvio}")
    public ResponseEntity<List<NotificacaoResponseDTO>> buscarPorIdEnvio(@PathVariable String idEnvio) {
        List<NotificacaoResponseDTO> notificacoesResponse = notificacaoService.buscarPorIdEnvio(idEnvio);

        return ResponseEntity.ok(notificacoesResponse);
    }

    // Buscar notificações por idEmpresa
    @GetMapping("/buscar-por-empresa/{idEmpresa}")
    public ResponseEntity<List<NotificacaoResponseDTO>> buscarPorEmpresa(@PathVariable Integer idEmpresa) {
        List<NotificacaoResponseDTO> notificacoesResponse = notificacaoService.buscarPorEmpresa(idEmpresa);

        return ResponseEntity.ok(notificacoesResponse);
    }
}
