package com.desafio3.desafio03.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio3.desafio03.model.Pessoa;
import com.desafio3.desafio03.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Optional<Pessoa> findByID(Long id) {
		return pessoaRepository.findById(id);
	}

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public void deleteById(long id) {
		pessoaRepository.deleteById(id);
	}

	public void deleteAll() {
		pessoaRepository.deleteAll();
	}

}
