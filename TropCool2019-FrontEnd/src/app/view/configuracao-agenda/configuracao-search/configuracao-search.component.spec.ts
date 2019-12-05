import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfiguracaoSearchComponent } from './configuracao-search.component';

describe('ConfiguracaoSearchComponent', () => {
  let component: ConfiguracaoSearchComponent;
  let fixture: ComponentFixture<ConfiguracaoSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfiguracaoSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfiguracaoSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
