package com.desafio.heuristicas.coesaobasica.valueobjects.cpf.v1;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ClienteService {
    public String cpfSemPontuacao(String cpf) {
        StringBuilder newCpf = new StringBuilder();
        for (int i = 0; i < cpf.length(); i++) {
            if (cpf.charAt(i) != '.' && cpf.charAt(i) != '-') {
                newCpf.append(cpf.charAt(i));
            }
        }
        return newCpf.toString();
    }

    public String cpfComPontuacao(String cpf) {
        Assert.isTrue(cpf.length() == 11, "O cpf deve estar sem pontuação nenhuma");

        StringBuilder newCpf = new StringBuilder();
        for (int i = 0; i < cpf.length(); i++) {
            if (i == 3 || i == 6) {
                newCpf.append('.');
            }
            if (i == 9) {
                newCpf.append('-');
            }
            newCpf.append(cpf.charAt(i));
        }
        return newCpf.toString();
    }

}
