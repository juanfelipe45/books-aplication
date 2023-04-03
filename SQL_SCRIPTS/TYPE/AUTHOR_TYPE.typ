create or replace type AUTHOR_TYPE as object
(
  -- Author  : Juan Gonzalez
  -- Created : 02/04/2023
  -- Purpose : TYPE OF AUTHOR
  
  -- Attributes
  NAME       VARCHAR2(50),
  BIRTHDAY   DATE,
  PHOTO      VARCHAR2(255),
  STATUS     CHAR(1),
  BOOKS      BOOKS_TYPE,
  CONSTRUCTOR FUNCTION AUTHOR_TYPE RETURN SELF AS RESULT
  
)
/
create or replace type body AUTHOR_TYPE AS
  
  CONSTRUCTOR FUNCTION AUTHOR_TYPE RETURN SELF AS RESULT IS
  BEGIN
    SELF.NAME := '';
    SELF.BIRTHDAY := NULL;
    SELF.PHOTO := EMPTY_CLOB();
    SELF.STATUS := 'A'; 
    SELF.BOOKS := BOOKS_TYPE();
    RETURN;
  END;
  
end;
/
