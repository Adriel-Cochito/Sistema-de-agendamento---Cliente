package br.com.infnet.appagendamento.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.infnet.appagendamento.model.negocio.Agendamento;
import br.com.infnet.appagendamento.model.negocio.Servico;
import br.com.infnet.appagendamento.model.service.AgendamentoService;
import br.com.infnet.appagendamento.model.service.MembroService;
import br.com.infnet.appagendamento.model.service.ProfissionalService;
import br.com.infnet.appagendamento.model.service.ServicoService;

@Controller
public class AgendamentoController {
	
	@Autowired private AgendamentoService agendamentoService;
	@Autowired private ServicoService servicoService;
	@Autowired private ProfissionalService profissionalService;
	@Autowired private MembroService membroService;
	
	@RequestMapping(value = "/agendamento")
	public String agendamento(
			Model model
			) {

		model.addAttribute("dataAtual", agendamentoService.obterDataAtual());
		model.addAttribute("dataLimite", agendamentoService.obterDataLimite());
		model.addAttribute("servicos", servicoService.obterLista());
		model.addAttribute("profissionais", profissionalService.obterLista());
		model.addAttribute("membros", membroService.obterLista());
		
		return "agenda/agendamento";
	}
	
	@PostMapping(value = "/agendar") //agendar Selecionar
	public String agendar(
			Model model,
			@RequestParam Optional<String[]> serv,
 			Agendamento agendamento
			) {
		System.out.println("/agendar controller, iniciado");
		
		
		if(serv.isPresent()) {

		List<Servico> lista = new ArrayList<Servico>();
		
		for(String id : serv.get()) {
			System.out.println("Lista.add serv, iniciado");		
			lista.add(servicoService.obterPorId(Integer.valueOf(id)));
		}
		
		agendamento.setValorTotal(agendamentoService.obterValorTotal(serv));
		agendamento.setServicos(lista);
		agendamentoService.incluir(agendamento);

		model.addAttribute("agendamentos", agendamentoService.obterLista());
		return "redirect:/agenda";
		}

		model.addAttribute("msgError", "Selecione no mínimo um serviço");
		
		return this.agendamento(model);
	}
	
	@RequestMapping(value = "/agenda")
	public String lista(
			Model model
			) {
		
		model.addAttribute("agendamentos", agendamentoService.obterLista());
		model.addAttribute("membros", membroService.obterLista());
		
		return "agenda/lista";
	}
	
	@GetMapping(value = "/agenda/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			agendamentoService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/agenda";
	}
	
	@GetMapping(value = "/agenda/{id}/consultar")
	public String consultar(
				Model model,
				@PathVariable Integer id
			) {
		model.addAttribute("operacao", "consulta");
		
		model.addAttribute("agendamento", agendamentoService.obterPorId(id));
		
		return "agenda/consultar";
	}
	
}
