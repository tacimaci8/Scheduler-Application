package tamarazdravkovic.scheduler.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.ScheduledFuture;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import tamarazdravkovic.scheduler.domain.ScheduleTask;

@SpringBootTest
@ActiveProfiles("test")
public class SchedulerJobExecutorTest {

	@Autowired
	SchedulerJobExecutor executor;
	
	@Test
	void scheduleTask() {
		ScheduledFuture<?> future = executor.scheduleTask(ScheduleTask.builder()
				.name("Task1")
				.recurrency("*/5 * * * * *")
				.code("(1..10).each{ println \"Hello World\" sleep(50) }").build());
		
		boolean canceled = executor.cancelSheduledFuture(future);
		
		assertThat(canceled).isEqualTo(true);
	}
	
	@Test
	void scheduleTaskWithExceptionInScript() {
		ScheduledFuture<?> future = executor.scheduleTask(ScheduleTask.builder()
				.name("Task1")
				.recurrency("*/5 * * * * *")
				.code("fjdsfjsdj").build());
		
		boolean canceled = executor.cancelSheduledFuture(future);
		
		assertThat(canceled).isEqualTo(true);
	}
	
	@Test
	void scheduleTaskWithExceptionInCronExpression() {
		ScheduledFuture<?> future = executor.scheduleTask(ScheduleTask.builder()
				.name("Task1")
				.recurrency("*/5 rty * * * *")
				.code("(1..10).each{ println \"Hello World\" sleep(50) }").build());
		
		boolean canceled = executor.cancelSheduledFuture(future);
		
		assertThat(canceled).isEqualTo(true);
	}
	
}
