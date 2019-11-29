 package com.tropcool.model.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.ConfiguracaoAgenda;
import com.tropcool.model.entity.DiaSemanaEnum;
import com.tropcool.model.entity.Tatuador;
import com.tropcool.model.repository.ConfiguracaoAgendaRepository;
import com.tropcool.model.repository.HorarioAgendadoRepository;
import com.tropcool.model.repository.TatuadorRepository;


public class ConfiguracaoAgendaTests extends AbstractIntegrationTests {
	
	@Autowired
	private ConfiguracaoAgendaRepository configuracaoRepository;
	
	@Autowired
	private ConfiguracaoAgendaService configuracaoService;
	
	@Autowired
	private HorarioAgendadoRepository horarioRepository;
	
	@Autowired
	private HorarioAgendadoService horarioService;
	
	@Autowired
	private TatuadorRepository tatuadorRepository;
	
	@Autowired
	private TatuadorService tatuadorService;
	
	/**
	 * ====================================== CADASTRAR ===========================================
	 */
	
	/* CADASTRAR CONFIGURAÇÂO_AGENDA - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql"
									})
	public void cadastrarConfiguracaoAgendaMustPass() {	
		Tatuador tatuador = tatuadorRepository.findById(1001L).orElse(null);
		ConfiguracaoAgenda conf = new ConfiguracaoAgenda();
		conf.setDia(DiaSemanaEnum.SEGUNDA);
		conf.setHoraInicio(LocalTime.of(8, 0));
		conf.setHorarioAgendado(null);
		conf.setHoraTermino(LocalTime.of(18, 0));
		conf.setTatuador(tatuador);
		
		configuracaoService.cadastrarConfiguracaoAgenda(conf);
	}
	
	/**
	 * ====================================== DETALAHR ===========================================
	 */
	
	/* DETALAHR CONFIGURAÇÂO_AGENDA - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql"
									})
	public void detalharConfiguracaoAgendaMustPass() {	
		ConfiguracaoAgenda conf = configuracaoRepository.findById(1001L).orElse(null);
		Assert.assertNotNull(conf);
		Assert.assertTrue(conf.getId() == 1001L);
	}
	
	/**
	 * ====================================== ATUALIZAR ===========================================
	 */
	
	/* ATUALIZAR CONFIGURAÇÂO_AGENDA - ATUALIZAR DIA - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql"
									})
	public void atualizarConfiguracaoAgendaMustPass() {	
		ConfiguracaoAgenda conf = configuracaoRepository.findById(1001L).orElse(null);
		Assert.assertNotNull(conf);
		Assert.assertTrue(conf.getId() == 1001L);
		
		conf.setDia(DiaSemanaEnum.TERCA);
		
	}
}
