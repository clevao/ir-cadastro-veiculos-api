package br.com.cadastro.veiculos.apis.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.cadastro.veiculos.apis.model.UnidadeFederal;

public class EstadosMapper implements RowMapper<UnidadeFederal> {

	@Override
	public UnidadeFederal mapRow(ResultSet rs, int rowNum) throws SQLException {
		UnidadeFederal unidadeFederal = new UnidadeFederal();
		unidadeFederal.setCodigoUnidadeFederal(rs.getInt("COD_UNFED"));
		unidadeFederal.setSiglaUnidadeFederal(rs.getString("SIG_UNFED"));
		unidadeFederal.setNomePais(rs.getString("NOM_UNFED"));
		
		return unidadeFederal;
	}

}
