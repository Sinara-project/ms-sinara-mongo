package com.example.mssinaramongo.openAPI;

import com.example.mssinaramongo.dto.request.RespostaFormularioPersonalizadoRequestDTO;
import com.example.mssinaramongo.dto.response.FormularioPersonalizadoComRespostasResponseDTO;
import com.example.mssinaramongo.dto.response.RespostaFormularioPersonalizadoResponseDTO;
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

public interface RespostaFormularioPersonalizadoOpenAPI {

    @Operation(summary = "Lista todas as respostas",
            description = "Retorna uma lista de respostas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Houve respostas encontradas",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaFormularioPersonalizadoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma resposta foi encontrada")
    })
    List<RespostaFormularioPersonalizadoResponseDTO> listarRespostasFormularioPersonalizados();

    @Operation(summary = "Busca resposta de formulário personalizado por ID",
            description = "Retorna uma resposta de formulário personalizado por seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Resposta encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaFormularioPersonalizadoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma resposta foi encontrada")
    })
    ResponseEntity<RespostaFormularioPersonalizadoResponseDTO> buscarRespostaFormularioPersonalizadoPorId(@Parameter(description = "ID único do formulário") @PathVariable String id);

    @Operation(summary = "Insere uma resposta de formulário personalizado",
            description = "Retorna uma mensagem de confirmação ou erro")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Resposta de formulário inserida",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaFormularioPersonalizadoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possível inserir a resposta")
    })
    ResponseEntity<String> inserirRespostaFormularioPersonalizado(@Parameter(description = "Informações da resposta do formulário") @Validated({OnCreate.class, Default.class}) @RequestBody RespostaFormularioPersonalizadoRequestDTO dto);

    @Operation(summary = "Excluí uma resposta de formulário",
            description = "Retorna uma mensagem de confirmação ou erro")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Resposta de formulário excluída",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaFormularioPersonalizadoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possível excluir a resposta")
    })
    ResponseEntity<String> excluirRespostaFormularioPersonalizado(@Parameter(description = "ID único do formulário") @PathVariable String id);

    @Operation(summary = "Busca o formulário com respostas",
            description = "Retorna um formulário com respostas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foi achado um formulário com esse ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespostaFormularioPersonalizadoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não existem formulários com esse ID")
    })
    FormularioPersonalizadoComRespostasResponseDTO formularioCompleto(@Parameter(description = "ID único do formulário") @PathVariable String idForm);

    @Operation(summary = "Busca a quantidade de formulários respondidos por operário",
            description = "Retorna um int da quantidade de formulários respondidos por operário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foram achados formulários personalizados respondidos por esse operário",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum formulário personalizado foi respondido por esse operário")
    })
    ResponseEntity<Integer> contarRespostasPorOperario(@Parameter(description = "ID único do operário") @PathVariable Integer idOperario);

    @Operation(summary = "Busca os formulários respondidos por ID único da permissão",
            description = "Retorna uma lista de formulários com resposta")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foram encontrados formulários com essa permissão",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FormularioPersonalizadoComRespostasResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foram encontrados formulários com essa permissão")
    })
    ResponseEntity<List<FormularioPersonalizadoComRespostasResponseDTO>> buscarFormulariosRespondidosPorPermissao(@Parameter(description = "ID único da permissão") @PathVariable String idPermissao);
}
