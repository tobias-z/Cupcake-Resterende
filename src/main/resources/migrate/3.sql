DROP TABLE IF EXISTS cupcakeBottom;
CREATE TABLE cupcakeBottom
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    pris DOUBLE       NOT NULL,
    type VARCHAR(255) NOT NULL
);

UPDATE properties
SET value = '3'
WHERE name = "version";