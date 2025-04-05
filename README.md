# Library_management_pjt

  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
  <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"> 
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 

##### 1차 개발 ( 2025-04-08 ~ 2025-04-14 )
- 로그인&회원가입
- 도서 등록
- 도서 수정
- 도서 대출&반납
- 도서 대출&반납 기록열람
- 게시판&게시글

##### 2차 개발
- 도서 판매 등록
- 도서 구매
- 도서 판매&구매 기록 열람

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
    U_NUMBER NUMBER(5) PRIMARY KEY, -- 유저 고유번호
    U_ID VARCHAR2(30) NOT NULL, -- 유저 아이디
    U_PW VARCHAR2(30) NOT NULL, -- 유저 비밀번호
    U_NAME VARCHAR2(20) NOT NULL, -- 유저 이름
    U_EMAIL VARCHAR2(50), -- 유저 이메일
    U_TEL VARCHAR2(25), -- 유저 전화번호
    U_BIRTH VARCHAR2(25), -- 유저 생일 (YYYYMMDD 형식)
    U_ADDRESS VARCHAR2(150), -- 유저 주소
    U_BORROW NUMBER(1) DEFAULT 3, -- 유저가 최대 빌릴 수 있는 수 (기본값 3)
    U_ADMIN NUMBER(1) DEFAULT 0, -- 유저 관리자 여부 (0: 일반, 1: 관리자)
    U_REGDATE DATE DEFAULT SYSDATE
);

CREATE TABLE BOOK (
    B_NUMBER NUMBER(6) PRIMARY KEY, -- 고유번호
    B_TITLE VARCHAR2 (50), -- 제목
    B_COMENT VARCHAR2 (100), -- 짧은 내용
    B_WRITER VARCHAR2(20), -- 저자
    B_PUB VARCHAR2(30), -- 출판사
    B_DATE VARCHAR2(100), -- 출판일자
    B_CATEGORY VARCHAR2(50), -- 카테고리
    B_COUNT NUMBER(1), -- 몇권남아있는지
    B_BORROWCOUNT NUMBER(3) DEFAULT 0 -- 얼마나 빌렸는지
);

CREATE TABLE BOOK_BORROW(
    BORROW_NUMBER NUMBER(5) PRIMARY KEY,
    U_NUMBER NUMBER(5), -- 유저 고유번호
    B_NUMBER NUMBER(6), -- 책 고유번호
    B_BORROWDATE DATE, -- 빌린날짜
    CONSTRAINT FK_BOOK_BORROW_USER FOREIGN KEY (U_NUMBER) REFERENCES USERINFO(U_NUMBER) ON DELETE CASCADE,
    CONSTRAINT FK_BOOK_BORROW_BOOK FOREIGN KEY (B_NUMBER) REFERENCES BOOK(B_NUMBER) ON DELETE CASCADE
);

CREATE TABLE BOOK_RETURN(
    RETURN_NUMBER NUMBER(5) PRIMARY KEY,
    U_NUMBER NUMBER(5), -- 유저 고유번호
    B_NUMBER NUMBER(6), -- 책 고유번호
    B_RETURNDATE DATE, -- 반납일자
    CONSTRAINT FK_BOOK_RETURN_USER FOREIGN KEY (U_NUMBER) REFERENCES USERINFO(U_NUMBER) ON DELETE CASCADE,
    CONSTRAINT FK_BOOK_RETURN_BOOK FOREIGN KEY (B_NUMBER) REFERENCES BOOK(B_NUMBER) ON DELETE CASCADE
);

-- 도서 등록 내역 관리 테이블
CREATE TABLE BOOK_REGISTRATION_LOG (
    LOG_ID NUMBER(6) PRIMARY KEY, -- 로그 고유번호
    U_NUMBER NUMBER(5) NOT NULL, -- 도서 등록을 한 관리자 USERINFO외례키
    B_NUMBER NUMBER(6) NOT NULL, -- 등록된 도서 번호 BOOK 외례키
    REG_DATE DATE DEFAULT SYSDATE, -- 등록일자
    CONSTRAINT FK_BOOK_REG_USER FOREIGN KEY (U_NUMBER) REFERENCES USER(U_NUMBER) ON DELETE CASCADE,
    CONSTRAINT FK_BOOK_REG_BOOK FOREIGN KEY (B_NUMBER) REFERENCES BOOK(B_NUMBER) ON DELETE CASCADE
);

-- 게시판 테이블
CREATE TABLE BOARD (
    B_ID NUMBER(5) PRIMARY KEY, -- 게시글 고유번호
    U_NUMBER NUMBER(5), -- 작성자 (USER 테이블 참조)
    B_TITLE VARCHAR2(100), -- 게시글 제목
    B_CONTENT CLOB, -- 게시글 내용
    B_WRITEDATE DATE DEFAULT SYSDATE, -- 작성일
    B_VIEWS NUMBER(5) DEFAULT 0, -- 조회수
    B_LIKES NUMBER(5) DEFAULT 0, -- 좋아요 수
    CONSTRAINT FK_BOARD_USER FOREIGN KEY (U_NUMBER) REFERENCES USER(U_NUMBER) ON DELETE CASCADE
);

