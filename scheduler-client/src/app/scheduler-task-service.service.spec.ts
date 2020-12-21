import { TestBed } from '@angular/core/testing';

import { SchedulerTaskServiceService } from './scheduler-task-service.service';

describe('SchedulerTaskServiceService', () => {
  let service: SchedulerTaskServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SchedulerTaskServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
