import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CabecalhoGeralComponent } from './cabecalho-geral.component';

describe('CabecalhoGeralComponent', () => {
  let component: CabecalhoGeralComponent;
  let fixture: ComponentFixture<CabecalhoGeralComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CabecalhoGeralComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CabecalhoGeralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
