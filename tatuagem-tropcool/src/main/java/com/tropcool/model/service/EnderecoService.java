package com.tropcool.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tropcool.model.entity.Endereco;
import com.tropcool.model.repository.EnderecoRepository;

@Service
@Transactional
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco cadastrarEndereco(Endereco endereco) {
		return this.enderecoRepository.save(endereco);
	}
	
	public Endereco detalharEndereco(Long id) {
		Endereco endereco = this.enderecoRepository.findById(id).orElse(null);
		Assert.notNull(endereco, "Endereço informado não foi encontrado...");
		return endereco;
	}
	
	public Endereco atualizarEndereco(Endereco endereco) {
		return this.enderecoRepository.save(endereco);
	}
	
	public List<Endereco> listarEndereco() {
		return this.enderecoRepository.findAll();
	}
	
	public void removerEndereco(Long id) {
		this.enderecoRepository.deleteById(id);
	}
	
}
