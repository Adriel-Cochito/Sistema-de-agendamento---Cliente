package br.com.infnet.appagendamento.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.appagendamento.model.negocio.Profissional;
import br.com.infnet.appagendamento.model.repository.IProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired private IProfissionalRepository profissionalRepository;
	
	public void incluir(Profissional profissional) {
		profissionalRepository.save(profissional);
	}
	
	public List<Profissional> obterLista() { 
		return (List<Profissional>)profissionalRepository.findAll(); 
	}

	public void excluir(Integer id) {
		profissionalRepository.deleteById(id);	
		System.out.println("Exclusão executado, id:"+id);
	}

	public Profissional obterPorId(Integer id) {
		System.out.println("Obter por ID Profissional executado : " + id);
		return profissionalRepository.findById(id).orElse(null);
	}
}
