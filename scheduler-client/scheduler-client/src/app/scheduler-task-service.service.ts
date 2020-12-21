import { SchedulerTask } from './scheduler-task';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SchedulerTaskServiceService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:9090/tasks';
  }

  public findAll(): Observable<SchedulerTask[]> {
    return this.http.get<SchedulerTask[]>(this.usersUrl);
  }

  public save(user: SchedulerTask) {
    return this.http.post<SchedulerTask>(this.usersUrl, user);
  }

  public get(id : number): Observable<SchedulerTask> {
    return this.http.get<SchedulerTask>(this.usersUrl.concat(`/`,`${id}`));
  }

  public update(id : number, data : any): Observable<SchedulerTask> {
    return this.http.put<SchedulerTask>(this.usersUrl.concat(`/`,`${id}`), data);
  }

  public delete(id : number): Observable<SchedulerTask> {
    return this.http.delete<SchedulerTask>(this.usersUrl.concat(`/`,`${id}`));
  }
}
