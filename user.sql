CREATE TABLE tbl_user(
	userId VARCHAR2(15),
	uName VARCHAR2(15) NOT NULL,
	uNickname VARCHAR2(20) UNIQUE NOT NULL,
	uPassword VARCHAR2(30) NOT NULL,
	uBirth DATE,
	uPostnumber VARCHAR2(10) NOT NULL,
	uAddress VARCHAR2(200) NOT NULL,
	udetailAddress VARCHAR2(100) NOT NULL,
	uPhone VARCHAR2(15) UNIQUE NOT NULL,
	uEmail VARCHAR2(50) UNIQUE NOT NULL,
	uGrade VARCHAR2(15) DEFAULT 'bronz',
	uSigndate DATE DEFAULT SYSDATE,
	uPoint NUMBER DEFAULT 0,

	CONSTRAINT pk_user_userId PRIMARY KEY(userId)
)


SELECT * FROM tbl_user

DROP TABLE tbl_user


ALTER TABLE tbl_user MODIFY uPostnumber VARCHAR2(10);


INSERT INTO tbl_user (userId,uName,uNickname,uPassword,uBirth,uPostnumber,uAddress,udetailAddress,uPhone,uEmail,uGrade) 
VALUES ('m002', '초콜렛', '초코', '1111', '2022-06-16', 12083, '서울시 중랑구 상봉로', '211동 111호', '01015789874', 'jinnny702@naver.com', 'silver');

DELETE FROM tbl_user WHERE userId = 'm001';