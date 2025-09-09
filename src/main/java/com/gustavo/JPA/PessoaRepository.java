package com.gustavo.JPA;

import org.springframework.data.jpa.repository.JpaRepository;


//Pessoa - Entidade
//Long - Tipo de Dados do Id
//JpaRepository<Pessoa, Long>
//Repository = DAO

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
