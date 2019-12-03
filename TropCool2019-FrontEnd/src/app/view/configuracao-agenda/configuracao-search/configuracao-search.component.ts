import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { TipoAcaoValues } from 'src/app/model/tipo-acao';
import { MessagesService } from 'src/app/service/messages.service';
import { TdDialogService } from '@covalent/core/dialogs';
import { ConfiguracaoAgenda } from 'src/app/model/configuracao-agenda';
import { ConfiguracaoAgendaService } from 'src/app/service/configuracao-agenda.service';


@Component({
  selector: 'app-configuracao-search',
  templateUrl: './configuracao-search.component.html',
  styleUrls: ['./configuracao-search.component.css']
})
export class ConfiguracaoSearchComponent implements OnInit {

  configuracoes : Array<ConfiguracaoAgenda>;

  /**
   * Construtor da classe
   * @param router 
   * @param activatedRoute 
   * @param departamentoService 
   */
  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private configuracaoService: ConfiguracaoAgendaService,
    private messageService: MessagesService,
    private _dialogService: TdDialogService,
    private _viewContainerRef: ViewContainerRef
    ) { }

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
    let id: number  = evento.departamentoSelecionadoId;
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
      this.configuracoes = dados;
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
      message: 'Tem certeza que deseja excluir essa Configuracao?',
      disableClose: true, // defaults to false
      viewContainerRef: this._viewContainerRef, //OPTIONAL
      title: 'Excluir configuracao', //OPTIONAL, hides if not provided
      cancelButton: 'Não', //OPTIONAL, defaults to 'CANCEL'
      acceptButton: 'Sim', //OPTIONAL, defaults to 'ACCEPT'
      width: '500px', //OPTIONAL, defaults to 400px
    }).afterClosed().subscribe((accept: boolean) => {
      if (accept) {
        this.configuracaoService.remover(id).subscribe(dados => {
          this.messageService.toastSuccess('Configuracao excluído com sucesso.');
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
