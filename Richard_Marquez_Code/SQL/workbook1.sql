-- Richard Marquez : Revature Associate Workbook assignment

-- Part 1 : Working with an existing database

-- Section 2 : SQL Queries
-- 2.1 : SELECT
SELECT *
FROM EMPLOYEE;
SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
-- 2.2 : ORDER BY
SELECT *
FROM ALBUM
ORDER BY TITLE DESC;
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY ASC;
-- 2.3 : INSERT INTO
INSERT INTO GENRE (GENREID, NAME) VALUES (26, 'Psychedelic funk');
INSERT INTO GENRE (GENREID, NAME) VALUES (27, 'Blues rock');
-- 2.4 : UPDATE
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
-- 2.5 : LIKE
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
-- 2.6 : BETWEEN
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '1-JUN-03' AND '1-MAR-04';
-- 2.7 : DELETE
-- how to delete dependencies programmatically? cascades?
DELETE FROM INVOICELINE
WHERE INVOICEID = 50 OR INVOICEID = 61 OR INVOICEID = 116 OR INVOICEID = 116 OR INVOICEID = 245 OR INVOICEID = 268 OR
      INVOICEID = 290 OR INVOICEID = 342;
DELETE FROM INVOICE
WHERE CUSTOMERID = 32;
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- Section 3 : SQL Functions
-- 3.1 : System Defined Functions
CREATE OR REPLACE FUNCTION getTime
  RETURN DATE
IS
  BEGIN
    RETURN (CURRENT_TIMESTAMP);
  END;
/
SELECT getTime()
FROM DUAL;

/
CREATE OR REPLACE FUNCTION getMediatypeLength(mId IN NUMBER)
  RETURN NUMBER
IS
  typeLen NUMBER;
  BEGIN
    SELECT LENGTH(MEDIATYPE.NAME)
    INTO typeLen
    FROM MEDIATYPE
    WHERE MEDIATYPE.MEDIATYPEID = mId;
    RETURN typeLen;
  END;
/
SELECT getMediaTypeLength(1)
FROM DUAL;

/
-- 3.2 : System Defined Aggregate Functions
CREATE OR REPLACE FUNCTION getAvgInvoiceTotal
  RETURN NUMBER
IS
  invAvg NUMBER;
  BEGIN
    SELECT AVG(TOTAL)
    INTO invAvg
    FROM INVOICE;
    RETURN invAvg;
  END;
/
SELECT getAvgInvoiceTotal()
FROM DUAL;

/
CREATE OR REPLACE FUNCTION getMostExpTrk
  RETURN VARCHAR2
IS
  maxPrice NUMBER;
  trkName  VARCHAR2(200);
  BEGIN
    SELECT MAX(UNITPRICE)
    INTO maxPrice
    FROM TRACK;

    SELECT NAME
    INTO trkName
    FROM (
      SELECT *
      FROM TRACK
      WHERE UNITPRICE = maxPrice
      ORDER BY NAME DESC
    )
    WHERE ROWNUM = 1;
    RETURN trkName;
  END;
/
SELECT getMostExpTrk()
FROM DUAL;

/
-- 3.3 : User Defined Scalar Functions
CREATE OR REPLACE FUNCTION avgInvLine
  RETURN NUMBER
IS
  invLineAvg NUMBER;
  BEGIN
    SELECT AVG(UNITPRICE)
    INTO invLineAvg
    FROM INVOICELINE;
    RETURN invLineAvg;
  END;
/
SELECT avgInvLine()
FROM DUAL;

/
-- 3.4 : User Defined Table Valued Functions
CREATE TYPE EMPTABTYPE IS OBJECT
("EMPLOYEEID" NUMBER,
 "LASTNAME"   VARCHAR2(20 BYTE),
 "FIRSTNAME"  VARCHAR2(20 BYTE),
 "TITLE"      VARCHAR2(30 BYTE),
 "REPORTSTO"  NUMBER,
 "BIRTHDATE"  DATE,
 "HIREDATE"   DATE,
 "ADDRESS"    VARCHAR2(70 BYTE),
 "CITY"       VARCHAR2(40 BYTE),
 "STATE"      VARCHAR2(40 BYTE),
 "COUNTRY"    VARCHAR2(40 BYTE),
 "POSTALCODE" VARCHAR2(10 BYTE),
 "PHONE"      VARCHAR2(24 BYTE),
 "FAX"        VARCHAR2(24 BYTE),
 "EMAIL"      VARCHAR2(60 BYTE)
);

/
CREATE TYPE EMPTABTYPECOL IS TABLE OF EMPTABTYPE;

/

CREATE OR REPLACE FUNCTION getEmplsBornAfter(year IN DATE)
  RETURN EMPTABTYPECOL PIPELINED
IS
  BEGIN
    FOR i IN (SELECT *
              FROM EMPLOYEE
              WHERE BIRTHDATE > year) LOOP
      PIPE ROW (empTabType(i.EMPLOYEEID, i.LASTNAME, i.FIRSTNAME, i.TITLE, i.REPORTSTO,
                           i.BIRTHDATE, i.HIREDATE, i.ADDRESS, i.CITY, i.STATE, i.COUNTRY,
                           i.POSTALCODE, i.PHONE, i.FAX, i.EMAIL));
    END LOOP;
    RETURN;
  END;
/
SELECT *
FROM TABLE (getEmplsBornAfter('01-JAN-1968'));

/

