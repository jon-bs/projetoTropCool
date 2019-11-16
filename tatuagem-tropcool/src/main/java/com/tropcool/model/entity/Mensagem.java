package com.tropcool.model.entity;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Mensagem extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;
	
	public Mensagem(Long id) {
		super.setId(id);
	}
	
	@NotNull
	@ManyToOne(
			targetEntity = Usuario.class,
			fetch = FetchType.LAZY,
			optional = true)
	private Usuario remetente;
	
	@NotNull
	@ManyToOne(
			targetEntity = Usuario.class, 
			fetch = FetchType.LAZY, 
			optional = true)
	private Usuario destinatario;
	
	@NotNull
	private LocalDateTime data;
	private Boolean lido;
	
	@NotBlank
	private String conteudo;
	
	@OneToMany(
			targetEntity = Interacao.class,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
			fetch = FetchType.LAZY, 
			mappedBy = "mensagem",
			orphanRemoval = false
			)
	private List<Interacao> interacao = new ArrayList<Interacao>();
	
	
}
