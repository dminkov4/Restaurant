CREATE TABLE IF NOT EXISTS product
(
    id SERIAL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL,
    price DECIMAL(4,2) NOT NULL,
    is_deleted bool DEFAULT FALSE,
    PRIMARY KEY (id)
);

SELECT product.name, product_category.name
FROM product
INNER JOIN product_category
ON product.id = product_category.id;

CREATE TABLE product_category
(
    id SERIAL PRIMARY KEY
);

ALTER TABLE product
ADD FOREIGN KEY (id) REFERENCES product_category(id);

