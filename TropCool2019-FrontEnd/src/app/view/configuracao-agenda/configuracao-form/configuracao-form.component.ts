import { Component, OnInit } from '@angular/core';
import { DiaSemanaValues } from 'src/app/model/dia-da-semana';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ConfiguracaoAgenda } from 'src/app/model/configuracao-agenda';
import { ActivatedRoute, Router } from '@angular/router';
import { ConfiguracaoAgendaService } from 'src/app/service/configuracao-agenda.service';
import { MessagesService } from 'src/app/service/messages.service';
import { DateAdapter } from '@angular/material';
import { DiaSemana } from 'src/app/model/dia-da-semana';
import { TatuadorService } from 'src/app/service/tatuador.service';
import { Tatuador } from 'src/app/model/tatuador';

@Component({
  selector: 'app-configuracao-form',
  templateUrl: './configuracao-form.component.html',
  styleUrls: ['./configuracao-form.component.css']
})
export class ConfiguracaoFormComponent implements OnInit {

  public configuracaoForm : FormGroup; // formulario

  public configuracao : ConfiguracaoAgenda;  // objeto configuracao-agenda

  public diaSemanaValues : String[] = DiaSemanaValues; // dias da semana enum
  
  public tatuadorList : Array<Tatuador> = []; // lista de tatuadores

  public isOnUpdate : boolean = false; // para verificação de cadastro/update

  /**
   * Construtor da classe
   * @param fb 
   * @param activatedRoute 
   * @param router 
   * @param configuracaoService 
   */


  constructor(
    private fb: FormBuilder, // construtor do formulario
    private activatedRoute: ActivatedRoute,
    private router: Router, 
    private configuracaoService: ConfiguracaoAgendaService, // service para manipulação dos dados
    private messageService: MessagesService,
    private _adapter: DateAdapter<any>,
    private tatuadorService: TatuadorService
    ) { }
  
    ngOnInit() {

      this.configuracao = new ConfiguracaoAgenda(null, null, null, null, null, null);
      this.createForm();
      this.listarTatuadores("");
      this.configuracao.id = this.activatedRoute.snapshot.params['id'];
      if (this.configuracao.id) {
        this.loadToEdit();
      }
      
    }
  
   
    public createForm() {
      

      this.configuracaoForm = this.fb.group(
        {
          tatuador: [null, { validators: [Validators.required], updateOn: 'blur' }],
          horaInico: [null, {validators: [Validators.required, Validators.maxLength(18)], updateOn: 'blur'}],
          horaTermino: [null, {validators: [Validators.required, Validators.maxLength(18)], updateOn: 'blur'}],
          diaSemanaValues: [null, { validators: [Validators.required] }],
        }
      );
      //this._adapter.setLocale('pt');
    }
  
  
    // evento para salvvar
    onSave() {
      if (this.configuracaoForm.valid) {
  
        this.configuracao.tatuador = this.configuracaoForm.get("tatuador").value;
        this.configuracao.diaSemana = this.configuracaoForm.get("diaSemanaValues").value;
        this.configuracao.horaInicio = this.configuracaoForm.get("horaInicio").value;
        this.configuracao.horaTermino = this.configuracaoForm.get("horaTermino").value;
        console.log(this.configuracao);
        // cadastro || edição
        if (this.configuracao.id == null) {
          this.configuracaoService.cadastrar(this.configuracao).subscribe(res => {
            this.configuracao = res;
            this.messageService.toastSuccess('Configuraçao de Agendamento cadastrado com sucesso.');
            this.onBack();
          },
            (error: any) => {
              this.messageService.toastError(error.error.message);
            });
        }
        else {
          this.configuracaoService.editar(this.configuracao).subscribe(res => {
            this.configuracao = res;
            this.isOnUpdate = true;
            this.messageService.toastSuccess('Configuração de Agendamento atualizado com sucesso.');
            this.onBack();
          },
          (error: any) => {
            this.messageService.toastError(error.error.message);
          });
        }
  
      } else {
        this.messageService.toastWarnning('Preencha todos os campos obrigatórios antes de salvar.');
  
      }
    }
  
    // carrega os dados no formulario


    loadToEdit() {
      this.configuracaoService.detalhar(this.configuracao.id).subscribe(res => {
        this.configuracaoForm.get("tatuador").setValue(res.tatuador);
        this.configuracaoForm.get("diaSemanaValues").setValue(res.diaSemana);
        this.configuracaoForm.get("horaInicio").setValue(res.horaInicio);
        this.configuracaoForm.get("horaTermino").setValue(res.horaTermino);
        this.isOnUpdate = true;
      },
        (error: any) => {
          this.messageService.toastError(error.error.message);
        });
  
    }
  
    onBack() {
      console.log(this.configuracaoForm.get("configuracao").value);
      if (!this.isOnUpdate) {
        this.router.navigate(['../'], { relativeTo: this.activatedRoute });
      } else {
        this.router.navigate(['../../'], { relativeTo: this.activatedRoute });
      }
  
    }
  
    displayTatuador(tatuador?: Tatuador): string | undefined {
      return tatuador ? tatuador.usuario.nome : undefined;
    }
  
    listarTatuadores(filter: string) {
      this.tatuadorService.listar().subscribe(dados => {
        this.tatuadorList = dados;
        console.log(this.tatuadorList)
      },
        (error: any) => {
          this.messageService.toastError(error.error.message);
        });
    }
  
  
    selectTatuador(event: any) {
      this.configuracaoForm.get("tatuador").setValue(event.option.value);
    }

}
