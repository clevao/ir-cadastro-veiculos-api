package br.com.cadastro.veiculos.apis.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.cadastro.veiculos.apis.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	Usuario findByUsername(String username);
}
