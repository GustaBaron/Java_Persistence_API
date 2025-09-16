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
	CommandLineRunner run(PessoaRepository repo, EnderecoRepository ende, CarroRepository carroRepository) {
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

			carroRepository.deleteAll();
			Carro carro = new Carro(null,"HB20","Hyundai",2025,2025,"branco");
			carroRepository.save(carro);
			carro = new Carro(null,"T-Cross","Volskwagen",2025,2024,"branco");
			carroRepository.save(carro);
			carro = new Carro(null,"Polo","Volskwagen",2022,2022,"vermelho");
			carroRepository.save(carro);
			carro = new Carro(null,"Onix","Chevrolet",2024,2024,"preto");
			carroRepository.save(carro);
			carro = new Carro(null,"Tracker","Chevrolet",2021,2020,"preto");
			carroRepository.save(carro);
			System.out.println("-------------------");
			System.out.println(" TODOS OS CARROS");
			System.out.println("-------------------");
			for (Carro c : carroRepository.findAll()) {
				System.out.println(c);
			}
			System.out.println("-------------------");
			System.out.println(" TODOS OS CARROS PELA COR");
			System.out.println("-------------------");
			for (Carro c : carroRepository.findByCor("branco")) {
				System.out.println(c);
			}
			System.out.println("-------------------");
			System.out.println(" TODOS OS CARROS PELA MARCA");
			System.out.println("-------------------");
			for (Carro c : carroRepository.findByMarcaIgnoreCaseOrderByModeloDesc("chevrolet")) {
				System.out.println(c);
			}
			System.out.println("-------------------");
			System.out.println(" TODOS OS CARROS PELA MARCA LIKE");
			System.out.println("-------------------");
			for (Carro c : carroRepository.findByMarcaContaining("v")) {
				System.out.println(c);
			}
		};
	}
}
