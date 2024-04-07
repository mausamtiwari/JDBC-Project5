CREATE TABLE userdetail
(
    email           VARCHAR(255) PRIMARY KEY UNIQUE NOT NULL,
    firstname       VARCHAR(255)                    NOT NULL,
    lastname        VARCHAR(255)                    NOT NULL,
    accountUsername VARCHAR(255),
    FOREIGN KEY (accountUsername) REFERENCES account (username)
);


INSERT INTO userdetail (email, firstname, lastname, accountUsername)
VALUES ('john@intec.com', 'John', 'Doe', 'john_doe'),
       ('bob@intec.com', 'Bob', 'Psy', 'bob_psy'),
       ('smith@intec.com', 'Smith', 'Will', 'smith_will'),
       ('tom@intec.com', 'Tom', 'Holland', 'tom_holland'),
       ('richard@intec.com', 'Richard', 'Unis', 'richard_unis');


drop table userdetail