package br.com.cadastro.veiculos.apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.veiculos.apis.dto.MarcaDTO;
import br.com.cadastro.veiculos.apis.service.MarcaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@ApiOperation(value = "Listar Marcas", notes = "Consulta Estado por Nome")
	@ApiResponses({ @ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "/listar", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<List<MarcaDTO>> listar(){
		List<MarcaDTO> lista = marcaService.listar();
		return ResponseEntity.ok().body(lista);
	}
}
