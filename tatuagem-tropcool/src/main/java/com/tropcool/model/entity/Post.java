package com.tropcool.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Post extends AbstractEntity{
	@NotNull
	@ManyToOne(
			targetEntity = Tatuador.class, 
			fetch = FetchType.LAZY, 
			optional = false)
    private Tatuador tatuador;
    private Boolean bloqueado;
    private byte[] imagem;
    
    
}
