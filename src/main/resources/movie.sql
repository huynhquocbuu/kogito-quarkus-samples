CREATE TABLE movies (
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL);

INSERT INTO movies (title) VALUES('The Lord of the Rings');
INSERT INTO movies (title) VALUES('Harry Potter');