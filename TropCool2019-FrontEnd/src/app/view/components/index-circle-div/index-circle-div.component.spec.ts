import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexCircleDivComponent } from './index-circle-div.component';

describe('IndexCircleDivComponent', () => {
  let component: IndexCircleDivComponent;
  let fixture: ComponentFixture<IndexCircleDivComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IndexCircleDivComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IndexCircleDivComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
