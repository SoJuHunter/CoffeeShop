CREATE TABLE notice_upload(
   nno NUMBER,
   fileName VARCHAR2(300) not null,
   CONSTRAINT fk_notice_upload_nno FOREIGN KEY(nno) REFERENCES tbl_notice(nno)
   ON DELETE CASCADE
)

drop table notice_upload