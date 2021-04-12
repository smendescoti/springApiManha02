package br.com.cotiinformatica.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.interfaces.ITarefaRepository;

@Service
@Transactional
public class TarefaService {

	@Autowired
	private ITarefaRepository repository;

	public void saveOrUpdate(Tarefa tarefa) throws Exception {
		repository.save(tarefa);
	}

	public void delete(Tarefa tarefa) throws Exception {
		repository.delete(tarefa);
	}

	public List<Tarefa> findAll() throws Exception {
		return (List<Tarefa>) repository.findAll();
	}

	public List<Tarefa> findByUsuario(Integer idUsuario) throws Exception {
		return (List<Tarefa>) repository.findByUsuario(idUsuario);
	}

	public Tarefa findById(Integer idTarefa) throws Exception {
		return repository.findById(idTarefa).get();
	}
}
