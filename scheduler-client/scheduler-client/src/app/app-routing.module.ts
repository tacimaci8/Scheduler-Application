import { UpdateSchedulerTaskComponent } from './update-scheduler-task/update-scheduler-task.component';
import { SchedulerTaskFormComponent } from './scheduler-task-form/scheduler-task-form.component';
import { SchedulerTaskListComponent } from './scheduler-task-list/scheduler-task-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  { path: '', redirectTo: 'tasks', pathMatch: 'full' },
  { path: 'tasks', component: SchedulerTaskListComponent },
  { path: 'create', component: SchedulerTaskFormComponent },
  { path: 'update/:id', component: UpdateSchedulerTaskComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
