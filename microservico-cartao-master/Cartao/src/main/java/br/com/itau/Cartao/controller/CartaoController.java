package br.com.itau.Cartao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.Cartao.DTOs.CartaoEntradaDTO;
import br.com.itau.Cartao.DTOs.CartaoSaidaDTO;
import br.com.itau.Cartao.DTOs.CartaoSemStatusDTO;
import br.com.itau.Cartao.DTOs.CartaoStatusDTO;
import br.com.itau.Cartao.service.CartaoService;

@RestController
@RequestMapping("/cartao")
public class CartaoController
{
    @Autowired
    CartaoService cartaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartaoSaidaDTO criar(@RequestBody @Valid CartaoEntradaDTO cartao){
    	
        return  cartaoService.criar(cartao);
    }


    @PatchMapping("/{numero}")
    public CartaoSaidaDTO alterarStatusAtivo(@PathVariable(name = "numero") String numero, @RequestBody @Valid CartaoStatusDTO cartaoStatusDTO)
    {
        try
        {
            return cartaoService.alterarStatusAtivo(numero, cartaoStatusDTO);
        }
        catch (RuntimeException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{numero}")
    public CartaoSemStatusDTO buscarPorNumero(@PathVariable(name = "numero") String numero)
    {
        try
        {
            return cartaoService.buscarPorNumero(numero);
        }
        catch (RuntimeException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

