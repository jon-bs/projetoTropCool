package com.tropcool.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Post extends AbstractEntity{
	@NotNull
	@ManyToOne(targetEntity = Tatuador.class, fetch = FetchType.LAZY, optional = false)
    private Tatuador tatuador;
    private Boolean bloqueado;
    private byte[] imagem;
    
    
}
