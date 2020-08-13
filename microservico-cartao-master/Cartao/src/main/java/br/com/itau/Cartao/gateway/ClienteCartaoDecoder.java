package br.com.itau.Cartao.gateway;


import br.com.itau.Cartao.service.CartaoNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ClienteCartaoDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 404) {
            return new CartaoNotFoundException();
        }
        return errorDecoder.decode(s, response);
    }

}
