package br.com.cadastro.veiculos.apis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.cadastro.veiculos.apis.dto.MarcaDTO;

@Repository
public class MarcaDAO {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public MarcaDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public List<MarcaDTO> listar(){
		String sql = "SELECT NUM_MARCA_VEI AS CODIGO, NOM_MARCA_VEI AS DESCRICAO  FROM pamais_prd.TCRP_MARCA_VEICULO";
		
		return namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource(), (rs, rowNum) -> {
			MarcaDTO marca = new MarcaDTO();
			marca.setCodigo(rs.getInt("CODIGO"));
			marca.setDescricao(rs.getString("DESCRICAO"));
			return marca;
			
		});
	}

}
