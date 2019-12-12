package com.tropcool.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tropcool.model.entity.Mensagem;
import com.tropcool.model.repository.MensagemRepository;

@Service
@Transactional
public class MensagemService {
	
	@Autowired
	private MensagemRepository MensagemRepository;
	
	public Mensagem escreverMensagem(Mensagem Mensagem) {
		return this.MensagemRepository.save(Mensagem);
	}
	
	public Mensagem detalharMensagem(Long id) {
		Mensagem mensagem = this.MensagemRepository.findById(id).orElse(null);
		Assert.notNull(mensagem,"Mensagem de id "+ id + "não encontrado.");
		return mensagem;
	}
	
	public List<Mensagem> listarMensagens(){
		return this.MensagemRepository.findAll();
	}
	
	public Mensagem atualizarMensagem(Mensagem Mensagem) {
		return this.MensagemRepository.save(Mensagem);
	}
	
	public void removerMensagem(Long id) {
		this.MensagemRepository.deleteById(id);
	}
}
