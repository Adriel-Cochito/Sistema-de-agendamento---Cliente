package br.com.infnet.appagendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.appagendamento.model.negocio.Servico;
import br.com.infnet.appagendamento.model.service.ServicoService;

@Controller
public class ServicoController {
	
	@Autowired private ServicoService servicoService;
	public Double preco = 0.0;
	public Double precoAtualizado = 0.0;
	
	@RequestMapping(value = "/servico/lista")
	public String lista(
			Model model
			) {		
		
		model.addAttribute("servicos", servicoService.obterLista());
		
		return "servico/lista";
	}
	
	@RequestMapping(value = "/servico/cadastro")
	public String cadastro(
			Model model
			) {		
		
		model.addAttribute("servicos", servicoService.obterLista());
		
		return "servico/inclusao";
	}
	
	
	@PostMapping(value = "/servico/inclusao") //agendar Selecionar
	public String cadastrar(
			Model model,
 			Servico servico
			) {

		servicoService.incluir(servico);
	
		model.addAttribute("servicos", servicoService.obterLista());
		
		return "redirect:/servico/lista";
	}
	
	@GetMapping(value = "/servico/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		System.out.println("Excluir iniciado");
		
		try {
			servicoService.excluir(id); 
			System.out.println("try Servico executado id:"+id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			System.out.println("Catch Servico executado id:"+id);
			
			return this.lista(model);
		}
		
		
		return "redirect:/servico/lista";
	}
	
	@GetMapping(value = "/servico/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		
		model.addAttribute("servico", servicoService.obterPorId(id));
		model.addAttribute("operacao", "alteração");
		
		return "servico/inclusao";
	}
	

}

