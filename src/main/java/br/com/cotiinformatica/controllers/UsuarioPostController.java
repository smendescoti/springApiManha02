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
import br.com.cotiinformatica.dtos.UsuarioPostDTO;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.services.UsuarioService;
import br.com.cotiinformatica.validations.UsuarioPostValidation;

@Controller
public class UsuarioPostController {

	@Autowired
	private UsuarioService service;

	@CrossOrigin
	@RequestMapping(value = "/api/usuarios", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<String>> post(@RequestBody UsuarioPostDTO dto) {

		List<String> result = new ArrayList<String>();
		
		try {
			
			//aplicando as validações..
			UsuarioPostValidation validation = new UsuarioPostValidation();
			result = validation.validate(dto);
			
			//verificando se ocorreram erros de validação..
			if(result.size() > 0) {
				
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(result);				
			}
			else {
				
				//verificar se o email do usuario já esta cadastrado no sistema
				if(service.find(dto.getEmail()) != null) {
					
					result.add("O email informado já encontra-se cadastrado.");
					
					return ResponseEntity
							.status(HttpStatus.FORBIDDEN)
							.body(result);					
				}
				else {
					
					//cadastrar o usuario..
					Usuario usuario = DTOEntityAdapter.getUsuario(dto);					
					service.saveOrUpdate(usuario);
					
					result.add("Usuário cadastrado com sucesso.");
					
					return ResponseEntity
							.status(HttpStatus.CREATED)
							.body(result);
				}
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
