package br.com.itau.Cartao.service;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Carro não encontrado")
public class CartaoNotFoundException extends RuntimeException {
}
