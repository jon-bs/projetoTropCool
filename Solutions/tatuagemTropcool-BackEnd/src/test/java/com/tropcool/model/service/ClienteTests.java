package com.tropcool.model.service;

import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.Cliente;
import com.tropcool.model.entity.RoleEnum;
import com.tropcool.model.entity.Tatuador;
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
	
	
	/**
	 * ====================================== CADASTRAR ===========================================
	 */
	
	/*  CADASTRAR CLIENTE - MUSTPASS  */
	
	@Test
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
		Assert.assertNotNull( cliente.getId() );
	}
	
	/** LOGIN EM BRANCO **/
	
	@Test(expected = ValidationException.class)
	@Sql({ 
		"/dataset/truncate.sql",
								})
	public void cadastrarClienteMustFailLoginEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setLogin("");
		cliente.setSenha("12345");
		cliente.setNome("Gabriel Andrade");
		cliente.setCpf("11111111112");
		cliente.setEmail("gabrieladm@hotmail.com");
		cliente.setAtivo(true);
		cliente.setPerfil(RoleEnum.USER);
		cliente.setTelefone("14523658745");
		
		this.clienteService.cadastrarCliente(cliente);
		Assert.assertNotNull( cliente.getId() );
	}
	
	/** SENHA EM BRANCO **/
	
	@Test(expected = ValidationException.class)
	@Sql({ 
		"/dataset/truncate.sql",
								})
	public void cadastrarClienteMustFailSenhaEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setLogin("adm");
		cliente.setSenha("");
		cliente.setNome("Gabriel Andrade");
		cliente.setCpf("11111111112");
		cliente.setEmail("gabrieladm@hotmail.com");
		cliente.setAtivo(true);
		cliente.setPerfil(RoleEnum.USER);
		cliente.setTelefone("14523658745");
		
		this.clienteService.cadastrarCliente(cliente);
	}
	
	/** NOME EM BRANCO **/
	
	@Test(expected = ValidationException.class)
	@Sql({ 
		"/dataset/truncate.sql",
								})
	public void cadastrarClienteMustFailNomeEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setLogin("adm");
		cliente.setSenha("12345");
		cliente.setNome("");
		cliente.setCpf("11111111112");
		cliente.setEmail("gabrieladm@hotmail.com");
		cliente.setAtivo(true);
		cliente.setPerfil(RoleEnum.USER);
		cliente.setTelefone("14523658745");
		
		this.clienteService.cadastrarCliente(cliente);
	}
	
	
	
	/** CPF DUPLICADO **/
	
	
	@Test(expected = DataIntegrityViolationException.class)
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
	}
	
	/** EMAIL EM BRANCO **/
	
	@Test(expected = ValidationException.class)
	@Sql({ 
		"/dataset/truncate.sql",
								})
	public void cadastrarClienteMustFailEmailEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setLogin("adm");
		cliente.setSenha("12345");
		cliente.setNome("Gabriel Andrade");
		cliente.setCpf("11111111112");
		cliente.setEmail("");
		cliente.setAtivo(true);
		cliente.setPerfil(RoleEnum.USER);
		cliente.setTelefone("14523658745");
		
		this.clienteService.cadastrarCliente(cliente);
	}
	
	/** TELEFONE EM BRANCO **/
	
	@Test(expected = ValidationException.class)
	@Sql({ 
		"/dataset/truncate.sql",
								})
	public void cadastrarClienteMustFailTelefoneEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setLogin("adm");
		cliente.setSenha("12345");
		cliente.setNome("Gabriel Andrade");
		cliente.setCpf("11111111112");
		cliente.setEmail("gabrieladm@hotmail.com");
		cliente.setAtivo(true);
		cliente.setPerfil(RoleEnum.USER);
		cliente.setTelefone("");
		
		this.clienteService.cadastrarCliente(cliente);
	}
	
