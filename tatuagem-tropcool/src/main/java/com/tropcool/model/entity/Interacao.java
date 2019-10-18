package com.tropcool.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Interacao extends Mensagem{
	
	@NotNull
	@ManyToOne(targetEntity = Mensagem.class, fetch = FetchType.LAZY, optional = false)
	private Mensagem mensagem;
	
}
