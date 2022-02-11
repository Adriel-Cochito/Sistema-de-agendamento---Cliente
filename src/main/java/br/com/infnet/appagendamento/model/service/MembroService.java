package br.com.infnet.appagendamento.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.appagendamento.clients.IMembroClient;
import br.com.infnet.appagendamento.model.negocio.Membro;
import br.com.infnet.appagendamento.model.repository.IMembroRepository;

@Service
public class MembroService {

	@Autowired private IMembroRepository membroRepository;
	@Autowired private IMembroClient membroClient;
	
	public List<Membro> obterLista(){
		return membroClient.obterLista();
	}
	
	public Membro obterPorId(Integer id) {
		return membroClient.obterPorId(id);
	}

	public void incluir(Membro membro) {
		membroRepository.save(membro);
	}

	public void excluir(Integer id) {
		membroRepository.deleteById(id);
	}
}