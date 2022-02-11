package br.com.infnet.appagendamento.model.negocio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TMembro")
@PrimaryKeyJoinColumn(name = "idMembro")
public class Membro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idDetalhe")
	private Detalhe detalhe;
	
	@Override
	public String toString() {
		return String.format("%d - %s - %s - %s - %s",
				this.getId(),
				this.getNome(),
				this.getSobrenome(),
				this.getDetalhe().getEmail(),
				this.getDetalhe().getTelefone()
				);
	}
	
	public Membro() {
		// TODO Auto-generated constructor stub
	}
	public Membro(Integer id, String nome) {
		this();
		this.setId(id);
		this.setNome(nome);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Detalhe getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(Detalhe detalhe) {
		this.detalhe = detalhe;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
