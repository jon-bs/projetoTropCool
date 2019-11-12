package com.webiv.ifpr.tropcool.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class AbstractUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;

	@NotBlank
	@Column(nullable = false, unique = true)
	private String login;
	
	@NotBlank
	@Column(nullable = false)
	private String senha;
	
	@NotBlank
	@Column(unique = true, nullable = false)
	private String email;
	
	
	private Boolean status = false;
	
	@NotBlank
	@Column(unique = true, nullable = false, length = 11)
	private String cpf;
	
	
	@NotBlank
	@Column(unique = true, length = 11, nullable = false)
	private String telefone;
	
	@NotNull
	private LocalDateTime created;
	
	private LocalDateTime updated;
	
	@PrePersist
	protected void refreshCreated()
	{
		if ( this.getCreated() == null )
		{
			this.setCreated( LocalDateTime.now() );
		}
	}
	
	@PreUpdate
	protected void refreshUpdated()
	{
		this.refreshCreated();
		this.setUpdated( LocalDateTime.now() );
	}
	
}
