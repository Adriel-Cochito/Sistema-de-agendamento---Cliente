package br.com.infnet.appagendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.appagendamento.model.negocio.Profissional;
import br.com.infnet.appagendamento.model.service.ProfissionalService;

@Controller
public class ProfissionalController {

	@Autowired private ProfissionalService profissionalService;
	
	
	@RequestMapping(value = "/profissional/lista")
	public String lista(
			Model model
			) {	
		
		model.addAttribute("profissionais", profissionalService.obterLista());
		System.out.println("cadastros/profissional");
		return "profissional/lista";
	}
	
	@RequestMapping(value = "/profissional/cadastro")
	public String cadastro(
			Model model
			) {	
		
		model.addAttribute("profissionais", profissionalService.obterLista());
		System.out.println("cadastros/profissional");
		return "profissional/inclusao";
	}
	
	
	@PostMapping(value = "/profissional/inclusao") 
	public String cadastrar(
			Model model,
			String nome,
 			Profissional profissional
			) {
		
		profissional.setLogin(nome); // Para cadastro automatico de logine senha através do nome
		profissional.setSenha(nome);

		profissionalService.incluir(profissional);
	
		model.addAttribute("profissionalCadastrado", profissional);
		
		return "redirect:/profissional/lista";
	}
	

	@GetMapping(value = "/profissional/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		System.out.println("Excluir iniciado");
		
		try {
			profissionalService.excluir(id);
			System.out.println("try executado id:"+id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			System.out.println("Catch executado id:"+id);
			
			return this.lista(model);
		}
		
		
		return "redirect:/profissional/lista";
	}
	
	@GetMapping(value = "/profissional/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		
		model.addAttribute("profissional", profissionalService.obterPorId(id));
		model.addAttribute("operacao", "alteração");
		
		return "profissional/inclusao";
	}
}

