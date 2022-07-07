drop table if exists board_tbl; 

create table board_tbl(
	bno int auto_increment primary key, 
    title varchar(300) not null, 
    content text not null, 
    writer varchar(50) not null, 
    regDate timestamp default current_timestamp, 
	updateDate timestamp default current_timestamp
);

insert into board_tbl(title,content, writer)
values ('게시물 제목입니다.','내용 테스트1.','거시기');
insert into board_tbl(title,content, writer)
values ('게시물 제목입니다.2','내용 테스트2','거시기2');
insert into board_tbl(title,content, writer)
values ('게시물 제목입니다.3','내용 테스트3','거시기3');
insert into board_tbl(title,content, writer)
values ('게시물 제목입니다.4','내용 테스트4','거시기4');