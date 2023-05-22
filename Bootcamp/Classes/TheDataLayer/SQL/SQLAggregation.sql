INSERT INTO course (course_code, course_name) VALUES
('CS101', 'Intro to Java'),
('CS103',  'Databases');

INSERT INTO section (id, course_code, room_num, instructor) VALUES
('CS101-A', 'CS101', 1802, 'Balderez'),
('CS101-B', 'CS101',  1650, 'Su'),
('CS103-A', 'CS103',  1200, 'Rojas'),
('CS103-B', 'CS103',  1208, 'Tonno');

INSERT INTO grade (student_name, section_id, score) VALUES
('Maya Charlotte', 'CS101-A', 98),
('James Fields', 'CS101-A', 82),
('Michael Alcocer', 'CS101-B', 65),
('Maya Charlotte', 'CS103-A', 89),
('Tomas Lacroix', 'CS101-A', 99),
('Sara Bisat', 'CS101-A', 87),
('James Fields', 'CS101-B', 46),
('Helena Sepulvida', 'CS103-A', 72);

--Display the count of grades for each section
SELECT section_id, COUNT(*) FROM grade GROUP BY section_id;

--Display the average grade for each section
SELECT section_id, AVG(score) FROM grade GROUP BY section_id;

--Display the average grade for each section where it is higher than 80
SELECT section_id, AVG(score) FROM grade GROUP BY section_id HAVING AVG(score) > 80;

--Display the sum of grades, the count of grades, and the average grade for the section 'CS101-A'
SELECT section_id, SUM(score), COUNT(*), AVG(score) FROM grade WHERE section_id = 'CS101-A' GROUP BY section_id;

--Display the Highest grade for the student Maya Charlotte
SELECT student_name, section_id, MAX(score) FROM grade WHERE student_name = 'Maya Charlotte';

--Display the Lowest grade for the student Maya Charlotte
SELECT student_name, section_id, MIN(score) FROM grade WHERE student_name = 'Maya Charlotte';
