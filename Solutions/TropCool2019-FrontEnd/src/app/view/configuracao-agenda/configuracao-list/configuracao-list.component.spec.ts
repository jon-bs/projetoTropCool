import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfiguracaoListComponent } from './configuracao-list.component';

describe('ConfiguracaoListComponent', () => {
  let component: ConfiguracaoListComponent;
  let fixture: ComponentFixture<ConfiguracaoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfiguracaoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfiguracaoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
