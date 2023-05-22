 CREATE TABLE customer(
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    street_address VARCHAR(255),
    city VARCHAR (255),
    postal_code VARCHAR(10),
    perm_street VARCHAR(255),
    perm_city VARCHAR(255),
    perm_postal VARCHAR(10),
    PRIMARY KEY (id)
 );
