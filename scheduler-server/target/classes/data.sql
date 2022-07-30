INSERT INTO schedule_task (name, recurrency, code) VALUES ('Task1','*/15 * * * * *','(1..10).each{ println "Hello World" sleep(50) }');
INSERT INTO schedule_task (name, recurrency, code) VALUES ('Task2','*/10 * * * * *','(1..10).each{ println "Hello World" sleep(100) }');
