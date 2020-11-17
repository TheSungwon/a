--테이블 만들기
create table MEMBER(
MEMBERID VARCHAR2(10) NOT NULL PRIMARY KEY,
PASSWROD VARCHAR2(10) NOT NULL,
NAME VARCHAR(20) NOT NULL,
EMAIL VARCHAR(80)
);

--데이터 입력하기
insert into member values('SSOL','1234','홍길동','hh@daum.net');
insert into member values('SSL','1234','홍길동형','hhh@daum.net');
insert into member values('SSs','1234','홍길동누나','11hh@daum.net');
insert into member values('SSss','1234','홍길동아들','h22h@daum.net');
insert into member values('SSLL','1234','홍길동딸','hhhh@daum.net');


--데이터 꺼내기
select * from member; --전체 꺼내기

select * from member --조건 검색
where memberid = 'SSOL';

--데이터수정
update member
set name = '홍길동엄마'
where memberid = 'SSs';
--데이터삭제
delete from member
where memberid = 'SSLL';