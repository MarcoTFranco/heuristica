package com.desafio.heuristicas.coesaobasica.valueobjects.cpf.v1;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    public String cpfFormatado(String cpf) {
        StringBuilder newCpf = new StringBuilder();
        for (int i = 0; i < cpf.length(); i++) {
            if (cpf.charAt(i) != '.' && cpf.charAt(i) != '-') {
                newCpf.append(cpf.charAt(i));
            }
        }
        return newCpf.toString();
    }

}
