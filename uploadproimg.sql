create table pro_upload(

filename VARCHAR2(300) not null,
pno NUMBER,
CONSTRAINT fk_upload_pno foreign key(pno) references product(pno)
on delete cascade
)


drop table pro_upload


SELECT pno FROM product