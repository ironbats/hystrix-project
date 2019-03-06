package br.com.circuitbreaker.hystrix.feign;


import br.com.circuitbreaker.hystrix.dto.CepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cepService" , url = "http://api.postmon.com.br")
public interface CepService {

    @GetMapping("/v1/cep/{cep}")
    CepResponse getCep(@PathVariable("cep") String cep);

}
