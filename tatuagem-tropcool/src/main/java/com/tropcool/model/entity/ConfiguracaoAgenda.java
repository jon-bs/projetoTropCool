package com.tropcool.model.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracaoAgenda extends AbstractEntity implements Serializable{
	
	@NotNull
	private LocalTime horaInicio;
	
	@NotNull
	private LocalTime horaTermino;
	
	@Enumerated( EnumType.ORDINAL )
	private DiaSemanaEnum dia;
	
	@NotNull
	@ManyToOne(
			targetEntity = Tatuador.class,
			fetch = FetchType.LAZY,
			optional = false
			)
	private Tatuador tatuador;
	
	@JsonIgnoreProperties("configuracao")
	@OneToMany(
			targetEntity = HorarioAgendado.class,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			fetch = FetchType.EAGER, 
			mappedBy = "configuracao", 
			orphanRemoval = true
			)
	private List<HorarioAgendado> horarioAgendado = new ArrayList<HorarioAgendado>();
	
}
