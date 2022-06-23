CREATE TABLE tbl_qna(
	qno NUMBER,
	userid VARCHAR2(300),
	qTitle VARCHAR2(300),
	qContent VARCHAR2(500),
	qWriteDay DATE DEFAULT SYSDATE,
	qUpdateDay DATE DEFAULT SYSDATE,
	CONSTRAINT pk_qna_qno PRIMARY KEY(qno)
)



ALTER TABLE tbl_qna ADD(readCnt NUMBER)


ALTER TABLE tbl_qna MODIFY(readCnt NUMBER DEFAULT 0)

SELECT * FROM tbl_qna

DELETE FROM tbl_qna

DROP TABLE tbl_qna

DROP TABLE tbl_qna_upload

CREATE SEQUENCE seq_qna_qno

DROP SEQUENCE seq_qna_qno








