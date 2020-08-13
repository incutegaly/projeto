package br.com.itau.Cartao.DTOs;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartaoEntradaDTO
{
    @NotNull(message =  "Número do cartao não pode ser nulo")
    @NotBlank(message = "Número do cartao não pode ser vazio")
    private String numero;

    @NotNull(message =  "ClienteId não pode ser nulo")
    private Long clienteId;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long ClienteId){
        this.clienteId = clienteId;
    }

    public CartaoEntradaDTO() {
    }
}
