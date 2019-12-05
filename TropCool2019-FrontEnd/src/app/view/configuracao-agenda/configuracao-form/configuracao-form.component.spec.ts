import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfiguracaoFormComponent } from './configuracao-form.component';

describe('ConfiguracaoFormComponent', () => {
  let component: ConfiguracaoFormComponent;
  let fixture: ComponentFixture<ConfiguracaoFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfiguracaoFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfiguracaoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
