package com.tropcool.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class HorarioAgendado extends AbstractEntity{
	
	@NotNull
    private LocalDateTime horario;
	
	@NotNull
	@ManyToOne(targetEntity = Cliente.class, fetch = FetchType.LAZY ,optional = false)
    private ConfiguracaoAgenda configuracao;
	
	@NotNull
	@ManyToOne(targetEntity = Cliente.class, fetch = FetchType.LAZY ,optional = false)
    private Cliente cliente;
	
}
