# Library_management_pjt

  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
  <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"> 
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 

##### 개발환경
- IDE : eclipse
- IDE package : sts-3.9.18.RELEASE
- language : Java
- Java version : 11
- Windows 10, 11

```
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW, CREATE SEQUENCE, 
      CREATE SYNONYM, CREATE PROCEDURE, CREATE TRIGGER, CREATE MATERIALIZED VIEW 
TO bookmanager;

GRANT SELECT ANY TABLE, INSERT ANY TABLE, UPDATE ANY TABLE, DELETE ANY TABLE 
TO bookmanager;
ALTER USER bookmanager DEFAULT TABLESPACE USERS;
ALTER USER bookmanager QUOTA UNLIMITED ON USERS;

CREATE TABLE USERINFO (
    userNumber      NUMBER PRIMARY KEY,
    userId          VARCHAR2(100),
    userPw          VARCHAR2(100),
    userName        VARCHAR2(100),
    userTel         VARCHAR2(20),
    userEmail       VARCHAR2(200),
    userBirth       VARCHAR2(50),
    userZipCode     VARCHAR2(50),
    userAddress     VARCHAR2(300),
    userDetailAddress VARCHAR2(500),
    userBorrow      NUMBER DEFAULT 0,
    userCanBorrow      NUMBER DEFAULT 5,
    userAdmin       NUMBER DEFAULT 0,
    userRegdate     DATE DEFAULT SYSDATE
);
CREATE TABLE BOOKINFO (
    bookNumber          NUMBER PRIMARY KEY,
    bookIsbn            VARCHAR2(50) DEFAULT 0,
    bookTitle           VARCHAR2(400),
    bookComent          VARCHAR2(4000),
    bookWrite           VARCHAR2(100),
    bookPub             VARCHAR2(100),
    bookDate            DATE,
    bookMajorCategory   NVARCHAR2(100),
    bookSubCategory     NVARCHAR2(100),
    bookCount           NUMBER,
    bookBorrowCount     NUMBER DEFAULT 0
);

CREATE TABLE NOTICE(
    noticeNum            NUMBER PRIMARY KEY,
    noticeTitle          VARCHAR2(500) NOT NULL,
    noticeContent        VARCHAR2(4000) NOT NULL,
    noticewriter         VARCHAR2(100) DEFAULT '관리자',
    noticeregdate        DATE DEFAULT SYSDATE,
    noticeviews          NUMBER DEFAULT 0,
    noticeCategory       VARCHAR2(30)
);

CREATE TABLE BOOK_REGISTATION_LOG (
    logNumber      NUMBER PRIMARY KEY,
    userNumber  NUMBER,
    bookNumber  NUMBER,
    regDate     DATE DEFAULT SYSDATE,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber) ON DELETE CASCADE,
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)ON DELETE CASCADE
);

CREATE TABLE BOARD (
    boardNumber     NUMBER PRIMARY KEY,
    userNumber      NUMBER,
    userName        VARCHAR2(50),
    boardTitle      VARCHAR2(1000),
    boardContent    VARCHAR2(4000),
    boardWriteDate  DATE DEFAULT SYSDATE,
    boardHit        NUMBER DEFAULT 0,
    boardViews      NUMBER DEFAULT 0,
    boardLikes      NUMBER DEFAULT 0,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber)ON DELETE CASCADE
);

CREATE TABLE board_likes (
    boardNumber number,
    userNumber number,
    PRIMARY KEY (boardNumber, userNumber)
);

CREATE TABLE BOARD_COMMENT (
    commentNumber       NUMBER PRIMARY KEY,
    commentSubNumber    NUMBER,
    commentSubStepNumber NUMBER,
    boardNumber         NUMBER,
    userNumber          NUMBER,
    userName            VARCHAR2(50),
    commentContent      VARCHAR2(4000),
    commentWriteDate    DATE DEFAULT SYSDATE
);

ALTER TABLE BOARD_COMMENT
ADD CONSTRAINT fk_comment_board
FOREIGN KEY (boardNumber)
REFERENCES BOARD(boardNumber)
ON DELETE CASCADE;

ALTER TABLE BOARD_COMMENT
ADD CONSTRAINT fk_comment_user
FOREIGN KEY (userNumber)
REFERENCES USERINFO(userNumber)
ON DELETE CASCADE;
DESC board_comment;

CREATE TABLE BOOK_BORROW (
    borrowNumber        NUMBER PRIMARY KEY,
    userNumber          NUMBER,
    bookNumber          NUMBER,
    bookBorrowDate      DATE DEFAULT SYSDATE,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber)ON DELETE CASCADE,
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)ON DELETE CASCADE
);
CREATE TABLE BORROW_RECORD (
    borrowRecordNumber  NUMBER PRIMARY KEY,
    userNumber          NUMBER,
    bookNumber          NUMBER,
    borrowNumber        NUMBER,
    bookBorrowDate      DATE,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber)ON DELETE CASCADE,
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)ON DELETE CASCADE,
    FOREIGN KEY (borrowNumber) REFERENCES BOOK_BORROW(borrowNumber)ON DELETE CASCADE
);
CREATE TABLE RETURN_RECORD (
    returnNumber        NUMBER PRIMARY KEY,
    userNumber          NUMBER,
    bookNumber          NUMBER,
    bookReturnDate      DATE DEFAULT SYSDATE,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber)ON DELETE CASCADE,
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)ON DELETE CASCADE
);
CREATE TABLE SELL_BOOK (
    sellNumber      NUMBER PRIMARY KEY,
    bookNumber      NUMBER,
    userNumber      NUMBER,
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)ON DELETE CASCADE,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber)ON DELETE CASCADE
);
CREATE TABLE SELL_RECORD (
    sellRecordNumber    NUMBER PRIMARY KEY,
    sellNumber          NUMBER,
    userNumber          NUMBER,
    bookNumber          NUMBER,
    FOREIGN KEY (sellNumber) REFERENCES SELL_BOOK(sellNumber)ON DELETE CASCADE,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber)ON DELETE CASCADE,
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)ON DELETE CASCADE
);
CREATE TABLE BUY_RECORD (
    buyRecordNumber     NUMBER PRIMARY KEY,
    userNumber          NUMBER,
    bookNumber          NUMBER,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber)ON DELETE CASCADE,
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)ON DELETE CASCADE
);

create or replace TRIGGER trg_after_book_borrow_insert
AFTER INSERT ON BOOK_BORROW
FOR EACH ROW
DECLARE
    v_bookcount     NUMBER;
    v_usercanborrow NUMBER;
    ex_no_stock     EXCEPTION;
    ex_no_quota     EXCEPTION;
BEGIN
    -- 책 재고 확인
    SELECT BOOKCOUNT INTO v_bookcount
    FROM BOOKINFO
    WHERE BOOKNUMBER = :NEW.BOOKNUMBER;

    -- 사용자 대출 가능 횟수 확인
    SELECT USERCANBORROW INTO v_usercanborrow
    FROM USERINFO
    WHERE USERNUMBER = :NEW.USERNUMBER;

    -- 예외 조건 검사
    IF v_bookcount <= 0 THEN
        RAISE ex_no_stock;
    ELSIF v_usercanborrow <= 0 THEN
        RAISE ex_no_quota;
    END IF;

    -- BOOKINFO 업데이트
    UPDATE BOOKINFO
    SET
        BOOKBORROWCOUNT = BOOKBORROWCOUNT + 1,
        BOOKCOUNT = BOOKCOUNT - 1
    WHERE BOOKNUMBER = :NEW.BOOKNUMBER;

    -- USERINFO 업데이트
    UPDATE USERINFO
    SET
        USERCANBORROW = USERCANBORROW - 1,
        USERBORROW = USERBORROW + 1
    WHERE USERNUMBER = :NEW.USERNUMBER;

EXCEPTION
    WHEN ex_no_stock THEN
        RAISE_APPLICATION_ERROR(-20001, '도서 재고가 부족하여 대출할 수 없습니다.');
    WHEN ex_no_quota THEN
        RAISE_APPLICATION_ERROR(-20002, '회원의 대출 가능 권수가 0입니다.');
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20003, '트리거 처리 중 오류 발생: ' || SQLERRM);
END;


create or replace TRIGGER trg_insert_borrow_record
AFTER INSERT ON book_borrow
FOR EACH ROW
BEGIN
    INSERT INTO borrow_record (
        borrowrecordnumber,
        usernumber,
        booknumber,
        borrownumber
    ) VALUES (
        borrowrecord_seq.NEXTVAL,   -- 시퀀스로 생성
        :NEW.usernumber,            -- book_borrow에서 가져온 값
        :NEW.booknumber,
        :NEW.borrownumber
    );
END;

CREATE SEQUENCE  "BOOKMANAGER"."BORROWRECORD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 20 NOCACHE  NOORDER  NOCYCLE 
```

## ERD
![image](https://github.com/user-attachments/assets/5c668ab5-4098-439b-a0d1-85609255b0c1)

## 로그인 & 회원가입 플로우차트
![image](https://github.com/user-attachments/assets/4042bba2-7485-47e2-ab54-9bbd5991b108)

## 도서 등록 플로우차트
![image](https://github.com/user-attachments/assets/1a6076e6-6014-438a-b477-9cc63ff3ed8f)


