package com.tropcool.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tropcool.model.entity.Interacao;
import com.tropcool.model.repository.InteracaoRepository;

@Service
@Transactional
public class InteracaoService {
	
	@Autowired
	private InteracaoRepository InteracaoRepository;
	
	public Interacao escreverInteracao(Interacao Interacao) {
		return this.InteracaoRepository.save(Interacao);
	}
	
	public Interacao detalharInteracao(Long id) {
		Interacao Interacao = this.InteracaoRepository.findById(id).orElse(null);
		Assert.notNull(Interacao,"Interacao de id "+ id + "não encontrado.");
		return Interacao;
	}
	
	public List<Interacao> listarInteracoes(){
		return this.InteracaoRepository.findAll();
	}
	
	public Interacao atualizarInteracao(Interacao Interacao) {
		return this.InteracaoRepository.save(Interacao);
	}
	
	public void removerInteracao(Long id) {
		this.InteracaoRepository.deleteById(id);
	}
}
