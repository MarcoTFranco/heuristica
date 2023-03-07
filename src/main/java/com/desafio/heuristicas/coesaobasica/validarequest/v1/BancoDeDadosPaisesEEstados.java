package com.desafio.heuristicas.coesaobasica.validarequest.v1;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class BancoDeDadosPaisesEEstados {

	private Map<String, Pais> paises = new HashMap<>();
	private Map<String, Estado> estados = new HashMap<>();

	{
		Pais brasil = new Pais("Brasil");
		this.paises.put("brasil",brasil);
		Pais eua = new Pais("Estados Unidos");
		this.paises.put("estados unidos",eua);
		
		this.estados.put("bahia", new Estado("Bahia", brasil));
		this.estados.put("california", new Estado("California", eua));
	}
	
	public Pais buscaPaisPeloNome(String nome) {
		Pais pais = paises.get(nome.toLowerCase());
		Assert.notNull(pais,"Não existe um país cadastrado com nome ["+nome+"] ");
		return pais;
	}
	
	public Estado buscaEstadoPeloNome(String nome) {
		Estado estado = estados.get(nome.toLowerCase());
		Assert.notNull(estado,"Não existe um estado cadastrado com nome ["+nome+"] ");
		return estado;
	}
}
