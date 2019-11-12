package com.webiv.ifpr.tropcool.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.webiv.ifpr.tropcool.model.entity.Cliente;
import com.webiv.ifpr.tropcool.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente cadastrarCliente(Cliente cliente) 
	{
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente atualizarCliente(Cliente cliente) 
	{
		return this.clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarClientes()
	{
		return this.clienteRepository.findAll();
	}
	
	public Cliente detalharCliente(Long id)
	{
		Cliente cliente = this.clienteRepository.findById(id).orElse(null);
		
		Assert.notNull(cliente, "O Id "+ id +" não foi encontrado.");
		
		return cliente;
	}
	
	public void removerCliente(long id) {
		this.clienteRepository.deleteById(id);
	}
	
}
