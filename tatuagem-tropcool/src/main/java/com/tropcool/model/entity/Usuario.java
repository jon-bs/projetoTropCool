package com.tropcool.model.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.EnumType;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Transient;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends AbstractEntity implements UserDetails{
	
	public Usuario(Long id) {
		super.setId(id);
	}
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@NotBlank
	@Column(unique = true, nullable = false, length = 20)
	private String login;
	
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotNull
	@NotBlank
	@Column(unique = false, nullable = false)
	private String senha;
	
	@NotNull
	@NotBlank // Não em branco
	private String nome;
	
	@NotNull
	@NotBlank
    @Column(unique = true, nullable = false, length = 11)
	private String cpf;
    
	@NotNull
	@NotBlank
	private String email;
	private Boolean ativo;
	
	@JsonIgnoreProperties({"remetente","destinatario","interacao"})
	@OneToMany(
			targetEntity = Mensagem.class,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
			fetch = FetchType.LAZY, 
			mappedBy = "remetente",
			orphanRemoval = true
			)
	private List<Mensagem> mensagemEnviada = new ArrayList<Mensagem>();
	
	@JsonIgnoreProperties({"remetente","destinatario","interacao"})
	@OneToMany(
			targetEntity = Mensagem.class,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
			fetch = FetchType.LAZY, 
			mappedBy = "destinatario",
			orphanRemoval = true
			)
	private List<Mensagem> mensagemRecebida = new ArrayList<Mensagem>();
	
	@NotNull
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
