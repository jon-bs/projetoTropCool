package com.tropcool.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Endereco extends AbstractEntity{
    private String cidade;
    private String estado;
    private String numero;
    private String rua;
    private String cep;
    
   
}
