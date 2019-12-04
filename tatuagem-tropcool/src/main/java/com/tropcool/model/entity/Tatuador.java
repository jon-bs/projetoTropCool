package com.tropcool.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Tatuador extends Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@OneToOne(
			targetEntity = Endereco.class, fetch = FetchType.LAZY, optional = true
		)
	private Endereco endereco;
	
	@OneToMany(
    		targetEntity = Post.class, 
    		cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			fetch = FetchType.LAZY, 
			mappedBy = "tatuador", 
			orphanRemoval = true
		)
	private List<Post> posts = new ArrayList<Post>();
	
	@OneToMany(
    		targetEntity = ConfiguracaoAgenda.class, 
    		cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			fetch = FetchType.LAZY, 
			mappedBy = "tatuador", 
			orphanRemoval = true
		)
	private List<ConfiguracaoAgenda> configuracaoAgenda = new ArrayList<ConfiguracaoAgenda>();
}
