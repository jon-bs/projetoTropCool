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

import com.tropcool.model.entity.Mensagem;
import com.tropcool.model.service.MensagemService;

@Component
@RestController
@RequestMapping("/api/departamento")
public class MensagemResource {

	@Autowired
	private MensagemService mensagemService;
	
	@GetMapping("/list")
	public List<Mensagem> listar(){
		return this.mensagemService.listarMensagens();
	}
	
	@PostMapping("/insert")
	public Mensagem cadastrar(@RequestBody Mensagem mensagem) {
		return this.mensagemService.escreverMensagem(mensagem);
	}
	
	@GetMapping("/update")
	public Mensagem atualizar(@RequestBody Mensagem mensagem) {
		return this.mensagemService.atualizarMensagem(mensagem);
	}
	
	@GetMapping("/find")
	public Mensagem detalhar(@RequestParam("id") Long id) {
		return this.mensagemService.detalharMensagem(id);
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("id") Long id) {
		this.mensagemService.removerMensagem(id);
	}
}
