package br.com.circuitbreaker.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class HystrixbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixbApplication.class, args);
	}

}
