SET SCHEMA TWO;
DELETE FROM LOGIN WHERE username IS NOT NULL;
DROP TABLE LOGIN;
DELETE FROM CLIENTPROFILE WHERE firstname IS NOT NULL;
DROP TABLE CLIENTPROFILE;
DELETE FROM ITEM WHERE name IS NOT NULL;
DROP TABLE ITEM;
DELETE FROM ORDERS WHERE orderID IS NOT NULL;
DROP TABLE ORDERS;
DROP SCHEMA TWO;