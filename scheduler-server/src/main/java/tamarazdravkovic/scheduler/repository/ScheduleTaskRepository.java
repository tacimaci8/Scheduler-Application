package tamarazdravkovic.scheduler.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import tamarazdravkovic.scheduler.domain.ScheduleTask;

@Repository
public interface ScheduleTaskRepository extends PagingAndSortingRepository<ScheduleTask, Long> {

}
