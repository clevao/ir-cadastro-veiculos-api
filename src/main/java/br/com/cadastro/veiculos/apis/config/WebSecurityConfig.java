package br.com.cadastro.veiculos.apis.config;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import br.com.cadastro.veiculos.apis.utils.Utils;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	

	@Autowired
	private Utils utils;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
    {
		/*
		 * auth.jdbcAuthentication().dataSource(utils.dataSource()).passwordEncoder(
		 * passwordEncoder())
		 * .usersByUsernameQuery("select username, password, enabled from userdetails where userName=?"
		 * ) .authoritiesByUsernameQuery(
		 * "select ud.username as username, rm.name as role from userdetails ud "
		 * + "INNER JOIN rolemaster rm ON rm.id = ud.roleId  where username = ?"
		 * );
		 */
        
    	/*
    	 * =============== CONFIGURAÇÃO PAMCARY =================
        auth.jdbcAuthentication().dataSource(utils.dataSource()).passwordEncoder(passwordEncoder())
        .usersByUsernameQuery("SELECT u.usr_name as username, '{noop}'||u.cod_senha as password, "
        		+ "(CASE WHEN u.sta_senha IS NULL THEN 0 ELSE 1 end ) as enabled, u.sta_senha "
        		+ "FROM usuario_internet u WHERE usr_name = ?")
        .authoritiesByUsernameQuery(
                "SELECT u.usr_name as username, f.des_funca as role "
                + "FROM USUARIO_INTERNET u "
                + "INNER JOIN relac_perfil_usuario pu ON pu.ctl_user = u.ctl_user AND pu.cod_sisti='3' "
                + "INNER JOIN funcoes_sistema f ON f.cod_funca = pu.cod_funca AND f.cod_sisti = pu.cod_sisti "
                + "WHERE usr_name = ?");
        */
    	
    	/* ================== CONFIGURAÇÃO DELL =================  */
    	auth.jdbcAuthentication().dataSource(utils.dataSource()).passwordEncoder(passwordEncoder())
        .usersByUsernameQuery("SELECT username, CONCAT('{noop}',password) AS password, enabled FROM users WHERE username = ?")
        .authoritiesByUsernameQuery(
                "SELECT u.username, ur.role FROM users u " + 
                "INNER JOIN user_roles ur ON ur.username = u.username " + 
                "WHERE  u.username =  ?");
        
    }

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests().antMatchers("/authenticate", "/teste/*").permitAll().
				// all other requests need to be authenticated
				anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
