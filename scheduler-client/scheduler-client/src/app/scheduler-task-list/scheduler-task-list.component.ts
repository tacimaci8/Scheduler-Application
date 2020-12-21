import { Router } from '@angular/router';
import { SchedulerTaskServiceService } from './../scheduler-task-service.service';
import { SchedulerTask } from './../scheduler-task';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-scheduler-task-list',
  templateUrl: './scheduler-task-list.component.html',
  styleUrls: ['./scheduler-task-list.component.css']
})
export class SchedulerTaskListComponent implements OnInit {

  tasks: SchedulerTask[];

  constructor(private taskService: SchedulerTaskServiceService,
    private router: Router) {
  }

  ngOnInit() {
    this.taskService.findAll().subscribe(data => {
      this.tasks = data;
    });
  }

  deleteTask(task : SchedulerTask, id : number){
    this.taskService.delete(id)
      .subscribe(data => {
        this.tasks.splice(this.tasks.indexOf(task), 1)
      });
  }

  updateTask(id: number){
    this.router.navigate(['update', id]);
  }

}
