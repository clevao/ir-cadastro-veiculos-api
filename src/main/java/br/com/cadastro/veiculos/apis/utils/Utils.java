package br.com.cadastro.veiculos.apis.utils;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.stereotype.Component;

import oracle.jdbc.pool.OracleDataSource;

@Component 
@EnableConfigurationProperties
@PropertySource("classpath:application.properties")
public class Utils {

	@Autowired
	private Environment env;
	/*
	 @Bean
	 @Primary
	    public DataSource dataSource() {
	
	        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
	        DataSource dataSource = dataSourceLookup.getDataSource(env.getProperty("spring.datasource.jndi-name"));
	        return dataSource;
	    }

	  */
	
	public DataSource dataSource() {
		OracleDataSource oracleDS = null;
		try {
			oracleDS = new OracleDataSource();
			oracleDS.setURL(env.getProperty("spring.datasource.url"));
			oracleDS.setUser(env.getProperty("spring.datasource.username"));
			oracleDS.setPassword(env.getProperty("spring.datasource.password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oracleDS;
	}
	
	public static boolean isEmpty(Object value) {
		if( value == null)
			return true;
		return false;
	}
	
	public static boolean isEmpty(String value) {
		if( value == null)
			return true;
		else {
			if(value.trim().equals(""))
				return true;
		}
		
		return false;
	}
	
	public static boolean isEmpty(Integer value) {
		if( value == null)
			return true;
		else {
			if(value == 0)
				return true;
		}
		return false;
	}
	
	    
	
}
