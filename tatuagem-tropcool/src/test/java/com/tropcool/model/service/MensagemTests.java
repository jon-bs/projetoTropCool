package com.tropcool.model.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tropcool.model.entity.Cliente;
import com.tropcool.model.entity.Mensagem;
import com.tropcool.model.entity.Tatuador;
import com.tropcool.model.repository.ClienteRepository;
import com.tropcool.model.repository.MensagemRepository;
import com.tropcool.model.repository.TatuadorRepository;

public class MensagemTests {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private MensagemService mensagemService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TatuadorRepository tatuadorRepository;
	
	@Autowired
	private TatuadorService tatuadorService;
	
	/**
	 * 
	 * 		VOCÊ TENTOU E FALHOU MIZERAVELMENTE !!
	 * 		SÓ DA ERRADO SE VC TENTAR :D
	 * 		O ESFORÇO DE HOJE É O FRACAÇO DE AMANHÃ ;)
	 * 
	 * 
	 */
	
	
//	@Test
//	public void cadastrarMensagem()
//	{
//		Mensagem mensagem = new Mensagem();
//		mensagem.setLido(false);
//		mensagem.setConteudo("A rua 15 é pros brabos");
//		Cliente cliente = this.clienteRepository.findById(1001L).orElse(null);
//		Tatuador tatuador = this.tatuadorRepository.findById(1001L).orElse(null);
//		mensagem.setRemetente(tatuador);
//		mensagem.setDestinatario(cliente);
//	}
}
