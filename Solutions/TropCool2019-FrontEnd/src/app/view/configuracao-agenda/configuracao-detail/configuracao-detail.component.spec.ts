import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfiguracaoDetailComponent } from './configuracao-detail.component';

describe('ConfiguracaoDetailComponent', () => {
  let component: ConfiguracaoDetailComponent;
  let fixture: ComponentFixture<ConfiguracaoDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfiguracaoDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfiguracaoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
