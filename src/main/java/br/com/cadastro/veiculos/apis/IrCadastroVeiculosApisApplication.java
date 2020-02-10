package br.com.cadastro.veiculos.apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class IrCadastroVeiculosApisApplication{ // extends SpringBootServletInitializer {

	//private static Class<IrCadastroVeiculosApisApplication> applicationClass = IrCadastroVeiculosApisApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(IrCadastroVeiculosApisApplication.class, args);
	}

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}*/
}
