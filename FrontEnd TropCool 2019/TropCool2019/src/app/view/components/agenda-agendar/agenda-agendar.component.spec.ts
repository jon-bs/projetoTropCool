import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgendaAgendarComponent } from './agenda-agendar.component';

describe('AgendaAgendarComponent', () => {
  let component: AgendaAgendarComponent;
  let fixture: ComponentFixture<AgendaAgendarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgendaAgendarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgendaAgendarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
