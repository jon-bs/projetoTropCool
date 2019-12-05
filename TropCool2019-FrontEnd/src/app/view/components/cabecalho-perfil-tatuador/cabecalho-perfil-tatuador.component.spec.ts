import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CabecalhoPerfilTatuadorComponent } from './cabecalho-perfil-tatuador.component';

describe('CabecalhoPerfilTatuadorComponent', () => {
  let component: CabecalhoPerfilTatuadorComponent;
  let fixture: ComponentFixture<CabecalhoPerfilTatuadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CabecalhoPerfilTatuadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CabecalhoPerfilTatuadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
