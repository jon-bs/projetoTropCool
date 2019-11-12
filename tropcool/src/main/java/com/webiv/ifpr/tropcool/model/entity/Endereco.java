package com.webiv.ifpr.tropcool.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;
	
	@NotBlank
	@Column(nullable = false)
	private String rua;
	
	@NotBlank
	@Column(nullable = false)
	private String cidade;
	
	@NotBlank
	@Column(nullable = false)
	private String bairro;
	
	@NotBlank
	@Column(unique = true, nullable = false, length = 10)
	private String cep;
	
	@JsonIgnoreProperties("endereco")
	@OneToMany(targetEntity = Tatuador.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			fetch = FetchType.EAGER, mappedBy = "endereco", orphanRemoval = true)
	private List<Tatuador> tatuadores = new ArrayList<Tatuador>();
}
