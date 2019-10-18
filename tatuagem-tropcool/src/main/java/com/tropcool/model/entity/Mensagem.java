package com.tropcool.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Mensagem {
	@NotNull
	@ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY, optional = false)
	private Usuario remetente;
	@NotNull
	@ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY, optional = false)
	private Usuario destinatario;
	@NotNull
	private LocalDateTime data;
	private Boolean lido;
	@NotBlank
	private String conteudo;
	@OneToMany(targetEntity = Interacao.class,cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "Mensagem",orphanRemoval = true)
	private List<Interacao> interacao = new ArrayList<Interacao>();
	
	
}
