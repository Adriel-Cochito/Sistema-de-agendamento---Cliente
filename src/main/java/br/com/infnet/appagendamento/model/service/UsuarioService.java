package br.com.infnet.appagendamento.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.appagendamento.model.negocio.Usuario;
import br.com.infnet.appagendamento.model.repository.IUsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	public boolean isValid(String login, String senha) {		
		return usuarioRepository.autenticacao(login, senha) != null;
	}
	
	public Usuario userExist(String login) {
		return usuarioRepository.findByLogin(login);
	}
	
	public void incluir(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}

