package br.com.infnet.appagendamento.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.appagendamento.clients.IDetalheClient;
import br.com.infnet.appagendamento.model.negocio.Detalhe;
import br.com.infnet.appagendamento.model.repository.IDetalheRepository;

@Service
public class DetalheService {

	@Autowired private IDetalheRepository detalheRepository;
	@Autowired private IDetalheClient detalheClient;
	
	public List<Detalhe> obterLista(){
		return detalheClient.obterLista();
	}
	
	public Detalhe obterPorId(Integer id) {
		return detalheClient.obterPorId(id);
	}

	public void incluir(Detalhe membro) {
		detalheRepository.save(membro);
	}

	public void excluir(Integer id) {
		detalheRepository.deleteById(id);
	}
}