-- Richard Marquez : Revature Associate Workbook assignment

-- Part 1 : Working with an existing database

-- Section 2 : SQL Queries
-- 2.1 : SELECT
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;
-- 2.2 : ORDER BY
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;
-- 2.3 : INSERT INTO
INSERT INTO GENRE (GENREID, NAME) VALUES (26, 'Psychedelic funk');
INSERT INTO GENRE (GENREID, NAME) VALUES (27, 'Blues rock');
-- 2.4 : UPDATE
UPDATE CUSTOMER
  SET FIRSTNAME='Robert', LASTNAME='Walter'
  WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
UPDATE ARTIST
  SET NAME='CCR'
  WHERE NAME='Creedence Clearwater Revival';
-- 2.5 : LIKE
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
-- 2.6 : BETWEEN
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '1-JUN-03' AND '1-MAR-04';
-- 2.7 : DELETE
-- how to delete dependencies programmatically? cascades?
DELETE FROM INVOICELINE WHERE INVOICEID=50 OR INVOICEID=61 OR INVOICEID=116 OR INVOICEID=116 OR INVOICEID=245 OR INVOICEID=268 OR INVOICEID=290 OR INVOICEID=342;
DELETE FROM INVOICE WHERE CUSTOMERID=32;
DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

-- Section 3 : SQL Functions
-- 3.1 : System Defined Functions
CREATE OR REPLACE FUNCTION getTime
  RETURN DATE
IS
BEGIN
  RETURN (CURRENT_TIMESTAMP);
END;
/
SELECT getTime() FROM DUAL;
/
CREATE OR REPLACE FUNCTION getMediatypeLength(mId IN NUMBER)
  RETURN NUMBER
IS
  typeLen NUMBER;
BEGIN
  SELECT LENGTH(MEDIATYPE.NAME) INTO typeLen
    FROM MEDIATYPE
    WHERE MEDIATYPE.MEDIATYPEID=mId;
  RETURN typeLen;
END;
/
SELECT getMediaTypeLength(1) FROM DUAL;
/
-- 3.2 : System Defined Aggregate Functions
CREATE OR REPLACE FUNCTION getAvgInvoiceTotal
  RETURN NUMBER
IS
  invAvg NUMBER;
BEGIN
  SELECT AVG(TOTAL) INTO invAvg FROM INVOICE;
  RETURN invAvg;
END;
/
SELECT getAvgInvoiceTotal() FROM DUAL;
/
CREATE OR REPLACE FUNCTION getMostExpTrk
  RETURN VARCHAR2
IS
  maxPrice NUMBER;
  trkName VARCHAR2(200);
BEGIN
  SELECT MAX(UNITPRICE) INTO maxPrice FROM TRACK;
  
  SELECT NAME INTO trkName
    FROM (
      SELECT * FROM TRACK
        WHERE UNITPRICE=maxPrice
        ORDER BY NAME DESC
    ) WHERE ROWNUM=1;
  RETURN trkName;
END;
/
SELECT getMostExpTrk() FROM DUAL;
/
-- 3.3 : User Defined Scalar Functions
CREATE OR REPLACE FUNCTION avgInvLine
  RETURN NUMBER
IS
  invLineAvg NUMBER;
BEGIN
  SELECT AVG(UNITPRICE) INTO invLineAvg
    FROM INVOICELINE;
  RETURN invLineAvg;
END;
/
SELECT avgInvLine() FROM DUAL;
/
-- 3.4 : User Defined Table Valued Functions
CREATE TYPE empTabType IS OBJECT
("EMPLOYEEID" NUMBER, 
	"LASTNAME" VARCHAR2(20 BYTE), 
	"FIRSTNAME" VARCHAR2(20 BYTE), 
	"TITLE" VARCHAR2(30 BYTE), 
	"REPORTSTO" NUMBER, 
	"BIRTHDATE" DATE, 
	"HIREDATE" DATE, 
	"ADDRESS" VARCHAR2(70 BYTE), 
	"CITY" VARCHAR2(40 BYTE), 
	"STATE" VARCHAR2(40 BYTE), 
	"COUNTRY" VARCHAR2(40 BYTE), 
	"POSTALCODE" VARCHAR2(10 BYTE), 
	"PHONE" VARCHAR2(24 BYTE), 
	"FAX" VARCHAR2(24 BYTE), 
	"EMAIL" VARCHAR2(60 BYTE)
  );  
/
create type empTabTypeCol is table of empTabType;
/

CREATE OR REPLACE FUNCTION getEmplsBornAfter(year IN DATE) 
RETURN empTabTypeCol PIPELINED
IS
BEGIN
  FOR i IN (SELECT * FROM EMPLOYEE WHERE BIRTHDATE > year) LOOP
    PIPE ROW(empTabType(i.EMPLOYEEID, i.LASTNAME, i.FIRSTNAME, i.TITLE, i.REPORTSTO,
      i.BIRTHDATE, i.HIREDATE, i.ADDRESS, i.CITY, i.STATE, i.COUNTRY,
      i.POSTALCODE, i.PHONE, i.FAX, i.EMAIL));
  END LOOP;
  RETURN;
END;
/
SELECT * FROM table(getEmplsBornAfter('01-JAN-1968'));
/

-- Section 4 : Stored Procedures
-- 4.1 : Basic Stored Procedure
