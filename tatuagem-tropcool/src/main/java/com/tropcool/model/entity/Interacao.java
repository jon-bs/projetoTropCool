package com.tropcool.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table
@Data
@Entity
//@EqualsAndHashCode(callSuper = true)
//@NoArgsConstructor
@AllArgsConstructor
public class Interacao extends Mensagem {
	
	public Interacao() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	/*
	public Interacao(Long id) {
		super.setId(id);
	}
	*/

	@OneToOne(
			targetEntity = Mensagem.class,
			fetch = FetchType.LAZY, 
			optional = true
			)
	/*@JoinColumn(
	    	name="mensagem_resp", unique=false, nullable=false, updatable=false)*/
	private Mensagem mensagem;
}
