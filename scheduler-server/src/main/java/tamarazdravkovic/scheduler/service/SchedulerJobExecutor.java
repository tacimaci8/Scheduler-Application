package tamarazdravkovic.scheduler.service;

import java.util.concurrent.ScheduledFuture;

import tamarazdravkovic.scheduler.domain.ScheduleTask;

public interface SchedulerJobExecutor {

	public ScheduledFuture<?> scheduleTask(ScheduleTask task);
	
	public boolean cancelSheduledFuture(ScheduledFuture<?> future);
	
}
