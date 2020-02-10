package br.com.cadastro.veiculos.apis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario_internet")
public class Usuario {
	
	@Id
	@Column(name="CTL_USER")
	private long id;
	
	@Column(name="USR_NAME")
	private String username;
	
	@Column(name="COD_SENHA")
	@JsonIgnore
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
