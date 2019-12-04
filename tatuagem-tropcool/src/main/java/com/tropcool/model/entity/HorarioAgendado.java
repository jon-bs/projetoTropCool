package com.tropcool.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class HorarioAgendado extends AbstractEntity implements Serializable{
	
	@NotNull
    private LocalDateTime horario;
	
	@NotNull
	@ManyToOne(
			targetEntity = ConfiguracaoAgenda.class, 
			fetch = FetchType.LAZY ,
			optional = false
			)
    private ConfiguracaoAgenda configuracao;
	
	@NotNull
	@ManyToOne(
		targetEntity = Cliente.class, 
		fetch = FetchType.LAZY ,
		optional = false
		)
    private Cliente cliente;
	
}
