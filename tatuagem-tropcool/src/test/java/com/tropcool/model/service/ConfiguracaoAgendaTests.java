 package com.tropcool.model.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
	
	/* CLONAR CONFIGURAÇÂO_AGENDA - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql"
									})
	public void clonarConfiguracaoAgendaMustPass() {	
		Tatuador tatuador = tatuadorRepository.findById(1002L).orElse(null);
		ConfiguracaoAgenda conf = configuracaoRepository.findById(1001L).orElse(null);
		Assert.assertNotNull(tatuador);
		Assert.assertNotNull(conf);
		
		ConfiguracaoAgenda confClone = conf;
		confClone.setTatuador(tatuador);
		
		configuracaoRepository.save(confClone);
	}
	
	/* CADASTRAR CONFIGURAÇÂO_AGENDA - SEMANA COMPLETA - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql"
									})
	public void cadastrarConfiguracaoAgendaSemanaCompletaMustPass() {	
		Tatuador tatuador = tatuadorRepository.findById(1001L).orElse(null);
		
		/*	SEGUNDA  */
		
		ConfiguracaoAgenda confs1 = new ConfiguracaoAgenda();
		confs1.setDia(DiaSemanaEnum.SEGUNDA);
		confs1.setHoraInicio(LocalTime.of(8, 0));
		confs1.setHorarioAgendado(null);
		confs1.setHoraTermino(LocalTime.of(12, 0));
		confs1.setTatuador(tatuador);
		
		ConfiguracaoAgenda confs2 = new ConfiguracaoAgenda();
		confs1.setDia(DiaSemanaEnum.SEGUNDA);
		confs1.setHoraInicio(LocalTime.of(13, 0));
		confs1.setHorarioAgendado(null);
		confs1.setHoraTermino(LocalTime.of(17, 0));
		confs1.setTatuador(tatuador);
		
		/*	TERÇA	*/
		
		ConfiguracaoAgenda conft1 = new ConfiguracaoAgenda();
		conft1.setDia(DiaSemanaEnum.SEGUNDA);
		conft1.setHoraInicio(LocalTime.of(8, 0));
		conft1.setHorarioAgendado(null);
		conft1.setHoraTermino(LocalTime.of(12, 0));
		conft1.setTatuador(tatuador);
		
		ConfiguracaoAgenda conft2 = new ConfiguracaoAgenda();
		conft2.setDia(DiaSemanaEnum.SEGUNDA);
		conft2.setHoraInicio(LocalTime.of(13, 0));
		conft2.setHorarioAgendado(null);
		conft2.setHoraTermino(LocalTime.of(17, 0));
		conft2.setTatuador(tatuador);
		
		/*	QUARTA	*/
		
		ConfiguracaoAgenda confq1 = new ConfiguracaoAgenda();
		confq1.setDia(DiaSemanaEnum.SEGUNDA);
		confq1.setHoraInicio(LocalTime.of(8, 0));
		confq1.setHorarioAgendado(null);
		confq1.setHoraTermino(LocalTime.of(12, 0));
		confq1.setTatuador(tatuador);
		
		ConfiguracaoAgenda confq2 = new ConfiguracaoAgenda();
		confq2.setDia(DiaSemanaEnum.SEGUNDA);
		confq2.setHoraInicio(LocalTime.of(13, 0));
		confq2.setHorarioAgendado(null);
		confq2.setHoraTermino(LocalTime.of(17, 0));
		confq2.setTatuador(tatuador);
		
		/*	QUINTA  */

		ConfiguracaoAgenda confqi1 = new ConfiguracaoAgenda();
		confqi1.setDia(DiaSemanaEnum.SEGUNDA);
		confqi1.setHoraInicio(LocalTime.of(8, 0));
		confqi1.setHorarioAgendado(null);
		confqi1.setHoraTermino(LocalTime.of(12, 0));
		confqi1.setTatuador(tatuador);
		
		ConfiguracaoAgenda confqi2 = new ConfiguracaoAgenda();
		confqi2.setDia(DiaSemanaEnum.SEGUNDA);
		confqi2.setHoraInicio(LocalTime.of(13, 0));
		confqi2.setHorarioAgendado(null);
		confqi2.setHoraTermino(LocalTime.of(17, 0));
		confqi2.setTatuador(tatuador);
		
		/*	SEXTA  */

		ConfiguracaoAgenda confsx1 = new ConfiguracaoAgenda();
		confsx1.setDia(DiaSemanaEnum.SEGUNDA);
		confsx1.setHoraInicio(LocalTime.of(8, 0));
		confsx1.setHorarioAgendado(null);
		confsx1.setHoraTermino(LocalTime.of(12, 0));
		confsx1.setTatuador(tatuador);
		
		ConfiguracaoAgenda confsx2 = new ConfiguracaoAgenda();
		confsx2.setDia(DiaSemanaEnum.SEGUNDA);
		confsx2.setHoraInicio(LocalTime.of(13, 0));
		confsx2.setHorarioAgendado(null);
		confsx2.setHoraTermino(LocalTime.of(17, 0));
		confsx2.setTatuador(tatuador);
		
		/*  SÁBADO  */
		
		ConfiguracaoAgenda confsa1 = new ConfiguracaoAgenda();
		confsa1.setDia(DiaSemanaEnum.SEGUNDA);
		confsa1.setHoraInicio(LocalTime.of(8, 0));
		confsa1.setHorarioAgendado(null);
		confsa1.setHoraTermino(LocalTime.of(12, 0));
		confsa1.setTatuador(tatuador);
		
		configuracaoService.cadastrarConfiguracaoAgenda(confs1);
		configuracaoService.cadastrarConfiguracaoAgenda(confs2);
		configuracaoService.cadastrarConfiguracaoAgenda(conft1);
		configuracaoService.cadastrarConfiguracaoAgenda(conft2);
		configuracaoService.cadastrarConfiguracaoAgenda(confq1);
		configuracaoService.cadastrarConfiguracaoAgenda(confq2);
		configuracaoService.cadastrarConfiguracaoAgenda(confqi1);
		configuracaoService.cadastrarConfiguracaoAgenda(confqi2);
		configuracaoService.cadastrarConfiguracaoAgenda(confsx1);
		configuracaoService.cadastrarConfiguracaoAgenda(confsx2);
		configuracaoService.cadastrarConfiguracaoAgenda(confsa1);
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
	public void atualizarConfiguracaoAgendaAtualizarDiaMustPass() {	
		ConfiguracaoAgenda conf = configuracaoRepository.findById(1001L).orElse(null);
		Assert.assertNotNull(conf);	
		conf.setDia(DiaSemanaEnum.TERCA);
		configuracaoRepository.save(conf);
	}
	
	/* ATUALIZAR CONFIGURAÇÂO_AGENDA - ATUALIZAR TATUADOR - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql"
									})
	public void atualizarConfiguracaoAgendaAtualizarTatuadorMustPass() {	
		ConfiguracaoAgenda conf = configuracaoRepository.findById(1001L).orElse(null);
		Tatuador t = tatuadorRepository.findById(1001L).orElse(null);
		
		Assert.assertNotNull(conf);
		Assert.assertNotNull(t);
		
		conf.setTatuador(t);
		configuracaoRepository.save(conf);
	}
	
	/**
	 * ====================================== REMOVER ===========================================
	 */
	
	/* REMOVER CONFIGURAÇÂO_AGENDA - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql"
									})
	public void removerConfiguracaoAgendaMustPass() {	
		configuracaoRepository.deleteById(1001L);
		ConfiguracaoAgenda conf = configuracaoRepository.findById(1001L).orElse(null);
		Assert.assertNull(conf);
	}
	
	/**
	 * ====================================== LISTAR ===========================================
	 */
	
	/* REMOVER CONFIGURAÇÂO_AGENDA - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql"
									})
	public void listarConfiguracaoAgendaMustPass() {	
		List<ConfiguracaoAgenda> configuracoes = new ArrayList<ConfiguracaoAgenda>();
		configuracoes = configuracaoRepository.findAll();
		Assert.assertNotNull(configuracoes);
	}
}
