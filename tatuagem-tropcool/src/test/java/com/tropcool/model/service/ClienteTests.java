package com.tropcool.model.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.service.AbstractIntegrationTests;
import com.tropcool.model.entity.Cliente;
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
	
	@Test
	@WithUserDetails("gabriel@mailinator.com")
	@Sql({ 
		"/dataset/truncate.sql", 
			"/dataset/usuarios.sql",
		})
	public void cadastrarClienteMustPass() {
		
		Cliente cliente = new Cliente();
		cliente.setCpf("12345678985");
		cliente.setTelefone("14523658745");
		Usuario usuario = this.usuarioRepository.findById(1001L).orElse(null);
		cliente.setUsuario(usuario);
		
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
		
		List<Cliente> funcionarios = this.clienteService.listaCliente();
		
		Assert.assertEquals(funcionarios.size(),1);
	}
	
	
}
