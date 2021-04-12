package br.com.cotiinformatica.validations;

import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.dtos.TarefaPutDTO;

public class TarefaPutValidation {

	public List<String> validate(TarefaPutDTO dto) {

		List<String> result = new ArrayList<String>();

		if (dto.getIdTarefa() == null || dto.getIdTarefa() == 0) {
			result.add("Por favor, informe o id da tarefa.");
		}

		if (dto.getNome() == null || dto.getNome().length() == 0) {
			result.add("Por favor, informe o nome da tarefa.");
		}

		if (dto.getDataInicio() == null) {
			result.add("Por favor, informe a data de início da tarefa.");
		}

		if (dto.getDataFim() == null) {
			result.add("Por favor, informe a data de término da tarefa.");
		}

		if (dto.getDescricao() == null || dto.getDescricao().length() == 0) {
			result.add("Por favor, informe a descrição da tarefa.");
		}

		return result;
	}

}
