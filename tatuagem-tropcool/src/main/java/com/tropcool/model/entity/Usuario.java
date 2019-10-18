package com.tropcool.model.entity;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Usuario extends AbstractEntity implements UserDetails{
	//private static final long serialVersionUID 1L;
	private static final long serialVersionUID = -6624327477248695198L;
	
	@NotBlank
	@Column(unique = true, nullable = false, length = 20)
	private String login;
	@NotBlank
	@Column(unique = false, nullable = false, length = 16)
	private String senha;
	@NotBlank // Não em branco
	private String nome;
	@NotBlank
	private String email;
	private Boolean ativo;
	
	/**
	 * Token para resetar o password
	 */
	private String passwordResetToken;

	/**
	 * Data que expira o token de resetar o password
	 */
	private OffsetDateTime passwordResetTokenExpiration;
	
	/**
	 * Token para ativar a conta
	 */
	private String accountActivateToken;

	/**
	 * Data que expira o token de ativar a conta
	 */
	private OffsetDateTime accountActivateTokenExpiration;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public void generateToken()
	{
		this.passwordResetToken = UUID.randomUUID().toString();

	}
}
