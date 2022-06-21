CREATE TABLE tbl_qna_upload(
	qno NUMBER,
	fileName VARCHAR2(300),
	CONSTRAINT fk_qna_upload_qno FOREIGN KEY(qno) REFERENCES tbl_qna(qno)
	ON DELETE CASCADE
)

alter table tbl_qna_upload modify fileName not null


SELECT * FROM tbl_qna_upload

DELETE FROM tbl_qna_upload
