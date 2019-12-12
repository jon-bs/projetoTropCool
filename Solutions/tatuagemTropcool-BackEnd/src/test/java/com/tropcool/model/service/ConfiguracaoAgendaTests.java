 package com.tropcool.model.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
		Assert.assertNotNull( conf.getId() );
	}
	
	/* CADASTRAR CONFIGURAÇÂO_AGENDA - SEMANA INTEIRA - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql"
									})
	public void cadastrarConfiguracaoAgendaSemanaInteiraMustPass() {	
		Tatuador tatuador = tatuadorRepository.findById(1002L).orElse(null);
		
		/* SEGUNDA  */
		
		ConfiguracaoAgenda confseg1 = new ConfiguracaoAgenda();
		confseg1.setDia(DiaSemanaEnum.SEGUNDA);
		confseg1.setHoraInicio(LocalTime.of(8, 0));
		confseg1.setHorarioAgendado(null);
		confseg1.setHoraTermino(LocalTime.of(12, 0));
		confseg1.setTatuador(tatuador);
		
		ConfiguracaoAgenda confseg2 = new ConfiguracaoAgenda();
		confseg2.setDia(DiaSemanaEnum.SEGUNDA);
		confseg2.setHoraInicio(LocalTime.of(8, 0));
		confseg2.setHorarioAgendado(null);
		confseg2.setHoraTermino(LocalTime.of(12, 0));
		confseg2.setTatuador(tatuador);
		
		/* TERÇA  */
		
		ConfiguracaoAgenda confter1 = new ConfiguracaoAgenda();
		confter1.setDia(DiaSemanaEnum.TERCA);
		confter1.setHoraInicio(LocalTime.of(8, 0));
		confter1.setHorarioAgendado(null);
		confter1.setHoraTermino(LocalTime.of(12, 0));
		confter1.setTatuador(tatuador);
		
		ConfiguracaoAgenda confter2 = new ConfiguracaoAgenda();
		confter2.setDia(DiaSemanaEnum.TERCA);
		confter2.setHoraInicio(LocalTime.of(8, 0));
		confter2.setHorarioAgendado(null);
		confter2.setHoraTermino(LocalTime.of(12, 0));
		confter2.setTatuador(tatuador);
		
		/* QUARTA  */
		
		ConfiguracaoAgenda confqua1 = new ConfiguracaoAgenda();
		confqua1.setDia(DiaSemanaEnum.QUARTA);
		confqua1.setHoraInicio(LocalTime.of(8, 0));
		confqua1.setHorarioAgendado(null);
		confqua1.setHoraTermino(LocalTime.of(12, 0));
		confqua1.setTatuador(tatuador);
		
		ConfiguracaoAgenda confqua2 = new ConfiguracaoAgenda();
		confqua2.setDia(DiaSemanaEnum.QUARTA);
		confqua2.setHoraInicio(LocalTime.of(8, 0));
		confqua2.setHorarioAgendado(null);
		confqua2.setHoraTermino(LocalTime.of(12, 0));
		confqua2.setTatuador(tatuador);
		
		/* QUINTA  */
		
		ConfiguracaoAgenda confqui1 = new ConfiguracaoAgenda();
		confqui1.setDia(DiaSemanaEnum.QUINTA);
		confqui1.setHoraInicio(LocalTime.of(8, 0));
		confqui1.setHorarioAgendado(null);
		confqui1.setHoraTermino(LocalTime.of(12, 0));
		confqui1.setTatuador(tatuador);
		
		ConfiguracaoAgenda confqui2 = new ConfiguracaoAgenda();
		confqui2.setDia(DiaSemanaEnum.QUINTA);
		confqui2.setHoraInicio(LocalTime.of(8, 0));
		confqui2.setHorarioAgendado(null);
		confqui2.setHoraTermino(LocalTime.of(12, 0));
		confqui2.setTatuador(tatuador);
		
		/* SEXTA  */
		
		ConfiguracaoAgenda confsex1 = new ConfiguracaoAgenda();
		confsex1.setDia(DiaSemanaEnum.SEXTA);
		confsex1.setHoraInicio(LocalTime.of(8, 0));
		confsex1.setHorarioAgendado(null);
		confsex1.setHoraTermino(LocalTime.of(12, 0));
		confsex1.setTatuador(tatuador);
		
		ConfiguracaoAgenda confsex2 = new ConfiguracaoAgenda();
		confsex2.setDia(DiaSemanaEnum.SEXTA);
		confsex2.setHoraInicio(LocalTime.of(8, 0));
		confsex2.setHorarioAgendado(null);
		confsex2.setHoraTermino(LocalTime.of(12, 0));
		confsex2.setTatuador(tatuador);
		
		/* SÁBADO  */
		
		ConfiguracaoAgenda confsab1 = new ConfiguracaoAgenda();
		confsab1.setDia(DiaSemanaEnum.SABADO);
		confsab1.setHoraInicio(LocalTime.of(8, 0));
		confsab1.setHorarioAgendado(null);
		confsab1.setHoraTermino(LocalTime.of(12, 0));
		confsab1.setTatuador(tatuador);
		
		configuracaoService.cadastrarConfiguracaoAgenda(confseg1);
		configuracaoService.cadastrarConfiguracaoAgenda(confseg2);
		
		configuracaoService.cadastrarConfiguracaoAgenda(confter1);
		configuracaoService.cadastrarConfiguracaoAgenda(confter2);
		
		configuracaoService.cadastrarConfiguracaoAgenda(confqua1);
		configuracaoService.cadastrarConfiguracaoAgenda(confqua2);
		
		configuracaoService.cadastrarConfiguracaoAgenda(confqui1);
		configuracaoService.cadastrarConfiguracaoAgenda(confqui2);
		
		configuracaoService.cadastrarConfiguracaoAgenda(confsex1);
		configuracaoService.cadastrarConfiguracaoAgenda(confsex2);
		
		configuracaoService.cadastrarConfiguracaoAgenda(confsab1);
	
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
	 * ====================================== LISTAR ===========================================
	 */
	
	/* LISTAR CONFIGURAÇÂO_AGENDA - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql"
									})
	public void listarConfiguracaoAgendaMustPass() {	
		List<ConfiguracaoAgenda> confs = configuracaoRepository.findAll();
		Assert.assertNotNull(confs);
	}
	
	/**
	 * ====================================== REMOVER ===========================================
	 */
	
	/* REMOVER CONFIGURAÇÂO_AGENDA - P/OBJETO - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql"
									})
	public void removerConfiguracaoAgendaPorObjetoMustPass() {	
		ConfiguracaoAgenda conf = configuracaoRepository.findById(1001L).orElse(null);
		Assert.assertNotNull(conf);
		configuracaoRepository.delete(conf);
		conf = configuracaoRepository.findById(1001L).orElse(null);
		Assert.assertNull(conf);
	}
	
	/* REMOVER CONFIGURAÇÂO_AGENDA - P/ID - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql"
									})
	public void removerConfiguracaoAgendaPorIdMustPass() {	
		configuracaoRepository.deleteById(1001L);
		ConfiguracaoAgenda conf = configuracaoRepository.findById(1001L).orElse(null);
		Assert.assertNull(conf);
	}
}
