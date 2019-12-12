import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../model/usuario';

const API_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  public login( email: string, senha: string): Promise<any>
    {
    let body = new URLSearchParams(); 
    body.set('email', email);
    body.set('password', senha);

    return this.http.post(API_URL+"/authenticate", body).toPromise();
  }
  
  listar(){
    return this.http.get<Usuario[]>('http://localhost:4200/api/api/usuario/list/');
  }

  detalhar(usuarioId: number){
    return this.http.get<Usuario>('http://localhost:4200/api/api/usuario/find?id='+usuarioId);

  }

  cadastrar(usuario: Usuario){
    return this.http.post<Usuario>('http://localhost:4200/api/api/usuario/insert/', usuario);
  }

  editar(usuario: Usuario){
    return this.http.post<Usuario>('http://localhost:4200/api/api/usuario/update/', usuario);
  }

  remover(usuarioId: number){
    return this.http.get('http://localhost:4200/api/api/usuario/remove?id='+usuarioId);
  }
}
