package br.com.itau.Cartao.repository;


import br.com.itau.Cartao.models.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao,Integer >
{
    Cartao findByNumero(String numero);
}
