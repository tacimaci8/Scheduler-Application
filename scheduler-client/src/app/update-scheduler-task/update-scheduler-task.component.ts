import { SchedulerTaskServiceService } from './../scheduler-task-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, TestabilityRegistry } from '@angular/core';
import { SchedulerTask } from '../scheduler-task';

@Component({
  selector: 'app-update-scheduler-task',
  templateUrl: './update-scheduler-task.component.html',
  styleUrls: ['./update-scheduler-task.component.css']
})
export class UpdateSchedulerTaskComponent implements OnInit {

  id: number;
  task: SchedulerTask;

  constructor(private route: ActivatedRoute, 
    private router: Router, 
      private taskService: SchedulerTaskServiceService) { }

  ngOnInit(): void {
    this.task = new SchedulerTask();
    this.id = this.route.snapshot.params['id'];
    this.taskService.get(this.id)
      .subscribe(data => this.task = data);
  }

  updateTask(){
    this.taskService.update(this.id, this.task)
      .subscribe(data => {
        this.task = new SchedulerTask();
        this.goToList();
      });
  }

  goToList(){
    this.router.navigate(['/tasks']);
  }

  onSubmit(){
    this.updateTask();
  }

}
