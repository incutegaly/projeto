package br.com.itau.Cliente.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.Cliente.Models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer > {

}




