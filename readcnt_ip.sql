CREATE TABLE tbl_readcnt_ip(
	ip VARCHAR2(300),
	qno NUMBER,
	CONSTRAINT pk_readcnt_ipNqno PRIMARY KEY(ip, qno)
)