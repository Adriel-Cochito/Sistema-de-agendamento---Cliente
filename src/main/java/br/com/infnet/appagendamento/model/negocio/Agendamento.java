package br.com.infnet.appagendamento.model.negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAgendamento")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String data;
	private String horario;
	private Double valorTotal;
	
	@ManyToMany(cascade = CascadeType.DETACH)									
	@JoinTable(name = "TAgendamentoServico",									
		joinColumns = {@JoinColumn(name="idAgendamento")},								
		inverseJoinColumns = {@JoinColumn(name="idServico")})																
	private List<Servico> servicos;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idProfissional")
	private Profissional profissional;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idMembro")
	private Membro membro;

	@Override
	public String toString() {
		return String.format("%d - %s - %s - %s - R$%2 - %s",
				this.getId(),
				this.getMembro().getNome(),
				this.getData(),
				this.getHorario(),
				this.getValorTotal(),
				this.getServicos()
				);
	}
	
	
// Getters and Setters -------------------------
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public List<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double double1) {
		this.valorTotal = double1;
	}
	
	
}

