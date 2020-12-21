import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSchedulerTaskComponent } from './update-scheduler-task.component';

describe('UpdateSchedulerTaskComponent', () => {
  let component: UpdateSchedulerTaskComponent;
  let fixture: ComponentFixture<UpdateSchedulerTaskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateSchedulerTaskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateSchedulerTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
