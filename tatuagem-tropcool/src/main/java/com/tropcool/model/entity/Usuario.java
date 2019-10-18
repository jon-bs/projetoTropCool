package com.tropcool.model.entity;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode (callSuper = true)
public class Usuario extends AbstractEntity implements UserDetails{
	//private static final long serialVersionUID 1L;
	private static final long serialVersionUID = -6624327477248695198L;
	
	@NotBlank
	@Column(unique = true, nullable = false, length = 20)
	private String login;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotBlank
	@Column(unique = false, nullable = false, length = 16)
	private String senha;
	@NotBlank // Não em branco
	private String nome;
	@NotBlank
	private String email;
	private Boolean ativo;
	
	@Enumerated( EnumType.ORDINAL )
	private RoleEnum perfil;
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
	@Transient
	public Set<GrantedAuthority> getAuthorities()
	{
		final Set<GrantedAuthority> authorities = new HashSet<>();

		if ( this.perfil == null )
		{
			return null;
		}
		
		authorities.addAll( this.perfil.getAuthorities() );

		return authorities;
	}

	@Override
	public String getPassword() { // método padrão da interface, podendo ser usados outros parâmetros além da senha
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
		return this.ativo;
	}
	
	public void generatePasswordResetToken()
	{
		this.passwordResetToken = UUID.randomUUID().toString();
		this.passwordResetTokenExpiration = OffsetDateTime.now().plusDays( 1 );

	}
	
	public void generateAccountActivateToken()
	{
		this.accountActivateToken = UUID.randomUUID().toString();
		this.accountActivateTokenExpiration = OffsetDateTime.now().plusDays( 1 );

	}
	
	public void generatePassword()
	{
		this.senha = UUID.randomUUID().toString();

	}
	
}
