package com.gustavo.JPA;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//indicar que a classe é uma Entidade
//Criar/ Atualizar a tabela no BD
//Nome da tabela é o nome da classe: Pessoa
@Entity
public class Pessoa {
    //@Id indica que é a chave Primária
    //@GeneratedValue - autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;

    public Pessoa() {
    }

    public Pessoa( Long id, String sobrenome, String nome) {
        this.sobrenome = sobrenome;
        this.nome = nome;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
