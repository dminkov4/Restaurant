CREATE TABLE IF NOT EXISTS product_category
(
    id SERIAL,
    name VARCHAR(100) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);