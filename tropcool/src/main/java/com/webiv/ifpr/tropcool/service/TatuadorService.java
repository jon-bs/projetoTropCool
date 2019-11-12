package com.webiv.ifpr.tropcool.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.webiv.ifpr.tropcool.model.entity.Tatuador;
import com.webiv.ifpr.tropcool.repository.TatuadorRepository;

@Service
@Transactional
public class TatuadorService {

	@Autowired
	private TatuadorRepository tatuadorRepository;
	
	public Tatuador cadastrarTatuador(Tatuador tatuador) 
	{
		return this.tatuadorRepository.save(tatuador);
	}
	
	public Tatuador atualizarTatuador(Tatuador tatuador) 
	{
		return this.tatuadorRepository.save(tatuador);
	}
	
	public List<Tatuador> listartatuadors()
	{
		return this.tatuadorRepository.findAll();
	}
	
	public Tatuador detalharTatuador(Long id)
	{
		Tatuador tatuador = this.tatuadorRepository.findById(id).orElse(null);
		
		Assert.notNull(tatuador, "O Id "+ id +" não foi encontrado.");
		
		return tatuador;
	}
	
	public void removerTatuador(long id) {
		this.tatuadorRepository.deleteById(id);
	}
}
