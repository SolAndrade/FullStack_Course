DROP SCHEMA IF EXISTS blog;
CREATE SCHEMA blog;
USE blog;

CREATE TABLE author (
	author_id INT NOT NULL AUTO_INCREMENT,
    author_name VARCHAR(255),
    PRIMARY KEY (author_id)
);

CREATE TABLE blog_post (
	blog_post_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255),
    word_count INT,
    views INT,
    PRIMARY KEY (blog_post_id),
    author_id INT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES author(author_id)
);

INSERT INTO author (author_name) VALUES
	('Maria Charlotte'),
    ('Juan Perez'),
    ('Gemma Alcocer');
    
INSERT INTO blog_post (title, word_count, views, author_id) VALUES
	('Best Paint Colors', 814, 14, 1),
    ('Hot Accesories', 986, 105, 1),
    ('Mixing Textures', 765, 22, 1),
    ('Homemade Art Hacks', 1002, 193, 1),
    ('Small Space Decorating Tips', 1146, 221, 2),
    ('Kitchen Refresh', 1242, 307, 2),
    ('RefinisingWood Floors', 1571, 7542, 3);
    