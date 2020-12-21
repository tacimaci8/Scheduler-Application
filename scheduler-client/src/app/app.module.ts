import { SchedulerTaskServiceService } from './scheduler-task-service.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SchedulerTaskListComponent } from './scheduler-task-list/scheduler-task-list.component';
import { SchedulerTaskFormComponent } from './scheduler-task-form/scheduler-task-form.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UpdateSchedulerTaskComponent } from './update-scheduler-task/update-scheduler-task.component';

@NgModule({
  declarations: [
    AppComponent,
    SchedulerTaskListComponent,
    SchedulerTaskFormComponent,
    UpdateSchedulerTaskComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [SchedulerTaskServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
