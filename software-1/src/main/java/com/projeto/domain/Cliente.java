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
@Table(name = "clientes")
public class Cliente {
	
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
	@Column(name = "id_cliente", unique = true, nullable = false)
	private Integer idCliente;
	@Column(name = "nome_cliente", unique = false, nullable = false)
	private String nomeCliente;
	@Column(name = "contato_cliente", unique = false, nullable = false)
	private Long contatoCliente;
	@Column(name = "obs_cliente", unique = false, nullable = false)
	private String obsCliente;

	public Cliente(Integer idCliente, String nomeCliente, Long contatoCliente, String obsCliente) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.contatoCliente = contatoCliente;
		this.obsCliente = obsCliente;

	}

	public Cliente() {}

	public String toString() {
		return getIdCliente() + " - " + getNomeCliente();
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		Object oldValue = this.idCliente;
		this.idCliente = idCliente;
		changeSupport.firePropertyChange("idCliente", oldValue, idCliente);
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		Object oldValue = this.nomeCliente;
		this.nomeCliente = nomeCliente;
		changeSupport.firePropertyChange("nomeCliente", oldValue, nomeCliente);
	}

	public Long getContatoCliente() {
		return contatoCliente;
	}

	public void setContatoCliente(Long contatoCliente) {
		Object oldValue = this.contatoCliente;
		this.contatoCliente = contatoCliente;
		changeSupport.firePropertyChange("contatoCliente", oldValue, contatoCliente);
	}

	public String getObsCliente() {
		return obsCliente;
	}

	public void setObsCliente(String obsCliente) {
		Object oldValue = this.obsCliente;
		this.obsCliente = obsCliente;
		changeSupport.firePropertyChange("obsCliente", oldValue, obsCliente);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}
}
