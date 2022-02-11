package br.com.infnet.appagendamento.model.service;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.infnet.appagendamento.model.negocio.Agendamento;
import br.com.infnet.appagendamento.model.repository.IAgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired private IAgendamentoRepository repository;
	@Autowired private ServicoService servicoService;
	public Double valor = 0.0;
	public Double valorTotal = 0.0;
	
	public void incluir(Agendamento agendamento) {
		repository.save(agendamento);
	}
	
	public List<Agendamento> obterLista(){
		return (List<Agendamento>)repository.findAll(Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public Object obterDataAtual() {
		LocalDate data = LocalDate.now ();
		return data;
	}
	
	
	public Object obterDataLimite() {
		LocalDate DataLimite = LocalDate.now ().plusDays(15);
		return DataLimite;
	}
	
	public String weekDay() {
		Calendar rightNow = Calendar.getInstance();
		System.out.println(rightNow);
		return new DateFormatSymbols().getWeekdays()[rightNow.get(Calendar.DAY_OF_WEEK)];
	}
	
	public Agendamento obterPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	public Double obterValorTotal(Optional<String[]> serv) {
		valorTotal = (double) 0;
		for(String id : serv.get()) {		
			System.out.println("obterValorTotal, iniciado");
			System.out.println("Preco: " + servicoService.obterPorId(Integer.valueOf(id)).getPreco());
			valor = servicoService.obterPorId(Integer.valueOf(id)).getPreco(); 
			valorTotal = valorTotal + valor;
		}
		return valorTotal;
	}
}

