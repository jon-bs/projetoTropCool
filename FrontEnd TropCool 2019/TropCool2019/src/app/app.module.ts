import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CabecalhoIndexComponent } from './view/components/cabecalho-index/cabecalho-index.component';
import { IndexCircleDivComponent } from './view/components/index-circle-div/index-circle-div.component';
import { IndexFormLoginComponent } from './view/components/index-form-login/index-form-login.component';
import { IndexComponent } from './view/index/index.component';
import { CabecalhoGeralComponent } from './view/components/cabecalho-geral/cabecalho-geral.component';
import { PrincipalComponent } from './view/principal/principal.component';
import { SearchBarComponent } from './view/components/search-bar/search-bar.component';
import { DivMeuPefilComponent } from './view/components/div-meu-pefil/div-meu-pefil.component';
import { RotativeButtonsComponent } from './view/components/rotative-buttons/rotative-buttons.component';
import { BotaoAnimadoComponent } from './view/components/botao-animado/botao-animado.component';
import { PerfilTatuadorComponent } from './view/perfil-tatuador/perfil-tatuador.component';
import { CabecalhoPerfilTatuadorComponent } from './view/components/cabecalho-perfil-tatuador/cabecalho-perfil-tatuador.component';
import { AgendarComponent } from './view/agendar/agendar.component';
import { CabecalhoTabelaAgendarComponent } from './view/components/cabecalho-tabela-agendar/cabecalho-tabela-agendar.component';
import { TabelaAgendarComponent } from './view/components/tabela-agendar/tabela-agendar.component';
import { AgendaAgendarComponent } from './view/components/agenda-agendar/agenda-agendar.component';

@NgModule({
  declarations: [
    AppComponent,
    CabecalhoIndexComponent,
    IndexCircleDivComponent,
    IndexFormLoginComponent,
    IndexComponent,
    CabecalhoGeralComponent,
    PrincipalComponent,
    SearchBarComponent,
    DivMeuPefilComponent,
    RotativeButtonsComponent,
    BotaoAnimadoComponent,
    PerfilTatuadorComponent,
    CabecalhoPerfilTatuadorComponent,
    AgendarComponent,
    CabecalhoTabelaAgendarComponent,
    TabelaAgendarComponent,
    AgendaAgendarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
