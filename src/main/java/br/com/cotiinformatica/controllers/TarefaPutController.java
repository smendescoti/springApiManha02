package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.adapters.DTOEntityAdapter;
import br.com.cotiinformatica.dtos.TarefaPutDTO;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.services.TarefaService;
import br.com.cotiinformatica.services.UsuarioService;
import br.com.cotiinformatica.validations.TarefaPutValidation;

@Controller
public class TarefaPutController {

	@Autowired
	private TarefaService tarefaService;
	
	@Autowired
	private UsuarioService usuarioService;

	@CrossOrigin
	@RequestMapping(value = "/api/tarefas", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<List<String>> put(@RequestBody TarefaPutDTO dto) {
		
		List<String> result = new ArrayList<String>();
		
		try {
			
			TarefaPutValidation validation = new TarefaPutValidation();
			result = validation.validate(dto); //validando o objeto DTO..
			
			//verificando se ocorreram erros de validação..
			if(result.size() > 0) {
				
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(result);				
			}
			else {
				
				//transferir os dados do DTO para um objeto da entidade Tarefa..
				Tarefa tarefa = DTOEntityAdapter.getTarefa(dto);
				
				//buscando o usuario da tarefa atraves do email
				Usuario usuario = usuarioService.find(dto.getEmailUsuario());
				tarefa.setUsuario(usuario);
				
				//gravando no banco de dados
				tarefaService.saveOrUpdate(tarefa);
				
				result.add("Tarefa atualizada com sucesso.");
				
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(result);
			}
		}
		catch(Exception e) {
			
			result.add("Erro: " + e.getMessage());
			
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(result);			
		}
	}
}
