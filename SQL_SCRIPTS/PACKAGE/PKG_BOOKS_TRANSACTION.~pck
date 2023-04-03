create or replace noneditionable package PKG_BOOKS_TRANSACTION is

  -- Author  : Juan González
  -- Created : 1/04/2023 8:18:55 p. m.
  -- Purpose : PKG_BOOKS_TRANSACTION
 
  -- FUNCTION THAT VALID IF AUTHOR IS ACTIVE
  FUNCTION IS_AUTHOR_ACTIVE(p_authorId IN NUMBER) RETURN BOOLEAN;
  
  -- FUNCTION THAT VALID IF BOOK IS ACTIVE
  FUNCTION IS_BOOK_ACTIVE(p_bookId IN NUMBER) RETURN BOOLEAN;
  
  -- FUNCTION THAT VALID IF CATEGORY IS ACTIVE
  FUNCTION IS_CATEGORY_ACTIVE(p_categoryId IN NUMBER) RETURN BOOLEAN;
  
  -- PROCEDURE THAT DEACTIVATES THE AUTHOR AND HIS BOOKS
  PROCEDURE DISABLE_AUTHOR(p_authorId IN NUMBER, p_code OUT NUMBER, p_response OUT VARCHAR2);
  
  -- PROCEDURE THAT DEACTIVATES THE CATEGORY AND RELATION BOOKS
  PROCEDURE DISABLE_CATEGORY(p_categoryId IN NUMBER, p_code OUT NUMBER, p_response OUT VARCHAR2);
  
  -- PROCEDURE THAT DEACTIVATES THE BOOK
  PROCEDURE DISABLE_BOOK(p_bookId IN NUMBER, p_code OUT NUMBER, p_response OUT VARCHAR2);
  
  -- PROCEDURE THAT CREATE A BOOK
  PROCEDURE CREATE_BOOK(p_book IN BOOK_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2);
  
  -- PROCEDURE THAT CREATE A CATEGORY
  PROCEDURE CREATE_CATEGORY(p_category IN CATEGORY_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2);
  
  -- PROCEDURE THAT CREATE A AUTHOR AND HIS BOOKS
  PROCEDURE CREATE_AUTHOR(p_author IN AUTHOR_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2);
  
  -- PROCEDURE THAT UPDATE A AUTHOR
  PROCEDURE UPDATE_AUTHOR(p_authorId IN NUMBER, p_author IN AUTHOR_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2);
  
  -- PROCEDURE THAT UPDATE A CATEGORY
  PROCEDURE UPDATE_CATEGORY(p_categoryId IN NUMBER, p_category IN CATEGORY_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2);
  
  -- PROCEDURE THAT UPDATE A BOOK
  PROCEDURE UPDATE_BOOK(p_bookId IN NUMBER, p_book IN BOOK_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2);
  
  -- PROCEDURE THAT DELETE A BOOK
  PROCEDURE DELETE_BOOK(p_bookId IN NUMBER);
  
  -- PROCEDURE THAT DELETE A CATEGORY
  PROCEDURE DELETE_CATEGORY(p_categoryId IN NUMBER);
  
  -- PROCEDURE THAT DELETE A AUTHOR
  PROCEDURE DELETE_AUTHOR(p_authorId IN NUMBER);
  
