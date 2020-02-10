package br.com.cadastro.veiculos.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.veiculos.apis.dao.VeiculoDAO;
import br.com.cadastro.veiculos.apis.dto.VeiculoDTO;
import br.com.cadastro.veiculos.apis.utils.Utils;

@Service
public class VeiculoServiceImpl implements VeiculoService {
	
	@Autowired
	private VeiculoDAO veiculoDAO;

	@Override
	public VeiculoDTO inserir(VeiculoDTO veiculoDTO) throws Exception {
		
		if(validar(veiculoDTO)) {
			veiculoDAO.inserir(veiculoDTO);
		}
		
		return veiculoDTO;
	}

	@Override
	public VeiculoDTO editar(Integer ctlVeiculo, VeiculoDTO veiculoDTO) throws Exception {
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
	public boolean validar(VeiculoDTO veiculoDTO) throws Exception {
		
		if(Utils.isEmpty(veiculoDTO.getPlaca())) {
			throw new Exception("Placa não informada");
		}
		
		if(Utils.isEmpty(veiculoDTO.getRenavam())) {
			throw new Exception("Renavam não informado");
		}
		
		if(Utils.isEmpty(veiculoDTO.getCodUF())) {
			throw new Exception("Codigo da UF não informado");
		}
		
		if(Utils.isEmpty(veiculoDTO.getCodCidade())) {
			throw new Exception("Codigo da cidade não informado");
		}
		
		if(veiculoDTO.getCodMarca() == null) {
			throw new Exception("Codigo da marca não informado");
		}
		
		if(veiculoDTO.getCodModelo() == null) {
			throw new Exception("Codigo do modelo não informado");
		}
		
		if(veiculoDTO.getCodTipo() == null) {
			throw new Exception("Codigo do tipo não informado");
		}
		
		if(Utils.isEmpty(veiculoDTO.getEixos())) {
			throw new Exception("Quantidade de eixos não informado");
		}
		
		if(Utils.isEmpty(veiculoDTO.getCodCor())) {
			throw new Exception("Codigo da cor não informado");
		}
		
		if(Utils.isEmpty(veiculoDTO.getAno())) {
			throw new Exception("Ano não informado");
		}
		
		if(
			Utils.isEmpty(veiculoDTO.getTecnologia().getCodProvTec()) 
			&& !Utils.isEmpty(veiculoDTO.getTecnologia().getIdTecnologia())
	     ) {
			throw new Exception("Provedor de tecnologia não informado");
		}
		
		if(
			!Utils.isEmpty(veiculoDTO.getTecnologia().getCodProvTec()) 
			&& Utils.isEmpty(veiculoDTO.getTecnologia().getIdTecnologia())
		) {
			throw new Exception("ID do dispositivo não informado");
		}
		
		return true;
	}

	
}
