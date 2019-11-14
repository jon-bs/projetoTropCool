package com.tropcool.model.service;

import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.Cliente;
import com.tropcool.model.entity.Endereco;
import com.tropcool.model.repository.EnderecoRepository;

public class EnderecoTests extends AbstractIntegrationTests {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EnderecoService enderecoService;
	
	/**
	 * ====================================== CADASTRAR ===========================================
	 */

	@Test
	@Sql({ "/dataset/truncate.sql", })
	public void cadastroEnderecoMustPass() {
		Endereco endereco = new Endereco();
		endereco.setCidade("Bel-Air");
		endereco.setEstado("Orio");
		endereco.setRua("Garibald");
		endereco.setNumero("1234654");
		endereco.setCep("4658954");

		this.enderecoService.cadastrarEndereco(endereco);

		Assert.assertNotNull(endereco.getId());
	}

	@Test(expected = ValidationException.class)
	@Sql({ "/dataset/truncate.sql", })
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
	@Sql({ "/dataset/truncate.sql", })
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
	@Sql({ "/dataset/truncate.sql", })
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
	@Sql({ "/dataset/truncate.sql", })
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
	@Sql({ "/dataset/truncate.sql", })
	public void cadastrarEnderecoMustFailCepEmBranco() {

		Endereco endereco = new Endereco();
		endereco.setCidade("Bel-Air");
		endereco.setEstado("Orio");
		endereco.setRua("Garibald");
		endereco.setNumero("1234654");
		endereco.setCep("");

		this.enderecoService.cadastrarEndereco(endereco);
	}
	
	/**
	 * ====================================== LISTAR ===========================================
	 */
	
	@Test
	@Sql({
		"/dataset/truncate.sql",
		"/dataset/enderecos.sql",
	})
	public void listarEnederecoesMustPass()
	{
		List<Endereco> endereco = this.enderecoService.listarEndereco();
		Assert.assertEquals(3, endereco.size());
		
	}
	
	/**
	 * ====================================== Atualizar ===========================================
	 */
	@Test
	@Sql({
		"/dataset/truncate.sql",
		"/dataset/enderecos.sql",
	})
	public void atualizarEnederecoMustPass()
	{
		Endereco endereco = this.enderecoRepository.findById(1002L).orElse(null);
		endereco.setRua("Carrinha que mora logo ali");
		
	}
	
//	@Test(expected = ValidationException.class)
//	@Sql({
//		"/dataset/truncate.sql",
//		"/dataset/enderecos.sql",
//	})
//	public void atualizarEnederecoMustFail()
//	{
//		Endereco endereco = this.enderecoRepository.findById(1002L).orElse(null);
//		endereco.setRua("");
//	}
	
}
