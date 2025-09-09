package com.gustavo.JPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	//Executa assim que começar o programa
	@Bean
	CommandLineRunner run(PessoaRepository repo, EnderecoRepository ende) {
		return args -> {
			// Inserções
			//Id é nulo -> insere o registro ( insert )
			// Id não é nulo -> atualiza o registro ( update )
			repo.save(new Pessoa(null, "João", "Silva"));
			repo.save(new Pessoa(null, "Maria", "Oliveira"));

			// Select
			System.out.println("Lista de pessoas:");
			repo.findAll().forEach(p ->
					System.out.println(p.getId() + " - " + p.getNome() + " " + p.getSobrenome())
			);
			ende.save(new Endereco(null, "avenida","aventureiro","joinville","SC","894556-123"));
			ende.save(new Endereco(null, "rua","bairro","cidade","estado","894556-123"));


			System.out.println("Lista de enderecos:");
			ende.findAll().forEach(e->
					System.out.println(e.getId()+ " -  " + e.getBairro() + " - " + e.getCidade() + " - " + e.getEstado() + " - " + e.getCep()));

		};
	}


}