-- Section 4 : Stored Procedures
-- 4.1 : Basic Stored Procedure
CREATE OR REPLACE PROCEDURE getFirstLastNames(empls OUT SYS_REFCURSOR)
IS
  BEGIN
    OPEN empls FOR
    SELECT
      FIRSTNAME,
      LASTNAME
    FROM EMPLOYEE;
  END getFirstLastNames;
/
VARIABLE names REFCURSOR;
EXEC getFirstLastNames(:names);
PRINT names;

-- 4.2 : Stored Procedure Input Parameters
CREATE OR REPLACE PROCEDURE updateEmp(eid IN NUMBER, fName IN VARCHAR2, lName IN VARCHAR2)
IS
  BEGIN
    UPDATE EMPLOYEE
    SET EMPLOYEE.FIRSTNAME = fName, EMPLOYEE.LASTNAME = lName
    WHERE EMPLOYEE.EMPLOYEEID = eid;
  END updateEmp;
/
CALL updateEmp(1, 'aa', 'ron');

/
-- 4.3 : Stored Procedure Output Parameters
CREATE OR REPLACE PROCEDURE getNameAndComp(custId IN NUMBER, name OUT VARCHAR2, comp OUT VARCHAR2)
IS
  BEGIN
    SELECT
      (LASTNAME || ', ' || FIRSTNAME),
      COMPANY
    INTO name, comp
    FROM CUSTOMER
    WHERE CUSTOMERID = custId;
  END getNameAndComp;
/
VARIABLE name VARCHAR2(100);
VARIABLE comp VARCHAR2(100);
EXEC getNameAndComp(1, :name, :comp);
PRINT name;
PRINT comp;

-- Section 5 : Transactions
CREATE OR REPLACE PROCEDURE delInv(invId IN NUMBER)
IS
  BEGIN
    SAVEPOINT delInvTrans;
    DELETE FROM INVOICE
    WHERE INVOICEID = invId;
    EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK TO delInvTrans;
    RAISE;
  END delInv;
/
CALL delInv(400);

/
CREATE OR REPLACE PROCEDURE insCust(fName IN VARCHAR2, lName IN VARCHAR2, email IN VARCHAR2)
IS
  BEGIN
    SAVEPOINT insCustTrans;
    INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, EMAIL) VALUES (fName, lName, email);
    EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK TO insCustTrans;
    RAISE;
  END insCust;
/
CALL insCust('asdf', 'qwert', 'qwer.asdf@kj.com');
-- Section 6 : Triggers
CALL DBMS_OUTPUT.ENABLE(buffer_size => NULL);
-- 6.1 : AFTER/FOR
CREATE OR REPLACE TRIGGER afterInsEmp
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
  BEGIN
    DBMS_OUTPUT.PUT_LINE('A ROW HAS BEEN INSERTEEEEED');
  END;
/
CREATE OR REPLACE TRIGGER afterAlbumUpdate
AFTER UPDATE ON ALBUM
FOR EACH ROW
  BEGIN
    DBMS_OUTPUT.PUT_LINE('A ROW HAS BEEN UPDAAATED');
  END;
/
CREATE OR REPLACE TRIGGER afterCustDelete
AFTER DELETE ON CUSTOMER
FOR EACH ROW
  BEGIN
    DBMS_OUTPUT.PUT_LINE('A ROW HAS BEEN DELEEEETED');
  END;
/
-- 6.2 : INSTEAD OF
CREATE VIEW invView AS
  SELECT *
  FROM INVOICE;

CREATE OR REPLACE TRIGGER delOver20
INSTEAD OF DELETE
  ON invView
FOR EACH ROW
  BEGIN
    IF :OLD.total < 20
    THEN
      DELETE FROM INVOICE
      WHERE INVOICEID = :OLD.INVOICEID;
    END IF;
  END;
/
DELETE FROM invView
WHERE TOTAL > 17;

-- Section 7 : Joins
-- 7.1 : Inner
SELECT
  (CUSTOMER.LASTNAME || ', ' || CUSTOMER.FIRSTNAME) AS "Name",
  INVOICE.INVOICEID
FROM CUSTOMER
  INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
-- 7.2 : Outer
SELECT
  (CUSTOMER.LASTNAME || ', ' || CUSTOMER.FIRSTNAME) AS "Name",
  INVOICE.INVOICEID,
  INVOICE.TOTAL
FROM CUSTOMER
  FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
-- 7.3 : Right
SELECT
  ARTIST.NAME,
  ALBUM.TITLE
FROM ARTIST
  RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID;
-- 7.4 : Cross
SELECT
  ARTIST.NAME,
  ALBUM.TITLE
FROM ARTIST
  CROSS JOIN ALBUM
ORDER BY ARTIST.NAME ASC;
-- 7.5 : Self
SELECT
  A.LASTNAME AS EmployeeName1,
  B.LASTNAME AS EmployeeName2,
  A.REPORTSTO
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.EMPLOYEEID <> B.EMPLOYEEID
      AND A.REPORTSTO = B.REPORTSTO;

-- Section 8 : Indexes
-- 8.1 : Clustered Indexes
-- Oracle uses Index Organized Tables
-- Add the following after your schema definition in create table clause:
--  create table asdf(....)
--  organization index;

-- Section 9 : Administration
-- run rman from console
--RMAN> run 
--2> {
--3> shutdown immediate
--4> startup mount
--5> backup database;
--6> SQL 'ALTER DATABASE OPEN';
--7>}
-- to restore .bkp:
-- RMAN> restore database from tag 'TAGXXXXXXXX';
-- tag found in C:\oraclexe\app\oracle\fast_recovery_area\...

COMMIT;