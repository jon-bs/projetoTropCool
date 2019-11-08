package com.tropcool.model.service;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.Cliente;
import com.tropcool.model.repository.ClienteRepository;

public class ClienteTests extends AbstractIntegrationTests  {
	@Autowired
	private ClienteService  clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * ====================================== LISTAR ===========================================
	 */
	@Test
	@Sql({ 
		//"/dataset/truncate.sql",  
		"/dataset/usuarios.sql", 
		"/dataset/clientes.sql"})
	public void listarClientesMustPass() {
		List<Cliente> funcionarios = this.clienteService.listaCliente();

	}
}
