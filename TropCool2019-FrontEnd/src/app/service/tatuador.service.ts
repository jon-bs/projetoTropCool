import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tatuador } from '../model/tatuador';

@Injectable({
  providedIn: 'root'
})
export class TatuadorService {

  constructor( private http: HttpClient) { }

  listar(){
    return this.http.get<Tatuador[]>('http://localhost:4200/api/api/tatuador/list/');
  }

  detalhar(tatuadorId: number){
    return this.http.get<Tatuador>('http://localhost:4200/api/api/tatuador/find?id='+tatuadorId);

  }

  cadastrar(tatuador: Tatuador){
    return this.http.post<Tatuador>('http://localhost:4200/api/api/tatuador/insert/', tatuador);
  }

  editar(tatuador: Tatuador){
    return this.http.post<Tatuador>('http://localhost:4200/api/api/tatuador/update/', tatuador);
  }

  remover(tatuadorId: number){
    return this.http.get('http://localhost:4200/api/api/tatuador/remove?id='+tatuadorId);
  }
}
