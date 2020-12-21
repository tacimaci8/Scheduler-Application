package tamarazdravkovic.scheduler.repository;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tamarazdravkovic.scheduler.domain.ScheduleTask;

@Slf4j
@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class ScheduleTaskRepositoryTest {

		@Autowired
		ScheduleTaskRepository repository;
	
		@Test
		void saveTask() {
			ScheduleTask st1 = ScheduleTask.builder()
					.name("Task1")
					.recurrency("*/5 * * * * *")
					.code("(1..10).each{ println \"Hello World\" sleep(50) }").build();
			
			ScheduleTask st2 = ScheduleTask.builder()
					.name("Task2")
					.recurrency("*/10 * * * * *")
					.code("(1..10).each{ println \"Hello World\" sleep(100) }").build();
	
			repository.saveAll(Arrays.asList(st1, st2));
	
			Iterable<ScheduleTask> found = repository.findAll();
			log.debug("{}", found);
			assertThat(found).contains(st1, st2);
		}
}
