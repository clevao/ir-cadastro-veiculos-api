package br.com.cadastro.veiculos.apis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.veiculos.apis.model.CidadesUfCodigoRequest;
import br.com.cadastro.veiculos.apis.model.CidadesUfSiglaRequest;
import br.com.cadastro.veiculos.apis.model.CodigoCidadeRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaCidadeRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaCodigoRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaEstadosRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaSiglaRequest;
import br.com.cadastro.veiculos.apis.model.Praca;
import br.com.cadastro.veiculos.apis.model.UnidadeFederal;

@Service
public class CidadeEstadoServiceImpl implements CidadeEstadoService {

	@Autowired
	private CidadeEstadoServiceStubImpl stubService;

	@Override
	public List<UnidadeFederal> consultaEstadoNome(ConsultaEstadosRequest request) {
		// TODO Auto-generated method stub
		return stubService.consultaEstadoNome(request);
	}

	@Override
	public UnidadeFederal consultaEstadoSigla(ConsultaSiglaRequest request) {
		// TODO Auto-generated method stub
		return stubService.consultaEstadoSigla(request);
	}

	@Override
	public UnidadeFederal consultaEstadoCodigo(ConsultaCodigoRequest request) {
		// TODO Auto-generated method stub
		return stubService.consultaEstadoCodigo(request);
	}

	@Override
	public List<Praca> consultaCidadeEstado(ConsultaCidadeRequest request) {
		// TODO Auto-generated method stub
		return stubService.consultaCidadeEstado(request);
	}

	@Override
	public List<UnidadeFederal> consultaTodosEstados() {
		// TODO Auto-generated method stub
		return stubService.consultaTodosEstados();
	}

	@Override
	public List<Praca> consultaCodigoCidade(CodigoCidadeRequest request) {
		// TODO Auto-generated method stub
		return stubService.consultaCodigoCidade(request);
	}

	@Override
	public List<Praca> consultaCidadesUf(CidadesUfCodigoRequest request) {
		// TODO Auto-generated method stub
		return stubService.consultaCidadesUf(request);
	}

	@Override
	public List<Praca> consultaSiglaUf(CidadesUfSiglaRequest request) {
		// TODO Auto-generated method stub
		return stubService.consultaSiglaUf(request);
	}

}
