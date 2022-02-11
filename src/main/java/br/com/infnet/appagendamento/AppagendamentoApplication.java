package br.com.infnet.appagendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppagendamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppagendamentoApplication.class, args);
	}

}
