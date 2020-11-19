-------select문으로 특정 데이터 추출하기
select * from tab; --scott 이 소유하고 있는 테이블 보기
desc emp; --describe or desc 테이블명; -- emp테이블 구조 보기
select * from emp; --emp테이블의 칼럼 보기 모든내용보기
select * from dept;
select deptno , dname from dept; --dept테이블에서 부서번호와 부서번호만 출력
select ename, sal, hiredate from emp; --emp테이블에서 이름칼럼 급여칼럼 입사일자칼럼

--별칭정하기. (칼럼 as 별칭)
select deptno as DN, dname as DM
from dept;
--별칭에서 공백문자 특수문자를 구별하고 싶다면 "" 사용. as를 생략하고 "", 공백 으로 사용가능
select deptno "dn", dname "!@#dm"
from dept;
--한글사용 가능
select deptno 부서번호
from dept;

-- 중복 데이터 한번씩만 출력 distinct
--emp테이블에서 job칼럼 표시하되 중복된 값은 한번만
select distinct job
from emp;

select distinct deptno from emp; --소속부서번호의 중복된 데이터 제외

--**************************where조건과 비교연산자
select empno, ename, sal from emp
where sal>=3000; --급여를 3000이상 받는 사원

select empno, ename, sal from emp
where sal<3000; --급여를 3000미만 받는 사원
---------------------------------------- = > < >= <= ---- 같지않다(<>, !=, ^=)
select empno, ename from emp
where deptno=10; --부서번호가 10번인 사원

select empno, ename, sal from emp
where sal<2000; --급여2000미만의 사원번호 이름 급여

--문자데이터 조회는 반드시 단일따옴표'' 안에 표시 *대소문자구분한다
select empno, ename, sal from emp
where ename='SCOTT'; --이름이 SCOTT인 사원

select empno,ename, job from emp
where ename='MILLER'; --이름이 MILLER인 사람의 사원번호 이름 직급

--날짜데이터조회는 단일따옴표안에 '' 한다 *년월일 형식
select ename, hiredate from emp
where hiredate>='1985/01/01'; --85년1월1일이후에 입사한 사원 --없음

--논리연산자 (and) (or) (not) (between and) (in)
--여러 조건을 모두 만족해야 할 경우 and연산자 사용
select ename, deptno, job from emp
where deptno=10 and job='MANAGER'; --부서번호가 10이고 직급이 MANAGER인 사원

select empno, ename, sal, job from emp
where sal>=1000 and sal<=3000; --급여가 1000에서 3000사이인 사원

select empno, ename, sal, job from emp
where sal between 1000 and 3000;--위와 같은 내용 between and 연산자로 표현

--두 가지 조건 중 한가지만 만족하더라도 검색할수있는 OR연산자
select ename, deptno, job from emp
where deptno=10 or job='MANAGER'; --부서번호가 10이거나 직급이 MANAGER인 사원

select ename, empno from emp
where empno=7844 or empno=7654 or empno=7521; --사원번호가 ~~이거나 이거나 인 사원

-- 반대되는 논리값 not 연산자
select ename, deptno, job from emp
where not deptno =10; --부서번호가 10이 아닌 사원
-- where not deptno !=10; !로 표현

select ename empno from emp
where not job='MANAGER'; --직급이 manager가 아닌 사원

--특정 범위 내에 속하는 데이터를 알아볼때 between and 연산자 사용
select ename, sal from emp
where sal between 1000 and 3000; --급여가 1000에서 3000 사이인 사원

select empno, ename, sal from emp
where sal between 1500 and 2500; --급여가 1500에서 2500사이인 사원번호 이름 급여

--동일한 칼럼이 여러 개의 값 중에 하나인지 표현하는 IN연산자
select ename, sal from emp
where empno=7844 or empno=7654 or empno=7521;

select ename, sal from emp
where empno in(7844, 7654, 7521); --위와 같음--사원번호가 이거나 이거나 인 사원

select ename, sal, comm from emp
where comm in(300, 500, 1400); --커미션이 300 500 1400 중 하나인 사원

--LIKE연산자는 검색하고자 하는 값을 정확히 모를 경우 와일드카드(%,_)연산자와 함께 사용하여 검색하는 연산자
--% 문자가 없거나, 하나 이상의 문자가 어떤 값이 오든 상관없다
-- _ 하나의 문자가 어떤 값이 오든 상관없다 // where columm LIKE ~~~

