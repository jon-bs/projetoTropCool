import { Injectable } from '@angular/core';
import { ConfiguracaoAgenda } from '../model/configuracao-agenda';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConfiguracaoAgendaService {

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<ConfiguracaoAgenda[]>('http://localhost:4200/api/api/configuracao_agenda/list/');
  }

  detalhar(configuracao_agendaId: number){
    return this.http.get<ConfiguracaoAgenda>('http://localhost:4200/api/api/configuracao_agenda/find?id='+configuracao_agendaId);
  }

  cadastrar(configuracao_agenda: ConfiguracaoAgenda){
    console.log(configuracao_agenda)
    return this.http.post<ConfiguracaoAgenda>('http://localhost:4200/api/api/configuracao_agenda/insert/', configuracao_agenda);
  }

  editar(configuracao_agenda: ConfiguracaoAgenda){
    return this.http.post<ConfiguracaoAgenda>('http://localhost:4200/api/api/configuracao_agenda/update/', configuracao_agenda);
  }

  remover(configuracao_agendaId: number){
    return this.http.get('http://localhost:4200/api/api/configuracao_agenda/remove?id='+configuracao_agendaId);
  }
}
