create table t_imageBoard(
idx number not null primary key,
userid varchar2(50),
title varchar2(200),
content varchar2(500),
pictureUrl varchar2(200)
);

drop table t_iamgeBoard;

insert into t_imageBoard values (t_imageBoard_idx_seq.nextval, 'ksw3230', '포도', '달달한포도', 'grape.jpg');

create SEQUENCE t_imageBoard_idx_seq;
select *from t_imageBoard;
SELECT * from(select * from t_imageBoard order by idx desc) where rownum=1;


select * from (
			select rownum rnum, G.* from (
				select * from t_imageboard order by idx desc
			) G where rownum <= 4
		) where rnum >= 1;







commit;