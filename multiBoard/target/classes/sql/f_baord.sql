create table f_board(
idx number not null primary key,
userid varchar2(50),
title varchar2(200),
content clob,
regdate date default sysdate,
hit number
);

create sequence f_board_seq;

create table f_comment(
  idx NUMBER NOT NULL, 
	ref NUMBER, 
	userid CHAR(20 BYTE) NOT NULL, 
	content VARCHAR2(300 BYTE) NOT NULL, 
	regdate date DEFAULT sysdate, 
	PRIMARY KEY (idx)
);

create sequence f_comment_seq;


create table f_attach(
fullName varchar2(150) not null,
idx number not null,
regdate date default sysdate,
primary key(fullName)
);

commit;