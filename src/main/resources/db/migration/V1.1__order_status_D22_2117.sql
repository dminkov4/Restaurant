CREATE TYPE status_type AS ENUM ('ACTIVE', 'COMPLETE');

CREATE TABLE IF NOT EXISTS order_status
(
    id SERIAL,
    order_status_type status_type,
    PRIMARY KEY (id)
);

INSERT INTO order_status(id, order_status_type) VALUES (1, 'ACTIVE');
INSERT INTO order_status(id, order_status_type) VALUES (2, 'COMPLETE');