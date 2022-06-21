CREATE TABLE notice_upload(
   nno NUMBER,
   fileName VARCHAR2(300),
   CONSTRAINT fk_notice_upload_nno FOREIGN KEY(nno) REFERENCES tbl_notice(nno)
   ON DELETE CASCADE
)
