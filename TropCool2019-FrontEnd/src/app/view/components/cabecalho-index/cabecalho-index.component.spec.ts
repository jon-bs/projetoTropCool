import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CabecalhoIndexComponent } from './cabecalho-index.component';

describe('CabecalhoIndexComponent', () => {
  let component: CabecalhoIndexComponent;
  let fixture: ComponentFixture<CabecalhoIndexComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CabecalhoIndexComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CabecalhoIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