-- 댓글 테이블
CREATE TABLE COMMENT (
    C_ID NUMBER(5) PRIMARY KEY, -- 댓글 고유번호
    B_ID NUMBER(5), -- 어느 게시글의 댓글인지 (BOARD 참조)
    U_NUMBER NUMBER(5), -- 작성자 (USER 테이블 참조)
    C_CONTENT VARCHAR2(500), -- 댓글 내용
    C_WRITEDATE DATE DEFAULT SYSDATE, -- 작성일
    CONSTRAINT FK_COMMENT_BOARD FOREIGN KEY (B_ID) REFERENCES BOARD(B_ID) ON DELETE CASCADE,
    CONSTRAINT FK_COMMENT_USER FOREIGN KEY (U_NUMBER) REFERENCES USER(U_NUMBER) ON DELETE CASCADE
);
```

## ERD
![image](https://github.com/user-attachments/assets/e37eb2fd-e6f8-457a-8bf0-caaeecd9eebb)

```

Table USERINFO {
    U_NUMBER NUMBER [primary key] // 유저 고유번호
    U_ID VARCHAR(30) // 유저 아이디
    U_PW VARCHAR(30) // 유저 비번
    U_NAME VARCHAR(20) // 유저 이름
    U_EMAIL VARCHAR(50) // 유저 이메일
    U_BORROW NUMBER(1) // 유저가 최대 빌릴 수 있는 수 (3권)
    U_ADMIN BOOLEAN // 유저 관리자확인 1,0
    U_REGDATE DATE // 유저 회원가입날짜
}

Table BOOK {
    B_NUMBER NUMBER [primary key] // 고유번호
    B_TITLE VARCHAR(50) // 제목
    B_COMENT VARCHAR(100) // 짧은 내용
    B_WRITER VARCHAR(20) // 저자
    B_PUB VARCHAR(30) // 출판사
    B_DATE DATE // 출판일자
    B_CATEGORY VARCHAR(50) // 카테고리
    B_COUNT NUMBER(2) // 몇 권 남아있는지
    B_BORROWCOUNT NUMBER(3) // 얼마나 빌렸는지
}

Table BOOK_BORROW {
    BORROW_NUMBER NUMBER [primary key] // 고유번호
    U_NUMBER NUMBER // 유저 고유번호
    B_NUMBER NUMBER // 책 고유번호
    B_BORROWDATE DATE // 빌린 날짜
}
    Ref: BOOK_BORROW.U_NUMBER > USERINFO.U_NUMBER
    Ref: BOOK_BORROW.B_NUMBER > BOOK.B_NUMBER

TABLE BOOK_RETURN{
    RETURN_NUMBER NUMBER [primary key] // 고유번호
    U_NUMBER NUMBER // 유저 고유번호
    B_NUMBER NUMBER // 책 고유번호
    B_RETURNDATE DATE // 반납일자
}

    Ref: BOOK_RETURN.U_NUMBER > USERINFO.U_NUMBER
    Ref: BOOK_RETURN.B_NUMBER > BOOK.B_NUMBER

TABLE BOOK_REGISTATION_LOG {
    LOG_ID NUMBER [primary key]
    U_NUMBER NUMBER
    B_NUMBER NUMNER
    REG_DATE DATE [default:'SYSDATE']
}
  REF: BOOK_REGISTATION_LOG.U_NUMBER > USERINFO.U_NUMBER
  REF: BOOK_REGISTATION_LOG.B_NUMBER > BOOK.B_NUMBER

Table BOARD {
    BD_ID NUMBER [primary key] // 게시글 고유번호
    U_NUMBER NUMBER // 작성자 (USER 테이블 참조)
    BD_TITLE VARCHAR(100) // 게시글 제목
    BD_CONTENT TEXT // 게시글 내용
    BD_WRITEDATE DATE [default: `SYSDATE`] // 작성일
    BD_VIEWS NUMBER(5) [default: 0] // 조회수
    BD_LIKES NUMBER(5) [default: 0] // 좋아요 수
}
    Ref: BOARD.U_NUMBER > USERINFO.U_NUMBER

    
Table COMMENT {
    CT_ID NUMBER [primary key] // 댓글 고유번호
    BD_ID NUMBER // 어느 게시글의 댓글인지 (BOARD 참조)
    U_NUMBER NUMBER // 작성자 (USER 테이블 참조)
    CT_CONTENT VARCHAR(500) // 댓글 내용
    CT_WRITEDATE DATE [default: `SYSDATE`] // 작성일
}
    Ref: COMMENT.U_NUMBER > USERINFO.U_NUMBER
    Ref: COMMENT.B_ID > BOARD.B_ID
```


## 로그인 & 회원가입 플로우차트
![image](https://github.com/user-attachments/assets/42c9b8b7-f470-4843-82bc-3ed59fce2352)

## 도서 등록 플로우차트
![image](https://github.com/user-attachments/assets/ddda9356-1cb5-4e6b-aa1d-6a7f0d169dc4)

