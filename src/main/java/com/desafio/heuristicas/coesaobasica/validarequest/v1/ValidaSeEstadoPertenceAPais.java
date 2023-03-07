package com.desafio.heuristicas.coesaobasica.validarequest.v1;

import jakarta.validation.constraints.Null;

import java.util.ArrayList;
import java.util.List;

public class ValidaSeEstadoPertenceAPais {

    /*
     * Existem dois países cadastrados com os seguintes nomes:
     *
     * 1) Brasil
     * 2) Estados Unidos
     *
     * Existem também dois estados pré cadastrados para cada país
     *
     * 1) Bahia
     * 2) Californina
     */
    private BancoDeDadosPaisesEEstados bancoDeDadosPaisesEEstados;

    public ValidaSeEstadoPertenceAPais(BancoDeDadosPaisesEEstados bancoDeDadosPaisesEEstados) {
        this.bancoDeDadosPaisesEEstados = bancoDeDadosPaisesEEstados;
    }

    public static void main(String[] args) {
        ValidaSeEstadoPertenceAPais validador = new ValidaSeEstadoPertenceAPais(
                new BancoDeDadosPaisesEEstados());

        /*
         * Aqui fique a vontade para brincar com os valores para testar seu validador
         */
        NovoClienteRequest request = new NovoClienteRequest("Estados Unidos");
        request.setEstado("Bahia");

        System.out.println(validador.valida(request));
    }

    /**
     * @return lista com mensagens de erros
     */
    public List<String> valida(NovoClienteRequest request) {
        //É necessário agora implementar a seguinte validação:
        /*
         * A validação é a seguinte: caso um estado tenha sido selecionado,
         * é necessário verificar se ele pertence ao pais que foi escolhido.
         *
         * Caso não pertença, uma lista com uma mensagem de erro deveria ser retornada
         */

        List<String> erros = new ArrayList<>();

        if (existeEstado(request.getNomeEstado())) {

            Pais pais = bancoDeDadosPaisesEEstados.buscaPaisPeloNome(request.getNomePais());
            Estado estado = bancoDeDadosPaisesEEstados.buscaEstadoPeloNome(request.getNomeEstado());

            if (!estado.pertence(pais)) {
                erros.add("Não pertence ao que tu deseja");
            }
        }
        return erros;
    }

    public boolean existeEstado(String nome) {
        if (bancoDeDadosPaisesEEstados.buscaEstadoPeloNome(nome) != null) {
            return true;
        }
        return false;
    }
}
