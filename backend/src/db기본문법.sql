/*
	SQL
		DDL
			create
				create database DB명
                create table 테이블명(피리드명1 타입 제약조건);
			drop
				drop database DB명;
                drop database if existe DB명; <-DB명이 존재하면 삭제
                drop table 테이블명;
                drop table if exists 테이블명;

		DML
        DCL
        
        - 타입[DBMS 회사마다 다름]
        1.정수형
			tinyint
            smallint
            int
            bigint
		2.문자형
			char(길이)		: 고정길이
			varchar(길이)	: 가변길이
		3.대용량[긴글,짧은글]
			text
            longtext
		4.실수형
			float
            double
		5.날짜형
			date
            time
            datetime
            

*/

-- 1.db생성
	drop database if exists market;
    create database market;
    use market;
-- 2. table생성 (삭제전 드랍 먼저 만들기)
	drop table if exists member;
    -- 테이블 앞글자 언더바 필드명을 쓴다 
    create table member(	
		mid char(8) not null primary key,
			-- char(길이) : 길이 만큼 문자 저장 최대 8글자 초과 안됨,
            -- not null : 공백 저장 불가능 말그대로 null 안씀[만일 공백이면 저장 실패]
            -- primary key: (기본키) 식별키 [필드내 중복 불가능.공백불가능]=>주민번호,학번,회원번호,사번,제품번호등 중복 안되는것들사용
		mname varchar(10) not null,
			-- varchar(길이) : 가변길이[데이터의 길이가 일정하지 않을때]
            -- 가변길이 : 저장된 데이터 만큼 메모리 할당
				-- varchar(8) => 에서 'abc' 저장시 5칸은 메모리 자동 제거
            -- 고정길이 : 선언된 길이 만큼 메모리 할당
				-- char(8) => 에서'abc'저장시 8칸 메모리 고정 [3칸:abc , 5칸 : 빈공간]
		mnumber int not null,
			-- int : 정수+-20억 정도 저장 가능
		maddr char(2) not null,  	-- [최대 2글자 저장 공백 불가능]
		mphone1 char(3) ,			-- [최대 3글자 공백 가능]
        mphone2 char(8),			-- [전화번호 최대 8글자 공백 가능]
        mheight smallint,			-- [+-3만 정도 ]
        mdebut date				-- [날짜]
                
    )	;
 
    
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
   select*from member;
-- -----------------------------------------------------------------------------------------

drop table if exists buy;

create table buy(
bnum int auto_increment primary key, -- 구매번호
mid char(8) , -- 구매한 회원 [외래키]
bpname char(6) not null,-- w제품이름
bgname char(4) ,
bprice int not null, 
bamout smallint not null,
foreign key(mid)references member(mid) -- 관계
-- 외래키설정필드(핸재테이블 필드명) 참조하다 pk위한 테이블명 (pk필드명)
-- foreign 외래키
-- references
);
select*from buy;

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

select*from buy;
-- 1.
select mid from member; -- 필드명1,필드명 2 만 보는거
select mid,mname from member;
-- 2.
select * from member; -- *을 넣으면 모든걸 다 불러온다
-- 3.
select mid as'회원아이디'from member; -- mid라고 찍히지않고 별칭으로 바껴서 찍힘
select mid '회원아이디'from member; -- as 생략가능
-- 4.
select * from member where mname='블랙핑크';	-- 회원명이 블랙 핑크인 레코드 검색
select * from member where mnumber=4; -- 맴버필드가 4명인것들 다 나온다
select * from member where mheight <= 162; -- 키 필드가 162이하이면
select * from member where mheight >=165 and mnumber>6; -- 키 필드가 165이상이면서 맴버수가 6초과이면
select * from member where mheight >=165 or mnumber >6; -- 키 필드가 165이상이거나 맴버수가 6초과이면
select * from member where mheight >=163 and mheight <=165;	-- 키 필드가 163 부터 165 까지
select * from member where mheight between 163 and 165; -- 키 필드가 163 부터 165 까지 위에꺼랑 같음
select * from member where maddr = '경기' or maddr = '전남'  or  maddr ='경남'; -- 주소가 경기,전남,경남 일경우
select * from member where maddr in ('경기','전남','경남');-- 주소가 경기,전남,경남 일경우 위에꺼랑 같음
select * from member where mname='우주소녀';
select * from member where mname like '우%'; -- 우로 시작하는 문자 찾기 
select * from member where mname like '%우'; -- 우로 끝나는 문자 찾기 
select * from member where mname like '%우%'; -- 우가 포함됨
select * from member where mname like '우___';-- 우 땡 땡 땡 인것들은 다 출력
select * from member where mname like '_우_'; -- 3글자중 카운데 글자가 '우'안 뮨저 첮가

select mnumber , mnumber+1 ,mnumber-1,mnumber*2,mnumber/2,mnumber div 2, mnumber mod 2 from member; -- div : 몫  , mod : 나머지
select mnumber * mheight 맴버키점수 from member;

-- 5 select*from 테이블명 order by 정렬기준필드
	-- select*from 테이블명 where 조건
select * from member order by mdebut asc; -- 과거순
select * from member order by mdebut desc; -- 최신군
select * from member order by mheight desc where mheight >=164;
select * from member where mheight >= 164 order by mheight; -- 오류해결
	-- 키를 내림 차순으로 정렬후 동일한 키가 있을경우 동일한 키 중에서 데뷔날짜를 오름차순으로 
