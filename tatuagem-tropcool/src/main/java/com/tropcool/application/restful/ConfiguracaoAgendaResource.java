package com.tropcool.application.restful;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tropcool.model.entity.ConfiguracaoAgenda;
import com.tropcool.model.service.ConfiguracaoAgendaService;

@Component
@RestController
@RequestMapping("/api/configuracao_agenda")
public class ConfiguracaoAgendaResource {
	private String mensagem;
	private LocalTime horaI;
	private LocalTime horaT;
	int horaIint;
	int horaTint;
	
	@Autowired
	private ConfiguracaoAgendaService configuracaoAgendaService;
	
	@GetMapping("/list")
	public List<ConfiguracaoAgenda> listar(){
		return this.configuracaoAgendaService.listaConfiguracaoAgenda();
	}
	
	@PostMapping("/insert")
	public ConfiguracaoAgenda cadastrar(@RequestBody ConfiguracaoAgenda configuracaoAgenda) throws Exception {
		System.out.println("\nDia da semana: " + configuracaoAgenda.getDia() + "\n");
		horaI = configuracaoAgenda.getHoraInicio();
		horaT = configuracaoAgenda.getHoraTermino();
		horaIint = configuracaoAgenda.getHoraInicio().getHour();
		horaTint = configuracaoAgenda.getHoraTermino().getHour();
		if(horaIint > horaTint) {
			mensagem = "ERRO: Horário de ínicio não pode superar o horário de encerramento do espediente.";
			throw new Exception(mensagem);
		}else if( horaI == horaT) {
			mensagem = "ERRO: Deve haver pelo menos uma hora de diferença entre o início e encerramento do expediente.";
			throw new Exception(mensagem);
		}else if(horaIint < horaTint){
			try {
				return this.configuracaoAgendaService.cadastrarConfiguracaoAgenda(configuracaoAgenda);
			}catch(Exception e) {
				throw new Exception(e);
			}
		}else{
			mensagem = "ERRO: Não foi possível finalizar o registro, causa desconhecida.";
			throw new Exception(mensagem);
		}
		
	}
	
	@GetMapping("/find")
	public ConfiguracaoAgenda detalhar(@RequestParam("id") Long id) {
		return this.configuracaoAgendaService.detalharConfiguracaoAgenda(id);
	}
	
	@PostMapping("/update")
	public ConfiguracaoAgenda atualizar(@RequestBody ConfiguracaoAgenda configuracaoAgenda) throws Exception {
		System.out.println("\nDia da semana: " + configuracaoAgenda.getDia() + "\n");
		horaI = configuracaoAgenda.getHoraInicio();
		horaT = configuracaoAgenda.getHoraTermino();
		horaIint = configuracaoAgenda.getHoraInicio().getHour();
		horaTint = configuracaoAgenda.getHoraTermino().getHour();
		if(horaIint > horaTint) {
			mensagem = "ERRO: Horário de ínicio não pode superar o horário de encerramento do espediente.";
			throw new Exception(mensagem);
		}else if( horaI == horaT) {
			mensagem = "ERRO: Deve haver pelo menos uma hora de diferença entre o início e encerramento do expediente.";
			throw new Exception(mensagem);
		}else if(horaIint < horaTint){
			try {
				return this.configuracaoAgendaService.atualizarConfiguracaoAgenda(configuracaoAgenda);
			}catch(Exception e) {
				throw new Exception(e);
			}
		}else{
			mensagem = "ERRO: Não foi possível finalizar o registro, causa desconhecida.";
			throw new Exception(mensagem);
		}
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("id") Long id) {
		this.configuracaoAgendaService.removerConfiguracaoAgenda(id);
	}
}