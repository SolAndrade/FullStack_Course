SELECT student_name, score, instructor
FROM grade
INNER JOIN section
ON grade.section_id = section.id;

SELECT student_name, score, instructor
FROM section
LEFT JOIN grade
ON section.id = grade.section_id ;

