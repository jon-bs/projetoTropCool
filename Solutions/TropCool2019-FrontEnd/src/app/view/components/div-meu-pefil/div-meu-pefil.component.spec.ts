import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DivMeuPefilComponent } from './div-meu-pefil.component';

describe('DivMeuPefilComponent', () => {
  let component: DivMeuPefilComponent;
  let fixture: ComponentFixture<DivMeuPefilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DivMeuPefilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DivMeuPefilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
