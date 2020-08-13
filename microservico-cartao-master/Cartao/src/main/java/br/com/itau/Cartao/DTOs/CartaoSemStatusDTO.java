package br.com.itau.Cartao.DTOs;


import br.com.itau.Cartao.models.Cartao;

public class CartaoSemStatusDTO
{
    private Integer id;

    private String numero;

    private Long clienteId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public CartaoSemStatusDTO() {
    }

    public CartaoSemStatusDTO(Cartao cartao)
    {
     //   this.setClienteId(cartao.getCliente().getId());
        this.setClienteId(cartao.getClienteId());
        this.setNumero(cartao.getNumero());
    }
}
