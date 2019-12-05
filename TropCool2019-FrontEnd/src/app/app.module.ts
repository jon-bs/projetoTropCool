import { BrowserModule} from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatListModule, MatCardModule, MatMenuModule, MatInputModule, MatButtonToggleModule, MatIconModule,
  MatProgressSpinnerModule, MatSelectModule, MatSlideToggleModule, MatSnackBarModule, MatToolbarModule,
  MatTabsModule, MatSidenavModule, MatTooltipModule, MatRippleModule, MatRadioModule, MatGridListModule,
  MatDatepickerModule, MatNativeDateModule, MatSliderModule, MatAutocompleteModule } from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';
import { CovalentCommonModule, CovalentLayoutModule, CovalentMediaModule, CovalentExpansionPanelModule,
  CovalentStepsModule, CovalentLoadingModule, CovalentSearchModule, CovalentPagingModule,
  CovalentNotificationsModule, CovalentMenuModule, CovalentDataTableModule, CovalentMessageModule } from '@covalent/core';
import { CovalentDialogsModule } from '@covalent/core/dialogs';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule} from "@angular/flex-layout";
import { AppRoutingModule } from './app-routing.module';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';

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
import { ConfiguracaoSearchComponent } from './view/configuracao-agenda/configuracao-search/configuracao-search.component';
import { ConfiguracaoDetailComponent } from './view/configuracao-agenda/configuracao-detail/configuracao-detail.component';
import { ConfiguracaoListComponent } from './view/configuracao-agenda/configuracao-list/configuracao-list.component';
import { ConfiguracaoFormComponent } from './view/configuracao-agenda/configuracao-form/configuracao-form.component';
import { ConfiguracaoAgendaService } from './service/configuracao-agenda.service';
import { TatuadorService } from './service/tatuador.service';
import { ClienteService } from './service/cliente.service';
import { HorarioAgendado } from './model/horario-agendado';
import { HorarioAgendadoService } from './service/horario-agendado.service';
import { Usuario } from './model/usuario';
import { UsuarioService } from './service/usuario.service';
import { MessagesService } from './service/messages.service';
import { MenuComponent } from './view/menu/menu.component';
//import { HorarioAgendadoComponent } from './model/horario-agendado.component';

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
    MenuComponent,
    // CRIADOS POR GABRIEL
    ConfiguracaoSearchComponent,
    ConfiguracaoDetailComponent,
    ConfiguracaoListComponent,
    ConfiguracaoFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,

    /** Material Modules */
    MatButtonModule,
    MatListModule,
    MatIconModule,
    MatCardModule,
    MatMenuModule,
    MatInputModule,
    MatSelectModule,
    MatButtonToggleModule,
    MatSlideToggleModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatTabsModule,
    MatSidenavModule,
    MatTooltipModule,
    MatRippleModule,
    MatRadioModule,
    MatGridListModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSliderModule,
    MatAutocompleteModule,

    /** Covalent Modules */
    CovalentCommonModule,
    CovalentLayoutModule,
    CovalentMediaModule,
    CovalentExpansionPanelModule,
    CovalentStepsModule,
    CovalentDialogsModule,
    CovalentLoadingModule,
    CovalentSearchModule,
    CovalentPagingModule,
    CovalentNotificationsModule,
    CovalentMenuModule,
    CovalentDataTableModule,
    CovalentMessageModule,
    NgxMaterialTimepickerModule
  ],
  providers: [
    ConfiguracaoAgendaService,
    TatuadorService,
    ClienteService,
    HorarioAgendadoService,
    UsuarioService,
    MessagesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
