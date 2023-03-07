package com.desafio.heuristicas.coesaobasica.strings.v1;

import java.util.Optional;

public class BuscaRequestV1 {

    private String nome;

    private String endereco;

    public Optional<String> getNome() {
        if (nome.isBlank()) {
            return Optional.empty();
        }
        return Optional.of(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Optional<String> getEndereco() {
        if (endereco.isBlank()) {
            return Optional.empty();
        }
        return Optional.of(endereco);
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
