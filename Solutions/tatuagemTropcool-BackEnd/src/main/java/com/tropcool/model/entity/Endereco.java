package com.tropcool.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@NotNull
	@JsonIgnoreProperties("endereco")
	private static final long serialVersionUID = 1L;
	
	@OneToOne(
			targetEntity = Tatuador.class, 
    		cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			fetch = FetchType.LAZY, 
			mappedBy = "endereco", 
			orphanRemoval = true
			)
	private Tatuador tatuador;
	
	@NotNull
	@NotBlank
	private String cidade;
    
	@NotNull
	@NotBlank
	private String estado;
    
	@NotNull
	@NotBlank
	private String numero;
    
	@NotNull
	@NotBlank
	private String rua;
	
	@NotNull
	@NotBlank
	private String cep;
    
   
}
