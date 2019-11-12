package com.tropcool.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table
@Entity
@EqualsAndHashCode(callSuper = true)
public class Tatuador extends Usuario{
	
	//private static final long serialVersionUID = 1L;
	
	public Tatuador(Long id) {
		super.setId(id);
	}
	
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
