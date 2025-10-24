package com.example.mssinaramongo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsSinaraMongoApplication {

	public static void main(String[] args) {
		try {
			// Carrega o .env
			Dotenv dotenv = Dotenv.configure()
					.directory("./")
					.ignoreIfMissing()
					.load();

			// ADICIONE ESTES LOGS PARA DEBUG
			System.out.println("=== DOTENV LOADED ===");
			System.out.println("MONGODB_URI: " + dotenv.get("MONGODB_URI"));
			System.out.println("=====================");

			// Define as variáveis como propriedades do sistema
			dotenv.entries().forEach(entry -> {
				System.setProperty(entry.getKey(), entry.getValue());
				System.out.println("Set property: " + entry.getKey() + " = " + entry.getValue());
			});

		} catch (Exception e) {
			System.err.println("Erro ao carregar .env: " + e.getMessage());
			e.printStackTrace();
		}

		SpringApplication.run(MsSinaraMongoApplication.class, args);
	}

}
