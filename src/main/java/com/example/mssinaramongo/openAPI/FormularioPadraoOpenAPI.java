package com.example.mssinaramongo.openAPI;

import com.example.mssinaramongo.dto.request.FormularioPadraoRequestDTO;
import com.example.mssinaramongo.dto.response.FormularioPadraoResponseDTO;
import com.example.mssinaramongo.validation.OnCreate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.groups.Default;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface FormularioPadraoOpenAPI {

    @Operation(summary = "Busca todos os formularios padrão",
            description = "Retorna uma lista de formularios padrão")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Houve formularios padrão encontrados",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioPadraoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulario padrão foi encontrado")
    })
    List<FormularioPadraoResponseDTO> listarFormulariosPadrao();

    @Operation(summary = "Busca formulário padrão por ID",
            description = "Retorna um formulário padrão por seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Formulário padrão encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioPadraoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Formulário padrão não encontrado")
    })
    ResponseEntity<FormularioPadraoResponseDTO> buscarFormularioPadraoPorId(@Parameter(description = "ID do formulário padrão a ser buscado") @PathVariable String id);

    @Operation(summary = "Insere um formulário padrão",
            description = "Retorna uma Response Entity de formulário padrão")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Inserido com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioPadraoResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Não foi possível inserir")
    })
    ResponseEntity<String> inserirFormularioPadrao(@Validated({OnCreate.class, Default.class}) @Parameter(description = "Informalções par preenchimento de formulário padrão") @RequestBody FormularioPadraoRequestDTO dto);

    @Operation(summary = "Deleta um formulário padrão",
            description = "Retorna uma string")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Deletado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulário padrão foi encontrado com esse ID")
    })
    ResponseEntity<String> excluirFormularioPadrao(@Parameter(description = "ID do formulário padrão a ser deletado") @PathVariable String id);

    @Operation(summary = "Busca formulários padrão por empresa",
            description = "Retorna uma lista de formulários padrão ordenada por empresa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Houve formularios padrão encontrados",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioPadraoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulario padrão foi encontrado")
    })
    ResponseEntity<List<FormularioPadraoResponseDTO>> buscarFormularioPadraoPorEmpresa(@Parameter(description = "ID da empresa que se refere aos formulários padrão") @PathVariable Integer idEmpresa);

    @Operation(summary = "Busca formulários padrão por data",
            description = "Retorna uma lista de formulários padrão ordenada por data")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Houve formularios padrão encontrados",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioPadraoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulario padrão foi encontrado")
    })
    List<FormularioPadraoResponseDTO> buscarFormularioPadraoPorData(@Parameter(description = "Data em que o formulários padrõ foram enviados") @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date data);
}
