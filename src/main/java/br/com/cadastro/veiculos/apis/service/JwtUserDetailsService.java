package br.com.cadastro.veiculos.apis.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.cadastro.veiculos.apis.dao.UsuarioDAO;
import br.com.cadastro.veiculos.apis.dto.UsuarioDTO;
import br.com.cadastro.veiculos.apis.model.Usuario;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioDAO userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}


}
