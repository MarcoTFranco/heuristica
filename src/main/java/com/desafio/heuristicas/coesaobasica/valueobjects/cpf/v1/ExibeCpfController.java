package com.desafio.heuristicas.coesaobasica.valueobjects.cpf.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExibeCpfController {

    private ClienteRepository clienteRepository;

    private ClienteService clienteService;


    public ExibeCpfController(ClienteRepository clienteRepository) {
        super();
        this.clienteRepository = clienteRepository;
    }


    @GetMapping("/cpf")
    public String executa(Long idCliente) {

        Cliente cliente = clienteRepository.busca(idCliente);
        /*
         * Como você sabe se o cpf está na formataçÃo que você precisa aqui?
         */

        clienteService.cpfSemPontuacao(cliente.getCpf());

        return cliente.getCpf();
    }

}
