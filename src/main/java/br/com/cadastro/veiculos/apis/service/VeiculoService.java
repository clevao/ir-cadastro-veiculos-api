package br.com.cadastro.veiculos.apis.service;

import java.util.List;

import br.com.cadastro.veiculos.apis.dto.VeiculoDTO;
import br.com.cadastro.veiculos.apis.model.ConsultaMarcaRequest;
import br.com.cadastro.veiculos.apis.model.ConsumtaMarcaNomeRequest;
import br.com.cadastro.veiculos.apis.model.MarcaResponse;

public interface VeiculoService {
	
	public VeiculoDTO inserir(VeiculoDTO veiculoDTO);
	
	public VeiculoDTO editar(Integer ctlVeiculo, VeiculoDTO veiculoDTO);
	
	public VeiculoDTO get(Integer ctlVeiculo);
	
	public VeiculoDTO getByPlaca(String placa); 
	
	public boolean validar(VeiculoDTO veiculoDTO) throws Exception;
		

}
