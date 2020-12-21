import { SchedulerTaskServiceService } from './../scheduler-task-service.service';
import { SchedulerTask } from './../scheduler-task';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-scheduler-task-form',
  templateUrl: './scheduler-task-form.component.html',
  styleUrls: ['./scheduler-task-form.component.css']
})
export class SchedulerTaskFormComponent {

  task: SchedulerTask;

  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private taskService: SchedulerTaskServiceService) {
    this.task = new SchedulerTask();
  }

  onSubmit() {
    this.taskService.save(this.task).subscribe(result => this.gotoTaskList());
  }

  gotoTaskList() {
    this.router.navigate(['/tasks']);
  }

}
