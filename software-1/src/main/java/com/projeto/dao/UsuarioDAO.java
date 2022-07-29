package com.projeto.dao;

import java.util.List;

import com.projeto.domain.Usuario;

public interface UsuarioDAO {
	
	void save(Usuario u);

	void delete(Usuario u);
	
	Usuario getUsuario(Integer idUsuario);
	
	String getLoginUsuario(Integer idUsuario);
	
	String getSenhaUsuario(Integer idUsuario);
	
	Usuario getIdUsuario(String loginUsuario);
	
	Usuario findByLogin(String loginUsuario);

	List<Usuario> listAll();

	List<Usuario> findAll();

}
