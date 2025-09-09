package com.gustavo.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> id(Long id);

    String rua(String rua);
}
