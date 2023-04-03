alter session set "_ORACLE_SCRIPT"=true;

------------------------

CREATE USER USER_BOOK IDENTIFIED BY 123456
default tablespace USERS
temporary tablespace TEMP
quota unlimited on USERS

-----------------------
grant create session to USER_BOOK;
grant create table to USER_BOOK;
grant create view to USER_BOOK;
grant create procedure to USER_BOOK;
grant create trigger to USER_BOOK;
grant create sequence to USER_BOOK;
grant create job to USER_BOOK;
grant create type to USER_BOOK;

