import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilTatuadorComponent } from './perfil-tatuador.component';

describe('PerfilTatuadorComponent', () => {
  let component: PerfilTatuadorComponent;
  let fixture: ComponentFixture<PerfilTatuadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PerfilTatuadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PerfilTatuadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
