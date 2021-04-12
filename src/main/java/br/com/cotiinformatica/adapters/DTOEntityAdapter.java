package br.com.cotiinformatica.adapters;

import br.com.cotiinformatica.dtos.TarefaPostDTO;
import br.com.cotiinformatica.dtos.TarefaPutDTO;
import br.com.cotiinformatica.dtos.UsuarioPostDTO;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;

public class DTOEntityAdapter {

	// método para converter um UsuarioPostDTO para Usuario
	public static Usuario getUsuario(UsuarioPostDTO dto) {

		Usuario usuario = new Usuario(); // entidade

		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());

		return usuario;
	}

	// método para converter um TarefaPostDTO para Tarefa
	public static Tarefa getTarefa(TarefaPostDTO dto) {

		Tarefa tarefa = new Tarefa();

		tarefa.setNome(dto.getNome());
		tarefa.setDataInicio(dto.getDataInicio());
		tarefa.setDataFim(dto.getDataFim());
		tarefa.setDescricao(dto.getDescricao());

		return tarefa;
	}

	// método para converter um TarefaPutDTO para Tarefa
	public static Tarefa getTarefa(TarefaPutDTO dto) {

		Tarefa tarefa = new Tarefa();

		tarefa.setIdTarefa(dto.getIdTarefa());
		tarefa.setNome(dto.getNome());
		tarefa.setDataInicio(dto.getDataInicio());
		tarefa.setDataFim(dto.getDataFim());
		tarefa.setDescricao(dto.getDescricao());

		return tarefa;
	}

}
