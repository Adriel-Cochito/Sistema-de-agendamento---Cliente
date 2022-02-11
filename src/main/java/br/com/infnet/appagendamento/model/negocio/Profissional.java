package br.com.infnet.appagendamento.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TProfissional")
@PrimaryKeyJoinColumn(name = "idProfissional")
public class Profissional extends Usuario{

	private String nome;
	private String apelido;


	@Override
	public String toString() {
		return String.format("%d - %s - '%s'",
				this.getId(),
				this.getNome(),
				this.getApelido()
				);
	}
	
// Getters and Setters-------------------------------
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

}

