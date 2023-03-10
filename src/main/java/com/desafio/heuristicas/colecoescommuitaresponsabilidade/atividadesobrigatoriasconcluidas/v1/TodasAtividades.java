package com.desafio.heuristicas.colecoescommuitaresponsabilidade.atividadesobrigatoriasconcluidas.v1;

import java.math.BigDecimal;
import java.util.SortedSet;

public class TodasAtividades {

    public static int quantidadeAtividadesObrigatorias(SortedSet<SecaoAtividades> secoes) {
        return secoes.stream()
                .mapToInt(SecaoAtividades::quantidadeAtividadesObrigatorias)
                .sum();
    }

    public static int quantasObrigatoriasForamFinalizadas(SortedSet<SecaoAtividades> secoes, Aluno aluno) {
        return (int) secoes.stream()
                .flatMap(secaoAtividades -> secaoAtividades.respostasDeterminadoAluno(aluno).stream())
                .filter(Resposta::eObrigatoria)
                .count();
    }

    public static BigDecimal percentualDeAtividadesObrigatorias(SortedSet<SecaoAtividades> secoes) {
        int obrigatorias = quantidadeAtividadesObrigatorias(secoes);
        int quantidadeAtividades = secoes.stream()
                .mapToInt(SecaoAtividades::totalAtividades)
                .sum();
        return BigDecimal.valueOf((obrigatorias * 100L) / quantidadeAtividades);
    }
}
