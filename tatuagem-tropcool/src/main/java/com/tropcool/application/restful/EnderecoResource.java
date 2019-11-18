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

import com.tropcool.model.entity.Endereco;
import com.tropcool.model.service.EnderecoService;

@Component
@RestController
@RequestMapping("/api/departamento")
public class EnderecoResource {

	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("/list")
	public List<Endereco> listar(){
		return this.enderecoService.listarEndereco();
	}
	
	@PostMapping("/insert")
	public Endereco cadastrar(@RequestBody Endereco endereco) {
		return this.enderecoService.cadastrarEndereco(endereco);
	}
	
	@GetMapping("/update")
	public Endereco atualizar(@RequestBody Endereco endereco) {
		return this.enderecoService.atualizarEndereco(endereco);
	}
	
	@GetMapping("/find")
	public Endereco detalhar(@RequestParam("id") Long id) {
		return this.enderecoService.detalharEndereco(id);
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("id") Long id) {
		this.enderecoService.removerEndereco(id);
	}
}
