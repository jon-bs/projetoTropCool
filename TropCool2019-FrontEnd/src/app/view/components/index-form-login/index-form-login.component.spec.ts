import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexFormLoginComponent } from './index-form-login.component';

describe('IndexFormLoginComponent', () => {
  let component: IndexFormLoginComponent;
  let fixture: ComponentFixture<IndexFormLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IndexFormLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IndexFormLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
