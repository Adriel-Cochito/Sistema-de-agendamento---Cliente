package br.com.infnet.appagendamento.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.appagendamento.model.negocio.Servico;
import br.com.infnet.appagendamento.model.repository.IServicoRepository;

@Service
public class ServicoService {

	@Autowired private IServicoRepository servicoRepository;

	public Double preco = 0.0;
	public Double precoAtualizado = 0.0;
	
	public void incluir(Servico servico) {
		servicoRepository.save(servico);
	}
	
	public List<Servico> obterLista() { 
		return (List<Servico>)servicoRepository.findAll(); 
	}
	
	public void excluir(Integer id) {
		servicoRepository.deleteById(id);	
		System.out.println("Exclusão executado, id:"+id);
	}

	public Servico obterPorId(Integer id) {
		System.out.println("Obter por ID Servico executado : " + id);
		return servicoRepository.findById(id).orElse(null);
	}

	public void alterarPreco(Integer id) {
		preco = obterPorId(id).getPreco();
		
		System.out.println("Preco: " + preco);
		
		precoAtualizado = preco - 1.0; 
		
		System.out.println("Preco atualizado: " + precoAtualizado);
		
		obterPorId(id).setPreco(precoAtualizado);
		
		System.out.println("Preco Servico: " + obterPorId(id).getPreco());
		
	}

}