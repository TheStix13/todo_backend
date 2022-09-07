DROP TABLE IF EXISTS task;
CREATE TABLE task(id serial PRIMARY KEY, content VARCHAR(255), completed boolean);