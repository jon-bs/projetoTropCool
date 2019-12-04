package com.tropcool.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Mensagem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
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
	
	@OneToOne(
			targetEntity = Interacao.class,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
			fetch = FetchType.LAZY, 
			mappedBy = "mensagem",
			orphanRemoval = false
			)
	private Interacao interacao;
	
}
