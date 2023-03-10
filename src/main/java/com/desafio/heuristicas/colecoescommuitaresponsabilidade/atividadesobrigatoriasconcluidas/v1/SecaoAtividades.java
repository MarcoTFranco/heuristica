package com.desafio.heuristicas.colecoescommuitaresponsabilidade.atividadesobrigatoriasconcluidas.v1;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SecaoAtividades implements Comparable<SecaoAtividades> {

    private String titulo;
    private SortedSet<Atividade> atividades = new TreeSet<>();
    private int ordem;

    public SecaoAtividades(String titulo, int ordem, List<Atividade> novasAtividades) {
        super();
        this.titulo = titulo;
        this.ordem = ordem;
        this.atividades.addAll(novasAtividades);
    }

    public int quantidadeAtividadesObrigatorias () {
        return (int) this.atividades.stream()
                .filter(Atividade::eObrigatoria)
                .count();
    }

    public List<Resposta> respostasDeterminadoAluno(Aluno aluno) {
        return this.atividades
                .stream()
                .flatMap(atividade -> atividade.respostaDeterminadoAluno(aluno).stream())
                .toList();
    }

    public int totalAtividades() {
        return this.atividades.size();
    }

    @Override
    public int compareTo(SecaoAtividades outra) {
        return this.ordem - outra.ordem;
    }

}
