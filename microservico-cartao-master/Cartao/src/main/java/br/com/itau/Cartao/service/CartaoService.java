package br.com.itau.Cartao.service;

import br.com.itau.Cartao.DTOs.CartaoEntradaDTO;
import br.com.itau.Cartao.DTOs.CartaoSaidaDTO;
import br.com.itau.Cartao.DTOs.CartaoSemStatusDTO;
import br.com.itau.Cartao.DTOs.CartaoStatusDTO;
import br.com.itau.Cartao.gateway.Cliente;
import br.com.itau.Cartao.gateway.ClienteCartao;
import br.com.itau.Cartao.models.Cartao;
import br.com.itau.Cartao.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class CartaoService
{
    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ClienteCartao clienteCartao;

    public CartaoSaidaDTO criar(@Valid CartaoEntradaDTO cartaoDTO)
    {
        Cliente cliente = clienteCartao.getByclienteId();

        if(cliente != null)
        {
            Cartao cartaoDb = cartaoRepository.findByNumero(cartaoDTO.getNumero());

            if(cartaoDb != null)
            {
                throw new RuntimeException("Número de cartão já utilizado");
            }
            else
            {
            	Cartao cartao = new Cartao();
            	
                cartao.setClienteId(cliente.getClientId());
                cartao.setNumero(cartao.getNumero());
                cartao.setAtivo(false);

                cartao = cartaoRepository.save(cartao);

                return new CartaoSaidaDTO(cartao);
            }
        }
        else
        {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    public Cartao buscarPorId(Integer id)
    {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);

        if(cartaoOptional.isPresent())
        {
            Cartao cartao = cartaoOptional.get();
            return cartao;
        }
        else
        {
            throw new RuntimeException("O cartão não foi encontrado");
        }
    }

    public CartaoSaidaDTO alterarStatusAtivo(String numero, CartaoStatusDTO cartaoStatusDTO)
    {
        Cartao cartao = cartaoRepository.findByNumero(numero);

        if(cartao != null)
        {
            cartao.setAtivo(cartaoStatusDTO.getAtivo());

            cartao = cartaoRepository.save(cartao);

            return new CartaoSaidaDTO(cartao);
        }
        else
        {
            throw new RuntimeException("Número de cartão não existe");
        }
    }

    public CartaoSemStatusDTO buscarPorNumero(String numero)
    {
        Cartao cartao = cartaoRepository.findByNumero(numero);

        if(cartao != null)
        {
            return new CartaoSemStatusDTO(cartao);
        }
        else
        {
            throw new RuntimeException("Número de cartão não existe");
        }
    }
}
