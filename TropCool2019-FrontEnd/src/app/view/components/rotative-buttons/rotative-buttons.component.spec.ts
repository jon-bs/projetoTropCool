import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RotativeButtonsComponent } from './rotative-buttons.component';

describe('RotativeButtonsComponent', () => {
  let component: RotativeButtonsComponent;
  let fixture: ComponentFixture<RotativeButtonsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RotativeButtonsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RotativeButtonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
