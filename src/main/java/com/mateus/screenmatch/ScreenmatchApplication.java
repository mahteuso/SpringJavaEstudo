package com.mateus.screenmatch;

import com.mateus.screenmatch.service.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner leitura = new Scanner(System.in);
		System.out.println("Digite um nome de filme para a busca");
		var busca = leitura.nextLine();

		String uri = "https://www.omdbapi.com/?t=" + busca + "&apikey=31cd69a1";

		ConsumoApi consumoApi = new ConsumoApi();

		var json = consumoApi.obterDados(uri);

		System.out.println(json);
	}
}
