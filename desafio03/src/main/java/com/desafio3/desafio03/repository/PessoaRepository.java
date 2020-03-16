package com.desafio3.desafio03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio3.desafio03.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	//Pessoa findById(Long id);
}
