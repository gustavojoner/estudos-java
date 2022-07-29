package com.projeto.dao;

import java.util.List;

import com.projeto.domain.Venda;

public interface VendaDAO {

	void save(Venda v);

	void delete(Venda v);

	Venda getVenda(Integer idVenda);

	List<Venda> listAll();

	List<Venda> findAll();
}
