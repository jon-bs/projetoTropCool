package com.webiv.ifpr.tropcool.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Cliente extends AbstractUser implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
