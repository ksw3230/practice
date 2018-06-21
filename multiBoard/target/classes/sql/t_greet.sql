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

insert into t_greet(idx, userid, content) values(t_greet_idx_seq.nextval, 'ksw3230', '�ȳ��ϼ���~!');
insert into t_greet(idx, userid, content) values(t_greet_idx_seq.nextval, 'aaaa', '�����λ� �帳�ϴ�.');
insert into t_greet(idx, userid, content) values(t_greet_idx_seq.nextval, 'bbbb', '�ȳ��ϼ���~! �����߾��~!');
insert into t_greet(idx, userid, content) values(t_greet_idx_seq.nextval, 'admin', '������ �Դϴ�.�ȳ��ϼ���~!');
insert into t_greet(idx, userid, content) values(t_greet_idx_seq.nextval, 'seanthebest', '�����ؾ��ϴ�.');
commit;