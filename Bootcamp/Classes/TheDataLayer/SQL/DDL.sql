--DROP SCHEMA IF EXISTS <TABLE_NAME>;
--CREATE SCHEMA  <TABLE_NAME>;
--USE <TABLE_NAME>;

CREATE TABLE course(
    course_code VARCHAR(6) NOT NULL,
    course_name VARCHAR(255),
    PRIMARY KEY (course_code)
 );

CREATE TABLE section(
    id VARCHAR(8) NOT NULL,
    course_code VARCHAR(6),
    room_num SMALLINT,
    instructor VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (course_code) REFERENCES course(course_code)
 );

CREATE TABLE grade(
    id INT NOT NULL AUTO_INCREMENT,
    student_name VARCHAR(255),
    section_id VARCHAR(8),
    score INT,
    PRIMARY KEY (id),
    FOREIGN KEY (section_id) REFERENCES section(id)
 );
