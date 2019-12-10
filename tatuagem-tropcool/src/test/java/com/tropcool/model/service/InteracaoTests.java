package com.tropcool.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.Cliente;
import com.tropcool.model.entity.Interacao;
import com.tropcool.model.entity.Mensagem;
import com.tropcool.model.entity.Tatuador;
import com.tropcool.model.repository.ClienteRepository;
import com.tropcool.model.repository.InteracaoRepository;
import com.tropcool.model.repository.MensagemRepository;
import com.tropcool.model.repository.TatuadorRepository;

public class InteracaoTests extends AbstractIntegrationTests {

	@Autowired
	private TatuadorRepository tatuadorRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private InteracaoRepository interacaoRepository;

	@Autowired
	private InteracaoService interacaoService;

	@Autowired
	private MensagemRepository mensagemRepository;

	/**
	 * ====================================== CADASTRAR ===========================================
	 */

	/* CADASTRAR INTERACAO - MUSTPASS */

	@Test
	@Sql({ "/dataset/truncate.sql", "/dataset/usuarios.sql", "/dataset/clientes.sql", "/dataset/tatuadores.sql",
			"/dataset/mensagens.sql" })
	public void cadastrarIntereacaoMustPass() {

		Cliente cliente = clienteRepository.findById(1001L).orElse(null);
		Tatuador tatuador = tatuadorRepository.findById(1002L).orElse(null);
		Mensagem mensagem = mensagemRepository.findById(1001L).orElse(null);

		Assert.assertNotNull(cliente);
		Assert.assertNotNull(tatuador);
		Assert.assertNotNull(mensagem);

		Interacao interacao = new Interacao();
		interacao.setId(2L);
		interacao.setConteudo("Boa tarde, o que deseja?");
		interacao.setData(LocalDateTime.now());
		interacao.setDestinatario(cliente);
		interacao.setLido(false);
		interacao.setMensagem(mensagem);
		interacao.setRemetente(tatuador);

		interacaoService.escreverInteracao(interacao);

	}

	/**
	 * ====================================== LISTAR ===========================================
	 */

	/* LISTAR INTERACAO - MUSTPASS */

	@Test
	@Sql({ "/dataset/truncate.sql", "/dataset/usuarios.sql", "/dataset/clientes.sql", "/dataset/tatuadores.sql",
			"/dataset/mensagens.sql", "/dataset/interacoes.sql"

	})
	public void listarInteracaoMustPass() {

		List<Interacao> list = interacaoService.listarInteracoes();
		System.out.println(list.size());
		Assert.assertTrue(list.size() > 1);
	}

	/**
	 * ====================================== Remover
	 * ===========================================
	 */

	/* REMOVER INTERACAO - POR ID - MUSTPASS */

	@Test
	@Sql({ "/dataset/truncate.sql", "/dataset/usuarios.sql", "/dataset/clientes.sql", "/dataset/tatuadores.sql",
			"/dataset/mensagens.sql", "/dataset/interacoes.sql" })
	public void removerInteracaoPorIdMustPass() {
		interacaoService.removerInteracao(1001L);
		Interacao i = interacaoService.detalharInteracao(1001L);
		Assert.assertNull(i);

	}

	
	/**
	 * ====================================== RECUPERAR ===========================================
	 */

	/* RECUPERAR INTERACAO - MUSTPASS */

	@Test
	@Sql({ 
		"/dataset/truncate.sql", 
		"/dataset/usuarios.sql", 
		"/dataset/clientes.sql", 
		"/dataset/tatuadores.sql",
		"/dataset/mensagens.sql", 
		"/dataset/interacoes.sql"
	})
	public void recuperarInteracaoMustPass() {
		Interacao i = interacaoService.detalharInteracao(1001L);
		Assert.assertNotNull(i);
	}
	
	/**
	 * ====================================== ATUALIZAR ===========================================
	 */

	/* EDITAR INTERACAO - MUSTPASS */

	@Test
	@Sql({ 
		"/dataset/truncate.sql", 
		"/dataset/usuarios.sql", 
		"/dataset/clientes.sql", 
		"/dataset/tatuadores.sql",
		"/dataset/mensagens.sql", 
		"/dataset/interacoes.sql"
	})
	public void editarInteracaoMustPass() {
		Interacao i = interacaoRepository.findById(1001L).orElse(null);
		Assert.assertNotNull(i);
		i.setLido(true);
		i.setData(LocalDateTime.now());
		i.setConteudo("boa tarde, tudo bem?");
		
		interacaoService.atualizarInteracao(i);
		
		i = interacaoRepository.findById(1001L).orElse(null);
		Assert.assertNotNull(i);
		Assert.assertTrue(i.getLido() == true);
		
	}
}
