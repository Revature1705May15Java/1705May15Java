--Create tables
CREATE TABLE Employee
(
    EMPLOYEE_ID NUMBER,
    First_Name VARCHAR2(100) NOT NULL,
    Last_Name VARCHAR2(100) NOT NULL,
    username VARCHAR2(100) NOT NULL UNIQUE,
    Password VARCHAR2(50)NOT NULL,
    Is_Manager NUMBER DEFAULT 0,
    
  
    CONSTRAINT PK_EMPLOYEE PRIMARY KEY (EMPLOYEE_ID),
    CHECK (Is_Manager BETWEEN 0 AND 1)
);

CREATE TABLE REQUEST
(
    REQUEST_Id NUMBER,
    REQUESTER_Id NUMBER NOT NULL,
    RESOLVER_Id NUMBER,
    NOTE VARCHAR2(500),
    purpose VARCHAR2(500),
    STATE_ID NUMBER Default 1,
    Opened DATE DEFAULT CURRENT_DATE,
    Closed DATE,
    AMOUNT NUMBER(9,2) NOT NULL,
    
    
    CONSTRAINT PK_REQUEST PRIMARY KEY  (REQUEST_Id),
    CONSTRAINT FK_REQUESTER FOREIGN KEY  (REQUESTER_ID) REFERENCES EMPLOYEE(EMPLOYEE_id),
    CONSTRAINT FK_RESOLVER FOREIGN KEY  (RESOLVER_ID) REFERENCES EMPLOYEE(EMPLOYEE_id),
    CHECK (AMOUNT > 0)
);


CREATE TABLE STATE_TYPE
(
    STATE_ID NUMBER,
    NAME VARCHAR2(50) NOT NULL UNIQUE,
    
    CONSTRAINT PK_STATE_TYPE PRIMARY KEY  (STATE_ID)
);

/

create sequence e_seq
start with 50
increment by 10;
/

create or replace trigger e_seq_trigger
before insert on employee
for each row
begin 
if:new.employee_id is null then 
  select e_seq.nextval into :new.employee_id from dual;
  end if;
  end;
  /

create sequence r_seq
start with 110
increment by 5;
/

create or replace trigger r_seq_trigger
before insert on request
for each row
begin 
if:new.request_id is null then 
  select r_seq.nextval into :new.request_id from dual;
  end if;
  end;
  /
  
insert into employee(first_name, last_name, username, password, is_manager)
values('liqun', 'zheng', 'lzheng', '123', 1);
/

insert into employee(first_name, last_name, username, password, is_manager)
values('test', 'test', 'test', 'test', 0);
/

commit;
/ 
insert into request(requester_id, purpose, amount)
values(60, 'relocation', 500);
/
insert into request(requester_id, resolver_id, note, purpose, state_id, closed, amount)
values(60, 50,'yes', 'relocation', 2, current_date, 500);
/

select *  from request r inner join employee e
on r.REQUESTER_ID = e.employee_id
/

commit;

select r.request_id, r.requester_id, r.resolver_id, r.note,r.purpose,
  r.state_id, r.opened, r.closed, r.amount from request r
  inner join employee e
  on e.employee_id = r.requester_id
  where e.employee_id = 60;
  
  
  
insert into request(requester_id, purpose, amount)
values(70, 'relocation', 100);
/

select * from request r 
inner join state_type s 
on r.state_id = s.STATE_ID
where r.request_id = 125;
/

update employee
set first_name = 'liqun', last_name = 'zheng', 
username = 'lizheng', password = '123'
where employee.employee_id = 50;
/

select r.REQUEST_ID, r.REQUESTER_ID, r.RESOLVER_ID, 
r.note, r.purpose, r.state_id, r.OPENED, r.closed, r.amount, s.NAME
from employee e
inner join request r
on e.EMPLOYEE_ID = r.REQUESTER_ID
inner join state_type s
on r.STATE_ID = s.STATE_ID
where e.FIRST_NAME = 'test' AND e.LAST_NAME = 'test';
/


select *
from request
inner join state_type
on state_type.state_id = request.state_id
inner join employee
on request.requester_id = employee.EMPLOYEE_ID;

/

update request
set request.state_id = 2, request.closed = current_date
where request.request_id = 120;
/
select *
from state_type
where state_type.name = 'Approve';
/

select e.first_name, last_name
from employee e
where e.employee_id = 10;/