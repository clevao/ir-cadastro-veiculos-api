package br.com.cadastro.veiculos.apis.handler;

public class ApiException extends RuntimeException {

    private static final long serialVersionUID = -3230337988862002727L;
    
    public ApiException(String mensagem) {
        super(mensagem);
    }
    
    public ApiException(Throwable causa) {
        super(causa);
    }
    
    public ApiException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    
}