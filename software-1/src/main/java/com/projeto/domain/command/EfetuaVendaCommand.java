package com.projeto.domain.command;

import com.projeto.dao.DAOFactory;
import com.projeto.domain.Produto;
import com.projeto.domain.Venda;

public class EfetuaVendaCommand implements Command {
	
	private Venda venda;
	
	public EfetuaVendaCommand(Venda venda) {
		this.venda = venda;
	}

	@Override
	public void execute() {
		Produto produto = DAOFactory.getProdutoDAO().getProduto(venda.getProduto().getIdProduto());
		if (produto.getQuantidadeItem() >=  venda.getQuantidadeVenda()) {
			produto.vender(venda.getQuantidadeVenda());
			DAOFactory.getProdutoDAO().save(produto);
			Venda historyVenda = new Venda();
			historyVenda.setProduto(produto);
			historyVenda.setQuantidadeVenda(venda.getQuantidadeVenda());
			historyVenda.setCliente(venda.getCliente());			
			DAOFactory.getVendaDAO().save(historyVenda);
		} else {
			throw new RuntimeException("Estoque indisponivel");
		}
	}

}
