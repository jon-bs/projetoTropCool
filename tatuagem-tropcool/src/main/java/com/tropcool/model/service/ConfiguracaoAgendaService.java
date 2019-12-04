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
	
	/**
	 * @param configuracao
	 * @return
	 */
	public ConfiguracaoAgenda cadastrarConfiguracaoAgenda(ConfiguracaoAgenda configuracaoAgenda) {
		return this.configuracaoAgendaRepository.save(configuracaoAgenda);
	}
	
	/**
	 * @param configuracao
	 * @return
	 */
	public ConfiguracaoAgenda atualizarConfiguracaoAgenda(ConfiguracaoAgenda configuracaoAgenda) {
		return this.configuracaoAgendaRepository.save(configuracaoAgenda);
	}
	
	/**
	 * @param id
	 * @return
	 */
	public ConfiguracaoAgenda detalharConfiguracaoAgenda(Long id) {
		 ConfiguracaoAgenda configuracaoAgenda = this.configuracaoAgendaRepository.findById(id).orElse(null);
		 Assert.notNull(configuracaoAgenda,"Essa configuração de agenda não foi encontrada, busca realizada pelo id : " + id);
		 return configuracaoAgenda;
	}
	
	/**
	 * @return
	 */
	public List<ConfiguracaoAgenda> listaConfiguracaoAgenda(){
		return this.configuracaoAgendaRepository.findAll();
	}
	
	/**
	 * @param id
	 */
	public void removerConfiguracaoAgenda(Long id) {
		this.configuracaoAgendaRepository.deleteById(id);
	}
}
