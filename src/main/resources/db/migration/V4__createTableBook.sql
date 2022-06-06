CREATE TABLE BOOK(
id bigserial NOT NULL,
name varchar(100) NOT NULL,
author_id bigserial NOT NULL,
PRIMARY KEY (id));