package com.gustavo.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    // select * from carro where cor = ?
    List<Carro> findByCor(String cor);

    // select * from carro where marca = ? order by modelo desc
    List<Carro> findByMarcaIgnoreCaseOrderByModeloDesc(String marca);


    // select * from carro where marca = '%?%' order by modelo desc
    List<Carro> findByMarcaContaining(String marca);

}
