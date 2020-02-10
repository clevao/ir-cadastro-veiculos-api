package br.com.cadastro.veiculos.apis.model;

import java.util.Date;

public class EstadosResponse {

	private Integer codigoUnidadeFederal;
	private String siglaUnidadeFederal;
	private Integer codigoPais;
	private String nomePais;
	private String codUsuario;
	private Date dataHora;
	private Integer numRegiao;

	public Integer getCodigoUnidadeFederal() {
		return codigoUnidadeFederal;
	}

	public void setCodigoUnidadeFederal(Integer codigoUnidadeFederal) {
		this.codigoUnidadeFederal = codigoUnidadeFederal;
	}

	public String getSiglaUnidadeFederal() {
		return siglaUnidadeFederal;
	}

	public void setSiglaUnidadeFederal(String siglaUnidadeFederal) {
		this.siglaUnidadeFederal = siglaUnidadeFederal;
	}

	public Integer getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getNumRegiao() {
		return numRegiao;
	}

	public void setNumRegiao(Integer numRegiao) {
		this.numRegiao = numRegiao;
	}

}
