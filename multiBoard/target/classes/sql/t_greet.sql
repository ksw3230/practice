create table t_greet(
idx number not null primary key,
userid varchar2(50),
content varchar2(200),
reg_date date DEFAULT sysdate
);
delete from t_greet;
drop sequence t_greet_idx_seq;
create sequence t_greet_idx_seq;

select * from t_greet;

insert into t_greet(idx, userid, content) values(t_greet_idx_seq.nextval, 'ksw3230', '안녕하세요~!');
insert into t_greet(idx, userid, content) values(t_greet_idx_seq.nextval, 'aaaa', '가입인사 드립니다.');
insert into t_greet(idx, userid, content) values(t_greet_idx_seq.nextval, 'bbbb', '안녕하세요~! 가입했어요~!');
insert into t_greet(idx, userid, content) values(t_greet_idx_seq.nextval, 'admin', '관리자 입니다.안녕하세요~!');
insert into t_greet(idx, userid, content) values(t_greet_idx_seq.nextval, 'seanthebest', '가입해씁니다.');
commit;