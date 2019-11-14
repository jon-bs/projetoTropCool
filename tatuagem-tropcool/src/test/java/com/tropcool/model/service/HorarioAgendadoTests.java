package com.tropcool.model.service;

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
		"/dataset/configuracaoAgendas.sql"
		
	})
	public void cadastrarHorarioAgendadoMustPass() {
		Cliente cliente = clienteRepository.findById(1001L).orElse(null);
		ConfiguracaoAgenda conf = configuracaoRepository.findById(1001L).orElse(null);
		
		HorarioAgendado horario = new HorarioAgendado();
		horario.setCliente(cliente);
		horario.setConfiguracao(conf);
		
		horarioService.agendarHorario(horario);
		Assert.assertNotNull(horario.getId());
	}

}