--%는 검색하고자 하는 값을 정확히 모를경우, %는 몇개의 문자가 오든 상관없다.
select empno, ename from emp
where ename like 'K%'; --K로 시작하는 사원

select empno, ename from emp
where ename like '%K%'; --K를 포함하는 사원.

select empno, ename from emp
where ename like '%K'; --K로 끝나는 사원

-- _ 는 한 문자를 대신해서 사용
select empno, ename from emp
where ename like '_A%'; --두번째 글자가 A로 시작하는 사원

-- like_A / AA BA CA / 두 글자 이되, 두번째 글자가 A인 글자
-- like_A% / AAA BAA CA234 / 두번째 글자가 A이고 뒤로는 무엇이 오든상관없음
--like A__ / AAA ABC AEW / A로 시작하고 세글자인 글자. 뒤 두 글자는 무엇이 오든상관없음
-- LIKE _a__ / AaAA Ba12 / 4글자이고 두번째 글자는 a인 글자

select empno, ename from emp
where not ename like '%A%'; --이름에 를 포함하지 않은 사원

--NULL을 위한 연산자
--오라클에서는 칼럼에 NULL값 저장 허용. NULL은 연산 할당 비교가 불가능 / 100 + null = null
select ename, comm, job from emp
where comm = NULL; -- null은 = 연산자로 판단할수없다

--is null , is not null
--칼럼에 값이 있는 경우 is null 연산자를 null값이 아닌지 알아보려면 is not null 연산자

select ename, comm, job from emp
where comm is null; --커미션을 받지 않는 사원

select ename, comm, job from emp
where comm is not null; --커미션을 받는 사원
--where not comm is null 같은 표현

select ename, job, mgr from emp
where mgr is null; --직속상관이 없는 사원

--정렬을 위한 orber by 절
--row 정렬. 쿼리문 맨 뒤에 기술. 정렬의 기준이 되는 칼럼 또는 select절에서 명시된 별칭

--오름차순 정렬 asc
select empno, ename from emp
order by empno asc; -- order by empno; (asc생략)
--내림차순 정렬 desc
select empno, ename from emp
order by empno desc;
--입사일이 가장 최근인 사원 순
select empno, ename, hiredate from emp
order by hiredate desc;

-------------------------------------SQL 함수
--DUAL테이블 - 한 행의 결과를 출력하기 위한 테이블
--산술연산이나 가상 칼럼 등의 값을 한 번만 출력하고 싶을 때
desc dual;
select * from dual; --dummy칼럼에 한개의 문자만 저장할수있는 x라는 값을 가진 로우만 저장

select 24*60*60 from dept; --1일을 초로 계산
select 24*60*60 from dual;

select deptno, sal from emp
where deptno=30; --30번 부서의 급여

select deptno, sum(sal) from emp
group by deptno
having deptno=30; --그룹함수로 30번 부서의 총 급여

--소문자로 변환 lower
select 'DATABASE', lower('DATABASE') 소문자 from dual;

select ename, lower(ename) as 부서10번인이름소문자 from emp where deptno=10;

--대문자로 변환 upper
select 'database', upper('database') 대문자 from dual;

select empno, ename, job from emp
where job=upper('manager'); -- or where lower(job)='manager';

--첫글자만 대문자 나머지는 소문자 initcap
select initcap('data base program') 첫글자만대문자 from dual;

select empno, initcap(ename) as 첫글자대문자 from emp
where deptno=10;

select empno, initcap(ename) as ename, sal, comm from emp
where ename=upper('smith');

--두 문자를 연결하는 concat
select concat('data ','base') as 문자연결 from dual;

--문자의 길이 구하기 length/lengthb
select length('database') 문자개수, lengthb('database') 바이트개수 from dual;
select length('데이터베이스') 문자개수 , lengthb('데이터베이스') 바이트개수 from dual;

select deptno, empno, ename, length(ename) from emp; --이름 길이

select deptno, empno, ename, lower(ename) from emp
where length(ename)=4; --이름길이가 4인 직원 이름을 소문자

select empno, ename, sal from emp where length(ename)>=6; --이름 6글자 이상인 직원

--문자열의 일부만 추출 substr/substrb
--substr(대상, 시작위치, 추출개수)
select substr('데이터베이스', 1, 3) from dual;
select substr('데이터베이스', -3, 3) from dual;-- -3 -2 -1, -1이 맨 끝

