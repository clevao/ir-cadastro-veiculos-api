package br.com.cadastro.veiculos.apis.service;

import java.util.List;

import br.com.cadastro.veiculos.apis.dto.MarcaDTO;

public interface MarcaService {
	
	public MarcaDTO getByCodigo(Integer codigo);
	
	public List<MarcaDTO> getByDescricao(String descricao);
	
	public List<MarcaDTO> listar();

}
