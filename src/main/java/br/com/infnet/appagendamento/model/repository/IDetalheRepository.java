package br.com.infnet.appagendamento.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appagendamento.model.negocio.Detalhe;

@Repository
public interface IDetalheRepository extends CrudRepository<Detalhe, Integer> {

	List<Detalhe> findAll(Sort by);
}

