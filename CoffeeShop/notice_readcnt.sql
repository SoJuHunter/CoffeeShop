CREATE TABLE notice_readcnt(
	ip VARCHAR2(300),
	nno NUMBER,
	CONSTRAINT pk_notice_readcnt_ipNnno PRIMARY KEY(ip, nno)
)
