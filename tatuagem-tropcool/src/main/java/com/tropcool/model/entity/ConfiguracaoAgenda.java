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
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class ConfiguracaoAgenda {
	@NotNull
	private LocalTime horaInicio;
	@NotNull
	private LocalTime horaTermino;
	@NotNull
	@Enumerated( EnumType.ORDINAL )
	private DiaSemanaEnum dia;
	
	/*
	 * @ManyToOne(targetEntity = Departamento.class, fetch = FetchType.LAZY,
	 * optional = false) private Departamento departamento;
	 * 
	 *  OrphanRemoval quer dizer que se excluirmos o departamento, se o funcionário
	 *  não estiver vinculado a outro departamento ele será excluído
	 * Enquanto que, cascade remove quer dizer que se eu remover o departamento os funcionários serão removidos
	*@OneToMany(targetEntity = Funcionario.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			*fetch = FetchType.EAGER, mappedBy = "departamento", orphanRemoval = true)
	*private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	 */
	@ManyToOne(targetEntity = Tatuador.class,fetch = FetchType.LAZY, optional = false)
	private Tatuador tatuador;
	
	@OneToMany(targetEntity = HorarioAgendado.class,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},fetch = FetchType.EAGER, mappedBy = "ConfiguracaoAgenda", orphanRemoval = true)
	private List<HorarioAgendado> horarioAgendado = new ArrayList<HorarioAgendado>();
	
}