select * from member order by mheight desc, mdebut asc;

	/*
		학년 점수		학년 정렬 ->점수 정렬	학년 점수
        1	50							1	50
        3	70							1	60
        1	60							3	20
        2
        
   
    */
    -- 레코드 수
    select *from member limit 3;
	select *from member limit 0,3;
	select * from member order by mheight desc limit 3;
    
    -- 7. 중복제거
    select addr from member;
    select distinct maddr from member;

	-- 8 select *from 테이블명 group by 그룹기준필드
		select bamout from buy; -- 판매수량 필드 검색
        select sum(bamout) from buy; -- 판매수량
        select avg(bamout) from buy; -- 판매수량 필드 평균
        select max(bamout) from buy; -- 판매수량 최대값
        select min(bamout) from buy; -- 판매수량 최소값
        select count(bamout) from buy; -- 판매수량 필드의 레코드수[null 포함]
        select count(*)   from buy; -- 전체 레코드수 널이 없어서 위꺼랑 같다
        
	-- 1. 회원 아이디[그룹] 별로 판매수량 합계
     select mid, sum(bamout) as 구매수량총합 from buy group by mid;
     
     -- 2. 회원아이디[그룹]별로 총매출액 [가격 * 수량 ] 합계
     select mid 회원아이디, sum(bprice * bamout) as 총매출액 from buy group by mid;
     
     -- 3. 회원아이디[그룹] 별로 판매 수량 평균
     select mid 회원아이디, avg (bamout) as 판매수량평균 from buy group by mid;
     
     -- 4.
     select mid 회원아이디,count(*) as 결제수량 from buy group by mid;
  
     -- 9 select * from 테이블명 group by 그룹기준필드 having 그룹내조건
		-- *.회원아이디[그룹] 별로 총매출액[가격*수량] 합계가 1000이상이면
		select mid 회원아이디 , sum(bprice*bamout) as 총매출액 
        from buy 
        group by mid
        having sum(bprice * bamout) >=1000;
        
     
	
   -- 인설트 insert
	-- 1. 특정필드에 값 삾입	: insert into 테이블명(필드명1,필드명2) values (값1, 값2);
    -- 2. 전체필드값에 삽입	: insert into 테이블명 values(값1, 값2)
    -- 3. 다중삽입		: insert into 테이블 values(값1,값2,),(값1,값2);
    -- 4. 검색된결과를삽입	: insert into 테이블명 select
    -- 5. 마지막으로 추가된 레코드의 pk값 확인 : select last_insert_id();
    
    create table maddr(mid char(8) , maddr char(2) ); -- 회원아이디와 ,주소필드를 갖는 테이블
    select*from member limit 5; -- 0번 레코드에서 5개 검색
    insert into maddr select mid,maddr from member limit 5; -- 검색한 필드를 새로만든 테이블maddr 로  찾아서 바로삽입 (대신 순서와 필드명이 동일해야한다)
    select * from maddr;
    select last_insert_id();
    
    
    -- update
		-- update 테이블명 set 필드명 = 수정할값 where 조건식
        -- 1. 해당 테이블에서 주소가 서울이면 'seoul'
        select * from member;
        update member set maddr = 'seoul' where maddr='서울'; -- 오류 [char(2)] 이여서 seoul 못함
        -- 기본적으로 update와 delete 못함
			-- 해결방법 : edit ->prefernces->사이드메뉴 SQL editor 선택 -> 가장아래 safe updates 체크 해제
        update member set maddr = 'se' where maddr='서울';
        update member set mnumber=mnumber/3;
        update member set maddr='안산';
    
    -- delete
		-- delete from 테이블명 where 조건식
        -- *만일 관게 테이블이 경우 다른 테이블에서 fk필드로 사용된 레코드는 삭제불가능[*제약조건을 넣어야한다]
        -- 1. 만약에 핑크가 포함된 이름을 삭제하기
        delete from member where mname like '%핑크%'; -- ??? 오류난다  이유 : 관계까 있는 테이블에서 pk필드가 포함된 레코드 삭제불가능
        delete from member where mname ='잇지';
        
    
    






/*
	연산자
		1.산술연산자 : + - * /  div(몫) mod (나머지)
		2.비교연산자 : >=이상 <=이하 >초과 <미만 =같다 !=같지않다
        3.논리연산자 : and 이면서 or 이거나 not 부정
        4.기타연산자 : 
			in(값1,값2,값3)		  	: 값1~값3 하나라도 존재하면 [값1 or 값2 or 값3]
            값 between 값1 and 값2	: 값이 값1 부터 값2 사이이면 true [값 >=값1 and 값<=값2]
            like					: 패턴검색
				% : 모든 문자수 대응	_:_갯수만큼 문자수 대응
		5.null관련 연선자
			=null [x]
            필드명 is null : null 이면
            필드명 is not null : null 이 아니면
            
        집계함수[2개 필드 검색시 그룹 ㅍ]
			sum(필드명) : 해당 필드내 데이터 총합
            avg(필드명) : 해당 필드내 데이터 평균
            max(필드명) : 해당 필드내 데이터 최대값
            min(필드명) : 해당 필드내 데이터 최소값
            count(필드명) : 해당 필드내 데이터수 [null 미포함] / count(*) :레코드수 [null 포함]
			count(*) : 레코드수[null포함]
*/




-- 타입확인
drop table if exists testtype;
create table testtype(
	tinyint_col tinyint, -- 1바이트
    smallint_com smallint,
    int_col int,
    int_con2 int unsigned ,
    bigint_col bigint,
    char_col char(10),
    varchar_col varchar(10),
    text_con text,
    longtext_col longtext,
	float_col float,
    double_col double,
    date_col date,					-- 날짜저장 [yyyy-MM-dd] 형식 넣어줘야함
    time_col time,					-- 시간저장 [hh:mm:ss]
    datetime_col datetime			-- 날짜/시간[yyyy-MM-dd hh:mm:ss]
    
);
select*from testtype;
















