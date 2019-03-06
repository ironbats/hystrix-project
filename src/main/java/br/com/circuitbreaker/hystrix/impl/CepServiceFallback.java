package br.com.circuitbreaker.hystrix.impl;

import br.com.circuitbreaker.hystrix.dto.CepResponse;
import br.com.circuitbreaker.hystrix.feign.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepServiceFallback {

    @Autowired
    private CepService cepService;


    public CepResponse consultCepValue(String cep)
    {
        CepResponse response = cepService.getCep(cep);
        if(response != null)
        {
            return response;
        }

        return hardCodedCep();
    }

    private CepResponse hardCodedCep()
    {
        CepResponse cepResponse = new CepResponse();
        cepResponse.setBairro("Bairro teste");
        cepResponse.setCep("000000000");
        cepResponse.setCidade("Sao paulo");
        cepResponse.setLogradouro("Rua teste ");

        return cepResponse;
    }

}
