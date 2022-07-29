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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "vendas")
public class Venda {

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
	@Column(name = "id_venda", unique = true, nullable = false)
	private Integer idVenda;
	@ManyToOne
	@JoinColumn(name = "id_produto", unique = false, nullable = false)
	private Produto produto;
	@Column(name = "quantidade_venda", unique = false, nullable = false)
	private Integer quantidadeVenda;
	@ManyToOne
	@JoinColumn(name = "id_cliente", unique = false, nullable = false)
	private Cliente cliente;

	public Venda(Integer idVenda, Produto produto, Integer quantidadeVenda, Cliente cliente) {
		this.idVenda = idVenda;
		this.produto = produto;
		this.quantidadeVenda = quantidadeVenda;
		this.cliente = cliente;
	}

	public Venda() {}
	
	public Produto getProduto() {
		return produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		Object oldValue = this.idVenda;
		this.idVenda = idVenda;
		changeSupport.firePropertyChange("idVenda", oldValue, idVenda);
	}

	public Integer getQuantidadeVenda() {
		return quantidadeVenda;
	}

	public void setQuantidadeVenda(Integer quantidadeVenda) {
		Object oldValue = this.quantidadeVenda;
		this.quantidadeVenda = quantidadeVenda;
		changeSupport.firePropertyChange("quantidadeVenda", oldValue, quantidadeVenda);
	}

	public void setCliente(Cliente cliente) {
		Object oldValue = this.cliente;
		this.cliente = cliente;
		changeSupport.firePropertyChange("cliente", oldValue, cliente);
	}

	public void setProduto(Produto produto) {
		Object oldValue = this.produto;
		this.produto = produto;
		changeSupport.firePropertyChange("produto", oldValue, produto);
	}

	public boolean isDisponivel() {
		if (produto.getQuantidadeItem() > quantidadeVenda) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVenda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(idVenda, other.idVenda);
	}
}