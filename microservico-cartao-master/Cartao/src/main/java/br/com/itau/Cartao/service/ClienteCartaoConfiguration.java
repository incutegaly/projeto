package br.com.itau.Cartao.service;

import br.com.itau.Cartao.gateway.ClienteCartaoDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class ClienteCartaoConfiguration {

    @Bean
    public ErrorDecoder getCarClientDecoder() {
        return new ClienteCartaoDecoder();
    }

}


