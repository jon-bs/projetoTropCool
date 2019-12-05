package com.tropcool.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table()
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario implements Serializable{
     
	private static final long serialVersionUID = 1L;
	
	public Cliente(Long id) {
		super.setId(id);
	}
	
    @Column(length = 11)
    @NotBlank
	private String telefone;
    
    @JsonIgnoreProperties({"cliente","configuracao"})
    @OneToMany(
	    		targetEntity = HorarioAgendado.class, 
	    		cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
				fetch = FetchType.LAZY, 
				mappedBy = "cliente", 
				orphanRemoval = true
			)
    private List<HorarioAgendado> horariosAgendados = new ArrayList<HorarioAgendado>();
}
