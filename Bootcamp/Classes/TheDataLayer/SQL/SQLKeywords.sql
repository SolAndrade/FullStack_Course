--Display all the grades where the section id starts with CS101.
SELECT *
FROM grade
WHERE section_id
LIKE 'CS101%';

--Display all grades where the grade is between 85 and 95.
SELECT *
FROM grade
WHERE score
BETWEEN 85 AND 95;

--Display all the grades where the student name starts with M and the grade is higher than 95.
SELECT *
FROM grade
WHERE student_name
LIKE 'M%' OR score > 95;

--Display the grades sorted by descending order of the grades
SELECT *
FROM grade
ORDER BY
score DESC;

--Display the names of students that have grades without any duplicates.
SELECT DISTINCT student_name
FROM grade;

--Display the combination of student names and scores without any duplicates.
-- contrast previous query with below --
SELECT DISTINCT student_name, score
FROM grade;
