package br.com.cadastro.veiculos.apis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.veiculos.apis.dao.MarcaDAO;
import br.com.cadastro.veiculos.apis.dto.MarcaDTO;

@Service
public class MarcaServiceImpl implements MarcaService{
	
	@Autowired
	private MarcaDAO marcaDAO;
	
	@Override
	public MarcaDTO getByCodigo(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarcaDTO> getByDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarcaDTO> listar() {
		return marcaDAO.listar();
	}

}
