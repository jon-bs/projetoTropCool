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

import com.tropcool.model.entity.Interacao;
import com.tropcool.model.service.InteracaoService;

@Component
@RestController
@RequestMapping("/api/interacao")
public class InteracaoResource {

	@Autowired
	private InteracaoService interacaoService;
	
	@GetMapping("/list")
	public List<Interacao> listar(){
		return this.interacaoService.listarInteracoes();
	}
	
	@PostMapping("/insert")
	public Interacao cadastrar(@RequestBody Interacao interacao) {
		return this.interacaoService.escreverInteracao(interacao);
	}
	
	@GetMapping("/update")
	public Interacao atualizar(@RequestBody Interacao interacao) {
		return this.interacaoService.atualizarInteracao(interacao);
	}
	
	@GetMapping("/write")
	public Interacao detalhar(@RequestParam("id") Long id) {
		return this.interacaoService.detalharInteracao(id);
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("id") Long id) {
		this.interacaoService.removerInteracao(id);
	}
}