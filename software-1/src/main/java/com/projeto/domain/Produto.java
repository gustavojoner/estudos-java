package com.projeto.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "produtos")
public class Produto {

	@Transient
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changeSupport.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changeSupport.removePropertyChangeListener(l);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "id_produto", unique = true, nullable = false)
	private Integer idProduto;
	@Column(name = "nome_produto", unique = false, nullable = false)
	private String nomeProduto;
	@Column(name = "valor_produto", unique = false, nullable = false)
	private Integer valorProduto;
	@Column(name = "quantidade_produto", unique = false, nullable = false)
	private Integer quantidadeItem;
	@Column(name = "descricao_produto", unique = false, nullable = false)
	private String descricaoProduto;

	public Produto(Integer idProduto, String nome, Integer valor, Integer quantidade, String descricao) {

		this.idProduto = idProduto;
		this.nomeProduto = nome;
		this.valorProduto = valor;
		this.quantidadeItem = quantidade;
		this.descricaoProduto = descricao;

	}

	public Produto() {
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		Object oldValue = this.nomeProduto;
		this.nomeProduto = nomeProduto;
		changeSupport.firePropertyChange("nomeProduto", oldValue, nomeProduto);
	}

	public Integer getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Integer valorProduto) {
		Object oldValue = this.valorProduto;
		this.valorProduto = valorProduto;
		changeSupport.firePropertyChange("valorProduto", oldValue, valorProduto);
	}

	public Integer getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(Integer quantidadeItem) {
		Object oldValue = this.quantidadeItem;
		this.quantidadeItem = quantidadeItem;
		changeSupport.firePropertyChange("quantidadeItem", oldValue, quantidadeItem);
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		Object oldValue = this.descricaoProduto;
		this.descricaoProduto = descricaoProduto;
		changeSupport.firePropertyChange("descricaoProduto", oldValue, descricaoProduto);
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		Object oldValue = this.idProduto;
		this.idProduto = idProduto;
		changeSupport.firePropertyChange("idProduto", oldValue, idProduto);
	}

	public String toString() {
		return getIdProduto() + " - " + getNomeProduto();
	}

	public void vender(Integer quantidadeVenda) {
		this.setQuantidadeItem(this.getQuantidadeItem() - quantidadeVenda);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(idProduto, other.idProduto);
	}
}
