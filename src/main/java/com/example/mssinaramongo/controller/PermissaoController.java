package com.example.mssinaramongo.controller;

import com.example.mssinaramongo.dto.request.PermissaoRequest;
import com.example.mssinaramongo.dto.response.PermissaoResponseDTO;
import com.example.mssinaramongo.openAPI.PermissaoOpenAPI;
import com.example.mssinaramongo.service.PermissaoService;
import com.example.mssinaramongo.validation.OnCreate;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController implements PermissaoOpenAPI {

    private final PermissaoService permissaoService;

    public PermissaoController(PermissaoService permissaoService) {
        this.permissaoService = permissaoService;
    }

    // Listar todas
    @GetMapping("/listar")
    public List<PermissaoResponseDTO> listarPermissoes() {
        return permissaoService.listarPermissoes();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<PermissaoResponseDTO> buscarPermissaoPorId(@PathVariable String id) {
        PermissaoResponseDTO permissao = permissaoService.buscarPorId(id);
        return ResponseEntity.ok(permissao);
    }

    // Criar nova
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirPermissao(@Validated({OnCreate.class, Default.class}) @RequestBody PermissaoRequest dto) {
        permissaoService.inserirPermissao(dto);
        return ResponseEntity.ok("Permissão inserida com sucesso!");
    }

    // Atualizar
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarPermissao(@Validated({OnCreate.class, Default.class}) @PathVariable String id,
                                       @RequestBody PermissaoRequest updates) {
        permissaoService.atualizarPermissao(id, updates);
        return ResponseEntity.ok("Permissão atualizada com sucesso!");
    }

    // Excluir
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirPermissao(@PathVariable String id) {
        permissaoService.excluirPermissao(id);
        return ResponseEntity.ok("Permissão excluída com sucesso!");
    }

    // Buscar por empresa
    @GetMapping("/buscar-por-empresa/{idEmpresa}")
    public ResponseEntity<List<PermissaoResponseDTO>> buscarPorEmpresa(@PathVariable Integer idEmpresa) {
        List<PermissaoResponseDTO> permissaoResponse = permissaoService.buscarPorEmpresa(idEmpresa);
        return ResponseEntity.ok(permissaoResponse);
    }

    // Buscar por nome
    @GetMapping("/buscar-por-nome/{nome}")
    public ResponseEntity<List<PermissaoResponseDTO>> buscarPorNome(@PathVariable String nome) {
        List<PermissaoResponseDTO> permissaoResponse = permissaoService.buscarPorNome(nome);
        return ResponseEntity.ok(permissaoResponse);
    }
}
