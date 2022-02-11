package br.com.infnet.appagendamento.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appagendamento.model.negocio.Agendamento;

@Repository
public interface IAgendamentoRepository extends CrudRepository<Agendamento, Integer>{
	
	List<Agendamento> findAll(Sort by);
}
