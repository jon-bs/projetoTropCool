package com.tropcool.model.service;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.Cliente;
import com.tropcool.model.entity.Mensagem;
import com.tropcool.model.entity.Tatuador;
import com.tropcool.model.repository.ClienteRepository;
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

}
