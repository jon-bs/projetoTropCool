package com.webiv.ifpr.tropcool.model.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.webiv.ifpr.tropcool.model.entity.Cliente;
import com.webiv.ifpr.tropcool.repository.ClienteRepository;
import com.webiv.ifpr.tropcool.service.ClienteService;

public class ClienteTest extends AbstractIntegrationTests {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * ====================================== LISTAR ===========================================
	 */
	
	/**
	 * ====================================== CADASTRAR ===========================================
	 */
	
	/* Exemplo para seguir jb
	 * @Sql({ "/dataset/truncate.sql",  
		"/dataset/departamentos.sql", 
		"/dataset/funcionarios.sql" })
	 * */
		
	@Test
	public void cadastrarClienteMustPass()
	{
		Cliente cliente = new Cliente();
		cliente.setCpf("45213654788");
		cliente.setEmail("teste@email.com");
		cliente.setLogin("loginNovo");
		cliente.setNome("Rosevaldo");
		cliente.setSenha("123456");
		cliente.setTelefone("4587454231");
		
		clienteService.cadastrarCliente(cliente);
	}
	
	/**
	 * ====================================== REMOVER ===========================================
	 */
	
	@Test
	@Sql({
		"/dataset/truncate.sql",
			"/dataset/clientes.sql"
	})
	public void removerClienteMustPass() {
		
		this.clienteService.removerCliente(1110L);
		
		Cliente cliente = this.clienteRepository.findById(1110L).orElse(null);
		
		Assert.assertNull(cliente);
	}
}
