package br.com.cadastro.veiculos.apis.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codVeiculo;
	
	private String placa;
	
	private Integer codUF;
	
	private Integer codCidade;
	
	private Integer renavam;
	
	private Integer codMarca;
	
	private Integer codModelo;
	
	private Integer codTipo;
	
	private Integer eixos;
	
	private Integer codCor;
	
	private Integer ano;
	
	private TecnologiaDTO tecnologia;
	
	@JsonIgnore
	private String codUsuario;
	
}
