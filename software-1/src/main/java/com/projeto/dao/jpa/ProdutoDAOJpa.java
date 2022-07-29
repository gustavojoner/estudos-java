package com.projeto.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projeto.dao.ProdutoDAO;
import com.projeto.domain.Produto;

@Repository
public class ProdutoDAOJpa implements ProdutoDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	@Transactional
	public void save(Produto p) {
		if (p.getIdProduto() == null) {
			entityManager.persist(p);
			entityManager.flush();
		} else {
			entityManager.merge(p);
			entityManager.flush();
		}
	}

	@Override
	@Transactional
	public void delete(Produto p) {
		entityManager.remove(entityManager.getReference(Produto.class, p.getIdProduto()));
		entityManager.flush();
	}

	@Override
	public Produto getProduto(Integer idProduto) {
		return entityManager.find(Produto.class, idProduto);
	}

	@Override
	public String getNomeProduto(Integer idProduto) {
		return entityManager.find(Produto.class, idProduto).getNomeProduto();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listAll() {
		List<Produto> produtos = entityManager.createQuery("from Produto p").getResultList();
		return produtos;
	}

	@Override
	public List<Produto> findAll() {
		TypedQuery<Produto> query = entityManager.createQuery("select p from Produto p", Produto.class);
		return query.getResultList();
	}
}
