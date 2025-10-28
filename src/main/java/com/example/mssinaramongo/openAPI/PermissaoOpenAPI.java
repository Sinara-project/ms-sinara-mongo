package com.example.mssinaramongo.openAPI;

import com.example.mssinaramongo.dto.request.PermissaoRequestDTO;
import com.example.mssinaramongo.dto.response.PermissaoResponseDTO;
import com.example.mssinaramongo.validation.OnCreate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PermissaoOpenAPI {

    @Operation(summary = "Lista todas as permissões",
            description = "Retorna uma lista de permissões")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Houve permissões encontradas",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PermissaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma permissão foi encontrada")
    })
    List<PermissaoResponseDTO> listarPermissoes();

    @Operation(summary = "Busca permissão por seu ID único",
            description = "Retorna uma permissão de acordo com seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foi encontrada uma permissão com esse ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PermissaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não há permissões com esse ID")
    })
    ResponseEntity<PermissaoResponseDTO> buscarPermissaoPorId(@Parameter(description = "ID único da permissão") @PathVariable String id);

    @Operation(summary = "Insere uma permissão",
            description = "Retorna uma Response Entity")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permissão inserida com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PermissaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma permissão foi encontrada")
    })
    ResponseEntity<String> inserirPermissao(@Parameter(description = "Informações da permissão") @Validated({OnCreate.class, Default.class}) @RequestBody PermissaoRequestDTO dto);

    @Operation(summary = "Atualiza uma permissão",
            description = "Retorna uma Response Entity")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permissão atualizada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PermissaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possível atualizar a permissão")
    })
    ResponseEntity<String> atualizarPermissao(@Parameter(description = "ID único da permissão") @Validated({OnCreate.class, Default.class}) @PathVariable String id,
                                              @Parameter(description = "informações a serem atualizadas") @RequestBody PermissaoRequestDTO updates);

    @Operation(summary = "Excluí uma permissão",
            description = "Retorna uma Response Entity")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permissão excluída com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PermissaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possível excluir a permissão")
    })
    ResponseEntity<String> excluirPermissao(@Parameter(description = "ID único da permissão") @PathVariable String id);

    @Operation(summary = "Busca permissões de acordo com o ID da empresa",
            description = "Retorna uma lista de permissões")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Houve permissões encontradas",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PermissaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma permissão foi encontrada")
    })
    ResponseEntity<List<PermissaoResponseDTO>> buscarPorEmpresa(@Parameter(description = "ID único da empresa") @PathVariable Integer idEmpresa);

    @Operation(summary = "Busca permissões por nome",
            description = "Retorna uma lista de permissões")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Houve permissões encontradas",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PermissaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma permissão foi encontrada")
    })
    ResponseEntity<List<PermissaoResponseDTO>> buscarPorNome(@Parameter(description = "Nome da permissão") @PathVariable String nomePermissao);

    @Operation(summary = "Adiciona IDs de operário a permissão",
        description = "Retorna uma Response Entity")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foi encontrada uma permissão com esse ID"),
            @ApiResponse(responseCode = "404", description = "Nenhuma permissão foi encontrada")
    })
    ResponseEntity<String> adicionarIdOperario(@Parameter(description = "ID único da permissao") @PathVariable String id, @Parameter(description = "lista de IDs de operário a serem adicionados") @RequestBody List<Integer> updates);

    @Operation(summary = "Remove IDs de operário a permissão",
            description = "Retorna uma Response Entity")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foi encontrada uma permissão com esse ID"),
            @ApiResponse(responseCode = "404", description = "Nenhuma permissão foi encontrada")
    })
    ResponseEntity<String> removerIdOperario(@Parameter(description = "ID único da permissao") @PathVariable String id, @Parameter(description = "lista de IDs de operário a serem removidos") @RequestBody List<Integer> updates);
    }
