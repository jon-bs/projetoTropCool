package com.tropcool.model.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.Cliente;
import com.tropcool.model.entity.RoleEnum;
import com.tropcool.model.entity.Usuario;
import com.tropcool.model.repository.ClienteRepository;
import com.tropcool.model.repository.UsuarioRepository;

public class ClienteTests extends AbstractIntegrationTests  {
	
	@Autowired
	private ClienteService  clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/*
	private String login;
	private String senha;
	private String nome;
	private String cpf;
	private String email;
	//private Boolean ativo;
	private RoleEnum perfil;
	private String telefone;
	*/
	/**
	 * ====================================== CADASTRAR ===========================================
	 */
	
	@Test
	@WithUserDetails("gabriel@mailinator.com")
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql"
		})
	
	public void cadastrarClienteMustPass() {
		Cliente cliente = new Cliente();
		cliente.setLogin("adm");
		cliente.setSenha("12345");
		cliente.setNome("Gabriel Andrade");
		cliente.setCpf("11111111112");
		cliente.setEmail("gabrieladm@hotmail.com");
		cliente.setAtivo(true);
		cliente.setPerfil(RoleEnum.USER);
		cliente.setTelefone("14523658745");
		this.clienteService.cadastrarCliente(cliente);
		Assert.assertNotNull(cliente.getId());
		//Assert.assertNotNull(cliente);
		
	}
	
	/** CPF DUPLICADO **/
	@Test
	@WithUserDetails("gabriel@mailinator.com")
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql"
		})
	
	public void cadastrarClienteCpfDuplicadoMustFail() {
		Cliente cliente = new Cliente();
		cliente.setLogin("adm");
		cliente.setSenha("12345");
		cliente.setNome("Gabriel Andrade");
		cliente.setCpf("11111111111");
		cliente.setEmail("gabrieladm@hotmail.com");
		cliente.setAtivo(true);
		cliente.setPerfil(RoleEnum.USER);
		cliente.setTelefone("14523658745");
		this.clienteService.cadastrarCliente(cliente);
		Assert.assertNotNull(cliente.getId());
		//Assert.assertNotNull(cliente);
		
	}
	
	/**
	 * ====================================== LISTAR ===========================================
	 */
	@Test
	@Sql({ 
		"/dataset/truncate.sql",  
			"/dataset/usuarios.sql", 
			"/dataset/clientes.sql"
		})
	public void listarClientesMustPass() {
		
		List<Cliente> clientes = this.clienteService.listaCliente();
		
		Assert.assertEquals(clientes.size(),1);
	}
	
	
}