/** TELEFONE MAIOR DO QUE O PERMITIDO **/
	
	@Test(expected = DataIntegrityViolationException.class)
	@Sql({ 
		"/dataset/truncate.sql",
								})
	public void cadastrarClienteMustFailTelefoneSuperiorAoMax() {
		Cliente cliente = new Cliente();
		cliente.setLogin("adm");
		cliente.setSenha("12345");
		cliente.setNome("Gabriel Andrade");
		cliente.setCpf("11111111112");
		cliente.setEmail("gabrieladm@hotmail.com");
		cliente.setAtivo(true);
		cliente.setPerfil(RoleEnum.USER);
		cliente.setTelefone("12365897421547");
		
		this.clienteService.cadastrarCliente(cliente);
	}
	
	
	
	/** LOGIN MAIOR DO QUE O PERMITIDO **/
	
	@Test(expected = DataIntegrityViolationException.class)
	@Sql({ 
		"/dataset/truncate.sql",
								})
	public void cadastrarClienteMustFailLogSuperiorAoMax() {
		Cliente cliente = new Cliente();
		cliente.setLogin("admjrmshnrotijhdhenjcd");
		cliente.setSenha("12345");
		cliente.setNome("Gabriel Andrade");
		cliente.setCpf("11111111112");
		cliente.setEmail("gabrieladm@hotmail.com");
		cliente.setAtivo(true);
		cliente.setPerfil(RoleEnum.USER);
		cliente.setTelefone("12365897421");
		
		this.clienteService.cadastrarCliente(cliente);
	}
	
	
	/**CPF MAIOR DO QUE O PERMITIDO **/
	
	@Test(expected = DataIntegrityViolationException.class)
	@Sql({ 
		"/dataset/truncate.sql",
								})
	public void cadastrarClienteMustFailCPFSuperiorAoMax() {
		Cliente cliente = new Cliente();
		cliente.setLogin("adm");
		cliente.setSenha("12345");
		cliente.setNome("Gabriel Andrade");
		cliente.setCpf("11111111112236");
		cliente.setEmail("gabrieladm@hotmail.com");
		cliente.setAtivo(true);
		cliente.setPerfil(RoleEnum.USER);
		cliente.setTelefone("12365897421547");
		
		this.clienteService.cadastrarCliente(cliente);
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
		
		Assert.assertEquals(clientes.size(), 4);
	}
	
	/**
	 * ====================================== DETALHAR ===========================================
	 */
	
	/* DETALHAR CLIENTE - MUSTPASS */
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",  
		"/dataset/usuarios.sql", 
		"/dataset/clientes.sql"
										})
	public void detalharClienteMustPass() {
		Cliente cliente = this.clienteService.detalharCliente(1002L);
		Assert.assertNotNull(cliente);
		Assert.assertTrue(cliente.getId() == 1002L);
	}
	
	/**
	 * ====================================== Atualizar ===========================================
	 */
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",  
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql", 
										})
	public void atualizarClienteMustPass() 
	{
		Cliente cliente = this.clienteService.detalharCliente(1001L);
		cliente.setLogin("cliente0001");
		
		clienteService.atualizarCliente(cliente);
	}
	
	
	@Test(expected = DataIntegrityViolationException.class)
	@Sql({ 
		"/dataset/truncate.sql",  
			"/dataset/usuarios.sql",
				"/dataset/clientes.sql", 
										})
	public void atualizarClienteMustFailLoginEmUso() 
	{
		Cliente cliente = this.clienteService.detalharCliente(1001L);
		cliente.setLogin("adm_gabriel");
		clienteService.atualizarCliente(cliente);
	}
	
	/*  ATUALIZAR CLIENTE - MUDAR SENHA */
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",  
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql", 
										})
	public void atualizarClienteMudarSenhaSemTokenMustFail() 
	{
		Cliente cliente = this.clienteService.detalharCliente(1001L);
		cliente.setSenha("12345");
		clienteService.atualizarCliente(cliente);
	}
	
	/**
	 * ====================================== REMOVER ===========================================
	 */
	
	@Test
	@Sql({
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql"
										})
	public void removerClienteMustPass() {
		
		Cliente cliente = this.clienteRepository.findById(1001L).orElse(null);
		this.clienteService.removerCliente(cliente.getId());
	}
	
}
