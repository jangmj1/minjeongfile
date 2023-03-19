drop database if exists nibo;
create database nibo;
use nibo;

drop table if exists exercise;
create table exercise(
eno int auto_increment primary key,
sports varchar(20) not null,
calorie double not null
);


insert into exercise (sports,calorie)value('운동안함',0);
insert into exercise (sports,calorie)value('계단오르기',66);
insert into exercise (sports,calorie)value('요가',24);
insert into exercise (sports,calorie)value('수영',85);
insert into exercise (sports,calorie)value('줄넘기',95);
insert into exercise (sports,calorie)value('자전거',76);
insert into exercise (sports,calorie)value('런닝머신',99);


select * from exercise;

drop table if exists mypage;
create table mypage(
today date,
height double,
weight double not null,
bmi double,
eno int default 1,
foreign key (eno) references  exercise(eno) -- 운동이 사라져도 운동한 내역은 사라지지말것
);
select * from mypage;
insert into mypage(height,weight,bmi)value(164,53,19.7);
select * from  mypage m,exercise e where m.eno=e.eno;


