package com.tropcool.model.service;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.Cliente;
import com.tropcool.model.entity.Interacao;
import com.tropcool.model.entity.Mensagem;
import com.tropcool.model.entity.Tatuador;
import com.tropcool.model.repository.ClienteRepository;
import com.tropcool.model.repository.InteracaoRepository;
import com.tropcool.model.repository.MensagemRepository;
import com.tropcool.model.repository.TatuadorRepository;


public class MensagemTests extends AbstractIntegrationTests {
	
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private MensagemService mensagemService;
	
	@Autowired
	private TatuadorRepository tatuadorRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private InteracaoRepository interacaoRepository;
	
	@Autowired
	private InteracaoService interacaoService;
	
	/**
	 * ====================================== CADASTRAR ===========================================
	 */
	
	/* CADASTRAR MENSGEM - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql"
	})
	public void cadastrarMensagemMustPass() {
		Cliente cliente = clienteRepository.findById(1001L).orElse(null);
		Tatuador tatuador = tatuadorRepository.findById(1001L).orElse(null);
		
		Mensagem mensagem = new Mensagem();
		mensagem.setConteudo("Bom dia, esta mensagem contém conteúdo irrelevante para sua leitura já que essa não passa de um mísero teste.");
		mensagem.setData(LocalDateTime.now());
		mensagem.setDestinatario(tatuador);
		mensagem.setInteracao(null);
		mensagem.setLido(false);
		mensagem.setRemetente(cliente);
		mensagem.setId(1001L);
		
		mensagemService.escreverMensagem(mensagem);
		Assert.assertNotNull(mensagem.getId());
	}
	
// CADASTRAR MENSGEM - INTERACAO - MUSTPASS
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql"
	})
	public void cadastrarMensagemInteracaoMustPass() {
		Cliente cliente = clienteRepository.findById(1001L).orElse(null);
		Tatuador tatuador = tatuadorRepository.findById(1002L).orElse(null);
		
		Assert.assertNotNull(tatuador.getId());
		Assert.assertNotNull(cliente);
		System.out.println("tatuador_id: " + tatuador.getId());
		System.out.println("cliente_id: " + cliente.getId());
		
		Mensagem mensagem = new Mensagem();
		mensagem.setConteudo("Bom dia, tudo em ordem?");
		mensagem.setData(LocalDateTime.now());
		mensagem.setDestinatario(tatuador);
		mensagem.setInteracao(null);
		mensagem.setLido(false);
		mensagem.setRemetente(cliente);
		mensagem.setId(1L);
		
		mensagemService.escreverMensagem(mensagem);
		Assert.assertNotNull(mensagem.getId());
		System.out.println("mensagem_id: " + mensagem.getId());
		
		mensagem.setLido(true);
		
		mensagemService.atualizarMensagem(mensagem);
		Assert.assertTrue(mensagem.getLido() == true);
		
		Interacao interacao = new Interacao();
		interacao.setConteudo("Bom dia, tudo dentro das circunstâncias previstas..."); 
		interacao.setData(LocalDateTime.now());
		interacao.setDestinatario(cliente); 
		interacao.setMensagem(mensagem); 
		interacao.setLido(false);
		interacao.setRemetente(tatuador);
		 						
		interacaoService.escreverInteracao(interacao);
		Assert.assertNotNull(interacao.getId());
		System.out.println("interacao_id: " + interacao.getId());
	}

	/**
	 * ====================================== DETALHAR ===========================================
	 */
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/mensagens.sql"
	})
	public void detalharrMensagemMustPass() {
		Mensagem mensagem = mensagemService.detalharMensagem(1001L);
		Assert.assertNotNull(mensagem);
		Assert.assertTrue(1001L == mensagem.getId());
	}
	/**
	 * ====================================== LISTAR ===========================================
	 */
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/mensagens.sql"
	})
	public void listarMensagemMustPass() {
		List<Mensagem> lista= this.mensagemService.listarMensagens();
		System.out.println(lista.size());
		Assert.assertTrue(lista.size() == 2);
	}
	
	/**
	 * ====================================== ATUALIZAR ===========================================
	 */
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/mensagens.sql"
	})
	public void atualizarMensagemMustPass() {
		Mensagem mensagem = this.mensagemService.detalharMensagem(1001L);
		Assert.assertNotNull(mensagem);
		mensagem.setConteudo("Olá, tudo bem contigo?");
		mensagem.setLido(true);
		mensagemService.atualizarMensagem(mensagem);
	}
	/**
	 * ====================================== REMOVER ===========================================
	 */
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/mensagens.sql"
	})
	public void removerMensagemMustPass() {
		Mensagem mensagem = this.mensagemService.detalharMensagem(1001L);
		Assert.assertNotNull(mensagem); // Garante que a mensagem existe antes da exclusão
		mensagemService.removerMensagem(1001L);
		mensagem = this.mensagemRepository.findById(1001L).orElse(null); // tenta recuperar a mensagem para garantir que tenha sido de fato removida
		Assert.assertNull(mensagem);
		
	}
}
