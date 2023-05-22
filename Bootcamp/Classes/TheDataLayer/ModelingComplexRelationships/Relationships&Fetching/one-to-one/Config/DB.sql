CREATE TABLE house_assignment(
  id INT AUTO_INCREMENT NOT NULL,
  house VARCHAR(255),
  wing VARCHAR(255),
  assigned_bed INT,
  PRIMARY KEY(id)
);

CREATE TABLE student (
  id BIGINT AUTO_INCREMENT NOT NULL,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  house_assignment_id INT,
  PRIMARY KEY(id),
  FOREIGN KEY (house_assignment_id) REFERENCES house_assignment(id)
);
