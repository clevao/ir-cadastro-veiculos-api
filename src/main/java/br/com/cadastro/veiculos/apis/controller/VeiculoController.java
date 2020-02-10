package br.com.cadastro.veiculos.apis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.veiculos.apis.dto.TecnologiaDTO;
import br.com.cadastro.veiculos.apis.dto.VeiculoDTO;
import br.com.cadastro.veiculos.apis.service.VeiculoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@ApiOperation(value = "Listar Marcas", notes = "Cadastro de Veículo")
	@ApiResponses({ @ApiResponse(code = 201, message = "Criado com sucesso"),
					@ApiResponse(code = 400, message = "Erro de validação de negócio"),
					@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "", produces = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<?> inserir(@RequestBody VeiculoDTO veiculoDTO) throws URISyntaxException{
				
		
			veiculoService.inserir(veiculoDTO);
			URI location;
			location = new URI("/veiculos/" + veiculoDTO.getCodVeiculo());
			veiculoService.inserir(veiculoDTO);
			return ResponseEntity.created(location).body(veiculoDTO);
			
		
	}
	
	@ApiOperation(value = "Listar Marcas", notes = "Cadastro de Veículo")
	@ApiResponses({ @ApiResponse(code = 201, message = "Criado com sucesso"),
					@ApiResponse(code = 400, message = "Erro de validação de negócio"),
					@ApiResponse(code = 500, message = "Erro inesperado") })
	@RequestMapping(value = "{ctlVeiculo}", produces = { "application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<VeiculoDTO> editar(@PathVariable Integer ctlVeiculo, @RequestBody VeiculoDTO veiculoDTO){
				
		try {
			return ResponseEntity.ok().body(veiculoDTO);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
	@RequestMapping(value = "/teste", produces = { "application/json" }, method = RequestMethod.GET)
	public void teste(HttpServletRequest  request, HttpServletResponse   response){
		response.setHeader("Location", "http://www.google.com");
        response.setContentType("text/html");
        PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.println("<html><head><title>Modified Hello World</title></head><body>");
	        pw.println("<h1>");
	        //getInitParameter function reads the contents ot init-param elements.
	        pw.println("message");
	        pw.println("</h1>");
	        pw.println("</body></html>");
	        pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}
