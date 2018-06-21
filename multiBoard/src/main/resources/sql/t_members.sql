create table t_member(
userid varchar2(50) not null primary key,
passwd varchar2(50) not null,
name varchar2(50) not null,
email varchar2(50),
gender varchar2(20),
join_date date default sysdate
);
drop table t_member;

alter table t_member add(user_level number(10) default 0);


insert into t_member (userid, passwd, name, email, gender) 
values('aaaa', '1111', '홍길동', 'hong@han.com', '남자');

insert into t_member (userid, passwd, name, email, gender) 
values('bbbb', '2222', '임걱정', 'lim@han.com', '남자');

select * from t_member;

select name from t_member where userid = 'aaaa';

create table t_admin(
userid varchar2(50) not null primary key,
passwd varchar2(50) not null,
name varchar2(50) not null,
email varchar2(50),
gender varchar2(20),
join_date date default sysdate
);

insert into t_admin (userid, passwd, name, email, gender) 
values('admin', '1111', '관리자', 'admin@untitled.com', '남자');

commit;
