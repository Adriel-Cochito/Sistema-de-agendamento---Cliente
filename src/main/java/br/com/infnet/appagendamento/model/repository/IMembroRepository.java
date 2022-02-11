package br.com.infnet.appagendamento.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appagendamento.model.negocio.Membro;

@Repository
public interface IMembroRepository extends CrudRepository<Membro, Integer> {

	List<Membro> findAll(Sort byId);
}
