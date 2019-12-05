import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../model/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Cliente[]>('http://localhost:4200/api/api/cliente/list/');
  }

  detalhar(clienteId: number){
    return this.http.get<Cliente>('http://localhost:4200/api/api/cliente/find?id='+clienteId);

  }

  cadastrar(cliente: Cliente){
    return this.http.post<Cliente>('http://localhost:4200/api/api/cliente/insert/', cliente);
  }

  editar(cliente: Cliente){
    return this.http.post<Cliente>('http://localhost:4200/api/api/cliente/update/', cliente);
  }

  remover(clienteId: number){
    return this.http.get('http://localhost:4200/api/api/cliente/remove?id='+clienteId);
  }
}
