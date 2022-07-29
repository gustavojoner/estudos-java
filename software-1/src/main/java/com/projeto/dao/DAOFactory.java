package com.projeto.dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DAOFactory {

	static DAOFactory instance;
	
	@Autowired
	private  ProdutoDAO produtoDAO;
	@Autowired
	private  VendaDAO vendaDAO;
	@Autowired
	private  ClienteDAO clienteDAO;
	@Autowired
	private  UsuarioDAO usuarioDAO;

	@PostConstruct
	protected void setupInstance() {
		DAOFactory.instance = this;
	}
	
	private ProdutoDAO getInstanceProdutoDAO() {
		return produtoDAO;
	}
	
	public static ProdutoDAO getProdutoDAO() {
		return instance.getInstanceProdutoDAO();
	}
	
	private VendaDAO getInstanceVendaDAO() {
		return vendaDAO;
	}
	
	public static VendaDAO getVendaDAO() {
		return instance.getInstanceVendaDAO();
	}
	
	private ClienteDAO getInstanceClienteDAO() {
		return clienteDAO;
	}
	
	public static ClienteDAO getClienteDAO() {
		return instance.getInstanceClienteDAO();
	}
	
	private UsuarioDAO getInstanceUsuarioDAO() {
		return usuarioDAO;
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return instance.getInstanceUsuarioDAO();
	}
}
