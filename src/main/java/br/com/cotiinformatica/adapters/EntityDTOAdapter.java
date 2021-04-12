package br.com.cotiinformatica.adapters;

import br.com.cotiinformatica.dtos.TarefaGetDTO;
import br.com.cotiinformatica.entities.Tarefa;

public class EntityDTOAdapter {

	// método para converter uma Tarefa para TarefaGetDTO
	public static TarefaGetDTO getTarefa(Tarefa tarefa) {

		TarefaGetDTO dto = new TarefaGetDTO();

		dto.setIdTarefa(tarefa.getIdTarefa());
		dto.setNome(tarefa.getNome());
		dto.setDataInicio(tarefa.getDataInicio());
		dto.setDataFim(tarefa.getDataFim());
		dto.setDescricao(tarefa.getDescricao());

		return dto;
	}

}
