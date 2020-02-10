package br.com.cadastro.veiculos.apis.model;

public class Praca {

	private Integer codPraca;

	private Integer codUnidadeFederal;

	private String descricaoPraca;

	private String sigla;

	public Integer getCodPraca() {
		return codPraca;
	}

	public void setCodPraca(Integer codPraca) {
		this.codPraca = codPraca;
	}

	public Integer getCodUnidadeFederal() {
		return codUnidadeFederal;
	}

	public void setCodUnidadeFederal(Integer codUnidadeFederal) {
		this.codUnidadeFederal = codUnidadeFederal;
	}

	public String getDescricaoPraca() {
		return descricaoPraca;
	}

	public void setDescricaoPraca(String descricaoPraca) {
		this.descricaoPraca = descricaoPraca;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
