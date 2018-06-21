CREATE TABLE imageComment (
  "IDX" NUMBER NOT NULL, 
	"REF" NUMBER, 
	"USERID" CHAR(20 BYTE) NOT NULL, 
	"CONTENT" VARCHAR2(300 BYTE) NOT NULL, 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	PRIMARY KEY ("IDX")
  
)

drop sequence imageComment_idx_seq;
create sequence imageComment_idx_seq;

commit;

select * from imageComment;

select * from imageComment where ref=62 order by idx desc;

