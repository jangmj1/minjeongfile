drop database if exists jspweb;
create database jspweb;
use jspweb;
drop table if exists ex1;
create table ex1(
	e_data varchar(100)
    );
select*from ex1;

drop table if exists q1;
create table q1(
	e_data varchar(100)
    );
 select*from q1;
 
 drop table if exists ex2;
 create table ex2(
  data1 varchar(100),
  data2 varchar(100),
  data3 double,
  data4 int,
  data5 date,
  data6 datetime,
  data7 char(1),
  data8 boolean,
  data9 varchar(100),
  data10 longtext
  );
  select*from ex2;
  
  create table ex2_2(
  이름 varchar(100),
  전화번호 varchar(20),
  키 double,
  나이 int,
  등록일 date,
  성별 char(1),
  동의 boolean,
  지역 varchar(5),
  소개 longtext
  );
  select*from ex2_2;
  
  drop table if exists ex3;
  create table ex3(
  bno int auto_increment primary key,
  bcontent varchar(1000),
  bwriter varchar(100),
  bdate datetime default now()
  );
  
  
  select * from ex3;
  
delete from ex3 where bno ='1';
  
drop table if exists ex4;
create table ex4(
pno int auto_increment primary key,
pproduct varchar(20),
pprice varchar(20)
);

select*from ex4;
update ex4 set pproduct='선풍기', pprice='100만원' where pno=4;

drop table if exists member;
create table member(
mno int auto_increment primary key,
mid varchar(30)not null unique, -- 회원 아이디 not null:공백불가  unique:중복불가
mpwd varchar(20)not null, -- 회원 비밀번호 not null:공백불가
mimg longtext , -- 웹 서버에 저장된 사진 경로 공백 가능
memail varchar(100)

);
-- 친추 테이블
drop table if exists friend;
create table friend(
fno int auto_increment primary key,
ffrom int, -- 친구 신청한 회원 fk
fto int, -- 친구 신청 받은 회원 fk
foreign key(ffrom) references member(mno) on delete set null, -- 친구가 탈퇴하면 null
foreign key(fto) references member(mno) on delete set null
);

drop table if exists mpoint;
create table mpoint(
mpno int auto_increment primary key, -- 포인트 내역 식별번호
mpcomment varchar(1000), -- 포인트 내역 내용
mpoint int default 0, -- 포인트 수량
mdate datetime default now(), -- 포인트 내역 날짜
mno int, -- 포인트 받는 회원
foreign key(mno) references member (mno) on delete set null -- 회원이 탈퇴하면 포인트 없어짐
);
select * from member; 


  

  
  
  
