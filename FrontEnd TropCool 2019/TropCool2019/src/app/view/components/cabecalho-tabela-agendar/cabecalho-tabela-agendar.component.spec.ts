import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CabecalhoTabelaAgendarComponent } from './cabecalho-tabela-agendar.component';

describe('CabecalhoTabelaAgendarComponent', () => {
  let component: CabecalhoTabelaAgendarComponent;
  let fixture: ComponentFixture<CabecalhoTabelaAgendarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CabecalhoTabelaAgendarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CabecalhoTabelaAgendarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
