package com.example.mssinaramobile.dto.request;

import jakarta.validation.constraints.NotBlank;

public class NotificacaoRequest {

    @NotBlank(message = "A mensagem não pode ser vazia")
    private String mensagem;

    @NotBlank(message = "O tipo não pode ser vazio")
    private String tipo;

    public NotificacaoRequest(String mensagem,
                              String tipo) {
        this.mensagem = mensagem;
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
