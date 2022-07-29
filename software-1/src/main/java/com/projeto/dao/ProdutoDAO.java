package com.projeto.dao;

import java.util.List;

import com.projeto.domain.Produto;

public interface ProdutoDAO {

	void save(Produto p);

	void delete(Produto p);
	
	Produto getProduto(Integer idProduto);
	
	String getNomeProduto(Integer idProduto);

	List<Produto> listAll();

	List<Produto> findAll();
}
