package br.com.cadastro.veiculos.apis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.veiculos.apis.handler.ApiException;
import br.com.cadastro.veiculos.apis.model.CidadesUfCodigoRequest;
import br.com.cadastro.veiculos.apis.model.CidadesUfSiglaRequest;
import br.com.cadastro.veiculos.apis.model.CodigoCidadeRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaCidadeRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaCodigoRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaEstadosRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaSiglaRequest;
import br.com.cadastro.veiculos.apis.model.Praca;
import br.com.cadastro.veiculos.apis.model.UnidadeFederal;
import br.com.cadastro.veiculos.apis.repository.EstadosMapper;
import br.com.cadastro.veiculos.apis.repository.PracaMapper;
import br.com.cadastro.veiculos.apis.utils.Utils;

@Component
public class CidadeEstadoServiceStubImpl {

	@Autowired
	private Utils utils;

	private static String QUERIE_CIDADES = "select p.des_praca, p.cod_praca, p.cod_unfed, uf.SIG_UNFED from unidade_federal uf join praca p on p.cod_unfed = uf.cod_unfed  where cod_pais= 999 and nom_unfed like'%consultanomeestado'";

	private static String QUERIE_NOME_ESTADO = "select * from unidade_federal where cod_pais= 999 and nom_unfed like '%consultauf'";

	private static String QUERIE_NOME_UF = "select * from unidade_federal where cod_pais= 999 and SIG_UNFED ='consultauf'";

	private static String QUERIE_CODIGO_UF = "select * from unidade_federal where cod_pais= 999 and COD_UNFED = codigouf";

	private static String QUERIE_CONSULTA_ALL = "select * from unidade_federal where cod_pais= 999";

	private static String QUERIE_CONSULTA_CODIGO_CIDADE = "select p.des_praca, p.cod_praca, p.cod_unfed, uf.SIG_UNFED from unidade_federal uf join praca p on p.cod_unfed = uf.cod_unfed  where cod_pais= 999 and p.cod_praca = codigopraca";

	private static String QUERIE_CONSULTA_CIDADE_CODIGO_UF = "select p.des_praca, p.cod_praca, p.cod_unfed, uf.SIG_UNFED from unidade_federal uf join praca p on p.cod_unfed = uf.cod_unfed  where cod_pais= 999 and uf.cond_unfed = codigouf";

	private static String QUERIE_CONSULTA_CIDADE_SIGLA = "select p.des_praca, p.cod_praca, p.cod_unfed, uf.SIG_UNFED from unidade_federal uf join praca p on p.cod_unfed = uf.cod_unfed  where cod_pais= 999 and uf.sig_unfed = 'siglauf'";

	public List<UnidadeFederal> consultaEstadoNome(ConsultaEstadosRequest request) {
		List<UnidadeFederal> entidade = new ArrayList<>();

		QUERIE_NOME_ESTADO = QUERIE_NOME_ESTADO.replace("consultauf", request.getNomeEstado());

		SimpleJdbcCall call = new SimpleJdbcCall(utils.dataSource());
		entidade = call.getJdbcTemplate().query(QUERIE_NOME_ESTADO, new EstadosMapper());

		if (entidade.isEmpty()) {
			throw new ApiException("nenhum estado encontrado com o nome informado!");
		}

		return entidade;
	}

	public UnidadeFederal consultaEstadoSigla(ConsultaSiglaRequest request) {

		List<UnidadeFederal> entidade = new ArrayList<>();

		QUERIE_NOME_UF = QUERIE_NOME_UF.replace("consultauf", request.getEstadoSigla());

		SimpleJdbcCall call = new SimpleJdbcCall(utils.dataSource());
		entidade = call.getJdbcTemplate().query(QUERIE_NOME_UF, new EstadosMapper());

		if (entidade.isEmpty()) {
			throw new ApiException("nenhum estado encontrado com a sigla informado!");
		}

		UnidadeFederal response = new UnidadeFederal();
		for (UnidadeFederal ud : entidade) {
			response.setCodigoUnidadeFederal(ud.getCodigoUnidadeFederal());
			response.setNomePais(ud.getNomePais());
			response.setSiglaUnidadeFederal(ud.getSiglaUnidadeFederal());
		}

		return response;
	}

