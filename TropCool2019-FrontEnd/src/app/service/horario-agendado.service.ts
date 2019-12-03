import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HorarioAgendado } from '../model/horario-agendado';

@Injectable({
  providedIn: 'root'
})
export class HorarioAgendadoService {

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<HorarioAgendado[]>('http://localhost:4200/api/api/horario_agendado/list/');
  }

  detalhar(horario_agendadoId: number){
    return this.http.get<HorarioAgendado>('http://localhost:4200/api/api/horario_agendado/find?id='+horario_agendadoId);

  }

  cadastrar(horario_agendado: HorarioAgendado){
    return this.http.post<HorarioAgendado>('http://localhost:4200/api/api/horario_agendado/insert/', horario_agendado);
  }

  editar(horario_agendado: HorarioAgendado){
    return this.http.post<HorarioAgendado>('http://localhost:4200/api/api/horario_agendado/update/', horario_agendado);
  }

  remover(horario_agendadoId: number){
    return this.http.get('http://localhost:4200/api/api/horario_agendado/remove?id='+horario_agendadoId);
  }
}
