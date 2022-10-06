drop table member2;
drop SEQUENCE seq_mem2;
create table member2(
    mno number CONSTRAINT member2_pk PRIMARY KEY,
    email VARCHAR2(255) CONSTRAINT member2_email_uk UNIQUE NOT NULL,
    name VARCHAR2(255) NOT NULL,
    pass VARCHAR2(255) NOT NULL,
    user_ip VARCHAR2(255) NOT NULL,
    created_date TIMESTAMP DEFAULT systimestamp,
    updated_date TIMESTAMP
);

create SEQUENCE seq_mem2 START WITH 1 INCREMENT BY 1;
set SERVEROUTPUT ON;
insert into member2(mno, email, name, pass, user_ip)
VALUES(seq_mem2.nextval, 'test2@', 'test2', '1234', '127.0.0.1');
commit;
select * from member2;

update member2
set pass='2222'
where mno=1;
