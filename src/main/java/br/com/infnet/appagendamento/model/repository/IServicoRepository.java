package br.com.infnet.appagendamento.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appagendamento.model.negocio.Servico;

@Repository
public interface IServicoRepository extends CrudRepository<Servico, Integer>{
	
	List<Servico> findAll(Sort by);
}
