package br.com.cadastro.veiculos.apis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import br.com.cadastro.veiculos.apis.dto.MarcaDTO;
import br.com.cadastro.veiculos.apis.dto.VeiculoDTO;
import br.com.cadastro.veiculos.apis.utils.Utils;

@Repository
public class VeiculoDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private Utils utils;
	
	public VeiculoDTO inserir(VeiculoDTO veiculo) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p_num_marca_vei", veiculo.getCodMarca());
		params.put("p_num_model_vei", veiculo.getCodModelo());
		params.put("p_cod_placa", veiculo.getPlaca());
		params.put("p_num_renav", veiculo.getRenavam());
		params.put("p_nom_cor_vei", veiculo.getCodCor());
		params.put("p_ano_fabrc", veiculo.getAno());
		params.put("p_sta_ativo", "S");
		params.put("p_cod_usuar", "PAMCARY.PAMCARY");
		params.put("p_ctl_local", veiculo.getCodCidade());
		params.put("p_qtd_eixo", veiculo.getEixos());
		params.put("p_sta_dedic", "N");
		params.put("p_tip_veicu", veiculo.getCodTipo());
		
		/*
		 p_num_marca_vei   IN NUMBER
		,p_num_model_vei   IN NUMBER
		,p_cod_placa       IN CHAR
		,p_num_renav       IN NUMBER
		,p_nom_cor_vei     IN VARCHAR2
		,p_ano_fabrc       IN NUMBER
		,p_sta_ativo       IN CHAR
		,p_cod_usuar	   IN VARCHAR2
		,p_ctl_local       IN NUMBER
		,p_qtd_eixo        IN NUMBER
		,p_sta_dedic       IN CHAR
		,p_tip_veicu       IN NUMBER
		,v_out_result      OUT NUMBER
		,v_out_err_message OUT VARCHAR2
		,v_out_ctl_veicu   OUT NUMBER) 
		 * */
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(utils.dataSource())
                .withProcedureName("SP_CRP_INSERE_VEICULO");
		
		SqlParameterSource in = new MapSqlParameterSource().addValues(params);
		
		Map<String, Object> out = simpleJdbcCall.execute(in);
		
		return veiculo;
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
