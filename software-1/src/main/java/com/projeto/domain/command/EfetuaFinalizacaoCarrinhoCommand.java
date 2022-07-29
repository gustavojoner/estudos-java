package com.projeto.domain.command;

import java.util.List;

import com.projeto.domain.Venda;

public class EfetuaFinalizacaoCarrinhoCommand implements Command {

	private List<Venda> vendas;
	
	public EfetuaFinalizacaoCarrinhoCommand(List<Venda> vendas) {
		this.vendas = vendas;
	}

	@Override
	public void execute() {
		for (Venda venda : vendas) {
			new EfetuaVendaCommand(venda).execute();				
		}		
	}

}
