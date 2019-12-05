import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabelaAgendarComponent } from './tabela-agendar.component';

describe('TabelaAgendarComponent', () => {
  let component: TabelaAgendarComponent;
  let fixture: ComponentFixture<TabelaAgendarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabelaAgendarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabelaAgendarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
