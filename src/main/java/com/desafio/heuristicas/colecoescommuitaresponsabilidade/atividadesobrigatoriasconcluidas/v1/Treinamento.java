package com.desafio.heuristicas.colecoescommuitaresponsabilidade.atividadesobrigatoriasconcluidas.v1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Treinamento {

    private String titulo;
    private SortedSet<SecaoAtividades> secoes = new TreeSet<>();

    public Treinamento(String titulo, List<SecaoAtividades> secoes) {
        super();
        this.titulo = titulo;
        this.secoes.addAll(secoes);
    }

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("aluno1@email.com");
        Aluno aluno2 = new Aluno("aluno2@email.com");
        AtividadeRepository atividadeRepository = new AtividadeRepository();

        List<Atividade> atividades = new ArrayList<>();
        Atividade atividade1 = new Atividade("t1", 0, TipoAtividade.OPCIONAL);
        atividadeRepository.save(atividade1);
        atividades.add(atividade1);
        atividade1.adicionaResposta(new Resposta(atividade1, aluno1));
        atividade1.adicionaResposta(new Resposta(atividade1, aluno2));

        Atividade atividade2 = new Atividade("t2", 1, TipoAtividade.OPCIONAL);
        atividadeRepository.save(atividade2);
        atividade2.adicionaResposta(new Resposta(atividade2, aluno1));
        atividades.add(atividade2);


        Atividade atividade3 = new Atividade("t3", 2, TipoAtividade.OBRIGATORIA);
        atividadeRepository.save(atividade3);
        atividade3.adicionaResposta(new Resposta(atividade3, aluno1));
        atividades.add(atividade3);

        SecaoAtividades secaoAtividades = new SecaoAtividades("titulo", 1, atividades);

        Treinamento treinamento = new Treinamento("titulo do treinamento", List.of(secaoAtividades));
        System.out.println(treinamento.calculaQuantidadeAtividadesObrigatorias());
        System.out.println(treinamento.calculaQuantasObrigatoriasForamFinalizadas(aluno1));
        System.out.println(treinamento.calculaPercentualDeAtividadesObrigatorias());

    }

    public int calculaQuantidadeAtividadesObrigatorias() {
        return TodasAtividades.quantidadeAtividadesObrigatorias(secoes);
    }

    public int calculaQuantasObrigatoriasForamFinalizadas(Aluno aluno) {
        return TodasAtividades.quantasObrigatoriasForamFinalizadas(secoes, aluno);
    }

    public BigDecimal calculaPercentualDeAtividadesObrigatorias() {
        return TodasAtividades.percentualDeAtividadesObrigatorias(secoes);
    }
}
