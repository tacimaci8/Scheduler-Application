create table schedule_task(
	id default hibernate_sequence.nextval not null primary key, 
	name varchar(250) not null,
	recurrency varchar(30) not null,
	code clob not null);
	