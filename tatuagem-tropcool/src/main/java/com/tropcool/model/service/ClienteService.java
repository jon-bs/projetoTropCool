package com.tropcool.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tropcool.model.entity.Cliente;
import com.tropcool.model.repository.ClienteRepository;


@Service // classe service
@Transactional
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	public Cliente cadastrarCliente(Cliente cliente) {
		this.usuarioService.cadastrarNewUser(cliente);
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente detalharCliente(Long id) {
		Cliente cliente = this.clienteRepository.findById(id).orElse(null);
		Assert.notNull(cliente,"O cliente de id " + id + " não foi encontrado no sistema...");
		return cliente;
	}
	
	public Cliente atualizarCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public List<Cliente> listaCliente(){
		return this.clienteRepository.findAll();
	}
	
	public void removerCliente(Long id) {
		this.clienteRepository.deleteById(id);
	}
}
