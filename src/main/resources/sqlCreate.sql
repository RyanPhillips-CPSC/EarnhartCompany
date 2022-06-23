CREATE SCHEMA TWO;
SET SCHEMA TWO;
CREATE TABLE LOGIN (
    username VARCHAR(100),
    password VARCHAR(100)
);
INSERT INTO LOGIN VALUES ('jearnhartLLC', '137562088');
CREATE TABLE CLIENTPROFILE (
    firstname VARCHAR(100),
    lastname VARCHAR(100),
    phone VARCHAR(100),
    email VARCHAR(100),
    address VARCHAR(100),
    consultation LONGTEXT,
    clientID LONGTEXT
);
INSERT INTO CLIENTPROFILE VALUES ('Ryan','Phillips','(540)-903-0781','ryanphillipsmusic41@gmail.com','7405 Stonegate Estates Dr', null, '0');
CREATE TABLE ITEM (
    name VARCHAR(200),
    price DOUBLE,
    clientID LONGTEXT,
    orderID LONGTEXT
);
CREATE TABLE ORDERS (
    orderID LONGTEXT,
    price DOUBLE,
    invoiceSent BOOLEAN,
    invoicePaid BOOLEAN,
    shipped BOOLEAN,
    dateOfShipment VARCHAR(100),
    refunded BOOLEAN,
    dateOfRefund VARCHAR(100),
    notes LONGTEXT,
    acFileLocation VARCHAR(200)
);