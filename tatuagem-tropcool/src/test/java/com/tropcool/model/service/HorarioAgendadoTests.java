package com.tropcool.model.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.Cliente;
import com.tropcool.model.entity.ConfiguracaoAgenda;
import com.tropcool.model.entity.HorarioAgendado;
import com.tropcool.model.repository.ClienteRepository;
import com.tropcool.model.repository.ConfiguracaoAgendaRepository;
import com.tropcool.model.repository.HorarioAgendadoRepository;

public class HorarioAgendadoTests extends AbstractIntegrationTests{
	
	@Autowired
	private HorarioAgendadoRepository horarioRepository;
	
	@Autowired
	private HorarioAgendadoService horarioService;
	
	@Autowired
	private ClienteService  clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ConfiguracaoAgendaRepository configuracaoRepository;
	
	@Autowired
	private ConfiguracaoAgendaService configuracaoService;
	
	/**
	 * ====================================== CADASTRAR ===========================================
	 */
	
	/* CADASTRAR HORARIO_AGENDADO - MUSTPASS*/
	

	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql"
	})
	public void cadastrarHorarioAgendadoMustPass() {
		Cliente cliente = clienteRepository.findById(1001L).orElse(null);
		ConfiguracaoAgenda conf = configuracaoRepository.findById(1001L).orElse(null);
		
		HorarioAgendado horario = new HorarioAgendado();
		horario.setCliente(cliente);
		horario.setConfiguracao(conf);  
		horario.setHorario(LocalDateTime.of(2019, 11, 22, 8, 0));
		
		horarioService.agendarHorario(horario);
		Assert.assertNotNull(horario.getId());
	}
	
	/**
	 * ====================================== LISTAR ===========================================
	 */
	
	/* LISTAR HORARIO_AGENDADO - MUSTPASS*/
	

	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql",
		"/dataset/horarioAgendado.sql"
	})
	public void listarHorarioAgendadoMustPass() {
		List<HorarioAgendado> l = horarioRepository.findAll();
		Assert.assertEquals(l.size(), 5);
	}

	/**
	 * ====================================== RECUPERAR ===========================================
	 */
	
	/* RECUPERAR HORARIO_AGENDADO - MUSTPASS*/
	

	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql",
		"/dataset/horarioAgendado.sql"
	})
	public void recuperarHorarioAgendadoMustPass() {
		HorarioAgendado h = horarioRepository.findById(1001L).orElse(null);
		Assert.assertNotNull(h);
	}
	
	/**
	 * ====================================== REMOVER ===========================================
	 */
	
	/* REMOVER HORARIO_AGENDADO - POR ID - MUSTPASS*/
	

	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql",
		"/dataset/horarioAgendado.sql"
	})
	public void removerHorarioAgendadoMustPass() {
		HorarioAgendado h = horarioRepository.findById(1001L).orElse(null);
		Assert.assertNotNull(h);
		
		horarioRepository.deleteById(1001L);
		
		h = horarioRepository.findById(1001L).orElse(null);
		Assert.assertNull(h);
	}
	
	/**
	 * ====================================== ALTERAR ===========================================
	 */
	
	/* EDITAR HORARIO_AGENDADO - ALTERA CONFIGURACAO - MUSTPASS*/
	

	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/clientes.sql",
		"/dataset/tatuadores.sql",
		"/dataset/configuracaoAgendas.sql",
		"/dataset/horarioAgendado.sql"
	})
	public void editarHorarioAgendadoConfiguracaoMustPass() {
		HorarioAgendado h = horarioRepository.findById(1001L).orElse(null);
		Assert.assertNotNull(h);
		
		h.setConfiguracao(configuracaoRepository.findById(1002L).orElse(null));
		Assert.assertNotNull(h.getConfiguracao());
		
		horarioRepository.save(h);
		
		h = horarioRepository.findById(1001L).orElse(null);
	}

}
