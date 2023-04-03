create or replace type CATEGORY_TYPE as object
(
  -- Author  : Juan Gonzalez
  -- Created : 02/04/2023
  -- Purpose : TYPE OF CATEGORY
  
  -- Attributes
  NAME       VARCHAR2(50),
  STATUS     CHAR(1),
  BOOKS      BOOKS_TYPE,
  CONSTRUCTOR FUNCTION CATEGORY_TYPE RETURN SELF AS RESULT
)
/
create or replace type body CATEGORY_TYPE is
CONSTRUCTOR FUNCTION CATEGORY_TYPE RETURN SELF AS RESULT IS
  BEGIN
    SELF.NAME := '';
    SELF.STATUS := 'A';
    SELF.BOOKS := BOOKS_TYPE();
    RETURN;
  END;
end;
/
