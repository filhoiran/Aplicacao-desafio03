package com.desafio3.desafio03.model;

import java.io.Serializable;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

//import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "Pessoas")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// private static final long serialVersionUID = -8592425184275347168L;

    @ApiModelProperty(value = "Código da pessoa")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Gera o ID automaticamente
	private Long id;
	
    @ApiModelProperty(value = "Primeiro nome")
    // @NotNull(message = "First Name cannot be null")
	@NotBlank(message = "Campo nome é obrigatório")
	@Column(name = "Primeiro_nome", nullable = false)
	private String first_name;
	
    @ApiModelProperty(value = "Ultimo nome")
    // @NotNull(message = "First Name cannot be null")
	@NotBlank(message = "Campo nome é obrigatório")
	@Column(name = "Ultimo_nome", nullable = false)
	private String last_name;
	
	private String career;
	
	// Constructor
	
	public Pessoa() {
		
	}
	
	// getters and setters

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}

}
