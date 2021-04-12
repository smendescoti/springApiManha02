package br.com.cotiinformatica.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private IUsuarioRepository repository;

	public void saveOrUpdate(Usuario usuario) throws Exception {
		repository.save(usuario);
	}

	public void delete(Usuario usuario) throws Exception {
		repository.delete(usuario);
	}

	public List<Usuario> findAll() throws Exception {
		return (List<Usuario>) repository.findAll();
	}

	public Usuario findById(Integer idUsuario) throws Exception {
		return repository.findById(idUsuario).get();
	}

	public Usuario find(String email) throws Exception {
		return repository.find(email);
	}

	public Usuario find(String email, String senha) throws Exception {
		return repository.find(email, senha);
	}
}
