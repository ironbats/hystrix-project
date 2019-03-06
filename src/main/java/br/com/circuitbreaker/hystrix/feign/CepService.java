package br.com.circuitbreaker.hystrix.feign;


import br.com.circuitbreaker.hystrix.dto.CepResponse;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cepService" , url = "http://api.postmon.com.br")
public interface CepService {

    //feature 1
    @GetMapping("/v1/cep/{cep}")
    CepResponse getCep(@PathVariable("cep") String cep);

    //feature 2
    @GetMapping(value = "/v1/cep/{cep}" )
    @HystrixProperty(name ="hystrix.command.default.execution.timeout.enabled", value = "false")
    HystrixCommand<CepResponse> getCep2(@PathVariable("cep") String cep);


}
