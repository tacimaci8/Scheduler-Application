package tamarazdravkovic.scheduler.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "schedule_task")
public class ScheduleTask {

	@Id
	@Min(1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Recurrency is mandatory")
	private String recurrency;

	@Lob
	@NotBlank(message = "Code is mandatory")
	private String code;

}
