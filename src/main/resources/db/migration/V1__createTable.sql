CREATE TABLE REGISTRATION_USERS(
id bigserial NOT NULL,
username varchar(100) NOT NULL,
first_name varchar(50) NOT NULL,
last_name varchar(50) NOT NULL,
email varchar(50) NOT NULL,
PRIMARY KEY (id));