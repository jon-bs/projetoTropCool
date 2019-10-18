package com.tropcool.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tropcool.model.entity.ConfiguracaoAgenda;
import com.tropcool.model.repository.ConfiguracaoAgendaRepository;

@Service
@Transactional
public class ConfiguracaoAgendaService {
	
	@Autowired
	private ConfiguracaoAgendaRepository configuracaoAgendaRepository;
	
	public ConfiguracaoAgenda cadastrarConfiguracaoAgenda(ConfiguracaoAgenda configuracaoAgenda) {
		return this.configuracaoAgendaRepository.save(configuracaoAgenda);
	}
	
	public ConfiguracaoAgenda detalharConfiguracaoAgenda(Long id) {
		 ConfiguracaoAgenda configuracaoAgenda = this.configuracaoAgendaRepository.findById(id).orElse(null);
		 Assert.notNull(configuracaoAgenda,"Essa configuração de agenda não foi encontrada, busca realizada pelo id : " + id);
		 return configuracaoAgenda;
	}
	
	public List<ConfiguracaoAgenda> listaConfiguracaoAgenda(){
		return this.configuracaoAgendaRepository.findAll();
	}
	
	public void removeConfiguracaoAgenda(Long id) {
		this.configuracaoAgendaRepository.deleteById(id);
	}
}
