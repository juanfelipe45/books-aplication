create or replace noneditionable type BOOK_TYPE as object
(
  -- Author  : Juan Gonzalez
  -- Created : 02/04/2023
  -- Purpose : Type of book for procedures
  
  -- Attributes
  PUBLICATION_DATE         DATE,
  PRICE                    NUMBER(8,3),
  TITLE                    VARCHAR2(50),
  DESCRIPTION              VARCHAR2(100),
  PHOTO                    VARCHAR2(255),
  STATUS                   CHAR(1),
  CATEGORY_ID              NUMBER,
  AUTHOR_ID                NUMBER,
  CONSTRUCTOR FUNCTION BOOK_TYPE RETURN SELF AS RESULT
);
/
create or replace noneditionable type body BOOK_TYPE AS
  CONSTRUCTOR FUNCTION BOOK_TYPE RETURN SELF AS RESULT IS
  BEGIN
    SELF.PUBLICATION_DATE := NULL;
    SELF.PRICE := 0;
    SELF.TITLE := '';
    SELF.DESCRIPTION := '';
    SELF.PHOTO := EMPTY_CLOB();
    SELF.STATUS := 'A';
    SELF.CATEGORY_ID := NULL;
    SELF.AUTHOR_ID := NULL;
    RETURN;
   END;
end;
/
