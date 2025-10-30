package com.example.mssinaramongo.openAPI;

import com.example.mssinaramongo.dto.request.NotificacaoRequestDTO;
import com.example.mssinaramongo.dto.response.NotificacaoResponseDTO;
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

public interface NotificacaoOpenAPI {

    @Operation(summary = "Lista todas as notificações",
            description = "Retorna uma lista de notificações")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Houve notificações encontradas",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotificacaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma notificação foi encontrada")
    })
    List<NotificacaoResponseDTO> listarNotificacoes();

    @Operation(summary = "Busca notificação por ID único",
            description = "Retorna uma notificação por seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Notificação encontrada",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotificacaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma notificação foi encontrada com esse ID")
    })
    ResponseEntity<NotificacaoResponseDTO> buscarPorId(@Parameter(description = "ID único da notificação") @PathVariable String id);

    @Operation(summary = "Insere uma nova notificação",
            description = "Retorna uma Response Entity")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Notificação inserida com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotificacaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possível inserir a notificação")
    })
    ResponseEntity<String> inserirNotificacao(@Parameter(description = "Informações da notificação a ser inserida") @Validated({OnCreate.class, Default.class}) @RequestBody NotificacaoRequestDTO dto);

    @Operation(summary = "Exclui uma notificação",
            description = "Retorna uma Response Entity")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Notificação excluída com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotificacaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possivel excluir a notificação")
    })
    ResponseEntity<String> excluirNotificacao(@Parameter(description = "ID único a notificação") @PathVariable String id);

    @Operation(summary = "Lista notiifcações por usuário",
            description = "Retorna uma lista de notificações")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Houve notificações encontrada para esse usuário",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotificacaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Esse usuário não tem nenhuma notificação")
    })
    ResponseEntity<List<NotificacaoResponseDTO>> buscarPorIdEnvio(@Parameter(description = "ID do usuário") @PathVariable String idEnvio);

    @Operation(summary = "Lista notificações por empresa",
            description = "Retorna uma lista de notificações")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Houve notificações encontradas para essa empresa",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotificacaoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Essa empresa não tem nenhuma notificação")
    })
    ResponseEntity<List<NotificacaoResponseDTO>> buscarPorEmpresa(@Parameter(description = "ID único da empresa") @PathVariable Integer idEmpresa);
    }
