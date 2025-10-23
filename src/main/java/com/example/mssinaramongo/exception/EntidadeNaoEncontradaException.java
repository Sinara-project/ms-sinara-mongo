package com.example.mssinaramongo.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {

    public EntidadeNaoEncontradaException(String entidade, String id) {
        super(String.format("%s não encontrado(a) com o ID: %s", entidade, id));
    }

    public EntidadeNaoEncontradaException(String entidade) {
    }
}
