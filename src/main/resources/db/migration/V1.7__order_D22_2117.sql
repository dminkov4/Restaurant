CREATE TABLE IF NOT EXISTS order
(
    id SERIAL,
    orderTime TIMESTAMP DEFAULT NOW(),

    PRIMARY KEY (id),
    FOREIGN KEY (status_type)
        REFERENCES order_status(id),
);

SELECT *
FROM product
LEFT JOIN order ON (order.product_id = product.id)