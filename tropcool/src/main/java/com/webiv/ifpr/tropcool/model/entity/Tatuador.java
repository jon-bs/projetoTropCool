package com.webiv.ifpr.tropcool.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tatuador extends AbstractUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Opcional */
	@Column(unique = true, length = 11)
	private String segundoTelefone;
	
	@NotBlank
	@Column(unique = true, nullable = false, length = 11)
	private String numeroAlvara;
	
	
	@JsonIgnoreProperties("tatuador")
	@ManyToOne(targetEntity = Endereco.class, fetch = FetchType.LAZY, optional = false)
	private Endereco endereco;
	
	//private ArrayList<ConfiguracaoAgenda> confAgenda;
}
