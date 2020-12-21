package tamarazdravkovic.scheduler.service;

import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import groovy.lang.GroovyShell;
import groovy.lang.MissingMethodException;
import groovy.lang.MissingPropertyException;
import lombok.extern.slf4j.Slf4j;
import tamarazdravkovic.scheduler.domain.ScheduleTask;

@Slf4j
@Service
public class SchedulerJobExecutorImpl implements SchedulerJobExecutor {

	@Autowired
	private ThreadPoolTaskScheduler taskScheduler;

	@Override
	public ScheduledFuture<?> scheduleTask(ScheduleTask task) {
		ScheduledFuture<?> future = null;

		try {
			future = taskScheduler.schedule(new Runnable() {
				@Override
				public void run() {
					try {
						new GroovyShell().evaluate(task.getCode());
						log.info(new StringBuilder().append("Schedule Task with name ").append(task.getName())
								.append(" and recurrency ").append(task.getRecurrency()).append(", on thread ")
								.append(Thread.currentThread().getName()).append(" execute code ")
								.append(task.getCode()).append(" in Groovy Schell.").toString());
					} catch (MissingMethodException e) {
						log.error("Bad method in Groovy script");
					} catch (MissingPropertyException e) {
						log.error("Bad property in Groovy script");
					}
				}
			}, new CronTrigger(task.getRecurrency()));
		} catch (IllegalArgumentException e) {
			log.error("Bad cron expression!");
		}

		return future;
	}

	@Override
	public boolean cancelSheduledFuture(ScheduledFuture<?> future) {
		if(future == null) return true;
		return future.cancel(true);
	}
	
	

}
