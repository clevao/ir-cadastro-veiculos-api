package br.com.cadastro.veiculos.apis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.veiculos.apis.model.CidadesUfCodigoRequest;
import br.com.cadastro.veiculos.apis.model.CidadesUfSiglaRequest;
import br.com.cadastro.veiculos.apis.model.CodigoCidadeRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaCodigoRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaEstadosRequest;
import br.com.cadastro.veiculos.apis.model.ConsultaSiglaRequest;
import br.com.cadastro.veiculos.apis.model.Praca;
import br.com.cadastro.veiculos.apis.model.UnidadeFederal;
import br.com.cadastro.veiculos.apis.service.CidadeEstadoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/cidade-estado")
public class CidadeEstadoController {

	@Autowired
	private CidadeEstadoService cidadeEstadoService;

	@ApiOperation(value = "Consultar Estado Nome", notes = "Consulta Estado por Nome")
	@ApiResponses({ @ApiResponse(code = 400, message = "Erro de validação de negócio"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/consulta/estado/nome", produces = { "application/json" }, method = RequestMethod.POST)
	public List<UnidadeFederal> consultaEstadosNome(@RequestBody ConsultaEstadosRequest request) {
		List<UnidadeFederal> response = new ArrayList<>();
		response = cidadeEstadoService.consultaEstadoNome(request);
		return response;
	}

	@ApiOperation(value = "Consultar Estado Sigla", notes = "Consulta Estado por sigla Exemplo:'SP , RJ, BH...'")
	@ApiResponses({ @ApiResponse(code = 400, message = "Erro de validação de negócio"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/consulta/estado/sigla", produces = { "application/json" }, method = RequestMethod.POST)
	public UnidadeFederal consultaEstadosSigla(@RequestBody ConsultaSiglaRequest request) {
		UnidadeFederal response = new UnidadeFederal();
		response = cidadeEstadoService.consultaEstadoSigla(request);
		return response;

	}

	@ApiOperation(value = "Consultar Estado Código", notes = "Consulta Estado por codigo Exemplo:'buscar código: 25 retorno SP'")
	@ApiResponses({ @ApiResponse(code = 400, message = "Erro de validação de negócio"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/consulta/estado/codigo", produces = { "application/json" }, method = RequestMethod.POST)
	public UnidadeFederal consultaEstadosCodigo(@RequestBody ConsultaCodigoRequest request) {
		UnidadeFederal response = new UnidadeFederal();
		response = cidadeEstadoService.consultaEstadoCodigo(request);
		return response;

	}

	@ApiOperation(value = "Consultar Todos os Estados", notes = "Consulta Todos os Estados")
	@ApiResponses({ @ApiResponse(code = 400, message = "Erro de validação de negócio"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/consulta/estados", produces = { "application/json" }, method = RequestMethod.GET)
	public List<UnidadeFederal> consultaTodosEstados() {
		List<UnidadeFederal> response = new ArrayList<>();
		response = cidadeEstadoService.consultaTodosEstados();
		return response;

	}

	@ApiOperation(value = "Consultar Cidade por codigo", notes = "Cosulta cidade por codigo da cidade")
	@ApiResponses({ @ApiResponse(code = 400, message = "Erro de validação de negócio"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/consulta/codigo/cidade", produces = { "application/json" }, method = RequestMethod.POST)
	public List<Praca> consultaCodigoCidade(CodigoCidadeRequest request) {
		List<Praca> response = new ArrayList<>();
		response = cidadeEstadoService.consultaCodigoCidade(request);
		return response;

	}

	@ApiOperation(value = "Consultar Cidade por codigo da uf", notes = "Cosulta cidade por codigo da uf Exemplo: 25:SP")
	@ApiResponses({ @ApiResponse(code = 400, message = "Erro de validação de negócio"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/consulta/uf/cidade", produces = { "application/json" }, method = RequestMethod.POST)
	public List<Praca> consultaCidadesUf(CidadesUfCodigoRequest request) {
		List<Praca> response = new ArrayList<>();
		response = cidadeEstadoService.consultaCidadesUf(request);
		return response;

	}

	@ApiOperation(value = "Consultar Cidade por sigla da uf", notes = "Cosulta cidade por sigla da uf Exemplo: SP, RJ")
	@ApiResponses({ @ApiResponse(code = 400, message = "Erro de validação de negócio"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/consulta/uf/sigla", produces = { "application/json" }, method = RequestMethod.POST)
	public List<Praca> consultaSiglaUf(CidadesUfSiglaRequest request) {
		List<Praca> response = new ArrayList<>();
		response = cidadeEstadoService.consultaSiglaUf(request);
		return response;

	}

}
