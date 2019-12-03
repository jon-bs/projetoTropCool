import { Component, OnInit } from '@angular/core';
import { ConfiguracaoAgenda } from 'src/app/model/configuracao-agenda';
import { ConfiguracaoAgendaService } from 'src/app/service/configuracao-agenda.service';
import { Router, ActivatedRoute } from '@angular/router';
import { MessagesService } from 'src/app/service/messages.service';
import { ParserToDateService } from 'src/app/service/parser-to-date.service';

@Component({
  selector: 'app-configuracao-detail',
  templateUrl: './configuracao-detail.component.html',
  styleUrls: ['./configuracao-detail.component.css']
})
export class ConfiguracaoDetailComponent implements OnInit {

  public configuracao : ConfiguracaoAgenda;
  constructor(
    private configuracaoService : ConfiguracaoAgendaService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private messageService: MessagesService,
    private parsserToDate: ParserToDateService
  ) { }

  ngOnInit() {
    this.configuracao = new ConfiguracaoAgenda(null, null, null, null, null, null);
    this.configuracao.id = this.activatedRoute.snapshot.params['id'];
    if (this.configuracao.id) {
      this.loadDados();
    }
  }

  loadDados(){
    this.configuracaoService.detalhar(this.configuracao.id).subscribe(res => {
      this.configuracao = new ConfiguracaoAgenda(res.id, res.horaInicio, res.horaTermino, res.tatuador, [], res.diaSemana);
    },
      (error: any) => {
      this.messageService.toastError(error.error.message);
    }
    );
    
  }

  onBack() {
    this.router.navigate(['../../'], { relativeTo: this.activatedRoute });
  }

  navigateToEdit() {
    this.router.navigate(['../../alterar/'+this.configuracao.id], { relativeTo: this.activatedRoute });
  }
}
