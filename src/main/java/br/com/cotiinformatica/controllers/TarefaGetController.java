package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.adapters.EntityDTOAdapter;
import br.com.cotiinformatica.dtos.TarefaGetDTO;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.services.TarefaService;
import br.com.cotiinformatica.services.UsuarioService;

@Controller
public class TarefaGetController {

	@Autowired
	private TarefaService tarefaService;
	
	@Autowired
	private UsuarioService usuarioService;

	@CrossOrigin
	@RequestMapping(value = "/api/tarefas/{emailUsuario}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TarefaGetDTO>> getByUsuario(@PathVariable("emailUsuario") String emailUsuario) {

		List<TarefaGetDTO> result = new ArrayList<TarefaGetDTO>();

		try {
			
			//buscando o registro do usuario no banco de dados
			Usuario usuario = usuarioService.find(emailUsuario);
			
			//realizando a consulta de tarefas por usuario..
			List<Tarefa> tarefas = tarefaService.findByUsuario(usuario.getIdUsuario());
			
			//transferir os registros de Tarefa para a lista de TarefaGetDTO
			for(Tarefa item : tarefas) {
				result.add(EntityDTOAdapter.getTarefa(item));
			}
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(result);
		}
		catch(Exception e) {
			
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(result);			
		}
	}
}
