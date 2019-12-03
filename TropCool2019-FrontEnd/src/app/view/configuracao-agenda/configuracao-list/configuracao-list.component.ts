import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { TipoAcaoValues } from 'src/app/model/tipo-acao';
import { ConfiguracaoAgenda } from 'src/app/model/configuracao-agenda';

@Component({
  selector: 'app-configuracao-list',
  templateUrl: './configuracao-list.component.html',
  styleUrls: ['./configuracao-list.component.css']
})
export class ConfiguracaoListComponent implements OnInit {

  @Input() configuracoes : ConfiguracaoAgenda[];

  @Output() selecionarConfiguracao = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  selecionar(id: any, acao: number) {
    console.log(acao);
    this.selecionarConfiguracao.emit({configuracaoSelecionadaId : id, acaoRealizada : TipoAcaoValues[acao]})
  }
}