select ename, hiredate, substr(hiredate, 1,2) from emp; --입사년도만 알기

select ename, hiredate, substr(hiredate,1,2) from emp
where deptno=20 and substr(hiredate,1,2)=81; --81년입사 부서번호20
------and함수, between and함수, substr연산자로 81년입사 검색
select ename, hiredate from emp
where hiredate>='1981/01/01' and hiredate<='1981/12/31';

select ename, hiredate from emp
where hiredate between '1981/01/01' and '1981/12/31';

select ename, hiredate from emp
where substr(hiredate,1,2)=81;

------------like연산자 와일드카드, substr함수로 k로끝나는 이름 검색
select ename from emp
where lower(ename) like '%k';

select ename from emp
where substr(ename,-1,1)='K';

--특정 문자 위치 구하는 instr/instrb
--instr(대상, 찾을글자, 시작위치, 몇번째발견)
select instr('database','b') b가5번째 from dual;

select ename, instr(ename,'E') from emp; --E가 몇번째 있는지

select instrb('데이터베이스','이',5,1) from dual; --5바이트 이후 1(처음)발견하는 '이'는 13바이트

select ename, sal from emp where ename like '__R%';
select ename, sal from emp where substr(ename,3,1)='R'; --세번째 R로 시작하는이름

select ename, sal from emp where instr(ename,'A')=2; --두번째A가있는

--특정기호로 채우는 lpad/rpad 함수
select lpad('data',10,'!') from dual;
select rpad('data',20,'@') from dual;

--특정 문자를 잘라내는 trim함수 --보통 공백을 없애기 위해
select trim('a' from 'aadata base aaaaaaa') from dual;
select ename, trim('S' from ename), trim('H' from ename) from emp
where ename='SMITH'; --smith이름의 s h 빼기

--숫자함수
select abs(-123123) from dual; --abs 는 절댓값

select floor(234.45145) from dual; --소숫점 버리기

select round(12.345,2) , round(12.345,0), round(12.345), round(12.345,-1) from dual; --특정자리에서 반올림하기
select trunc(12.345,2) , trunc(12.345,0), trunc(12.345), trunc(12.345,-1) from dual; --특정자리 수 버리기
select mod(34,2), mod(34,5), mod(34,7) from dual; --나머지

select ename, job from emp where mod(empno,2)=0; --사번이 짝수인 사원

----------날짜함수
select sysdate from dual; --현재날짜
select sysdate-1 어제, sysdate+1 오늘 from dual; --날짜데이터에는 - + 연산
select ename, round(sysdate-hiredate) 입사날부터오늘까지 from emp;

--두 날짜 사이 간격 계산 months_between함수
select sysdate, hiredate, months_between(sysdate,hiredate) from emp;--개월 수 구하기

--특정 개월 수를 더한 날짜 계산 add_months함수
select ename, hiredate, add_months(hiredate,3) from emp; --3개월을 더한 날짜

--지정 요일에 해당되는 날짜 기준으로 가장 빨리 다가오는 날짜 next_day함수
select sysdate, next_day(sysdate,'수요일') from dual; --or sysdate,수 or sysdate,4

--영어로 사용할 경우
alter session set nls_language=american;
select sysdate, next_day(sysdate,'wednesday') from dual;
alter session set nls_language=korean;

--해당 달의 마지막 날짜 반환 last_day
select sysdate, last_day(sysdate) from dual;

--round 함수의 다양한 적용
select hiredate, round(hiredate, 'month') from emp; --일 이 반올림

--trunc 함수의 다양한 적용
select hiredate, trunc(hiredate, 'month') from emp; --월 기준으로 잘라냄

---------변환함수
--날짜형, 숫자형 을 문자로 변환
select sysdate, to_char(sysdate,'yyyy-mmdd') from dual;
select to_char(hiredate, 'yy/mm/dd/day/dy') from emp;
--시간출력
select to_char(sysdate, 'yy/mm/dd hh24:mi:ss') from dual;

--숫자형을 문자형으로 변환
select ename, sal, to_char(sal, 'L999,999') from emp;
select ename, sal, to_char(111111111, '999,999,999') from emp;
--문자형을 날짜형으로 변환
select ename, hiredate from emp where hiredate=to_date(19810220,'yyyymmdd');
--문자형을 숫자형으로 변환
select to_number('111,111','999,999') + to_number('111,111','999,999') from dual;

