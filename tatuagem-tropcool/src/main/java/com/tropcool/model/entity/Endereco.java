package com.tropcool.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table()
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Endereco extends AbstractEntity implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String cidade;
    
	@NotBlank
	private String estado;
    
	@NotBlank
	private String numero;
    
	@NotBlank
	private String rua;
	
	@NotBlank
	private String cep;
    
   
}
