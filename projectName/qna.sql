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

CREATE TABLE tbl_qna_upload(
	qno NUMBER,
	fileName VARCHAR2(300),
	CONSTRAINT fk_qna_upload_qno FOREIGN KEY(qno) REFERENCES tbl_qna(qno)
	ON DELETE CASCADE
)

alter table tbl_qna_upload modify fileName not null


SELECT * FROM tbl_qna_upload

CREATE TABLE tbl_readcnt_ip(
	ip VARCHAR2(300),
	qno NUMBER,
	CONSTRAINT pk_readcnt_ipNqno PRIMARY KEY(ip, qno)
)

DELETE FROM tbl_qna_upload

SELECT * FROM tbl_qna_upload

CREATE TABLE tbl_qna_reply(
	qno NUMBER,
	replyText VARCHAR2(500),
	CONSTRAINT fk_qna_reply_qno FOREIGN KEY(qno) REFERENCES tbl_qna(qno)
)

SELECT * FROM tbl_qna_reply

alter table tbl_qna_reply modify replyText not null

DELETE FROM tbl_qna_reply

ALTER TABLE tbl_qna_reply ADD (rno NUMBER)

alter table tbl_qna_reply modify rno not null

ALTER TABLE tbl_qna_reply ADD CONSTRAINT pk_qna_reply_rno PRIMARY KEY(rno)

ALTER TABLE tbl_qna_reply DROP COLUMN rno

CREATE SEQUENCE seq_qna_reply_rno

