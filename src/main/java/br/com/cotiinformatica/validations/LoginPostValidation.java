package br.com.cotiinformatica.validations;

import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.dtos.LoginPostDTO;

public class LoginPostValidation {

	// método para validar os dados enviados no
	// serviço de login de usuario
	public List<String> validate(LoginPostDTO dto) {

		List<String> result = new ArrayList<String>();

		// validação do campo email
		if (dto.getEmail() == null || dto.getEmail().length() == 0) {
			result.add("Por favor, informe o email do usuário.");
		}

		// validação do campo senha
		if (dto.getSenha() == null || dto.getSenha().length() == 0) {
			result.add("Por favor, informe a senha do usuário.");
		} else if (dto.getSenha().length() < 8 || dto.getSenha().length() > 20) {
			result.add("Por favor, informe a senha do usuário com no mínimo 8 e no máximo 20 caracteres.");
		}

		return result;
	}

}
