package br.com.cotiinformatica.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("select u from Usuario u where u.email = :email")
	Usuario find(@Param("email") String email);

	@Query("select u from Usuario u where u.email = :email and u.senha = :senha")
	Usuario find(@Param("email") String email, @Param("senha") String senha);
}