-----일반함수 nvl, decode, case
---null을 다른 값 또는 0으로 변환하는 nvl
select ename, sal, comm, job from emp order by job; --커미션이 null
select ename, sal, nvl(comm,0), job from emp order by job; --null을 0

select ename , sal*12, sal*12+comm from emp order by job; --null 계산하면 null
select ename , sal*12, sal*12+nvl(comm,0) from emp order by job;

----switch case문과 같은 여러가지 경우에 대해서 선택할수있는 함수 ==if
select deptno, decode(deptno, 10,'a', 20,'b', 30,'c', 40,'d') as abcd from emp;

--조건에 따라 서로 다른 처리가 가능한 case함수 ==switch
select ename, deptno, case when deptno=10 then 'a'
                           when deptno=20 then 'b'
                           when deptno=30 then 'c'                           
                           when deptno=40 then 'd'                           
end abcd from emp;
--직급에 따라 급여인상
select ename, sal, case when job='ANALYST' then sal*1.05 end sal from emp;--미
select * from emp;

--그룹 함수 sum avg min max count
--함계를 구하는 함수 sum
select sum(sal) from emp;
--평균을 구하는 avg함수
select avg(sal) from emp;
max min 함수
select min(sal), max(sal) from emp;
--로우 개수를 구하는 count함수
select count(comm) from emp;
--전체 사원의 수와 커미션을 받는 사원의 수
select count(*), count(comm) from emp; --count는 null있어도

select count(distinct job) 직업의종류 from emp; --중복되지 않는 직업의 개수

--특정 칼럼 값을 기준으로 테이블을 그룹별로 나누기 위한 group by절
select deptno from emp group by deptno;--사원번호 기준으로 3개 그룹
select deptno, sum(sal), avg(sal) from emp group by deptno;
select deptno, min(sal), max(sal) from emp group by deptno;

select deptno, count(ename), count(comm) from emp group by deptno;--부서별로 사원수 커미션받는 수
select deptno, count(ename), count(comm) from emp group by deptno order by deptno; --orderby하면 반대로
--그룹의 결과를 제한할때 having절 (where 비슷 조건)
select deptno, avg(sal) from emp group by deptno having avg(sal) >=2000;

--테이블 구조를 결정하는 ddl. 테이블 생성 변경 삭제*****************************
--테이블칼럼명 반드시문자 1~30자 특문_$# 만 예약어객체명안됨 공백안됨

create table emp01 ( empno number(4),
                     ename varchar2(20),
                     sal number(7,2)
); --3개의 칼럼 구성 사원번호 사원명 급여. 테이블생성
select * from tab; --테이블구조
select * from emp01; --테이블구조
desc emp01; --테이블구조

--기존 테이블 복사
create table emp02 as select * from emp; -- emp 테이블 복사 emp02 --보통 기존테이블대신 연습할때

--alter table로 테이블 구조 변경. 칼럼의 추가 삭제 칼럼타입 변경
--add (column) 새로운 칼럼추가 , modify (column) 기존칼럼수정, drop (column) 기존칼럼 삭제

alter table emp01 add(JOB varchar2(9)); --job 칼럼 추가
desc emp01; --확인

alter table emp01 add(credate date); --기존 테이블에 날짜형 칼럼 추가

--alter table -- modify 칼럼수정 데이터의 타입,크기(자료가 없는경우)  변경 데이터타입 크기를 늘린다 작게는X(자료있는경우)
alter table emp01 modify(job varchar2(30)); --크기를 9에서 30으로 변경
--칼럼 삭제 drop
alter table emp01 drop column job; --job칼럼을 삭제
--drop table로 테이블 구조 삭제
drop table emp01; --테이블삭제
select * from tab; --확인
--삭제하려는 테이블의 기본키나 고유키를 다른 테이블에서 참조하는 경우 삭제 불가. 참조하는 테이블삭제후 가능

--휴지통
select * from recyclebin; --휴지통보기
--휴지통 비우기
purge recyclebin;
--휴지통에 넣지 않고 바로 삭제
drop table tablename purge;

--테이블명 변경  rename문/ rename old테이블 to new테이블
rename emp02 to emp03; --emp02에서 emp03변경

--테이블의 모든 로우를 제거하는 truncate문
select * from emp03;
truncate table emp03; --제거 
rollback;-- emp03안됨
--truncate는 ddl명령이므로 롤백데이터가 생성안됨 delete명령은 롤백가능. 외래키 참조중은 truncate안됨

