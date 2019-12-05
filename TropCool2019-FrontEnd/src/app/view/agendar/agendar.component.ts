import { Component, OnInit, Input, Output, EventEmitter, ViewContainerRef} from '@angular/core';
import { ConfiguracaoAgenda } from 'src/app/model/configuracao-agenda';
import { TipoAcaoValues } from 'src/app/model/tipo-acao';
import { Router, ActivatedRoute } from '@angular/router';
import { MessagesService } from 'src/app/service/messages.service';
import { TdDialogService } from '@covalent/core/dialogs';
import { ConfiguracaoAgendaService } from 'src/app/service/configuracao-agenda.service';
import { __param } from 'tslib';


@Component({
  selector: 'app-agendar',
  templateUrl: './agendar.component.html',
  styleUrls: ['./agendar.component.css']
})
export class AgendarComponent implements OnInit {

  // LISTA DE CONFIGURAÇÕES DE AGENDA

  configuracaoes: Array<ConfiguracaoAgenda>;
/*
  *@param router
  *@param activatedRoute
  *@param configuracaoService
*/
  constructor(
      private router: Router,
      private activatedRoute: ActivatedRoute,
      private configuracaoService: ConfiguracaoAgendaService,
      private messageService: MessagesService,
      private _dialogService: TdDialogService,
      private _viewContainerRef: ViewContainerRef) { 
}
/**
   * Método que é executado ao carregar a classe
   */
  ngOnInit() {
    this.listar();
  }

  /**
   * Método que redireciona para cadastrar departamento
   */
  navigateToNovo() {
    this.router.navigate(['cadastrar'], { relativeTo: this.activatedRoute });

  }

  /**
   * Método que redireciona para alterar, excluir ou visualizar departamento
   * @param evento 
   */
  navigateTo(evento) {
    console.log(evento.acaoRealizada);
    let id: number  = evento.configuracaoSelecionadaId;
    if(evento.acaoRealizada == TipoAcaoValues[0]){
      this.router.navigate(['detalhes/'+id], { relativeTo: this.activatedRoute });
    }
    else if(evento.acaoRealizada == TipoAcaoValues[1]){
      this.router.navigate(['alterar/'+id], { relativeTo: this.activatedRoute });
    
    } else if(evento.acaoRealizada == TipoAcaoValues[2]){
      this.remover(id);
    }
    
  }

  /**
   * Método para listar os departamentos
   */
  listar(){
    this.configuracaoService.listar().subscribe(dados => {
      this.configuracaoes = dados;
    },
    (error: any) => {
      console.log(error);
      console.log(error.error.message);
      this.messageService.toastError(error.error.message);
    });
  }
    
  /**
   * Método para remover um departamento
   */
  remover(id: number){
    this.openRemoverConfirm(id);
  }

  openRemoverConfirm(id: number): void {
    this._dialogService.openConfirm({
      message: 'Tem certeza que deseja excluir esse departamento?',
      disableClose: true, // defaults to false
      viewContainerRef: this._viewContainerRef, //OPTIONAL
      title: 'Excluir departamento', //OPTIONAL, hides if not provided
      cancelButton: 'Não', //OPTIONAL, defaults to 'CANCEL'
      acceptButton: 'Sim', //OPTIONAL, defaults to 'ACCEPT'
      width: '500px', //OPTIONAL, defaults to 400px
    }).afterClosed().subscribe((accept: boolean) => {
      if (accept) {
        this.configuracaoService.remover(id).subscribe(dados => {
          this.messageService.toastSuccess('Departamento excluído com sucesso.');
          this.listar();
        },
        (error: any) => {
          console.log(error.error.message);
          this.messageService.toastError(error.error.message);
          
        });
      } else {
        // DO SOMETHING ELSE
      }
    });
  }
}
