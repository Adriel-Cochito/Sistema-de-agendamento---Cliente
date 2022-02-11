package br.com.infnet.appagendamento.model.negocio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TServico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descricao;
	private Double preco;
	
	@ManyToMany(mappedBy = "servicos")
	private List<Agendamento> agendamentos;
	
	public Servico() {
	}
	
	public Servico(Integer id, String titulo, String descricao, Double preco) {
		this();
		this.setId(id);
		this.setTitulo(titulo);
		this.setDescricao(descricao);
		this.setPreco(preco);
	}
	public Servico(Servico servico) {
		this();
		this.setId(id);
		this.setTitulo(titulo);
		this.setDescricao(descricao);
		this.setPreco(preco);
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s - %s - R$%2",
				this.getId(),
				this.getTitulo(),
				this.getDescricao(),
				this.getPreco()
				);
	}

	public Servico(Integer id) {
		this();
		this.setId(id);
	}
	
	
// Getters and Setters  ---------------------------------------
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
