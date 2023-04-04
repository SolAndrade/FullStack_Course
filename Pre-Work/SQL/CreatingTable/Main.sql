CREATE TABLE rating (
    id INT,
    app_name VARCHAR(255),
    app_size BIGINT,
    price DECIMAL(5,2),
    total_ratings DECIMAL(2,1),
    genre VARCHAR(50)
);

CREATE TABLE car (
    vin BIGINT,
    make VARCHAR(255),
    model VARCHAR(255),
    color VARCHAR(255),
    vin INT,
    release_year YEAR
);
