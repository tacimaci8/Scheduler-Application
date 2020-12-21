import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedulerTaskFormComponent } from './scheduler-task-form.component';

describe('SchedulerTaskFormComponent', () => {
  let component: SchedulerTaskFormComponent;
  let fixture: ComponentFixture<SchedulerTaskFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchedulerTaskFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchedulerTaskFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
