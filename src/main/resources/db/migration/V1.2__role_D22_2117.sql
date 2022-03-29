CREATE TYPE role_type AS ENUM ('ADMIN', 'USER');

CREATE TABLE IF NOT EXISTS role
(
    id SERIAL,
    role_name role_type,
    PRIMARY KEY (id)
);

INSERT INTO role(id, role_name) VALUES (1, 'ADMIN');
INSERT INTO role(id, role_name) VALUES (2, 'USER');