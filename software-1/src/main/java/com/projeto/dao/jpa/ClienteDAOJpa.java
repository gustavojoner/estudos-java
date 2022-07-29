package com.projeto.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projeto.dao.ClienteDAO;
import com.projeto.domain.Cliente;

@Repository
public class ClienteDAOJpa implements ClienteDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	@Transactional
	public void save(Cliente c) {
		if (c.getIdCliente() == null) {
			entityManager.persist(c);
			entityManager.flush();
		} else {
			entityManager.merge(c);
			entityManager.flush();
		}
	}

	@Override
	@Transactional
	public void delete(Cliente c) {
		entityManager.remove(entityManager.getReference(Cliente.class, c.getIdCliente()));
		entityManager.flush();
	}

	@Override
	public Cliente getCliente(Integer idCliente) {
		return entityManager.find(Cliente.class, idCliente);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listAll() {
		List<Cliente> clientes = entityManager.createQuery("from Cliente c").getResultList();
		return clientes;
	}

	@Override
	public List<Cliente> findAll() {
		TypedQuery<Cliente> query = entityManager.createQuery("select c from Cliente c", Cliente.class);
		return query.getResultList();
	}

}
