package com.example.mssinaramongo.openAPI;

import com.example.mssinaramongo.dto.request.FormularioPersonalizadoRequestDTO;
import com.example.mssinaramongo.dto.response.FormularioPersonalizadoResponseDTO;
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

public interface FormularioPersonalizadoOpenAPI {

    @Operation(summary = "Busca todos os formulários personalizados",
            description = "Retorna uma lista de formulários personalizados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Houve formulários personalizados encontrados",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioPersonalizadoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulário personalizado foi encontrado")
    })
    List<FormularioPersonalizadoResponseDTO> listarFormulariosPersonalizados();

    @Operation(summary = "Busca formulário personalizado por ID",
            description = "Retorna um formulário personalizado por seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Formulário personalizado encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioPersonalizadoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulário personalizado foi encontrado")
    })
    ResponseEntity<FormularioPersonalizadoResponseDTO> buscarFormularioPersonalizadoPorId(@Parameter(description = "ID do formulário personalizado a ser buscado") @PathVariable String id);

    @Operation(summary = "Insere um formulário personalizado",
            description = "Retorna uma Response Entity de formulário personalizado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Formulário personalizado inserido com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioPersonalizadoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possível inserir formulário personalizado")
    })
    ResponseEntity<String> inserirFormularioPersonalizado(@Parameter(description = "Informações do formulário a ser inserido") @Validated({OnCreate.class, Default.class}) @RequestBody FormularioPersonalizadoRequestDTO dto);

    @Operation(summary = "Deleta um formulário personalizado",
            description = "Retorna uma Response Entity de string")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Deletado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulário personalizado foi encontrado com esse ID")
    })
    ResponseEntity<String> excluirFormularioPersonalizado(@Parameter(description = "ID do formulário") @PathVariable String id);

    @Operation(summary = "Busca formulários personalizados por criador (adm)",
            description = "Retorna uma lista de formulários personalizados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foram achados formulários personalizados com esse idEmpresa",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulário personalizado foi encontrado com esse idEmpresa")
    })
    ResponseEntity<List<FormularioPersonalizadoResponseDTO>> buscarPorCriador(@Parameter(description = "ID da empresa que criou o formulario") @PathVariable Integer idEmpresa);

    @Operation(summary = "Busca formulários personalizados por título",
            description = "Retorna uma lista de formulários personalizados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foram achados formulários personalizados com esse título",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulário personalizado foi encontrado com esse título")
    })
    ResponseEntity<List<FormularioPersonalizadoResponseDTO>> buscarPorTitulo(@Parameter(description = "Título do formulário") @PathVariable String titulo);

    @Operation(summary = "Busca formulários personalizados por parte do título",
            description = "Retorna uma lista de formulários personalizados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foram achados formulários personalizados com esse título",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulário personalizado foi encontrado com esse título")
    })
    ResponseEntity<List<FormularioPersonalizadoResponseDTO>> buscarPorParteTitulo(@Parameter(description = "Título do formulário")
                                                                               @PathVariable String parteTitulo);

    @Operation(summary = "Busca a quantidade de formulários registrados por empresa",
            description = "Retorna um int da quantidade de formulários registrados por empresa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foram achados formulários personalizados com esse ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulário personalizado foi encontrado com esse ID")
    })
    ResponseEntity<Integer> contarPorEmpresa(@Parameter(description = "ID único da empresa") @PathVariable Integer idEmpresa);

    @Operation(summary = "Verifica se o formulário foi respondido ou não",
            description = "Retorna um boolean")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foram achados formulários personalizados com esse ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulário personalizado foi encontrado com esse ID")
    })
    Boolean buscarStatus(@Parameter(description = "ID único do formulário") @PathVariable String id);

    @Operation(summary = "Busca os formulários que estão pendentes de cada permissão",
            description = "Retorna uma lista de formularios")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foram achados formulários para essa permissão",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))),
            @ApiResponse(responseCode = "404", description = "Não há formulários para essa permissão")
    })
    ResponseEntity<List<FormularioPersonalizadoResponseDTO>> buscarFormulariosPendentesPorPermissao(@Parameter(description = "ID único da permissão") @PathVariable String idPermissao);

    @Operation(summary = "Busca os formulários de cada permissão",
            description = "Retorna uma lista de formularios")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foram achados formulários para essa permissão",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioPersonalizadoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não há formulários para essa permissão")
    })
    ResponseEntity<List<FormularioPersonalizadoResponseDTO>> buscarFormulariosPorPermissao(@Parameter(description = "ID único da permissão") @PathVariable String idPermissao);

    @Operation(summary = "Conta formulários pendentes por permissão",
        description = "Retorna um Integer")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foram achados formulários pra essa permissão",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)))
    })
    ResponseEntity<Integer> contarFormulariosPendentes(@PathVariable String idPermissao);
}
