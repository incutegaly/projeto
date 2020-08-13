package br.com.itau.Cartao.gateway;


import br.com.itau.Cartao.service.ClienteCartaoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLIENTE", configuration = ClienteCartaoConfiguration.class)
public interface ClienteCartao {
    @GetMapping("/cliente/{id}")
        Cliente getByclienteId(@PathVariable(name = "id") Long clienteId);


    Cliente getByclienteId();
}
