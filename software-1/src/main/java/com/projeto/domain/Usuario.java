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

import com.projeto.domain.command.CriptografaSenhaCommand;

@Entity
@Table(name = "usuarios")
public class Usuario {

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
	@Column(name = "id_usuario", unique = true, nullable = false)
	private Integer idUsuario;
	@Column(name = "login_usuario", unique = true, nullable = false)
	private String loginUsuario;
	@Column(name = "senha_usuario", unique = false, nullable = false)
	private String senhaUsuario;

	public Usuario(Integer idUsuario, String loginUsuario, String senhaUsuario) {
		this.idUsuario = idUsuario;
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;

	}

	public Usuario() {
	}

	public String toString() {
		return getLoginUsuario();
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(idUsuario, other.idUsuario);
	}

	public void setIdUsuario(Integer idUsuario) {
		Object oldValue = this.idUsuario;
		this.idUsuario = idUsuario;
		changeSupport.firePropertyChange("idUsuario", oldValue, idUsuario);
	}
	
	public void setLoginUsuario(String loginUsuario) {
		Object oldValue = this.loginUsuario;
		this.loginUsuario = loginUsuario;
		changeSupport.firePropertyChange("loginUsuario", oldValue, loginUsuario);
	}
	
	public void setSenhaUsuario(String senhaUsuario) {
		Object oldValue = this.senhaUsuario;
		this.senhaUsuario = new CriptografaSenhaCommand(senhaUsuario).execute();
		changeSupport.firePropertyChange("senhaUsuario", oldValue, senhaUsuario);
	}

}
