package br.com.cadastro.veiculos.apis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "CRP_VEICULO")
public class Veiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CTL_VEICU")
	private Integer ctlVeiculo;

	@Column(name="COD_PLACA")
	private String placa;
/*
	@Column(name="")
	private Integer codUF;
*/
	@Column(name="CTL_LOCAL")
	private Integer ctlLocal;

	@Column(name="NUM_RENAV")
	private Integer renavam;

	@Column(name="NUM_MARCA_VEI")
	private Integer numMarcaVei;

	@Column(name="NUM_MODEL_VEI")
	private Integer numModeloVei;

	@Column(name="TIP_VEICU")
	private Integer tipVeiculo;

	@Column(name="QTD_EIXO")
	private Integer qtdEixeo;

	@Column(name="NOM_COR_VEI")
	private Integer num;

	@Column(name="ANO_FABRC")
	private Integer ano;

	@Column(name="")
	private Integer codProvTec; // código do PROVEDOR DE TECNOLOGIA

	@Column(name="")
	private String idTecnologia; 
	
}
