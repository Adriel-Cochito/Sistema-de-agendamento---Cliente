package br.com.infnet.appagendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.appagendamento.model.negocio.Detalhe;
import br.com.infnet.appagendamento.model.service.DetalheService;
@Controller
public class DetalheController {

	@Autowired private DetalheService detalheService;
	
	@GetMapping(value = "/detalhe")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		
		return "detalhe/detalhe";
	}
	
	@GetMapping(value = "/detalhes")
	public String lista(
				Model model
			) {
		model.addAttribute("detalhes", detalheService.obterLista());
		System.out.println("Controller /detalhe lista, iniciado");
		return "detalhe/lista";
	}
	
	@PostMapping(value = "/detalhe/incluir")
	public String incluir(
				Detalhe detalhe
			) {
		
		detalheService.incluir(detalhe);
		
		return "redirect:/detalhes";
	}

	@GetMapping(value = "/detalhe/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			detalheService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/detalhes";
	}
	
	@GetMapping(value = "/detalhe/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		
		model.addAttribute("detalhe", detalheService.obterPorId(id));
		model.addAttribute("operacao", "alteração");
		
		return "detalhe/detalhe";
	}
}
