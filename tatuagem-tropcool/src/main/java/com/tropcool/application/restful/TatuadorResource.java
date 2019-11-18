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

import com.tropcool.model.entity.Tatuador;
import com.tropcool.model.service.TatuadorService;

@Component
@RestController
@RequestMapping("/api/departamento")
public class TatuadorResource {

	@Autowired
	private TatuadorService tatuadorService;
	
	@GetMapping("/list")
	public List<Tatuador> listar(){
		return this.tatuadorService.listarTatuadors();
	}
	
	@PostMapping("/insert")
	public Tatuador cadastrar(@RequestBody Tatuador tatuador) {
		return this.tatuadorService.cadastrarTatuador(tatuador);
	}
	
	@GetMapping("/update")
	public Tatuador atualizar(@RequestBody Tatuador tatuador) {
		return this.tatuadorService.atualizarTatuador(tatuador);
	}
	
	@GetMapping("/find")
	public Tatuador detalhar(@RequestParam("id") Long id) {
		return this.tatuadorService.detalharTatuador(id);
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("id") Long id) {
		this.tatuadorService.removerTatuador(id);
	}
}









