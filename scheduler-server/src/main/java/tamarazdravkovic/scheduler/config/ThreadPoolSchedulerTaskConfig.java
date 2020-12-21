package tamarazdravkovic.scheduler.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class ThreadPoolSchedulerTaskConfig {

	@Value("${scheduler.pool-size}")
	private int poolSize;
	
	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(this.poolSize);
		threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolSchedulerTask");
		return threadPoolTaskScheduler;
	}
}
