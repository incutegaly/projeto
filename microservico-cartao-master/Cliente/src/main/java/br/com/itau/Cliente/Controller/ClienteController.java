package br.com.itau.Cliente.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.Cliente.Models.Cliente;
import br.com.itau.Cliente.Service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController
{
    @Autowired
    ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar(@RequestBody @Valid Cliente cliente)
    {
        return  clienteService.criar(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable(name = "id") int id)
    {
        try
        {
            Cliente cliente = clienteService.buscarPorId(id);
            return cliente;
        }
        catch (RuntimeException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
