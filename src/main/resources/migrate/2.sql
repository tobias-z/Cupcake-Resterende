DROP TABLE IF EXISTS cupcakeTop;
CREATE TABLE cupcakeTop
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    pris DOUBLE NOT NULL,
    type VARCHAR(255) NOT NULL
);

UPDATE properties
SET value = '2'
WHERE name = "version";