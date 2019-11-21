package com.tropcool.application.restful;

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

	@Autowired
	private ConfiguracaoAgendaService configuracaoAgendaService;
	
	@GetMapping("/list")
	public List<ConfiguracaoAgenda> listar(){
		return this.configuracaoAgendaService.listaConfiguracaoAgenda();
	}
	
	@PostMapping("/insert")
	public ConfiguracaoAgenda cadastrar(@RequestBody ConfiguracaoAgenda configuracaoAgenda) {
		return this.configuracaoAgendaService.cadastrarConfiguracaoAgenda(configuracaoAgenda);
	}
	
	@GetMapping("/find")
	public ConfiguracaoAgenda detalhar(@RequestParam("id") Long id) {
		return this.configuracaoAgendaService.detalharConfiguracaoAgenda(id);
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("id") Long id) {
		this.configuracaoAgendaService.removeConfiguracaoAgenda(id);
	}
}