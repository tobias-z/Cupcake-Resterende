DROP TABLE IF EXISTS cupcake;
CREATE TABLE cupcake
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    cupcakeBottom INT NOT NULL,
    cupcakeTop    INT NOT NULL,
    pris          DOUBLE NOT NULL,
    FOREIGN KEY (cupcakeBottom) REFERENCES cupcakeBottom(id),
    FOREIGN KEY (cupcakeTop) REFERENCES cupcakeTop(id)
);

UPDATE properties
SET value = '4'
WHERE name = "version";