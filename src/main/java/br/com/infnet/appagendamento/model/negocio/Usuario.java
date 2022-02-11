package br.com.infnet.appagendamento.model.negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "TUsuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String login;
	private String senha;
	
	@Override
	public String toString() {
		return String.format("%s",
				this.getLogin()
				);
	}
	
	public Usuario() {
	}
	public Usuario(Integer id) {
		this();
		this.setId(id);
	}

	
//		 Getterns and Setters --------------------
	
	public Usuario(Integer id, String login, String senha) {
		this(id);
		this.setLogin(login);
		this.setSenha(senha);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}