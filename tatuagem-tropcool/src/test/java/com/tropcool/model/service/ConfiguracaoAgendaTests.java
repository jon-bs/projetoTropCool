package com.tropcool.model.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.ConfiguracaoAgenda;
import com.tropcool.model.entity.DiaSemanaEnum;
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
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql"
									})
	public void cadastrarConfiguracaoAgendaMustPass() {		
		ConfiguracaoAgenda conf = new ConfiguracaoAgenda();
		conf.setDia(DiaSemanaEnum.SEGUNDA);
		conf.setHoraInicio(LocalTime.of(8, 0));
		conf.setHorarioAgendado(null);
		conf.setHoraTermino(LocalTime.of(18, 0));
		conf.setTatuador(null);
	}
}