--테이블에 내용을 추가 수정 삭제하기 위한 DML (insert, update, delete)*******************
--insert 새로운 행을 추가. 한번에 하나의 행만. values에 차례로 삽입. 
create table dept01(deptno number(2), dname varchar2(14), loc varchar2(13) ); --테이블 칼럼 생성
insert into dept01(deptno, dname, loc) values(10, 'accounting','new york'); --생성한 칼럼에 데이터넣기
select * from dept01; --확인
--insert 구문오류
insert into dept01(deptno, dname, loc) values(10,'dd');-- 괄호안에 기술한 값보다 적으면
insert into dept01(deptno, dname) values(10,'dd','ㅇㅇ'); -- " 많으면
insert into dept01(num, dname, loc) values(10,'dd'); --칼럼명 잘못입력
insert into dept01(deptno, dname, loc) values(10,dd,'ㅇㅇ'); --데이터타입 다를때

--칼럼명을 생략한 insert 구문
insert into dept01 values(20,'research','dallas');
select * from dept01; --확인 칼럼명 생략. 대신 순서대로

--null값의 삽입 
--not null 제약조건을 지정하지 않으면 null값 허용으로 생성
--암시적 null값 삽입
insert into dept01(deptno, dname) values(30,'sales');
select * from dept01; --컬럼을 넣지않으면 null값적용

--명시적 null값 삽입
insert into dept01 values(50,'chicage'); --오류발생. 다 넣어줘야함
insert into dept01 values(50,'chicage',null); --수정
insert into dept01 values(50,'','chicago'); --''만 넣어서 null값

--테이블의 내용을 수정하기 위한 update문 ***************
--기존의 행을 수정. where절을 사용하지 않으면 모든행이 수정.
create table emp01 as select * from emp; --emp테이블 복사

update emp01
set deptno=30;
select * from emp01; --모든 부서번호를 30변경

update emp01
set sal= sal*1.1;
select * from emp01; --모든 사원 급여 10%인상

update emp01
set hiredate=sysdate;
select * from emp01; --모든 입사일 오늘 수정

--테이블의 특정 행만 변경------ update문에 where절을 추가
drop table emp01; --or rollback;
create table emp01 as select * from emp;
select * from emp01; --복사 생성 확인

update emp01
set deptno=30
where deptno=10;
select deptno from emp01; --10번 부서를 30번으로 변경

update emp01
set sal = sal*1.1
where sal>=3000;
select sal from emp01; --3천이상 받으면 10%인상

update emp01
set hiredate=sysdate
where substr(hiredate,1,2)=81; --substr 활용 
select hiredate from emp01; --입사일 81년 이면 오늘날짜로

--테이블에서 2개이상 칼럼값 변경. set절에 콤마 추가
rollback;

update emp01 set deptno=10, job='MANAGER'
where ename='SCOTT';
select * from emp01; --scott 부서10 직급manager변경

update emp01 set hiredate=sysdate, comm=4000
where ename='SCOTT'; --scott 입사일 오늘로 커미션 4000

--테이블에 불필요한 행 삭제 delete문 ********
rollback;

delete from dept01;
select * from dept01; --dept01테이블 데이터 모두 삭제

rollback;
delete from dept01
where deptno=30;
select * from dept01; --30번 부서 삭제
drop table dept01;
rollback;
select * from dept01;
--delete, drop, truncate 차이
-- delete는 데이터는 지워지지만 테이블용량은 그대로. 원하는 데이터만 지울수있음. 롤백가능 DML 조작어
--drop은 용량 줄어듦. 테이블 전체 ,공간, 객체 삭제. 롤백불가 DDL 정의어
--truncate는 용량 줄어듦. 인덱스, 데이터 삭제. *테이블은 남기기(다시생성). 롤백 불가 DDL 정의어
------------------------------------------------------------------------DCL제어어. grant revoke commit rollback
drop table emp01;
create table emp01(empno number(4), ename varchar2(10), job varchar2(9), mgr number(4), hiredate date,
                   sal number(7,2), comm number(7,2), deptno number(2) ); --테이블생성
                   select ename from emp01 where ename='SCOTT';

insert into emp01(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(7369,'smith','cleak',7836,'80/12/17',800,null,20);
insert into emp01(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(7499,'allen','salesman',7369,'87/12/20',1600,300,30);
insert into emp01(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(7839,'king','president',null,null,5000,null,null);
select * from emp01;
----------------------------------------------
