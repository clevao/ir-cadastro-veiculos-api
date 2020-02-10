package br.com.cadastro.veiculos.apis.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TecnologiaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
		
	private Integer codProvTec; // código do PROVEDOR DE TECNOLOGIA
	
	private String idTecnologia; 
	
}