end PKG_BOOKS_TRANSACTION;
/
create or replace noneditionable package body PKG_BOOKS_TRANSACTION is

       -- FUNCTION THAT VALID IF AUTHOR IS ACTIVE
       FUNCTION IS_AUTHOR_ACTIVE(p_authorId in NUMBER) RETURN BOOLEAN IS
         v_active CHAR(1);
        BEGIN
          SELECT STATUS INTO v_active
          FROM AUTHOR
          WHERE ID = p_authorId;
          
          IF v_active = 'A' THEN 
            RETURN TRUE;
          ELSE
            RETURN FALSE;
          END IF;
        EXCEPTION
          WHEN NO_DATA_FOUND THEN
               RETURN FALSE;
       END IS_AUTHOR_ACTIVE;
          
       -- FUNCTION THAT VALID IF BOOK IS ACTIVE
       FUNCTION IS_BOOK_ACTIVE(p_bookId in NUMBER) RETURN BOOLEAN IS
         v_active CHAR(1);
         BEGIN
           SELECT STATUS INTO v_active
           FROM BOOK
           WHERE ID = p_bookId;
          
          IF v_active = 'A' THEN 
            RETURN TRUE;
          ELSE
            RETURN FALSE;
          END IF;
          EXCEPTION
          WHEN NO_DATA_FOUND THEN
               RETURN FALSE;
       END IS_BOOK_ACTIVE;
        
       -- FUNCTION THAT VALID IF CATEGORY IS ACTIVE
       FUNCTION IS_CATEGORY_ACTIVE(p_categoryId in NUMBER) RETURN BOOLEAN IS
        v_active CHAR(1);
       BEGIN
        SELECT STATUS INTO v_active
        FROM CATEGORY
        WHERE ID = p_categoryId;
          
        IF v_active = 'A' THEN 
          RETURN TRUE;
        ELSE
          RETURN FALSE;
        END IF;
        EXCEPTION
          WHEN NO_DATA_FOUND THEN
               RETURN FALSE;
       END IS_CATEGORY_ACTIVE;
       
       -- PROCEDURE THAT DEACTIVATES THE AUTHOR AND HIS BOOKS
       PROCEDURE DISABLE_AUTHOR(p_authorId IN NUMBER, p_code OUT NUMBER, p_response OUT VARCHAR2) IS
         BEGIN
           -- Deactivate the author
           UPDATE AUTHOR
           SET STATUS = 'I'
           WHERE ID = p_authorId;
           
           -- Update the status of books associated with the deactivated author
           FOR BOOK IN (
             SELECT ID
             FROM BOOK
             WHERE AUTHOR_ID = p_authorId  
           ) LOOP
             IF NOT IS_AUTHOR_ACTIVE(p_authorId) THEN
               UPDATE BOOK
               SET STATUS = 'I'
               WHERE ID = BOOK.ID;
               
             END IF;
           END LOOP;
           
           p_code := 200;
           p_response := 'Autor y libros deshabilitados existósamente';
         END DISABLE_AUTHOR;

       -- PROCEDURE THAT DEACTIVATES THE CATEGORY AND RELATION BOOKS
       PROCEDURE DISABLE_CATEGORY(p_categoryId IN NUMBER, p_code OUT NUMBER, p_response OUT VARCHAR2) IS
        BEGIN
           -- Deactivate the category
           UPDATE CATEGORY
           SET STATUS = 'I'
           WHERE ID = p_categoryId;
           
           -- Update the status of books associated with the deactivated category
           FOR BOOK IN (
             SELECT ID
             FROM BOOK
             WHERE CATEGORY_ID = p_categoryId  
           ) LOOP
             IF NOT IS_CATEGORY_ACTIVE(p_categoryId) THEN
               UPDATE BOOK
               SET STATUS = 'I'
               WHERE ID = BOOK.ID;
               
             END IF;
           END LOOP;
           p_code := 200;
           p_response := 'Categoría y libros deshabilitados existósamente';
       END DISABLE_CATEGORY;

       -- PROCEDURE THAT DEACTIVATES THE BOOK
       PROCEDURE DISABLE_BOOK(p_bookId IN NUMBER, p_code OUT NUMBER, p_response OUT VARCHAR2) IS
         BEGIN
           -- Desactivate the book
           UPDATE BOOK
           SET STATUS = 'I'
           WHERE ID = p_bookId;
           
           p_code := 200;
           p_response := 'Libros deshabilitado existósamente';
       END DISABLE_BOOK;
       
       -- PROCEDURE THAT CREATE A BOOK
       PROCEDURE CREATE_BOOK(p_book IN BOOK_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2) IS
         BEGIN
           -- create a book
           INSERT INTO BOOK (PUBLICATION_DATE, PRICE, TITLE, DESCRIPTION, PHOTO, CATEGORY_ID, AUTHOR_ID)
           VALUES (p_book.PUBLICATION_DATE, p_book.PRICE, p_book.TITLE, p_book.DESCRIPTION, p_book.PHOTO, p_book.CATEGORY_ID,
           p_book.AUTHOR_ID);
           
           p_code := 200;
           p_response := 'El libro fue creado exitósamente';
       END CREATE_BOOK;
       
       -- PROCEDURE THAT CREATE A CATEGORY
       PROCEDURE CREATE_CATEGORY(p_category IN CATEGORY_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2) IS
         BEGIN
           -- create a category
           INSERT INTO CATEGORY (NAME)
           VALUES (p_category.NAME);
           
           p_code := 200;
           p_response := 'La categoría fue creada exitósamente';
       END CREATE_CATEGORY;
       
       -- PROCEDURE THAT CREATE A AUTHOR AND HIS BOOKS
       PROCEDURE CREATE_AUTHOR(p_author IN AUTHOR_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2) IS
         v_book BOOK_TYPE;
         v_authorId NUMBER;
         v_code NUMBER;
         v_response VARCHAR2(100);
         BEGIN
           --create a author
           INSERT INTO AUTHOR(NAME, BIRTHDAY, PHOTO)
           VALUES (p_author.NAME, p_author.BIRTHDAY, p_author.PHOTO);
           
           --validate books
           IF p_author.BOOKS IS NOT NULL OR p_author.BOOKS.COUNT <> 0 THEN
             FOR i IN 1..p_author.BOOKS.COUNT LOOP
               SELECT MAX(ID) INTO v_authorId FROM AUTHOR;
               v_book := BOOK_TYPE(PUBLICATION_DATE => p_author.BOOKS(i).PUBLICATION_DATE,
                                   PRICE            => p_author.BOOKS(i).PRICE,
                                   TITLE            => p_author.BOOKS(i).TITLE,
                                   DESCRIPTION      => p_author.BOOKS(i).DESCRIPTION,
                                   PHOTO            => p_author.BOOKS(i).PHOTO,
                                   STATUS           => p_author.BOOKS(i).STATUS,
                                   CATEGORY_ID      => p_author.BOOKS(i).CATEGORY_ID,
                                   AUTHOR_ID        => v_authorId);
               -- create book
               CREATE_BOOK(v_book, v_code, v_response);
               
               p_code := 200;
               p_response := 'La categoría fue creada exitósamente';
             END LOOP;
           END IF;
           
             
       END CREATE_AUTHOR;
       
       -- PROCEDURE THAT UPDATE A AUTHOR
       PROCEDURE UPDATE_AUTHOR(p_authorId IN NUMBER, p_author IN AUTHOR_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2) IS
         BEGIN
           
           IF NOT IS_AUTHOR_ACTIVE(p_authorId) THEN
             p_code := 400;
             p_response := 'El autor no está activado';
             return;
           END IF;
         
           UPDATE AUTHOR
           SET NAME = p_author.NAME,
               BIRTHDAY = p_author.BIRTHDAY,
               PHOTO = p_author.PHOTO
           WHERE ID = p_authorId;
           
           p_code := 200;
           p_response := 'El registro ha sido actualizado';
       END UPDATE_AUTHOR;
       
       -- PROCEDURE THAT UPDATE A CATEGORY
       PROCEDURE UPDATE_CATEGORY(p_categoryId IN NUMBER, p_category IN CATEGORY_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2) IS
         BEGIN
           
           IF NOT IS_CATEGORY_ACTIVE(p_categoryId) THEN
             p_code := 400;
             p_response := 'La categoría no está activado';
             return;
           END IF;
         
           UPDATE CATEGORY
           SET NAME = p_category.NAME
           WHERE ID = p_categoryId;
           
           p_code := 200;
           p_response := 'El registro ha sido actualizado';
       END UPDATE_CATEGORY;
       
       -- PROCEDURE THAT UPDATE A BOOK
       PROCEDURE UPDATE_BOOK(p_bookId IN NUMBER, p_book IN BOOK_TYPE, p_code OUT NUMBER, p_response OUT VARCHAR2) IS
         BEGIN
           
           IF NOT IS_CATEGORY_ACTIVE(p_bookId) THEN
             p_code := 400;
             p_response := 'eL libro no está activado';
             return;
           END IF;
         
           UPDATE BOOK
           SET PUBLICATION_DATE = p_book.PUBLICATION_DATE,
               PRICE = p_book.PRICE,
               TITLE = p_book.TITLE,
               DESCRIPTION = p_book.DESCRIPTION,
               PHOTO = p_book.PHOTO,
               CATEGORY_ID = p_book.CATEGORY_ID,
               AUTHOR_ID = p_book.AUTHOR_ID
           WHERE ID = p_bookId;
           
           p_code := 200;
           p_response := 'El registro ha sido actualizado';
       END UPDATE_BOOK;
       
       -- PROCEDURE THAT DELETE A BOOK
       PROCEDURE DELETE_BOOK(p_bookId IN NUMBER) IS
         BEGIN
           DELETE FROM BOOK
           WHERE ID = p_bookId;
       END DELETE_BOOK;
       
       -- PROCEDURE THAT DELETE A CATEGORY
       PROCEDURE DELETE_CATEGORY(p_categoryId IN NUMBER) IS
         BEGIN
           -- DELETE BOOKS
           DELETE FROM BOOK
           WHERE CATEGORY_ID =  p_categoryId;
           
           -- DELETE CATEGORY
           DELETE FROM CATEGORY
           WHERE ID = p_categoryId;
       END DELETE_CATEGORY;
       
       -- PROCEDURE THAT DELETE A AUTHOR
       PROCEDURE DELETE_AUTHOR(p_authorId IN NUMBER) IS
         BEGIN
           -- DELETE BOOKS
           DELETE FROM BOOK
           WHERE AUTHOR_ID =  p_authorId;
           
           -- DELETE AUTHOR
           DELETE FROM AUTHOR
           WHERE ID = p_authorId;
       END DELETE_AUTHOR;
end PKG_BOOKS_TRANSACTION;
/
