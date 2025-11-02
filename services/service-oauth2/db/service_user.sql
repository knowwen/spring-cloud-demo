
CREATE DATABASE service_user;

USE service_user;

CREATE TABLE t_user(
id BIGINT PRIMARY KEY,
user_name VARCHAR(128),
PASSWORD VARCHAR(128)
);

CREATE TABLE t_authorities (
    user_id BIGINT NOT NULL,
    authority VARCHAR(50) NOT NULL
);