package com.tropcool.model.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table
@Data
public class ConfiguracaoAgenda extends AbstractEntity{
	
	@NotNull
	private LocalTime horaInicio;
	@NotNull
	private LocalTime horaTermino;
	@Enumerated( EnumType.ORDINAL )
	private DiaSemanaEnum dia;
	
	@ManyToOne(targetEntity = Tatuador.class,fetch = FetchType.LAZY, optional = false)
	private Tatuador tatuador;
	
	@OneToMany(targetEntity = HorarioAgendado.class,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},fetch = FetchType.EAGER, mappedBy = "configuracao", orphanRemoval = true)
	private List<HorarioAgendado> horarioAgendado = new ArrayList<HorarioAgendado>();
	
}
