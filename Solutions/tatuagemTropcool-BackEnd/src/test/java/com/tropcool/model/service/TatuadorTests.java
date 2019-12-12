package com.tropcool.model.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.Endereco;
import com.tropcool.model.entity.RoleEnum;
import com.tropcool.model.entity.Tatuador;
import com.tropcool.model.repository.EnderecoRepository;
import com.tropcool.model.repository.TatuadorRepository;
import com.tropcool.model.repository.UsuarioRepository;
import com.tropcool.model.service.AbstractIntegrationTests;

public class TatuadorTests extends AbstractIntegrationTests {

	@Autowired
	private TatuadorRepository tatuadorRepository;
	
	@Autowired
	private TatuadorService tatuadorService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	/**
	 * ====================================== CADASTRAR ===========================================
	 */
	
	/** CADASTRAR TATUADOR **/
	
	@Test
	@Sql({ 
			"/dataset/truncate.sql",
			"/dataset/usuarios.sql",
			"/dataset/enderecos.sql"
									})
	public void cadastrarTatuadorMustPass() {
		Tatuador tatuador = new Tatuador();
		tatuador.setLogin("tatooadm");
		tatuador.setSenha("12345");
		tatuador.setNome("Gabriel Andrade");
		tatuador.setCpf("11111111113");
		tatuador.setEmail("gabrieladm@hotmail.com");
		tatuador.setAtivo(true);
		tatuador.setPerfil(RoleEnum.USER);
		tatuador.setTelefone1("14523658745");
		tatuador.setTelefone2("14523658746");
		tatuador.setAlvara("1111111111");
		
		Endereco endereco = enderecoRepository.findById(1001L).orElse(null);
		Assert.assertNotNull(endereco);
		tatuador.setEndereco(endereco);
		
		this.tatuadorService.cadastrarTatuador(tatuador);
		Assert.assertNotNull(tatuador.getId());
		//System.out.println(tatuador.getId());
	}
	
	/** CADASTRAR TATUADOR - ALVARA DUPLICADO - MUST FAIL **/
	
	@Test(expected = ValidationException.class)
	@Sql({ 
		"/dataset/truncate.sql",
			"/dataset/usuarios.sql"
									})
	public void cadastrarTatuadorMustFailAlavaraDuplicado() {
		Tatuador tatuador = new Tatuador();
		tatuador.setLogin("tatooadm");
		tatuador.setSenha("12345");
		tatuador.setNome("Gabriel Andrade");
		tatuador.setCpf("11111111113");
		tatuador.setEmail("gabrieladm@hotmail.com");
		tatuador.setAtivo(true);
		tatuador.setPerfil(RoleEnum.USER);
		tatuador.setTelefone1("14523658745");
		tatuador.setTelefone2("14523658746");
		tatuador.setAlvara("1111111111");
		
		this.tatuadorService.cadastrarTatuador(tatuador);
		Assert.assertNotNull(tatuador.getId());
		//System.out.println(tatuador.getId());
	}
	
	/** CADASTRAR TATUADOR ENDEREÇO - MUST PASS **/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
			"/dataset/usuarios.sql"
									})
	public void cadastrarTatuadorMustPasslEndereco() {
		
		Tatuador tatuador = new Tatuador();
		Endereco end = new Endereco();
		tatuador.setLogin("tatooadm");
		tatuador.setSenha("12345");
		tatuador.setNome("Gabriel Andrade");
		tatuador.setCpf("11111111113");
		tatuador.setEmail("gabrieladm@hotmail.com");
		tatuador.setAtivo(true);
		tatuador.setPerfil(RoleEnum.USER);
		tatuador.setTelefone1("14523658745");
		tatuador.setTelefone2("14523658746");
		tatuador.setAlvara("1111111111");
		end.setCep("452632145");
		end.setCidade("Belfaest");
		end.setRua("dos bobos");
		end.setEstado("Molondo");
		end.setNumero("9586");
		
		this.enderecoService.cadastrarEndereco(end);
		
		tatuador.setEndereco(end);
		
		
		this.tatuadorService.cadastrarTatuador(tatuador);
		Assert.assertNotNull(tatuador.getId());
		//System.out.println(tatuador.getId());
	}
	
	/**
	 * ====================================== ATUALIZAR ===========================================
	 */
	
	/** ATUALIZAR TATUADOR - MUST PASS **/
	
	@Test
	@Sql({ 
			"/dataset/truncate.sql",  
			"/dataset/usuarios.sql", 
			"/dataset/tatuadores.sql" 
		})
	public void atualizarTatuadorMustPass() {
		Tatuador tatuador = this.tatuadorRepository.findById(1001L).orElse(null);
		Endereco end = new Endereco();
		end.setCep("452632145");
		end.setCidade("Belfaest");
		end.setRua("dos bobos");
		end.setEstado("Molondo");
		end.setNumero("9586");
		
		this.enderecoService.cadastrarEndereco(end);
		tatuador.setEndereco(end);
		
		tatuador.setLogin("tatoooMaster");
		tatuador.setAlvara("1231231234");

		tatuadorService.atualizarTatuador(tatuador);

		Assert.assertTrue(tatuador.getAlvara() == "1231231234");

	}
	/**
	 * ====================================== DETALHAR ===========================================
	 */
	
	
	/** DETALHAR TATUADOR - MUST PASS **/
	
	@Test
	@Sql({ 
			"/dataset/truncate.sql",  
			"/dataset/usuarios.sql", 
			"/dataset/tatuadores.sql" 
		})
	public void detalharTatuadorMustPass() {
		Tatuador tatuador = this.tatuadorService.detalharTatuador(1001L);
		Assert.assertNotNull(tatuador);
		Assert.assertNotNull(tatuador.getId());
	
	}
	
	/**
	 * ====================================== LISTAR ===========================================
	 */
	
	/** LISTAR TATUADORES - MUST PASS **/
	
	@Test
	@Sql({ 
			"/dataset/truncate.sql",  
			"/dataset/usuarios.sql", 
			"/dataset/tatuadores.sql" 
		})
	public void listarTatuadorMustPass() {
		List<Tatuador> tatuadores = tatuadorService.listarTatuadors();
		Assert.assertTrue(tatuadores.size() == 4);
	}
	
	/**
	 * ====================================== REMOVER ===========================================
	 */
	
	/** REMOVER TATUADORES - MUST PASS **/
	
	@Test
	@Sql({ 
			"/dataset/truncate.sql",  
			"/dataset/usuarios.sql", 
			"/dataset/tatuadores.sql" 
		})
	public void removerTatuadorMustPass() {
		Tatuador tatuador = tatuadorService.detalharTatuador(1001L);
		Assert.assertNotNull(tatuador);
		
		tatuadorService.removerTatuador(1001L);
		
		tatuador = tatuadorRepository.findById(1001L).orElse(null);
		Assert.assertNull(tatuador);
	}
}
