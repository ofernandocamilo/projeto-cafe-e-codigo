package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository < Usuario, String> {
	Usuario findByLogin(String login);
}
