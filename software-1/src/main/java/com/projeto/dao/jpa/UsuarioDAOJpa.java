package com.projeto.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projeto.dao.UsuarioDAO;
import com.projeto.domain.Usuario;

@Repository
public class UsuarioDAOJpa implements UsuarioDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	@Transactional
	public void save(Usuario u) {
		if (u.getIdUsuario() == null) {
			entityManager.persist(u);
			entityManager.flush();
		} else {
			entityManager.merge(u);
			entityManager.flush();
		}
	}

	@Override
	@Transactional
	public void delete(Usuario u) {
		entityManager.remove(entityManager.getReference(Usuario.class, u.getIdUsuario()));
		entityManager.flush();
	}

	@Override
	public Usuario getIdUsuario(String loginUsuario) {
		return entityManager.find(Usuario.class, loginUsuario);
	}

	@Override
	public Usuario getUsuario(Integer idUsuario) {
		return entityManager.find(Usuario.class, idUsuario);
	}

	@Override
	public String getLoginUsuario(Integer idUsuario) {
		return entityManager.find(Usuario.class, idUsuario).getLoginUsuario();
	}

	@Override
	public String getSenhaUsuario(Integer idUsuario) {
		return entityManager.find(Usuario.class, idUsuario).getSenhaUsuario();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listAll() {
		List<Usuario> usuarios = entityManager.createQuery("from Usuario u").getResultList();
		return usuarios;
	}

	@Override
	public List<Usuario> findAll() {
		TypedQuery<Usuario> query = entityManager.createQuery("select u from Usuario u", Usuario.class);
		return query.getResultList();
	}

	@Override
	public Usuario findByLogin(String loginUsuario) {
		TypedQuery<Usuario> query = entityManager
				.createQuery("select u from Usuario u where u.loginUsuario = :loginUsuario", Usuario.class);
		query.setParameter("loginUsuario", loginUsuario);
		return query.getSingleResult();
	}

}
