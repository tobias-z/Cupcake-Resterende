DROP TABLE IF EXISTS orders;
CREATE TABLE orders
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    userid        INT NOT NULL,
    cupcakeid     varchar(225) DEFAULT NULL,
    price         DOUBLE DEFAULT 0,
    paydate       TIMESTAMP NOT NULL,
    paid          BOOLEAN DEFAULT FALSE
);

UPDATE properties
SET value = '5'
WHERE name = "version";