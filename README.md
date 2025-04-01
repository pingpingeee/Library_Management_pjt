## Library_management_pjt

  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
  <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"> 
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 

#### pilot pjt 1

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
  도서 검색 후 화면
- book_update.jsp
  도서 수정 화면
- join.jsp
  회원가입 화면
- jogin.jsp
  로그인 화면
- main.jsp
  메인 화면
- search_book.jsp
  도서 검색 결과 화면
- user_info.jsp
  유저 정보 조회 화면
- user_update.jsp
  유저 정보 수정 화면

##### entitiy
- User.java
  유저 엔티티
- Book.java
  도서 엔티티

---
```
CREATE TABLE USER (
    U_NUMBER NUMBER(5) PRIMARY KEY, // 유저 고유번호
    U_ID VARCHAR2(30), // 유저 아이디
    U_PW VARCHAR2(30), // 유저 비번
    U_NAME VARCHAR2(20), // 유저 이름
    U_EMAIL VARCHAR2 (50), // 유저 이메일
    U_TEL VARCHAR2 (14), // 유저 전화번호
    U_BIRTH VARCHAR2 (8), // 유저 생일
    U_ADDRESS VARCHAR2 (150), // 유저 주소
    U_BORROW number(1), // 유저가 최대 빌릴 수 있는 수 (3권)
    U_ADMIN BOOLEAN, // 유저 관리자확인 1,0
    U_REGDATE DATE DEAFULT now()// 유저 회원가입날짜
);

CREATE TABLE BOOK (
    B_NUMBER NUMBER(5) PRIMARY KEY, // 고유번호
    B_TITLE VARCHAR2 (50), // 제목
    B_COMENT VARCHAR2 (100), // 짧은 내용
    B_WRITER VARCHAR2(20), // 저자
    B_PUB VARCHAR2(30), //출판사
    B_DATE DATE, // 출판일자
    B_CATEGORY VARCHAR2(50), // 카테고리
    B_COUNT NUMBER(2), // 몇권남아있는지
    B_BORROWCOUNT NUMBER(3) // 얼마나 빌렸는지
);

CREATE TABLE BOOK_BORROW(
    U_NUMBER NUMBER(5), // 유저 고유번호
    B_NUMBER NUMBER(5), // 책 고유번호
    B_BORROWDATE DATE, // 빌린날짜
    B_RETURNDATE DATE // 반납일자
    CONSTRAINT FK_BOOK_BORROW_USER FOREIGN KEY (U_NUMBER) REFERENCES USER(U_NUMBER) ON DELETE CASCADE,
    CONSTRAINT FK_BOOK_BORROW_BOOK FOREIGN KEY (B_NUMBER) REFERENCES BOOK(B_NUMBER) ON DELETE CASCADE
);
```
