package br.com.cadastro.veiculos.apis.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {
	
	
	
	@RequestMapping(value = "/teste/{link}", method = RequestMethod.GET)
	public void teste(HttpServletRequest  request, HttpServletResponse   response, @PathVariable("link") String link){
		
		byte[] byteArray = Base64.decodeBase64(link.getBytes());
		try {
			response.sendRedirect("https://preprod.gps-pamcary.com.br/ir-rotograma/?" + new String(byteArray));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}
