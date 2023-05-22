CREATE TABLE course(
    course_code VARCHAR(6),
    course_name VARCHAR(255),
    PRIMARY KEY (course_code)
);

CREATE TABLE section(
    id VARCHAR(8) NOT NULL,
    course_code VARCHAR(6),
    room_num SMALLINT,
    instructor VARCHAR(255),
    section_type VARCHAR(255),
    capacity INT,
    enrolled INT,
    lab_room_num INT,
    credits INT,
    PRIMARY KEY (id),
    FOREIGN KEY (course_code) REFERENCES course(course_code)
 );
