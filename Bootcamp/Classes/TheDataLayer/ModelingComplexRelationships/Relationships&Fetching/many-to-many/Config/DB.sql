CREATE TABLE student (
id INT AUTO_INCREMENT NOT NULL,
first_name VARCHAR(255),
last_name VARCHAR(255),
house_assignment_id INT UNIQUE,
PRIMARY KEY(id),
FOREIGN KEY (house_assignment_id) REFERENCES house_assignment(id)
);
 
CREATE TABLE spell(
id INT AUTO_INCREMENT NOT NULL,
name VARCHAR(255),
level VARCHAR(255),
PRIMARY KEY(id)
);
 
CREATE TABLE students_casts_spells(
student_id INT,
spell_id INT,
FOREIGN KEY (student_id) REFERENCES student(id),
FOREIGN KEY (spell_id) REFERENCES spell(id)
);