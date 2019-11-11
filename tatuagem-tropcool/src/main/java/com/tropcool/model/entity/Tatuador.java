package com.tropcool.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Table
@Entity
public class Tatuador extends AbstractEntity{
	@NotNull
	private Usuario usuario;
	
	@Column(unique = true, nullable = false, length = 11)
	private String cpf;
	
	@NotBlank
	@Column(unique = true, length = 11)
	private String telefone1;
	
	@NotBlank
	@Column(unique = true, length = 11)
	private String telefone2;
	
	@NotBlank
	@Column(unique = true,nullable = false, length = 10)
	private String alvara;
	
	//private Endereco endereco;
	//private ArrayList<ConfiguracaoAgenda> horarios;
}
