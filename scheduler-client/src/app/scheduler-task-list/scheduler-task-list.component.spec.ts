import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedulerTaskListComponent } from './scheduler-task-list.component';

describe('SchedulerTaskListComponent', () => {
  let component: SchedulerTaskListComponent;
  let fixture: ComponentFixture<SchedulerTaskListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchedulerTaskListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchedulerTaskListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
