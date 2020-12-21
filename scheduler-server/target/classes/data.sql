INSERT INTO schedule_task (id, name, recurrency, code) VALUES (hibernate_sequence.nextval,'Task1','*/15 * * * * *','(1..10).each{ println "Hello World" sleep(50) }');
INSERT INTO schedule_task (id, name, recurrency, code) VALUES (hibernate_sequence.nextval,'Task2','*/10 * * * * *','(1..10).each{ println "Hello World" sleep(100) }');
