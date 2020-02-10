package br.com.cadastro.veiculos.apis.service;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.cadastro.veiculos.apis.dao.VeiculoDAO;
import br.com.cadastro.veiculos.apis.dto.VeiculoDTO;
import br.com.cadastro.veiculos.apis.handler.ApiError;
import br.com.cadastro.veiculos.apis.handler.ApiException;
import br.com.cadastro.veiculos.apis.utils.Utils;

@Service
public class VeiculoServiceImpl implements VeiculoService {
	
	@Autowired
	private VeiculoDAO veiculoDAO;

	@Override
	public VeiculoDTO inserir(VeiculoDTO veiculoDTO) {
		
		if(validar(veiculoDTO)) {
			veiculoDTO.setCodVeiculo(1);
			//veiculoDAO.inserir(veiculoDTO);
		}
		
		return veiculoDTO;
	}

	@Override
	public VeiculoDTO editar(Integer ctlVeiculo, VeiculoDTO veiculoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VeiculoDTO get(Integer ctlVeiculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VeiculoDTO getByPlaca(String placa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(VeiculoDTO veiculoDTO) {
		
		if(Utils.isEmpty(veiculoDTO.getPlaca())) {
			//throw new Exception("Placa não informada");
			throw new ApiException("Placa não informada");
		}
				
		if(Utils.isEmpty(veiculoDTO.getRenavam())) {
			throw new ApiException("Renavam não informado");
		}
		
		if(Utils.isEmpty(veiculoDTO.getCodUF())) {
			throw new ApiException("Codigo da UF não informado");
		}
		
		if(Utils.isEmpty(veiculoDTO.getCodCidade())) {
			throw new ApiException("Codigo da cidade não informado");
		}
		
		if(veiculoDTO.getCodMarca() == null) {
			throw new ApiException("Codigo da marca não informado");
		}
		
		if(veiculoDTO.getCodModelo() == null) {
			throw new ApiException("Codigo do modelo não informado");
		}
		
		if(veiculoDTO.getCodTipo() == null) {
			throw new ApiException("Codigo do tipo não informado");
		}
		
		if(Utils.isEmpty(veiculoDTO.getEixos())) {
			throw new ApiException("Quantidade de eixos não informado");
		}
		
		if(Utils.isEmpty(veiculoDTO.getCodCor())) {
			throw new ApiException("Codigo da cor não informado");
		}
		
		if(Utils.isEmpty(veiculoDTO.getAno())) {
			throw new ApiException("Ano não informado");
		}
		
		if(
			Utils.isEmpty(veiculoDTO.getTecnologia().getCodProvTec()) 
			&& !Utils.isEmpty(veiculoDTO.getTecnologia().getIdTecnologia())
	     ) {
			throw new ApiException("Provedor de tecnologia não informado");
		}
		
		if(
			!Utils.isEmpty(veiculoDTO.getTecnologia().getCodProvTec()) 
			&& Utils.isEmpty(veiculoDTO.getTecnologia().getIdTecnologia())
		) {
			throw new ApiException("ID do dispositivo não informado");
		}
				
		return true;
	}

	
}
