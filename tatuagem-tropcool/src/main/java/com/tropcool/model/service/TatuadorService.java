package com.tropcool.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tropcool.model.entity.Tatuador;
import com.tropcool.model.repository.TatuadorRepository;

@Service
@Transactional
public class TatuadorService {
	
	@Autowired
	private TatuadorRepository TatuadorRepository;
	
	public Tatuador cadastrarTatuador(Tatuador Tatuador) {
		return this.TatuadorRepository.save(Tatuador);
	}
	
	public Tatuador detalharTatuador(Long id) {
		Tatuador Tatuador = this.TatuadorRepository.findById(id).orElse(null);
		Assert.notNull(Tatuador,"Tatuador de id "+ id + "não encontrado.");
		return Tatuador;
	}
	
	public List<Tatuador> listarTatuadors(){
		return this.TatuadorRepository.findAll();
	}
	
	public Tatuador atualizarTatuador(Tatuador Tatuador) {
		return this.TatuadorRepository.save(Tatuador);
	}
	
	public void removerTatuador(Long id) {
		this.TatuadorRepository.deleteById(id);
	}
}
