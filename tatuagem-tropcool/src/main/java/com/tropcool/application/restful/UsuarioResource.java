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

import com.tropcool.model.entity.Usuario;
import com.tropcool.model.service.UsuarioService;

@Component
@RestController
@RequestMapping("/api/departamento")
public class UsuarioResource {

	@Autowired
	private UsuarioService UsuarioService;
	
	@PostMapping("/insert")
	public Usuario cadastrar(@RequestBody Usuario Usuario) {
		return this.UsuarioService.cadastrarUsuario(Usuario);
	}
	
	@GetMapping("/find")
	public Usuario detalhar(@RequestParam("id") Long id) {
		return this.UsuarioService.detalharUsuario(id);
	}
}