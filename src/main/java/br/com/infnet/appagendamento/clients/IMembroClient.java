package br.com.infnet.appagendamento.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.appagendamento.model.negocio.Membro;

@FeignClient(url = "http://localhost:8081/api/membro", name = "membroClient")
public interface IMembroClient {

	@GetMapping(value = "/membros")
	public List<Membro> obterLista();
	
	@GetMapping(value = "/membro/{id}")
	public Membro obterPorId(@PathVariable Integer id);
	
	@PostMapping(value = "/membro/incluir")
	public void incluir(Membro membro);
	
	@GetMapping(value = "/membro/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/membro/{id}/alterar")
	public void alterar(@PathVariable Integer id);
	
}
