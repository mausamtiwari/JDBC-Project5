CREATE TABLE account
(
    userName VARCHAR(255) PRIMARY KEY NOT NULL UNIQUE,
    password VARCHAR(255)             NOT NULL
);

INSERT INTO account (username, password)
VALUES ('john_doe', 'doe123'),
       ('bob_psy', 'psy456'),
       ('smith_will', 'will789'),
       ('tom_holland', 'holland012'),
       ('richard_unis', 'unis345');

drop table account