package br.com.circuitbreaker.hystrix.controller;

import br.com.circuitbreaker.hystrix.dto.CepResponse;
import br.com.circuitbreaker.hystrix.feign.CepService;
import br.com.circuitbreaker.hystrix.impl.CepServiceFallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consult")
public class CepController {

    @Autowired
    private CepServiceFallback cepServiceFallback;

    @Autowired
    private CepService cepService;

    //feature 1
    @GetMapping("/cep/{cep}")
    public CepResponse cep(@PathVariable("cep") String cep)
    {
        return cepServiceFallback.consultCepValue(cep);
    }


    //feature 2
    @GetMapping("/cep2/{cep}")
    public CepResponse cep2(@PathVariable("cep") String cep)
    {
        CepResponse cepResponse = cepService.getCep2(cep).execute();
        if(cepResponse != null)
        {
            return cepResponse;
        }
        return cepServiceFallback.consultCepValue(cep);
    }


}
