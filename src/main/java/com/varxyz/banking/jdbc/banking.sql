select * from customer;
select * from account;

delete from customer where cid=1018;

SELECT * FROM Customer WHERE email = "example@example" AND passwd = "1122";

CREATE TABLE Customer(
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	email		VARCHAR(20)		NOT NULL,
	passwd		VARCHAR(20)		NOT NULL,
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL, -- 123456-7890123
	phone		VARCHAR(13)		NOT NULL, -- 010-1234-5678
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP 
)AUTO_INCREMENT = 1001;

SELECT * FROM Customer;


DELETE FROM Customer WHERE cid=1002;

INSERT INTO Customer (email, passwd, name, ssn, phone)
VALUES ("ee", "123", "ee", "ee", "ee");

CREATE TABLE Account(
	aid				BIGINT		PRIMARY KEY AUTO_INCREMENT,
	customerId		BIGINT		NOT NULL,
	accountNum		CHAR(11)	NOT NULL,	-- 000-00-0000
	accType			CHAR(1)		NOT NULL DEFAULT 'S',
	balance			DOUBLE		NOT NULL DEFAULT 0,
	interestRate	DOUBLE		NOT NULL DEFAULT 0.0,
	overAmount		DOUBLE		NOT NULL DEFAULT 0.0,
	regDate			TIMESTAMP	NOT NULL DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT Account_customerId_FK
		FOREIGN KEY(customerId) REFERENCES Customer(cid)
)AUTO_INCREMENT = 3001;

DROP TABLE Account;

SELECT * FROM Account;

delete from customer;

select * from account where customerId=1031;

UPDATE Account SET balance=2000 WHERE aid=3007;

SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overAmount, a.accType, c.name, c.ssn, c.phone, a.regDate FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = '800111-1234567';
