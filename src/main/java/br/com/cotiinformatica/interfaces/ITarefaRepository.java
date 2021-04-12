package br.com.cotiinformatica.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Tarefa;

public interface ITarefaRepository extends CrudRepository<Tarefa, Integer> {

	// Consulta em JPQL - Java Persistence Query Language
	// para obter as tarefas de um determinado usuario..
	@Query("select t from Tarefa t where t.usuario.idUsuario = :param")
	List<Tarefa> findByUsuario(@Param("param") Integer idUsuario);

}
