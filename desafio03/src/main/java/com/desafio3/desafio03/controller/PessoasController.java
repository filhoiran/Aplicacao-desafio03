package com.desafio3.desafio03.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio3.desafio03.model.Pessoa;
import com.desafio3.desafio03.repository.PessoaRepository;
import com.desafio3.desafio03.service.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Rest Pessoas")
@CrossOrigin(origins = "*")
public class PessoasController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
/**	@RequestMapping(value = "/pessoa", method =  RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Pessoa Post(@Valid @RequestBody Pessoa pessoa) {
	    return pessoaRepository.save(pessoa);
	} **/
	
/**	@RequestMapping(path = "/pessoa", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Retorna a lista dos colaboradores devidamente cadastrados.")
	public List<Pessoa> Get() {
			return pessoaRepository.findAll();
	} **/
	
	@ApiOperation(value = "Retorna a lista dos colaboradores devidamente cadastrados.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") } )
	@GetMapping(path = "/pessoas/listar")
	public List<Pessoa> listarPessoas() {
			return pessoaRepository.findAll();
	}
	
	@ApiOperation(value = "Retorna uma colaborador específico referente ao seu ID informado.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") } )	
	@GetMapping(path = "/pessoa/{id}/id")
	public Optional<Pessoa> listarPessoasPorID(
			@PathVariable(name = "id", required = true) Long id) {
		return pessoaRepository.findById(id);
	}
	
	@ApiOperation(value = "Cadastrar um novo colaborador.")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "OK"),
		    @ApiResponse(code = 201, message = "Created")
	})
	@PostMapping(path = "/pessoa/adicionar")
	public Pessoa adicionarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	// Cadastrar pessoa
/** @PostMapping(path = "/pessoa/cadastrar")
	public cadastrarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	} */
	
	// Atualizar os dados da pessoa cadastradas
/** @PostMapping(path = "/pessoa/atualizar")
	public void atualizarPessoa(@RequestBody Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	} */
	
	@ApiOperation(value = "Deletar um colaborador referente ao seu ID informado.")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content") } )
	@DeleteMapping(path = "/pessoas/{id}/deletar")
	public void deletePessoa(
			@PathVariable(name = "id", required = true) Long id) {
		pessoaRepository.deleteById(id);
	}
	
	// Excluir pessoa informada
/** @DeleteMapping(path = "/pessoas/excluir")
	public void excluirPessoa(@RequestBody Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	} */
	
	// Através do PUT
	@ApiOperation(value = "Atualizar os dados de um colaborador cadastrado.")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content") } )
	@PutMapping(path = "/pessoa/atualizar")
	public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	/*
	 * @Autowired private PessoaService pessoaService;
	 * 
	 * @GetMapping public List<Pessoa> findAll() { return pessoaService.findAll(); }
	 * 
	 * @GetMapping(value="/{id}") public ResponseEntity<Pessoa>
	 * findById(@PathVariable Long id){ return pessoaService.findById(id)
	 * .map(record -> ResponseEntity.ok().body(record))
	 * .orElse(ResponseEntity.notFound().build()); }
	 * 
	 * @PostMapping public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa
	 * pessoa) { Pessoa obj = pessoaService.save(pessoa); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (obj.getId()).toUri(); return ResponseEntity.created(uri).body(obj); }
	 */

}
