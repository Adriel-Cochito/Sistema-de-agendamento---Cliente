package br.com.infnet.appagendamento.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.appagendamento.model.negocio.Detalhe;

@FeignClient(url = "http://localhost:8081/api/membro", name = "detalheClient")
public interface IDetalheClient {

	@GetMapping(value = "/detalhes")
	public List<Detalhe> obterLista();
	
	@GetMapping(value = "/detalhe/{id}")
	public Detalhe obterPorId(@PathVariable Integer id);
	
	@PostMapping(value = "/detalhe/incluir")
	public void incluir(Detalhe detalhe);
	
	@GetMapping(value = "/detalhe/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/detalhe/{id}/alterar")
	public void alterar(@PathVariable Integer id);

}
