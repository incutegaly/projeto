package br.com.itau.Cliente.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.Cliente.Models.Cliente;
import br.com.itau.Cliente.Repository.ClienteRepository;


@Service
public class ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar (Cliente cliente)
    {
        return  clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(int id)
    {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if(clienteOptional.isPresent())
        {
            Cliente cliente = clienteOptional.get();
            return  cliente;
        }
        else
        {
            throw new RuntimeException("O cliente não foi encontrado");
        }
    }
}
