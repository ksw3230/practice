CREATE TABLE t_board (
  "IDX" NUMBER NOT NULL,
  "REF" NUMBER, 
  "LEV" NUMBER,
  "SEQ" NUMBER,
	"USERID" CHAR(20 BYTE) NOT NULL,  
	"TITLE" VARCHAR2(100 BYTE) NOT NULL, 
	"CONTENT" VARCHAR2(500 BYTE) NOT NULL, 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	"HIT" NUMBER DEFAULT 0, 
	"IP" CHAR(15 BYTE),
  "NOTICE" CHAR(10 BYTE), 
	PRIMARY KEY ("IDX")
);

create sequence t_board_idx_seq;

insert into t_board (idx, ref, lev, seq, userid, title, content, ip, notice)
	values (t_board_idx_seq.nextval, t_board_idx_seq.currval, 0, 0, 'aaaa', '�Խñۿø���', '1���̴�.', '192.168.100.001', '');
insert into t_board (idx, ref, lev, seq, userid, title, content, ip, notice)
	values (t_board_idx_seq.nextval, t_board_idx_seq.currval, 0, 0, 'ksw3230', '������ �Խñ�', '2���̴�.', '192.168.100.002', '');
insert into t_board (idx, ref, lev, seq, userid, title, content, ip, notice)
	values (t_board_idx_seq.nextval, t_board_idx_seq.currval, 0, 0, 'bbbb', '���̾��̾�', '3���̴�.', '192.168.100.003', '');
insert into t_board (idx, ref, lev, seq, userid, title, content, ip, notice)
	values (t_board_idx_seq.nextval, t_board_idx_seq.currval, 0, 0, 'cccc', '������ �� ������?', '4���̴�.', '192.168.100.004', '');
  
select * from t_board order by idx desc;
select * from (
	
  
commit;

select * from (select * from t_board where notice='notice' order by idx desc) where rownum=1;