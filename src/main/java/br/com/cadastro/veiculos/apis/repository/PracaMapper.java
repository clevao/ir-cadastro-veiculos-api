package br.com.cadastro.veiculos.apis.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.cadastro.veiculos.apis.model.Praca;


public class PracaMapper implements RowMapper<Praca> {

	@Override
	public Praca mapRow(ResultSet rs, int rowNum) throws SQLException {
        
		Praca praca = new Praca();
		praca.setCodPraca(rs.getInt("COD_PRACA"));
		praca.setCodUnidadeFederal(rs.getInt("COD_UNFED"));
		praca.setDescricaoPraca(rs.getString("DES_PRACA"));
	    praca.setSigla(rs.getString("SIG_UNFED"));
		
		return praca;
	}
}
