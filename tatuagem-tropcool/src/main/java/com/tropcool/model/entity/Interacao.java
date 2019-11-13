package com.tropcool.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Table
@Data
@Entity
public class Interacao extends Mensagem{
	
	@NotNull
	@ManyToOne(targetEntity = Mensagem.class, fetch = FetchType.LAZY, optional = false)
	private Mensagem mensagem;
	
}
