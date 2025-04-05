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

##### controller
- UserController.java
  유저 관련기능 (회원가입, 로그인, 유저 정보 관리)
- BookController.java
  도서 관련 기능 (도서 검색, 도서 정보 조회, 도서 수정, 도서 등록)

##### model
- UserDAO.java
  유저 관련 로직 선언(interface)
- BookDAO.java
  도서 관련 로직 선언(interface)
- UserDAOImpl.java
  유저 관련 로직 구현
- BookDAOImpl.java
  도서 관련 로직 구현

##### views
- book_search.jsp
  도서 검정
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
    userId          VARCHAR2(50),
    userPw          VARCHAR2(50),
    userName        VARCHAR2(50),
    userTel         VARCHAR2(20),
    userEmail       VARCHAR2(100),
    userBirth       VARCHAR2(20),
    userAddress     VARCHAR2(100),
    userDetailAddress VARCHAR2(100),
    userBorrow      NUMBER DEFAULT 3,
    userAdmin       NUMBER DEFAULT 0,
    userRegdate     DATE DEFAULT SYSDATE
);
CREATE TABLE BOOKINFO (
    bookNumber          NUMBER PRIMARY KEY,
    bookTitle           VARCHAR2(100),
    bookComent          VARCHAR2(255),
    bookWrite           VARCHAR2(50),
    bookPub             VARCHAR2(50),
    bookDate            DATE,
    bookMajorCategory   NVARCHAR2(50),
    bookSubCategory     NVARCHAR2(50),
    bookCount           NUMBER,
    bookBorrowCount     NUMBER
);

CREATE TABLE notice (
    noticeNum      NUMBER PRIMARY KEY,
    title          VARCHAR2(200) NOT NULL,
    noContent      VARCHAR2(1000) NOT NULL,
    writer         VARCHAR2(50) DEFAULT '관리자',
    regdate        DATE DEFAULT SYSDATE,
    views          NUMBER DEFAULT 0
);

CREATE TABLE BOOK_REGISTATION_LOG (
    logNumber      NUMBER PRIMARY KEY,
    userNumber  NUMBER,
    bookNumber  NUMBER,
    regDate     DATE DEFAULT SYSDATE,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber),
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)
);
CREATE TABLE BOARD (
    boardNumber     NUMBER PRIMARY KEY,
    userNumber      NUMBER,
    boardTitle      VARCHAR2(100),
    boardContent    VARCHAR2(1000),
    boardWriteDate  DATE DEFAULT SYSDATE,
    boardViews      NUMBER,
    boardLikes      NUMBER,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber)
);
CREATE TABLE BOARD_COMMENT (
    commentNumber       NUMBER PRIMARY KEY,
    boardNumber         NUMBER,
    userNumber          NUMBER,
    commentContent      VARCHAR2(1000),
    commentWriteDate    DATE DEFAULT SYSDATE,
    FOREIGN KEY (boardNumber) REFERENCES BOARD(boardNumber),
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber)
);
CREATE TABLE BOOK_BORROW (
    borrowNumber        NUMBER PRIMARY KEY,
    userNumber          NUMBER,
    bookNumber          NUMBER,
    bookBorrowDate      DATE DEFAULT SYSDATE,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber),
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)
);
CREATE TABLE BORROW_RECORD (
    borrowRecordNumber  NUMBER PRIMARY KEY,
    userNumber          NUMBER,
    bookNumber          NUMBER,
    borrowNumber        NUMBER,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber),
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber),
    FOREIGN KEY (borrowNumber) REFERENCES BOOK_BORROW(borrowNumber)
);
CREATE TABLE RETURN_RECORD (
    returnNumber        NUMBER PRIMARY KEY,
    userNumber          NUMBER,
    bookNumber          NUMBER,
    bookReturnDate      DATE DEFAULT SYSDATE,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber),
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)
);
CREATE TABLE SELL_BOOK (
    sellNumber      NUMBER PRIMARY KEY,
    bookNumber      NUMBER,
    userNumber      NUMBER,
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber),
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber)
);
CREATE TABLE SELL_RECORD (
    sellRecordNumber    NUMBER PRIMARY KEY,
    sellNumber          NUMBER,
    userNumber          NUMBER,
    bookNumber          NUMBER,
    FOREIGN KEY (sellNumber) REFERENCES SELL_BOOK(sellNumber),
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber),
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)
);
CREATE TABLE BUY_RECORD (
    buyRecordNumber     NUMBER PRIMARY KEY,
    userNumber          NUMBER,
    bookNumber          NUMBER,
    FOREIGN KEY (userNumber) REFERENCES USERINFO(userNumber),
    FOREIGN KEY (bookNumber) REFERENCES BOOKINFO(bookNumber)
);

```

## ERD
![image](https://github.com/user-attachments/assets/e37eb2fd-e6f8-457a-8bf0-caaeecd9eebb)

## 로그인 & 회원가입 플로우차트
![image](https://github.com/user-attachments/assets/42c9b8b7-f470-4843-82bc-3ed59fce2352)

## 도서 등록 플로우차트
![image](https://github.com/user-attachments/assets/ddda9356-1cb5-4e6b-aa1d-6a7f0d169dc4)

