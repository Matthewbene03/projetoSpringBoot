package com.matthews.projetoCourse.entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String nomeUser;
	private String emailUser;
	private String telefoneUser;
	private String senhaUser;
	
	public User() {
	}
	
	public User(Long idUser, String nomeUser, String emailUser, String telefoneUser, String senhaUser) {
		this.idUser = idUser;
		this.nomeUser = nomeUser;
		this.emailUser = emailUser;
		this.telefoneUser = telefoneUser;
		this.senhaUser = senhaUser;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNomeUser() {
		return nomeUser;
	}
	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public String getTelefoneUser() {
		return telefoneUser;
	}
	public void setTelefoneUser(String telefoneUser) {
		this.telefoneUser = telefoneUser;
	}
	public String getSenhaUser() {
		return senhaUser;
	}
	public void setSenhaUser(String senhaUser) {
		this.senhaUser = senhaUser;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idUser);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(idUser, other.idUser);
	}
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nomeUser=" + nomeUser + ", emailUser=" + emailUser + ", telefoneUser="
				+ telefoneUser + ", senhaUser=" + senhaUser + "]";
	}
}
