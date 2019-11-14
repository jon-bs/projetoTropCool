package com.tropcool.model.service;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tropcool.model.entity.Endereco;
import com.tropcool.model.repository.EnderecoRepository;


public class EnderecoTests extends AbstractIntegrationTests {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EnderecoService enderecoService;
	
	
	@Test
	public void cadastroEnderecoMustPass()
	{
		Endereco endereco = new Endereco();
		endereco.setCidade("Bel-Air");
		endereco.setEstado("Orio");
		endereco.setRua("Garibald");
		endereco.setNumero("1234654");
		endereco.setCep("4658954");
		
		this.enderecoService.cadastrarEndereco(endereco);
		
		Assert.assertNotNull(endereco.getId());
		System.out.println(endereco.getId());
	}
	
	@Test(expected = ValidationException.class)
	public void cadastrarEnderecoMustFailCidadeEmBranco() {
		
		Endereco endereco = new Endereco();
		endereco.setCidade("");
		endereco.setEstado("Orio");
		endereco.setRua("Garibald");
		endereco.setNumero("1234654");
		endereco.setCep("4658954");

		this.enderecoService.cadastrarEndereco(endereco);
	}
	
	@Test(expected = ValidationException.class)
	public void cadastrarEnderecoMustFailEstadoEmBranco() {
		
		Endereco endereco = new Endereco();
		endereco.setCidade("Bel-Air");
		endereco.setEstado("");
		endereco.setRua("Garibald");
		endereco.setNumero("1234654");
		endereco.setCep("4658954");

		this.enderecoService.cadastrarEndereco(endereco);
	}
	
	@Test(expected = ValidationException.class)
	public void cadastrarEnderecoMustFailRuaEmBranco() {
		
		Endereco endereco = new Endereco();
		endereco.setCidade("Bel-Air");
		endereco.setEstado("Orio");
		endereco.setRua("");
		endereco.setNumero("1234654");
		endereco.setCep("4658954");

		this.enderecoService.cadastrarEndereco(endereco);
	}
	
	@Test(expected = ValidationException.class)
	public void cadastrarEnderecoMustFailNumeroEmBranco() {
		
		Endereco endereco = new Endereco();
		endereco.setCidade("Bel-Air");
		endereco.setEstado("Orio");
		endereco.setRua("Garibald");
		endereco.setNumero("");
		endereco.setCep("4658954");

		this.enderecoService.cadastrarEndereco(endereco);
	}
	
	@Test(expected = ValidationException.class)
	public void cadastrarEnderecoMustFailCepEmBranco() {
		
		Endereco endereco = new Endereco();
		endereco.setCidade("Bel-Air");
		endereco.setEstado("Orio");
		endereco.setRua("Garibald");
		endereco.setNumero("1234654");
		endereco.setCep("");

		this.enderecoService.cadastrarEndereco(endereco);
	}
}
