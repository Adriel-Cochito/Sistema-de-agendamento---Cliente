package br.com.infnet.appagendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.appagendamento.model.negocio.Detalhe;
import br.com.infnet.appagendamento.model.negocio.Membro;
import br.com.infnet.appagendamento.model.service.DetalheService;
import br.com.infnet.appagendamento.model.service.MembroService;

@Controller
public class MembroController {

	@Autowired private MembroService membroService;
	@Autowired private DetalheService detalheService;
	
	@GetMapping(value = "/membro")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		
		return "membro/detalhe";
	}
	
	@PostMapping(value = "/membro/incluir")
	public String incluir(
				Model model,
				Membro membro,
				Detalhe detalhe
			) {
		
		
		
		detalheService.incluir(detalhe);
		membro.setDetalhe(detalhe);
		membroService.incluir(membro);
		model.addAttribute("msgSuccess", "Operação realizada com sucesso!! id: "+ membro.getId());
		return this.lista(model);
	}
	
	@GetMapping(value = "/membros")
	public String lista(
				Model model
			) {
		model.addAttribute("membros", membroService.obterLista());
		
		System.out.println("Controller /membros lista, executado");
		
		return "membro/lista";
	}

	@GetMapping(value = "/membro/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			Integer s = membroService.obterPorId(id).getDetalhe().getId(); //Grava id do "Detalhe" relacionado antes de excluir o membro e perder o id
			membroService.excluir(id);	// Exclui o Membro	
			detalheService.excluir(s);	// Permite excluir o detalhe, pois não há membro relacionado para impedir
			
			model.addAttribute("msgSuccess", "Exclusão realizada com sucesso!! id: "+id);
					
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!! id: " + id);
			return this.lista(model);
		}
		
		return this.lista(model);
	}
	
	@GetMapping(value = "/membro/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		model.addAttribute("operacao", "alteração");
		
		model.addAttribute("membro", membroService.obterPorId(id));
		
		return "membro/detalhe";
	}
	
	@GetMapping(value = "/membro/{id}/{id2}/consulta")
	public String consultar(
				Model model,
				@PathVariable Integer id,
				@PathVariable Integer id2
			) {
		
		model.addAttribute("operacao", "consulta");
		
		model.addAttribute("membro", membroService.obterPorId(id));
		model.addAttribute("detalhe", detalheService.obterPorId(id2));
		
		return "membro/consulta";
	}
}