	public UnidadeFederal consultaEstadoCodigo(ConsultaCodigoRequest request) {

		List<UnidadeFederal> entidade = new ArrayList<>();

		QUERIE_CODIGO_UF = QUERIE_CODIGO_UF.replace("codigouf", request.getCodUnidadeFederal());

		SimpleJdbcCall call = new SimpleJdbcCall(utils.dataSource());
		entidade = call.getJdbcTemplate().query(QUERIE_CODIGO_UF, new EstadosMapper());

		if (entidade.isEmpty()) {
			throw new ApiException("nenhum estado encontrado com o código informado!");
		}
		UnidadeFederal response = new UnidadeFederal();
		for (UnidadeFederal ud : entidade) {
			response.setCodigoUnidadeFederal(ud.getCodigoUnidadeFederal());
			response.setNomePais(ud.getNomePais());
			response.setSiglaUnidadeFederal(ud.getSiglaUnidadeFederal());
		}

		return response;
	}

	public List<UnidadeFederal> consultaTodosEstados() {
		List<UnidadeFederal> entidade = new ArrayList<>();

		SimpleJdbcCall call = new SimpleJdbcCall(utils.dataSource());
		entidade = call.getJdbcTemplate().query(QUERIE_CONSULTA_ALL, new EstadosMapper());

		return entidade;
	}

	public List<Praca> consultaCidadeEstado(ConsultaCidadeRequest request) {

		List<Praca> listaPraca = new ArrayList<>();

		QUERIE_CIDADES = QUERIE_CIDADES.replace("consultanomeestado", request.getNomeEstado());

		SimpleJdbcCall call = new SimpleJdbcCall(utils.dataSource());
		listaPraca = call.getJdbcTemplate().query(QUERIE_CIDADES, new PracaMapper());

		if (listaPraca.isEmpty()) {
			throw new ApiException("Nenhuma informação encontrada para o nome de estado informado!");
		}

		return listaPraca;
	}

	public List<Praca> consultaCodigoCidade(CodigoCidadeRequest request) {
		List<Praca> listaPraca = new ArrayList<>();

		QUERIE_CONSULTA_CODIGO_CIDADE = QUERIE_CONSULTA_CODIGO_CIDADE.replace("codigopraca",
				request.getCodigoCidade().toString());

		SimpleJdbcCall call = new SimpleJdbcCall(utils.dataSource());
		listaPraca = call.getJdbcTemplate().query(QUERIE_CONSULTA_CODIGO_CIDADE, new PracaMapper());

		if (listaPraca.isEmpty()) {
			throw new ApiException("Nenhuma informação encontrada para o codigo da cidade informado!");
		}

		return listaPraca;
	}

	public List<Praca> consultaCidadesUf(CidadesUfCodigoRequest request) {
		List<Praca> listaPraca = new ArrayList<>();

		QUERIE_CONSULTA_CIDADE_CODIGO_UF = QUERIE_CONSULTA_CIDADE_CODIGO_UF.replace("codigouf", request.getCodigoUf());

		SimpleJdbcCall call = new SimpleJdbcCall(utils.dataSource());
		listaPraca = call.getJdbcTemplate().query(QUERIE_CONSULTA_CIDADE_CODIGO_UF, new PracaMapper());

		if (listaPraca.isEmpty()) {
			throw new ApiException("Nenhuma informação encontrada para o codigo de estado informado!");
		}

		return listaPraca;
	}

	public List<Praca> consultaSiglaUf(CidadesUfSiglaRequest request) {
		List<Praca> listaPraca = new ArrayList<>();

		QUERIE_CONSULTA_CIDADE_SIGLA = QUERIE_CONSULTA_CIDADE_SIGLA.replace("codigouf", request.getUnidadeFederal());

		SimpleJdbcCall call = new SimpleJdbcCall(utils.dataSource());
		listaPraca = call.getJdbcTemplate().query(QUERIE_CONSULTA_CIDADE_SIGLA, new PracaMapper());

		if (listaPraca.isEmpty()) {
			throw new ApiException("Nenhuma informação encontrada para o codigo de estado informado!");
		}

		return listaPraca;
	}

}
