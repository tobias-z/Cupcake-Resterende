DROP TABLE IF EXISTS cupcake;
CREATE TABLE cupcake
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    orderid       INT NOT NULL,
    cupcakeBottom INT NOT NULL,
    cupcakeTop    INT NOT NULL,
    cupcakeBottomType VARCHAR(50),
    cupcakeTopType VARCHAR(50),
    pris          DOUBLE NOT NULL,
    antal         INT NOT NULL,
    FOREIGN KEY (cupcakeBottom) REFERENCES cupcakeBottom(id),
    FOREIGN KEY (cupcakeTop) REFERENCES cupcakeTop(id)
);

UPDATE properties
SET value = '4'
WHERE name = "version";