package com.tropcool.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends AbstractEntity implements Serializable{
    @NotNull
    private Usuario usuario;
    @Column(unique = true, nullable = false, length = 11)
	private String cpf;
    @Column(length = 11)
	private String telefone;
    @OneToMany(targetEntity = HorarioAgendado.class,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			fetch = FetchType.EAGER, mappedBy = "cliente", orphanRemoval = true)
    private List<HorarioAgendado> horariosAgendados = new ArrayList<HorarioAgendado>();
    
}
