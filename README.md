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

## 🛑주의사항🛑
- jsp의 body부에서 각 input의 name은 Entity의 참조변수를 따라가야합니다. 꼭 주의해서 작성해주세요.
- entity 및 model 패키지의 경로와 클래스, 인터페이스 파일 이름이 변경 될 수 있습니다. 변경시 말씀드림

  **** 컨트롤러 부분을 세분화하여 분리 할 수 있습니다. 컨트롤러부분의 내용만 세분화하고 나머지는 이름변경만 할 수 있습니다.
  
  현재 == model, entity => DB데이터 보냄 => controller => DB데이터를 가공하여 표현 => views

  변경 될 수 있음 == DAO, entity => DB데이터보냄 => Service = DB데이터를 객체에 담음 => controller => DB데이터 표현 => views

  DAO - 쿼리문
  
  DTO - 엔티티
  
  Service - DAO와 controller 중간다리
  
  controller - view와 중간다리
  

## 서비스 구현
- 2025-04-02. 로그인, 세션(loginUser사용하세요. UserController참고.) - 정종현
- 2025-04-02. 도서 등록 예외처리 완료 *(보완점 발견 시 수정필요) - 이병훈
  
  🛑 카테고리를 문자열로 입력하는게 아닌 사용자에게 직접 보기를 보여주는 식으로 표현이 좋아보임
- 2025-04-02. 회원가입 예외처리 완료 *(회원가입 성공시 완료 화면 및 화면이동 필요) - 정종현

## 변경 사항
- 2025-04-02. lombok 사용을 위한 dependency 추가
```
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
   <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.36</version>
      <scope>provided</scope>
   </dependency>
```


## DB쿼리문
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
    U_NUMBER NUMBER(5), -- 유저 고유번호
    B_NUMBER NUMBER(6), -- 책 고유번호
    B_BORROWDATE DATE, -- 빌린날짜
    CONSTRAINT FK_BOOK_BORROW_USER FOREIGN KEY (U_NUMBER) REFERENCES USERINFO(U_NUMBER) ON DELETE CASCADE,
    CONSTRAINT FK_BOOK_BORROW_BOOK FOREIGN KEY (B_NUMBER) REFERENCES BOOK(B_NUMBER) ON DELETE CASCADE
);

CREATE TABLE BOOK_RETURN(
    U_NUMBER NUMBER(5), -- 유저 고유번호
    B_NUMBER NUMBER(6), -- 책 고유번호
    B_RETURNDATE DATE, -- 반납일자
    CONSTRAINT FK_BOOK_RETURN_USER FOREIGN KEY (U_NUMBER) REFERENCES USERINFO(U_NUMBER) ON DELETE CASCADE,
    CONSTRAINT FK_BOOK_RETURN_BOOK FOREIGN KEY (B_NUMBER) REFERENCES BOOK(B_NUMBER) ON DELETE CASCADE
);
```
