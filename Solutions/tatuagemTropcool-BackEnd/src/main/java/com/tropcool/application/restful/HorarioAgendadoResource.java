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

import com.tropcool.model.entity.HorarioAgendado;
import com.tropcool.model.service.HorarioAgendadoService;

@Component
@RestController
@RequestMapping("/api/horario_agendado")
public class HorarioAgendadoResource {

	@Autowired
	private HorarioAgendadoService horarioAgendadoService;
	
	@GetMapping("/list")
	public List<HorarioAgendado> listar(){
		return this.horarioAgendadoService.listarHorarioAgendado();
	}
	
	@PostMapping("/insert")
	public HorarioAgendado cadastrar(@RequestBody HorarioAgendado horario) {
		return this.horarioAgendadoService.agendarHorario(horario);
	}
	
	@GetMapping("/find")
	public HorarioAgendado detalhar(@RequestParam("id") Long id) {
		return this.horarioAgendadoService.detalharHorarioAgendado(id);
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("id") Long id) {
		this.horarioAgendadoService.removerHorarioAgendao(id);
	}
}