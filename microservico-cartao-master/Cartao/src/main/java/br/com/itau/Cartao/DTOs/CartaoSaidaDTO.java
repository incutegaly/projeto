package br.com.itau.Cartao.DTOs;


import br.com.itau.Cartao.models.Cartao;

public class CartaoSaidaDTO
{
    private Integer id;

    private String numero;

    private Long clienteId;

    private Boolean ativo;



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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

  public CartaoSaidaDTO(Cartao cartao)
    {
        this.setId(cartao.getId());
        this.setNumero(cartao.getNumero());
        this.setClienteId(cartao.getClienteId());
        this.setAtivo(cartao.getAtivo());

    }
}
