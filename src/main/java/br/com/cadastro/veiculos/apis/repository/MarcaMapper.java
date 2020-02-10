package br.com.cadastro.veiculos.apis.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.cadastro.veiculos.apis.model.MarcaResponse;

public class MarcaMapper implements RowMapper<MarcaResponse>{

	@Override
	public MarcaResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MarcaResponse response = new MarcaResponse();
		response.setCodigoMarca(rs.getInt("num_marca_vei"));
		response.setDescricaoMarca(rs.getString("NOM_MARCA_VEI"));
		return response;
	}

}
