package br.com.cadastro.veiculos.apis.service;

import java.util.List;

import br.com.cadastro.veiculos.apis.model.CidadesUfCodigoRequest;
import br.com.cadastro.veiculos.apis.model.CidadesUfSiglaRequest;
import br.com.cadastro.veiculos.apis.model.CodigoCidadeRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaCidadeRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaCodigoRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaEstadosRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaSiglaRequest;
import br.com.cadastro.veiculos.apis.model.Praca;
import br.com.cadastro.veiculos.apis.model.UnidadeFederal;

public interface CidadeEstadoService {

	public List<UnidadeFederal> consultaEstadoNome(ConsultaEstadosRequest request);

	public UnidadeFederal consultaEstadoSigla(ConsultaSiglaRequest request);

	public UnidadeFederal consultaEstadoCodigo(ConsultaCodigoRequest request);

	public List<Praca> consultaCidadeEstado(ConsultaCidadeRequest request);

	public List<UnidadeFederal> consultaTodosEstados();

	public List<Praca> consultaCodigoCidade(CodigoCidadeRequest request);

	public List<Praca> consultaCidadesUf(CidadesUfCodigoRequest request);

	public List<Praca> consultaSiglaUf(CidadesUfSiglaRequest request);
}
