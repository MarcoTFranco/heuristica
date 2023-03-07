package com.desafio.heuristicas.coesaobasica.treinamentoseatividades.v1;

import java.util.ArrayList;
import java.util.List;

public class Treinamento {

    private String titulo;
    private List<String> titulosAtividades = new ArrayList<>();

    public Treinamento(String titulo) {
        this.titulo = titulo;
    }

    public static void main(String[] args) {
        Treinamento testeDeFogo = new Treinamento("teste de fogo para você");

        /*
         * Primeiro passo é vocé implementar a adição de titulos de atividades
         * dentro do treinamento. Como você faria?
         */

        testeDeFogo.addTitulosAtividades("Ta feito");

        /*
         * Uma vez que você implementou a adição de titulos de atividades,
         * é necessário que você possibilite a descoberta da posicao do titulo
         * da atividade dentro do treinamento.
         */

        int posicao = testeDeFogo.verificaPosicao("Ta feito");
    }

    public void addTitulosAtividades(String titulo) {
        this.titulosAtividades.add(titulo);
    }

    public int verificaPosicao(String titulo) {
        for (int i = 0; i<titulosAtividades.size(); i++) {
            if (titulosAtividades.get(i).equals(titulo)) {
                return i;
            }
        }
        return -1;
    }


}
