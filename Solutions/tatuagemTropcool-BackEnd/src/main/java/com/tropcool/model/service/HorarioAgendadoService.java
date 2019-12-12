package com.tropcool.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tropcool.model.entity.HorarioAgendado;
import com.tropcool.model.repository.HorarioAgendadoRepository;

@Service
@Transactional
public class HorarioAgendadoService {
	
	@Autowired
	private HorarioAgendadoRepository horarioAgendadoRepository;
	
	public HorarioAgendado agendarHorario(HorarioAgendado horario) {
		return this.horarioAgendadoRepository.save(horario);
	}
	
	public HorarioAgendado detalharHorarioAgendado(Long id) {
		HorarioAgendado horario = this.horarioAgendadoRepository.findById(id).orElse(null);
		Assert.notNull(horario,"Horário não reservado no sistema... id de busca " + id);
		return horario;
	}
	
	public List<HorarioAgendado> listarHorarioAgendado(){
		return this.horarioAgendadoRepository.findAll();
	}
	
	public void removerHorarioAgendao(Long id) {
		this.horarioAgendadoRepository.deleteById(id);
	}
}
