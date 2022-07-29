package com.projeto.dao;

import java.util.List;

import com.projeto.domain.Cliente;

public interface ClienteDAO {

	void save(Cliente c);

	void delete(Cliente c);

	Cliente getCliente(Integer idCliente);
	
	List<Cliente> findAll();
	
	List<Cliente> listAll();
}
