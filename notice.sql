CREATE TABLE tbl_notice(
	nno 		 NUMBER,
    userId       VARCHAR2(30) NOT NULL,
    nTitle       VARCHAR2(300) NOT NULL,
    nContent     VARCHAR2(4000) NOT NULL,
    nWritedate   DATE DEFAULT SYSDATE,
 	nUpdatedate  DATE DEFAULT SYSDATE,
 	readCnt NUMBER DEFAULT 0,
 	CONSTRAINT pk_notice_nno PRIMARY KEY(nno)
)

CREATE SEQUENCE seq_tbl_notice_nno;

select * from user_sequences
SELECT * FROM tbl_notice;

drop sequence seq_notice_nno;
drop table tbl_notice;
drop table notice_upload