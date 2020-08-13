package br.com.itau.Cartao.DTOs;

import javax.validation.constraints.NotNull;

public class CartaoStatusDTO
{
    @NotNull(message =  "Ativo não  pode ser nulo")
    private Boolean ativo;

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public CartaoStatusDTO() {
    }
}
