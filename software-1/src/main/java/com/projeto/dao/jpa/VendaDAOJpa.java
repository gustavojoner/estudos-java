package com.projeto.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projeto.dao.VendaDAO;
import com.projeto.domain.Venda;

@Repository
public class VendaDAOJpa implements VendaDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	@Transactional
	public void save(Venda v) {

		if (v.getIdVenda() == null) {
			entityManager.persist(v);
			entityManager.flush();
		} else {
			entityManager.merge(v);
			entityManager.flush();
		}
	}

	@Override
	@Transactional
	public void delete(Venda v) {
		entityManager.remove(entityManager.getReference(Venda.class, v.getIdVenda()));
		entityManager.flush();
	}

	@Override
	public Venda getVenda(Integer idVenda) {
		return entityManager.find(Venda.class, idVenda);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venda> listAll() {
		List<Venda> vendas = entityManager.createQuery("from Venda v").getResultList();
		return vendas;
	}

	@Override
	public List<Venda> findAll() {
		TypedQuery<Venda> query = entityManager.createQuery("select v from Venda v", Venda.class);
		return query.getResultList();

	}
}
