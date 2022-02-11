package br.com.infnet.appagendamento.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appagendamento.model.negocio.Profissional;

@Repository
public interface IProfissionalRepository extends CrudRepository<Profissional, Integer>{

	List<Profissional> findAll(Sort by);
}
