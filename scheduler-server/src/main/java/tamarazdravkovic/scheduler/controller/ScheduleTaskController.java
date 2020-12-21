package tamarazdravkovic.scheduler.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tamarazdravkovic.scheduler.domain.ScheduleTask;
import tamarazdravkovic.scheduler.repository.ScheduleTaskRepository;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScheduleTaskController {

	@Autowired
	private ScheduleTaskRepository repository;

	@GetMapping("/tasks")
	public ResponseEntity<List<ScheduleTask>> getAllScheduleTasks() {
		try {
			List<ScheduleTask> tasks = StreamSupport.stream(repository.findAll().spliterator(), false)
					.collect(Collectors.toList());
			return new ResponseEntity<>(tasks, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error occurred when getting all tasks");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<ScheduleTask> getScheduleTaskById(@PathVariable("id") long id) {
		Optional<ScheduleTask> task = repository.findById(id);
		if (task.isPresent()) {
			return new ResponseEntity<>(task.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tasks")
	public ResponseEntity<ScheduleTask> createScheduleTask(@Valid @RequestBody ScheduleTask task) {
		try {
			ScheduleTask _task = repository.save(ScheduleTask.builder().name(task.getName())
					.recurrency(task.getRecurrency()).code(task.getCode()).build());
			return new ResponseEntity<>(_task, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tasks/{id}")
	public ResponseEntity<ScheduleTask> updateScheduleTask(@PathVariable("id") long id, @Valid @RequestBody ScheduleTask task) {
		Optional<ScheduleTask> newTask = repository.findById(id);

		if (newTask.isPresent()) {
			ScheduleTask _task = newTask.get();
			_task.setName(task.getName());
			_task.setRecurrency(task.getRecurrency());
			_task.setCode(task.getCode());
			return new ResponseEntity<>(repository.save(_task), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<HttpStatus> deleteScheduleTask(@PathVariable("id") long id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
