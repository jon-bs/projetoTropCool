import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BotaoAnimadoComponent } from './botao-animado.component';

describe('BotaoAnimadoComponent', () => {
  let component: BotaoAnimadoComponent;
  let fixture: ComponentFixture<BotaoAnimadoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BotaoAnimadoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BotaoAnimadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
