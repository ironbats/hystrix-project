package br.com.circuitbreaker.hystrix.dto;

import lombok.Data;

@Data
public class CepResponse {

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;

}
