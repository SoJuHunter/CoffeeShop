create TABLE product(
pno NUMBER,
pName  varchar2(30) NOT NULL,
pContent varchar2(100) NOT NULL,
pPrice  NUMBER NOT NULL,
pStock  NUMBER NOT NULL,
pCategory  VARCHAR2(50) NOT NULL,
pSize VARCHAR2(10) NOT NULL,
pOrigin VARCHAR2(50) NOT NULL,
CONSTRAINT pk_product_pno PRIMARY KEY (pno)
)

drop table product 

create sequence seq_product_pno
drop sequence pro_upload_pno
drop sequence seq_product_pno;
select * from product
ALTER TABLE product DROP CONSTRAINT pk_product_pno;
delete from product  where pno = 45

select cartCount from tbl_orderItem
inner join product 
on Product.pno = Product.pno

