package br.com.infnet.appagendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.com.infnet.appagendamento.model.negocio.Usuario;
import br.com.infnet.appagendamento.model.service.UsuarioService;

@Controller
@SessionAttributes("user")
public class AppController {

	@Autowired private UsuarioService usuarioService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showInit() {
		return "login";
	}
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String showTest() {
		return "teste";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return this.showInit();
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showHome(
				Model model,
				@RequestParam String login,
				@RequestParam String senha
			) {

		Usuario usuario = usuarioService.userExist(login);
		
		if(usuario == null) {
			return "usuario/detalhe";
			
		}else if (!usuarioService.isValid(login, senha)) {
			model.addAttribute("mensagem", "Credenciais inválidas: " + login);
			return "login";
			
		}  else {
			model.addAttribute("user", usuario);
			return "home";
		}		
	}
	
	
	@RequestMapping(value = "/sair", method = RequestMethod.GET)
	public String sair(SessionStatus session) {
		
		session.setComplete();		
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/usuario/cadastro")
	public String novoUsuario() {
		return "usuario/detalhe";
	}
	
	@RequestMapping(value = "/cadastro")
	public String cadastros() {
		return "cadastros";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome() {	
		return "home";
	}
	
}
