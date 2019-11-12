package com.webiv.ifpr.tropcool.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.webiv.ifpr.tropcool.model.entity.Endereco;
import com.webiv.ifpr.tropcool.repository.EnderecoRepository;

@Service
@Transactional
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco cadastrarEndereco(Endereco endereco) 
	{
		return this.enderecoRepository.save(endereco);
	}
	
	public Endereco atualizarEndereco(Endereco endereco) 
	{
		return this.enderecoRepository.save(endereco);
	}
	
	public List<Endereco> listarEnderecos()
	{
		return this.enderecoRepository.findAll();
	}
	
	public Endereco detalharEndereco(Long id)
	{
		Endereco endereco = this.enderecoRepository.findById(id).orElse(null);
		
		Assert.notNull(endereco, "O Id "+ id +" não foi encontrado.");
		
		return endereco;
	}
	
	public void removerEndereco(long id) {
		this.enderecoRepository.deleteById(id);
	}
}
