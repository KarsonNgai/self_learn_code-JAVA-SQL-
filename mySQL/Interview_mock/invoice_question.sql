-- this sql test the understanding of UNION operator
use invoice_db;

CREATE TABLE CITY(
	ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	CITY_NAME VARCHAR(50)
);

CREATE TABLE CUSTOMER (
  ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  CUSTOMER_NAME VARCHAR(255),
  CITY_ID INTEGER, -- fk
  CUSTOMER_ADDRESS VARCHAR(255),
  CONTACT_PERSON VARCHAR(255) NOT NULL,
  EMAIL VARCHAR(128),
  PHONE VARCHAR(128),
  FOREIGN KEY(CITY_ID) references CITY(ID)
);

CREATE TABLE PRODUCT (
  ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  SKU VARCHAR(32),
  PRODUCT_NAME VARCHAR(128),
  PRODUCT_DESCRIPTION VARCHAR(100),
  CURRENT_PRICE DECIMAL(8,2),
  QUANTITY_IN_STOCK INTEGER
);

CREATE TABLE INVOICE (
  ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  INVOICE_NUMBER VARCHAR(32),
  CUSTOMER_ID INTEGER,
  USER_ACCOUNT_ID VARCHAR(100),
  TOTAL_PRICE DECIMAL(8,2),
  TIME_ISSUED DATETIME,
  TIME_DUE DATETIME,
  TIME_PAID DATETIME,
  TIME_CANCELED DATETIME,
  TIME_REFUNDED DATETIME,
  foreign key (CUSTOMER_ID) references CUSTOMER(ID) 
);

CREATE TABLE INVOICE_ITEM (
  ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  INVOICE_ID INTEGER,
  PRODUCT_ID INTEGER,
  QUANTITY INTEGER,
  PRICE DECIMAL(8,2),
  LINE_TOTAL_PRICE DECIMAL(8,2),
  foreign key(INVOICE_ID) references INVOICE(ID),
  foreign key(PRODUCT_ID) references PRODUCT(ID)
  
);


INSERT INTO CITY(ID, CITY_NAME) VALUES(1, 'George Town'), (2, 'Kuala Lumpur'), (3,'Ipoh'),(4,'Kuching'),(5,'Johor Bahru'),
								(6,'Putrajaya'),(7,'Kota Kinabalu'),(8,'Shah Alam');

INSERT INTO CUSTOMER VALUES
(1, 'Drogerie Wien', 1, 'Deckergasse 15A', 'Emil Steinbach', 'abc@gmail.com', 123455678);
INSERT INTO CUSTOMER VALUES
(2, 'John', 4, 'Deckergasse 1A', '9upper', 'abck@gmail.com', 12345567);
INSERT INTO CUSTOMER VALUES
(3, 'Mary', 8, 'Deckergasse 18A', '9upper', 'abcd@gmail.com', 1234556789);

INSERT INTO PRODUCT VALUES
(1, '330120', '9UP PRODUCT', 'COMPLETELY 9UP', 60, 122);
INSERT INTO PRODUCT VALUES
(2, '330121', '9UPPER PRODUCT', 'COMPLETELY 9UPPER', 50, 50);
INSERT INTO PRODUCT VALUES
(3, '330122', '9UPPER PRODUCTS', 'SUPER 9UPPER', 40, 600);
INSERT INTO PRODUCT VALUES
(4, '330123', '9UPPER PRODUCTSS', 'SUPER COMPLETELY 9UPPER', 30, 500);

INSERT INTO INVOICE VALUES
(1, 123456780, 2, 41, 1423, NULL, NULL, NULL, NULL, NULL);
INSERT INTO INVOICE VALUES
(2, 123456780, 3, 42, 1400, NULL, NULL, NULL, NULL, NULL);
INSERT INTO INVOICE VALUES
(3, 123456780, 2, 43, 17000, NULL, NULL, NULL, NULL, NULL);

INSERT INTO INVOICE_ITEM VALUES
(1, 1, 1, 40, 23, 920);
INSERT INTO INVOICE_ITEM VALUES
(2, 1, 2, 4, 20, 80);
INSERT INTO INVOICE_ITEM VALUES
(3, 1, 3, 4, 10, 40);
INSERT INTO INVOICE_ITEM VALUES
(4, 1, 2, 4, 30, 120);

select * FROM invoice_item as i_t
right join product as p on i_t.product_id = p.id
right join invoice as i on i_t.invoice_id = i.id
right join customer as c on i.customer_id = c.id
where invoice_id is null and i_t.id is null
;

-- question 1
select 'customer',c.id, c.customer_name from customer as c 
left join invoice as i 
on c.id = i.customer_id 
where i.id is null
UNION
select 'product',p.id,p.product_name from product as p 
left join invoice_item as i_t
on p.id = i_t.product_id
where i_t.id is null;
