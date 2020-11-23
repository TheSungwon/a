-------select������ Ư�� ������ �����ϱ�
select * from tab; --scott �� �����ϰ� �ִ� ���̺� ����
desc emp; --describe or desc ���̺��; -- emp���̺� ���� ����
select * from emp; --emp���̺��� Į�� ���� ��系�뺸��
select * from dept;
select deptno , dname from dept; --dept���̺��� �μ���ȣ�� �μ���ȣ�� ���
select ename, sal, hiredate from emp; --emp���̺��� �̸�Į�� �޿�Į�� �Ի�����Į��

--��Ī���ϱ�. (Į�� as ��Ī)
select deptno as DN, dname as DM
from dept;
--��Ī���� ���鹮�� Ư�����ڸ� �����ϰ� �ʹٸ� "" ���. as�� �����ϰ� "", ���� ���� ��밡��
select deptno "dn", dname "!@#dm"
from dept;
--�ѱۻ�� ����
select deptno �μ���ȣ
from dept;

-- �ߺ� ������ �ѹ����� ��� distinct
--emp���̺��� jobĮ�� ǥ���ϵ� �ߺ��� ���� �ѹ���
select distinct job
from emp;

select distinct deptno from emp; --�ҼӺμ���ȣ�� �ߺ��� ������ ����

--**************************where���ǰ� �񱳿�����
select empno, ename, sal from emp
where sal>=3000; --�޿��� 3000�̻� �޴� ���

select empno, ename, sal from emp
where sal<3000; --�޿��� 3000�̸� �޴� ���
---------------------------------------- = > < >= <= ---- �����ʴ�(<>, !=, ^=)
select empno, ename from emp
where deptno=10; --�μ���ȣ�� 10���� ���

select empno, ename, sal from emp
where sal<2000; --�޿�2000�̸��� �����ȣ �̸� �޿�

--���ڵ����� ��ȸ�� �ݵ�� ���ϵ���ǥ'' �ȿ� ǥ�� *��ҹ��ڱ����Ѵ�
select empno, ename, sal from emp
where ename='SCOTT'; --�̸��� SCOTT�� ���

select empno,ename, job from emp
where ename='MILLER'; --�̸��� MILLER�� ����� �����ȣ �̸� ����

--��¥��������ȸ�� ���ϵ���ǥ�ȿ� '' �Ѵ� *����� ����
select ename, hiredate from emp
where hiredate>='1985/01/01'; --85��1��1�����Ŀ� �Ի��� ��� --����

--�������� (and) (or) (not) (between and) (in)
--���� ������ ��� �����ؾ� �� ��� and������ ���
select ename, deptno, job from emp
where deptno=10 and job='MANAGER'; --�μ���ȣ�� 10�̰� ������ MANAGER�� ���

select empno, ename, sal, job from emp
where sal>=1000 and sal<=3000; --�޿��� 1000���� 3000������ ���

select empno, ename, sal, job from emp
where sal between 1000 and 3000;--���� ���� ���� between and �����ڷ� ǥ��

--�� ���� ���� �� �Ѱ����� �����ϴ��� �˻��Ҽ��ִ� OR������
select ename, deptno, job from emp
where deptno=10 or job='MANAGER'; --�μ���ȣ�� 10�̰ų� ������ MANAGER�� ���

select ename, empno from emp
where empno=7844 or empno=7654 or empno=7521; --�����ȣ�� ~~�̰ų� �̰ų� �� ���

-- �ݴ�Ǵ� ���� not ������
select ename, deptno, job from emp
where not deptno =10; --�μ���ȣ�� 10�� �ƴ� ���
-- where not deptno !=10; !�� ǥ��

select ename empno from emp
where not job='MANAGER'; --������ manager�� �ƴ� ���

--Ư�� ���� ���� ���ϴ� �����͸� �˾ƺ��� between and ������ ���
select ename, sal from emp
where sal between 1000 and 3000; --�޿��� 1000���� 3000 ������ ���

select empno, ename, sal from emp
where sal between 1500 and 2500; --�޿��� 1500���� 2500������ �����ȣ �̸� �޿�

--������ Į���� ���� ���� �� �߿� �ϳ����� ǥ���ϴ� IN������
select ename, sal from emp
where empno=7844 or empno=7654 or empno=7521;

select ename, sal from emp
where empno in(7844, 7654, 7521); --���� ����--�����ȣ�� �̰ų� �̰ų� �� ���

select ename, sal, comm from emp
where comm in(300, 500, 1400); --Ŀ�̼��� 300 500 1400 �� �ϳ��� ���

--LIKE�����ڴ� �˻��ϰ��� �ϴ� ���� ��Ȯ�� �� ��� ���ϵ�ī��(%,_)�����ڿ� �Բ� ����Ͽ� �˻��ϴ� ������
--% ���ڰ� ���ų�, �ϳ� �̻��� ���ڰ� � ���� ���� �������
-- _ �ϳ��� ���ڰ� � ���� ���� ������� // where columm LIKE ~~~

--%�� �˻��ϰ��� �ϴ� ���� ��Ȯ�� �𸦰��, %�� ��� ���ڰ� ���� �������.
select empno, ename from emp
where ename like 'K%'; --K�� �����ϴ� ���

select empno, ename from emp
where ename like '%K%'; --K�� �����ϴ� ���.

select empno, ename from emp
where ename like '%K'; --K�� ������ ���

-- _ �� �� ���ڸ� ����ؼ� ���
select empno, ename from emp
where ename like '_A%'; --�ι�° ���ڰ� A�� �����ϴ� ���

-- like_A / AA BA CA / �� ���� �̵�, �ι�° ���ڰ� A�� ����
-- like_A% / AAA BAA CA234 / �ι�° ���ڰ� A�̰� �ڷδ� ������ ����������
--like A__ / AAA ABC AEW / A�� �����ϰ� �������� ����. �� �� ���ڴ� ������ ����������
-- LIKE _a__ / AaAA Ba12 / 4�����̰� �ι�° ���ڴ� a�� ����

select empno, ename from emp
where not ename like '%A%'; --�̸��� �� �������� ���� ���

--NULL�� ���� ������
--����Ŭ������ Į���� NULL�� ���� ���. NULL�� ���� �Ҵ� �񱳰� �Ұ��� / 100 + null = null
select ename, comm, job from emp
where comm = NULL; -- null�� = �����ڷ� �Ǵ��Ҽ�����

--is null , is not null
--Į���� ���� �ִ� ��� is null �����ڸ� null���� �ƴ��� �˾ƺ����� is not null ������

select ename, comm, job from emp
where comm is null; --Ŀ�̼��� ���� �ʴ� ���

select ename, comm, job from emp
where comm is not null; --Ŀ�̼��� �޴� ���
--where not comm is null ���� ǥ��

select ename, job, mgr from emp
where mgr is null; --���ӻ���� ���� ���

--������ ���� orber by ��
--row ����. ������ �� �ڿ� ���. ������ ������ �Ǵ� Į�� �Ǵ� select������ ��õ� ��Ī

--�������� ���� asc
select empno, ename from emp
order by empno asc; -- order by empno; (asc����)
--�������� ���� desc
select empno, ename from emp
order by empno desc;
--�Ի����� ���� �ֱ��� ��� ��
select empno, ename, hiredate from emp
order by hiredate desc;

-------------------------------------SQL �Լ�
--DUAL���̺� - �� ���� ����� ����ϱ� ���� ���̺�
--��������̳� ���� Į�� ���� ���� �� ���� ����ϰ� ���� ��
desc dual;
select * from dual; --dummyĮ���� �Ѱ��� ���ڸ� �����Ҽ��ִ� x��� ���� ���� �ο츸 ����

select 24*60*60 from dept; --1���� �ʷ� ���
select 24*60*60 from dual;

select deptno, sal from emp
where deptno=30; --30�� �μ��� �޿�

select deptno, sum(sal) from emp
group by deptno
having deptno=30; --�׷��Լ��� 30�� �μ��� �� �޿�

--�ҹ��ڷ� ��ȯ lower
select 'DATABASE', lower('DATABASE') �ҹ��� from dual;

select ename, lower(ename) as �μ�10�����̸��ҹ��� from emp where deptno=10;

--�빮�ڷ� ��ȯ upper
select 'database', upper('database') �빮�� from dual;

select empno, ename, job from emp
where job=upper('manager'); -- or where lower(job)='manager';

--ù���ڸ� �빮�� �������� �ҹ��� initcap
select initcap('data base program') ù���ڸ��빮�� from dual;

select empno, initcap(ename) as ù���ڴ빮�� from emp
where deptno=10;

select empno, initcap(ename) as ename, sal, comm from emp
where ename=upper('smith');

--�� ���ڸ� �����ϴ� concat
select concat('data ','base') as ���ڿ��� from dual;

--������ ���� ���ϱ� length/lengthb
select length('database') ���ڰ���, lengthb('database') ����Ʈ���� from dual;
select length('�����ͺ��̽�') ���ڰ��� , lengthb('�����ͺ��̽�') ����Ʈ���� from dual;

select deptno, empno, ename, length(ename) from emp; --�̸� ����

select deptno, empno, ename, lower(ename) from emp
where length(ename)=4; --�̸����̰� 4�� ���� �̸��� �ҹ���

select empno, ename, sal from emp where length(ename)>=6; --�̸� 6���� �̻��� ����

--���ڿ��� �Ϻθ� ���� substr/substrb
--substr(���, ������ġ, ���ⰳ��)
select substr('�����ͺ��̽�', 1, 3) from dual;
select substr('�����ͺ��̽�', -3, 3) from dual;-- -3 -2 -1, -1�� �� ��

select ename, hiredate, substr(hiredate, 1,2) from emp; --�Ի�⵵�� �˱�

select ename, hiredate, substr(hiredate,1,2) from emp
where deptno=20 and substr(hiredate,1,2)=81; --81���Ի� �μ���ȣ20
------and�Լ�, between and�Լ�, substr�����ڷ� 81���Ի� �˻�
select ename, hiredate from emp
where hiredate>='1981/01/01' and hiredate<='1981/12/31';

select ename, hiredate from emp
where hiredate between '1981/01/01' and '1981/12/31';

select ename, hiredate from emp
where substr(hiredate,1,2)=81;

------------like������ ���ϵ�ī��, substr�Լ��� k�γ����� �̸� �˻�
select ename from emp
where lower(ename) like '%k';

select ename from emp
where substr(ename,-1,1)='K';

--Ư�� ���� ��ġ ���ϴ� instr/instrb
--instr(���, ã������, ������ġ, ���°�߰�)
select instr('database','b') b��5��° from dual;

select ename, instr(ename,'E') from emp; --E�� ���° �ִ���

select instrb('�����ͺ��̽�','��',5,1) from dual; --5����Ʈ ���� 1(ó��)�߰��ϴ� '��'�� 13����Ʈ

select ename, sal from emp where ename like '__R%';
select ename, sal from emp where substr(ename,3,1)='R'; --����° R�� �����ϴ��̸�

select ename, sal from emp where instr(ename,'A')=2; --�ι�°A���ִ�

--Ư����ȣ�� ä��� lpad/rpad �Լ�
select lpad('data',10,'!') from dual;
select rpad('data',20,'@') from dual;

--Ư�� ���ڸ� �߶󳻴� trim�Լ� --���� ������ ���ֱ� ����
select trim('a' from 'aadata base aaaaaaa') from dual;
select ename, trim('S' from ename), trim('H' from ename) from emp
where ename='SMITH'; --smith�̸��� s h ����

--�����Լ�
select abs(-123123) from dual; --abs �� ����

select floor(234.45145) from dual; --�Ҽ��� ������

select round(12.345,2) , round(12.345,0), round(12.345), round(12.345,-1) from dual; --Ư���ڸ����� �ݿø��ϱ�
select trunc(12.345,2) , trunc(12.345,0), trunc(12.345), trunc(12.345,-1) from dual; --Ư���ڸ� �� ������
select mod(34,2), mod(34,5), mod(34,7) from dual; --������

select ename, job from emp where mod(empno,2)=0; --����� ¦���� ���

----------��¥�Լ�
select sysdate from dual; --���糯¥
select sysdate-1 ����, sysdate+1 ���� from dual; --��¥�����Ϳ��� - + ����
select ename, round(sysdate-hiredate) �Ի糯���Ϳ��ñ��� from emp;

--�� ��¥ ���� ���� ��� months_between�Լ�
select sysdate, hiredate, months_between(sysdate,hiredate) from emp;--���� �� ���ϱ�

--Ư�� ���� ���� ���� ��¥ ��� add_months�Լ�
select ename, hiredate, add_months(hiredate,3) from emp; --3������ ���� ��¥

--���� ���Ͽ� �ش�Ǵ� ��¥ �������� ���� ���� �ٰ����� ��¥ next_day�Լ�
select sysdate, next_day(sysdate,'������') from dual; --or sysdate,�� or sysdate,4

--����� ����� ���
alter session set nls_language=american;
select sysdate, next_day(sysdate,'wednesday') from dual;
alter session set nls_language=korean;

--�ش� ���� ������ ��¥ ��ȯ last_day
select sysdate, last_day(sysdate) from dual;

--round �Լ��� �پ��� ����
select hiredate, round(hiredate, 'month') from emp; --�� �� �ݿø�

--trunc �Լ��� �پ��� ����
select hiredate, trunc(hiredate, 'month') from emp; --�� �������� �߶�

---------��ȯ�Լ�
--��¥��, ������ �� ���ڷ� ��ȯ
select sysdate, to_char(sysdate,'yyyy-mmdd') from dual;
select to_char(hiredate, 'yy/mm/dd/day/dy') from emp;
--�ð����
select to_char(sysdate, 'yy/mm/dd hh24:mi:ss') from dual;

--�������� ���������� ��ȯ
select ename, sal, to_char(sal, 'L999,999') from emp;
select ename, sal, to_char(111111111, '999,999,999') from emp;
--�������� ��¥������ ��ȯ
select ename, hiredate from emp where hiredate=to_date(19810220,'yyyymmdd');
--�������� ���������� ��ȯ
select to_number('111,111','999,999') + to_number('111,111','999,999') from dual;

-----�Ϲ��Լ� nvl, decode, case
---null�� �ٸ� �� �Ǵ� 0���� ��ȯ�ϴ� nvl
select ename, sal, comm, job from emp order by job; --Ŀ�̼��� null
select ename, sal, nvl(comm,0), job from emp order by job; --null�� 0

select ename , sal*12, sal*12+comm from emp order by job; --null ����ϸ� null
select ename , sal*12, sal*12+nvl(comm,0) from emp order by job;

----switch case���� ���� �������� ��쿡 ���ؼ� �����Ҽ��ִ� �Լ� ==if
select deptno, decode(deptno, 10,'a', 20,'b', 30,'c', 40,'d') as abcd from emp;

--���ǿ� ���� ���� �ٸ� ó���� ������ case�Լ� ==switch
select ename, deptno, case when deptno=10 then 'a'
                           when deptno=20 then 'b'
                           when deptno=30 then 'c'                           
                           when deptno=40 then 'd'                           
end abcd from emp;
--���޿� ���� �޿��λ�
select ename, sal, case when job='ANALYST' then sal*1.05 end sal from emp;--��
select * from emp;

--�׷� �Լ� sum avg min max count
--�԰踦 ���ϴ� �Լ� sum
select sum(sal) from emp;
--����� ���ϴ� avg�Լ�
select avg(sal) from emp;
max min �Լ�
select min(sal), max(sal) from emp;
--�ο� ������ ���ϴ� count�Լ�
select count(comm) from emp;
--��ü ����� ���� Ŀ�̼��� �޴� ����� ��
select count(*), count(comm) from emp; --count�� null�־

select count(distinct job) ���������� from emp; --�ߺ����� �ʴ� ������ ����

--Ư�� Į�� ���� �������� ���̺��� �׷캰�� ������ ���� group by��
select deptno from emp group by deptno;--�����ȣ �������� 3�� �׷�
select deptno, sum(sal), avg(sal) from emp group by deptno;
select deptno, min(sal), max(sal) from emp group by deptno;

select deptno, count(ename), count(comm) from emp group by deptno;--�μ����� ����� Ŀ�̼ǹ޴� ��
select deptno, count(ename), count(comm) from emp group by deptno order by deptno; --orderby�ϸ� �ݴ��
--�׷��� ����� �����Ҷ� having�� (where ��� ����)
select deptno, avg(sal) from emp group by deptno having avg(sal) >=2000;

--���̺� ������ �����ϴ� ddl. ���̺� ���� ���� ����*****************************
--���̺�Į���� �ݵ�ù��� 1~30�� Ư��_$# �� ����ü��ȵ� ����ȵ�

create table emp01 ( empno number(4),
                     ename varchar2(20),
                     sal number(7,2)
); --3���� Į�� ���� �����ȣ ����� �޿�. ���̺����
select * from tab; --���̺���
select * from emp01; --���̺���
desc emp01; --���̺���

--���� ���̺� ����
create table emp02 as select * from emp; -- emp ���̺� ���� emp02 --���� �������̺��� �����Ҷ�

--alter table�� ���̺� ���� ����. Į���� �߰� ���� Į��Ÿ�� ����
--add (column) ���ο� Į���߰� , modify (column) ����Į������, drop (column) ����Į�� ����

alter table emp01 add(JOB varchar2(9)); --job Į�� �߰�
desc emp01; --Ȯ��

alter table emp01 add(credate date); --���� ���̺� ��¥�� Į�� �߰�

--alter table -- modify Į������ �������� Ÿ��,ũ��(�ڷᰡ ���°��)  ���� ������Ÿ�� ũ�⸦ �ø��� �۰Դ�X(�ڷ��ִ°��)
alter table emp01 modify(job varchar2(30)); --ũ�⸦ 9���� 30���� ����
--Į�� ���� drop
alter table emp01 drop column job; --jobĮ���� ����
--drop table�� ���̺� ���� ����
drop table emp01; --���̺����
select * from tab; --Ȯ��
--�����Ϸ��� ���̺��� �⺻Ű�� ����Ű�� �ٸ� ���̺��� �����ϴ� ��� ���� �Ұ�. �����ϴ� ���̺������ ����

--������
select * from recyclebin; --�����뺸��
--������ ����
purge recyclebin;
--�����뿡 ���� �ʰ� �ٷ� ����
drop table tablename purge;

--���̺�� ����  rename��/ rename old���̺� to new���̺�
rename emp02 to emp03; --emp02���� emp03����

--���̺��� ��� �ο츦 �����ϴ� truncate��
select * from emp03;
truncate table emp03; --���� 
rollback;-- emp03�ȵ�
--truncate�� ddl����̹Ƿ� �ѹ鵥���Ͱ� �����ȵ� delete����� �ѹ鰡��. �ܷ�Ű �������� truncate�ȵ�

--���̺� ������ �߰� ���� �����ϱ� ���� DML (insert, update, delete)*******************
--insert ���ο� ���� �߰�. �ѹ��� �ϳ��� �ุ. values�� ���ʷ� ����. 
create table dept01(deptno number(2), dname varchar2(14), loc varchar2(13) ); --���̺� Į�� ����
insert into dept01(deptno, dname, loc) values(10, 'accounting','new york'); --������ Į���� �����ͳֱ�
select * from dept01; --Ȯ��
--insert ��������
insert into dept01(deptno, dname, loc) values(10,'dd');-- ��ȣ�ȿ� ����� ������ ������
insert into dept01(deptno, dname) values(10,'dd','����'); -- " ������
insert into dept01(num, dname, loc) values(10,'dd'); --Į���� �߸��Է�
insert into dept01(deptno, dname, loc) values(10,dd,'����'); --������Ÿ�� �ٸ���

--Į������ ������ insert ����
insert into dept01 values(20,'research','dallas');
select * from dept01; --Ȯ�� Į���� ����. ��� �������

--null���� ���� 
--not null ���������� �������� ������ null�� ������� ����
--�Ͻ��� null�� ����
insert into dept01(deptno, dname) values(30,'sales');
select * from dept01; --�÷��� ���������� null������

--����� null�� ����
insert into dept01 values(50,'chicage'); --�����߻�. �� �־������
insert into dept01 values(50,'chicage',null); --����
insert into dept01 values(50,'','chicago'); --''�� �־ null��

--���̺��� ������ �����ϱ� ���� update�� ***************
--������ ���� ����. where���� ������� ������ ������� ����.
create table emp01 as select * from emp; --emp���̺� ����

update emp01
set deptno=30;
select * from emp01; --��� �μ���ȣ�� 30����

update emp01
set sal= sal*1.1;
select * from emp01; --��� ��� �޿� 10%�λ�

update emp01
set hiredate=sysdate;
select * from emp01; --��� �Ի��� ���� ����

--���̺��� Ư�� �ุ ����------ update���� where���� �߰�
drop table emp01; --or rollback;
create table emp01 as select * from emp;
select * from emp01; --���� ���� Ȯ��

update emp01
set deptno=30
where deptno=10;
select deptno from emp01; --10�� �μ��� 30������ ����

update emp01
set sal = sal*1.1
where sal>=3000;
select sal from emp01; --3õ�̻� ������ 10%�λ�

update emp01
set hiredate=sysdate
where substr(hiredate,1,2)=81; --substr Ȱ�� 
select hiredate from emp01; --�Ի��� 81�� �̸� ���ó�¥��

--���̺��� 2���̻� Į���� ����. set���� �޸� �߰�
rollback;

update emp01 set deptno=10, job='MANAGER'
where ename='SCOTT';
select * from emp01; --scott �μ�10 ����manager����

update emp01 set hiredate=sysdate, comm=4000
where ename='SCOTT'; --scott �Ի��� ���÷� Ŀ�̼� 4000

--���̺� ���ʿ��� �� ���� delete�� ********
rollback;

delete from dept01;
select * from dept01; --dept01���̺� ������ ��� ����

rollback;
delete from dept01
where deptno=30;
select * from dept01; --30�� �μ� ����
drop table dept01;
rollback;
select * from dept01;
--delete, drop, truncate ����
-- delete�� �����ʹ� ���������� ���̺�뷮�� �״��. ���ϴ� �����͸� ���������. �ѹ鰡�� DML ���۾�
--drop�� �뷮 �پ��. ���̺� ��ü ,����, ��ü ����. �ѹ�Ұ� DDL ���Ǿ�
--truncate�� �뷮 �پ��. �ε���, ������ ����. *���̺��� �����(�ٽû���). �ѹ� �Ұ� DDL ���Ǿ�
------------------------------------------------------------------------DCL�����. grant revoke commit rollback
drop table emp01;
create table emp01(empno number(4), ename varchar2(10), job varchar2(9), mgr number(4), hiredate date,
                   sal number(7,2), comm number(7,2), deptno number(2) ); --���̺����
                   select ename from emp01 where ename='SCOTT';

insert into emp01(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(7369,'smith','cleak',7836,'80/12/17',800,null,20);
insert into emp01(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(7499,'allen','salesman',7369,'87/12/20',1600,300,30);
insert into emp01(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(7839,'king','president',null,null,5000,null,null);
select * from emp01;
----------------------------------------------
----���Ἲ���� ����***********
-- not null �������� null�� ��������ʴ´�.
drop table emp01;
create table emp01( empno number(4) not null,
                    ename varchar2(10) not null,
                    job varchar2(9), 
                    deptno number(4) );
-- insert into emp01 values(null, null, 'salesman', 30); not null�������� null �Ұ�

--unique �������� �ߺ��� ���� ������� �ʴ´�. �׻� ������ ��. (�����ȣ�� ������ �ȵ�.)
create table emp01( empno number(4) unique, --�����ȣ
                    ename varchar2(10) not null,
                    job varchar2(9), 
                    deptno number(4) );

insert into emp01(7499,'allen','saleman',30); --�ѹ��ۿ� �� ��. unique!

insert into emp01(null,'jones','manager',20);
insert into emp01(null,'jones','salesman',10); --unique�� null�� ���.
--unique�� null ����. unique���� null���� �Էµ����ʰ��Ϸ��� empno number(4) unique not null �� ������ ���

--������ ��ųʸ�*�����ͺ��̽� �ڿ��� �����ϱ����� ������ �����ϴ� �ý���
--�����͵�ųʸ� �� ���̺��� ������ȸ�ϱ� �Ұ����ؼ� �����͵�ųʸ� �並 �����Ѵ�.
--dba_xxxx, all_xxxx, user_xxxx
desc user_tables; --������ ���̺��� �����˱�

show user;
select table_name from user_tables order by table_name desc; --����Ŭ������ ������ ����� ������ ���̺����̸���ȸ

--�������� Ȯ���ϱ�**���������� �����޼����� ���� �˱����� user_constaints �����͵�ųʸ����ִ�.
--�������Ǹ� constraint_name, ������������ constraint_type, ���������̼������̺� table_name

column constraint_type format a18; --Į���� ũ�⸦ �÷��ֱ� ���� ��ɾ�
select constraint_name, constraint_type, table_name from user_constraints;

select * from user_cons_columns where table_name='emp02'; --?

--primay key �������� ******
--unique�������ǰ� not null���������� ��� �����ִ� primary key
create table emp04( empno number(4) primary key,
                    ename varchar2(10) not null,
                    job varchar2(9), 
                    deptno number(4) );
insert into emp04 values(7499,'allen','slaesman',30); --������ �����ȣ �Է��ϸ� ���Ἲ�������� ����
insert into emp04 values(null,'allen','slaesman',30); --null���� ����

select constraint_name, constraint_type, table_name from user_constraints where table_name='emp04'; --??

--���� ���Ἲ�� ���� foreign key ��������
--���� ���Ἲ�� �� ���̺� ������ �������� ����
select table_name from user_tables;
select * from emp04;
--�����ϴ� ���̺��� �ڽ����̺��� ��
alter table dept
add primary key(deptno); --dept���̺� deptnoĮ������ primary key�������� �ֱ�. ������ �ܷ�Ű�Ұ�

create table emp05( empno number(4) primary key, ename varchar2(10) not null,
job varchar2(9), deptno number(4) references dept(deptno) );

insert into emp05 values(7499,'allen','salesman',30);
select * from emp05;
--insert into emp05 values(7499,'allen','salesman',50); --50�μ��� ���⶧���� �����Ұ�

--check ��������. ** �ԷµǴ� ���� üũ. �̿��� ���� ���� ����
create table emp06( empno number(4) primary key, ename varchar2(10) not null,
gender varchar2(1) check(gender in('m','f')) );
insert into emp06 values(7566,'jones','m'); --m,f �ܿ��� ����

--�������Ǹ� �����ϱ� * ����ڰ� �ǹ��ְ� ���� ���Ǹ��� ����Ϸ� �������Ǹ����ε� �˼��ְ�
--���̺��_Į����_������������_�������� emp05_empno_pk_primary key
drop table emp05;
create table emp05( empno number(4) constraint emp05_empno_pk primary key,
                    ename varchar2(10) constraint emp05_ename_nn not null,
                    job varchar2(9) constraint emp05_job_uk unique,
                    deptno number(4)constraint emp05_deptno_fk reference dept(deptno) );
                    
                 --�־ȴ�
--���̺���������� �������� �����ϱ�
--����Ű�� �⺻Ű ���� ..Į���������ĺҰ�. ���̺���������θ�
--alter table�� �������� �߰�. ���̺����������

drop table emp04;
create table emp04( empno number(4) primary key,
                    ename varchar2(10) not null,
                    job varchar2(9) unique, 
                    deptno number(4) references dept(deptno) ); --Į�������� ����
                    
drop table emp04;
create table emp04( empno number(4) ,
                    ename varchar2(10) not null,
                    job varchar2(9), 
                    deptno number(4),
                    
                    primary key(empno, job),
                    foreign key(deptno) references dept(deptno) ); --���̺����� ���� +primary�� 2���̻� ����
                    
drop table emp03;
create table emp03( empno number(4),
                    ename varchar2(10) constraint emp03_ename_nn not null,
                    job varchar2(9), 
                    deptno number(4),
                    
                   constraint emp03_empno_pk primary key(empno) ); --Į������ ��������� ���� .constraintŰ����
                   
-- �������Ǻ����ϱ�
--���̺������ ���� �� �������� �߰� alter table
create table emp01( empno number(4),
                    ename varchar2(10),
                    job varchar2(9), 
                    deptno number(4) );
alter table emp01 add primary key(empno); --alter table�� �̿��� ���������߰�
alter table emp01 add constraint emp01_deptno_fk foreign key(deptno) references dept(deptno);

select * from user_constraints where table_name='EMP01'; --���̺��̸� �빮�ڷ�

--�������� �����ϱ� drop costraint�� �̿�

--alter table drop constraint emp06_emp_pk; --������������

--���������� ��Ȱ��Ȱ cascade 
--disable constraint��Ȱ��ȭ, enable constraint ��Ȱ��ȭ����

--delete from dept01 where deptno=10; �ڽ����̺�emp01�� dept01�� �����ϰ� �־� ���������.
---�����Ϸ��� emp01 10���μ� �����͸� ������� Į�� ����� or emp01 �ܷ�Ű�� ���� �ϰ� Į������
----emp01���̺��� �ܷ�Ű�� ��Ȱ��ȭ�Ѵ�.
--alter table disable constraint emp01_deptno01_deptno_fk;
--alter table enable constraint emp01_deptno_fk;

--cascade �ɼ�. forign key�����Ǿ������� �θ����̺��� ��Ȱ��ȭ�ϸ� �ڽ����̺� ��Ȱ��ȭ���ش�
---alter table dept01 disable primary key; -������������ �𸣴��� primary key�� ��Ȱ��ȭ

--alter table dept01 disable primary key cascade; --�θ����̺� ��Ȱ��ȭ
--alter table dept01 drop primary key cascade; --cascade�ɼ��� �����Ͽ� �⺻Ű�������ǻ��� �ϸ� �����ϴ� �ܷ�Ű�� ����

--*******����.. �� �� �̻��� ���̺��� ���ϴ� ����� �������
--where�� ������ from���� ����� ���� ���̺��� ���� join����. ���̺���� n���� join������ n-1����.

--1)cross join - 2���̻� ���̺� ���εɶ� where���� ���� ���� Į���� ���� ������ �ȵ�. ��� �����Ͱ� ���
select * from emp, dept; --�ƹ� �ǹ̾��� ���̺�����

--join��Ģ. primary key�� foreign key ���� �ٸ� ���̺��� ��� ����
--          ���� key������� ���̺�� ���̺� ����
--          where������ ���������� ���. (�������� ���� = ���� ���̺�� -1)?
--          ��Ȯ���� ���� Į�� �̸� �տ� ���̺�� �Ǵ� ��Ī�� ���δ�.

--2)equi join. ���帹�� ���. �� ���̺��� ���������� �����ϴ� Į������ ��ġ�Ǵ� ���� ����

--emp, dept���̺��� ���� Į�� deptno���� ��ġ�Ǵ� ������ where���� ���. �� ���̺��� �����Ϸ���
--��ġ�Ǵ� ����Į�� ���. Į������ ������ ȥ���ϹǷ� Į���� �տ� ���̺��.Į��


select ename, dname from emp, dept
where emp.deptno = emp.deptno;

--��Ī
select e.ename, e.deptno, d.dname, d.deptno from emp e, dept d
where e.deptno = d.deptno;

select e.ename, e.deptno, d.dname, d.deptno from emp e, dept d
where e.deptno = d.deptno and e.ename='SCOTT';

--3) non-equi join . ���̺� ������ Į�� ���� ���������� ����ġ �� =�� ������ ������.
select * from salgrade;
select e.ename, e.sal, s.grade from emp e, salgrade s
where e.sal between s.losal and s.hisal; --or where e.sal >= s.losal and e.sal <= s.hisal
-- �޿���� 5���� ���� salgrade���̺��� �� ����� �޿���� ����. emp�� salgrade���̺� ����

--4)outer join. ���� ���� ���ǿ� ��������������� ��Ÿ���� �����Ƿ� outer join�� ���
select e.ename, d.deptno, d.dname from emp e, dept d
where e.deptno(+) = d.deptno --40�� �μ��� �� ���� (+) outer join
order by d.deptno;

--5)self join �ڱ� �ڽŰ� ����. from�� ���� ������ ���̺�� where���� �ٸ� ���̺��� ��ó�� ��Ī
select ename, mgr from emp; --��� ���

select w.ename, m.ename from emp w, emp m
where w.mgr = m.empno;

select w.ename||'�ǸŴ�����'||m.ename||'�̴�.' as "�� ����� �Ŵ���"
from emp w, emp m 
where w.mgr = m.empno;

--6)ANSI join --�����ͺ��̽� ǥ�ؾ��

--1 ANSI cross join
select * from emp cross join dept; -- ,��� cross join

--2 ANSI inner join
select ename, dname from emp inner join dept
on emp.deptno = dept.deptno;

--3 using
select emp.ename, dept.dname from emp inner join dept using(deptno);

--4natural join . ������ ����. �ڵ����� ���� Į���� ����
select ename, dname from emp natural join dept;

--5 ANSI outer join (+)��� left, right, full
select e.ename, d.deptno, d.dname from emp e right outer join dept d
on e.deptno = d.deptno;

--******�������� . 
select deptno from emp where ename='SCOTT'; --�μ���ȣ 20 �˾Ƴ�

--�������� ����
select dname from dept where deptno = (select deptno from emp where ename='SCOTT'); --20�� dname��?

--2) ������ �������� .���� select�������κ��� ���� �ϳ��� �ο츸�� ��ȯ. �񱳿����� ���
select * from emp where deptno = (select deptno from emp where ename='SMITH'); --smith�� �����μ����� �ٹ��ϴ� ���

select ename, sal from emp where sal > (select avg(sal) from emp); --��ձ޿����� ���� �޴� ���

--3) ������ �������� . ������������ ��ȯ�Ǵ� ����� �ϳ� �̻��� ���� �� in any som all exist
--����� 2���̻� �������� �������� ���������� ����� ��� ������ ������ ���

--in������ . �ϳ��� ��ġ�ϸ� ��
select ename, sal, deptno from emp where deptno 
in (select distinct deptno from emp where sal >= 3000); --3000�̻� �޴� �μ� 10,20 �� ����

--all������  ���������˻� ����� ��� ���� ��ġ
select ename, sal from emp where sal > all(select sal from emp where deptno=30); --�������� ��� ���� ���� �޴�

--any ������. �ϳ� �̻� ��ġ�ϸ� ��. �ּڰ����� ũ�� ���̵ȴ�
select ename, sal from emp where sal > any(select sal from emp where deptno=30);

--4) ���������� ���̺� �ۼ��ϱ�
--1 �����ϱ�
create table emp01 as
select * from emp;

--��� Į���� �ƴ� Ư�� Į���� ���� ���� �Ϸ��� Į���� �̸�
create table emp02 as
select empno, ename from emp;

--2 ���̺� ������ �����ϱ�
create table emp03 as
select * from emp where 1=0;

--5) ���������� �̿��� ������ �߰�
--���������� ����Ͽ� insert���� �ۼ�, values���� ������. �� ���������� ������ insert�� ���̺� ������ ��ġ �ؾ���
create table dept01 as
select *from dept where 1=0;

insert into dept01 select * from dept;

--6) ���������� �̿��� ������ ����
update dept01
set loc = (select loc from dept01 where deptno=40); --10���μ��� 40�� �μ��� ���������� ����

--7) ���� ������ �̿��� �� �� �̻��� Į���� ����
update dept01
set (dname,loc) = (select dname,loc from dept01 where deptno=30)
where deptno=20; --20���μ��� �μ���� �������� 30�� �μ��� �μ���� ���������� ����
--�Ǵ�
update dept01
set dname = (select dname from dept01 where deptno =30),
    loc = (select loc from dept01 where deptno=30)
where deptno=20;

--8) ���������� �̿��� �����ͻ���
delete from emp01
where deptno = (select deptno from dept where dname='SLAES'); --slaes�� �μ���ȣ�Ͱ��� emp01�Ǻμ���ȣ �����

--*****��
create view view_emp10 --�� ���� create view
as
select empno, ename, sal, deptno
from emp01
where deptno=10; --"insufficient privileges" ����... system������ grant create view to scott;
--���� ��� ����. �������� ���̺� ���� ����. ������ ���Ǹ� ����
--������ �κи� ���� �� �ִ� ���� ���̺�. ���� �ڷḦ ���� ������ �並 ���� ���̺����. �ϳ��� ���̺� �� ���� ���Ѿ���

--or replcae view. ���ο� �並 ���� �� �ְ�, �䰡 �����ϴ��� ���� ���� �ʰ�
--���ο� ������ ��� ������ �� �ִ�.

--force. �⺻ ���̺��� ���� ���� ������� �� ����

--with check option. �ش� �並 ���ؼ� �� �� �ִ� ���� �������� update, insert ����

--�� ������ ��ųʸ�
select * from user_views;

--�ܼ���. �ϳ��� ���̺� ����. �׷��Լ� �Ұ�. distinct�Ұ�. dml����
insert into view_emp10
values(8000,'angel',7000,10); --�信 ������ insert
select * from view_emp10;

--�ܼ��� Į���� ��Ī�ο��ϱ�
create or replace view view_emp(�����ȣ,�����,�޿�,�μ���ȣ)
as
select empno, ename, sal, deptno from emp01;

select * from view_emp;
select * from view_emp where �μ���ȣ=10;

---�ܼ��� �׷��Լ� ���
create view view_sal
as
select deptno, sum(sal) as salsum , avg(sal) as salavg
from emp01
group by deptno;

select * from view_sal;
--sum, avg Į���� ���� Į���̱⿡ �ݵ�� �̸� ����

--�ܼ��� dml��ɾ� �Ұ��� ���. �⺻ ���̺� Į���� not null���������̸� insert�Ұ�
--sal*12���� ���ǥ���� ���ǵ� ����Į���� �信 ���ǵǸ� insert, update�Ұ�
--distinct�Ұ�, �׷��Լ��� group by�� ������ ��쵵 dml�Ұ�

-------���պ�. ���� ���̺� ����. �׷��Լ� ����. distinct����, dml�Ұ�
----�� �� �̻��� �⺻ ���̺� ���� ������ ��
create view view_emp_dept
as
select e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
order by empno desc;

select * from view_emp_dept;

----�� ����
--��� ��ü�� ���� ���� ���̺��̹Ƿ� ������ �ٴ� ���� user_views ������ ��ųʸ���
--����Ǿ� �ִ� ���� ���Ǹ� �����Ѵٴ� �ǹ�

drop view view_sal;

------�� ����. or replcae �ɼ�

--create view ��� create or replace view ����ϸ� . �������� �ʴ� ���̸� ���ο� �� �����ϰ�
--������ �����ϴ� ���̸� �� ���� ����

create or replace view view_emp10
as
select empno, ename, sal, comm, deptno --comm�߰�
from emp01;

select * from user_views;

------------�⺻ ���̺���� �� ���� force�ɼ�

create or replace force view view_notable
as
select empno, ename, deptno
from aaa;

select * from user_views;

-------�� ������ �������� ������ Į�� ���� �������� ���ϵ��� �ϴ� with check option

create or replace view view_chk20
as
select empno, ename, sal, comm,deptno from emp01
where deptno=10 with check option;

update view_chk20 set deptno=20 --5000�̻��� ��� 20���μ��� �̵� 
where sal>=5000;                --�ɼ��������� �Ұ�

select * from view_chk20;

----with read only. �並 ���ؼ��� �⺻ ���̺��� � �÷��� ���ؼ��� ���뺯��Ұ�
--with ceck option�� ���ǿ� ����� �÷��� �� ���� �Ұ�
--with red only�� �⺻ ���̺� ��� ���� �Ұ�

create or replace view view_read30
as
select empno, ename, sal, comm, deptno from emp
where deptno=10 with read only;

update view_read30 set comm=1000; --����


---�� Ȱ��. rownum - ����Ŭ ���ο��� �ο��Ǵ� insert���� ���� �Է��� ������ ���� 1�� ����

create or replace view view_hire
as
select empno, ename, hiredate from emp
order by hiredate;

select rownum, empno, ename, hiredate from view_hire;

select rownum, empno, ename, hiredate from view_hire
where rownum <= 5;

----�ζ��κ� �� top-n ���ϱ�
--���������� �������� from���� ��ġ�� ���̺� ó�� ���.
--�ζ��� ��� ���� ������ select���� from�� ���ο� ���� ���� ������
--create view�� ������ �ƴ϶� sql�����ο� �並 �����ϰ� ���̺�ó�� ���
select rownum, empno, ename, hiredate
from (select empno, ename, hiredate from emp order by hiredate)
where rownum <=5;

-----�����ͺ��̽� ����***
--����ڻ��� create user USER_NAME identified by PASSWORD
--���Ѻο� grant create...to
--��ȣ���� alter user USER_NAME identified by PASSWORD
--with grant option
--public
---�������� revoke

--���� ����� ���Ѻο� DBA, CONNECT, RESOURCE


-------������ �ε��� ���Ǿ�*****
--�������� �����ϸ� �⺻Ű�� ���� ���������� �����ϴ� Į���� �ڵ� ����
-----1) start with.�������� ���۰� ����. n�� 1�� �����ϸ� 1���� ����
----2)increment by. �������� ������. n�� 2���ϸ� 2�� ����. start with1�̰� increment by 2�� 1 3 5 7
---3)maxvalu n|nomaxvalue. ������ �ִ� ������. nomaxvlue�� ���Ѵ�
--4)minvalue n|nominvalue. ������ �ּڰ�. �⺻�� 1�̰� nominvalue�� �ּڰ��� ���Ѽ�
---5)cycle | nocycle. ���������� �ִ񰪱��� �Ϸ�Ǹ� �ٽ� �ּڰ����� ����. nocycle�� �ִ��� ������ ����
----6)cache n | nocache. ����ũ������ �̸������ϰ� �޸𸮿� ������ ���� ���� ����Ʈ��2

create sequence emp_seq --���۰�1 1�� ���� �ִ� 100000�� ������
start with 1     increment by 1      maxvalue 100000;

create table emp01 as select empno, ename, hiredate from emp where 1=0;

insert into emp01 values(emp_seq.nextval,'a',sysdate);
--�������κ��� �����ȣ�� �ڵ����� �Ҵ�. nextval ��������� ���� ���� �� ��ȯ
select * from emp01;

--���� ������ �� ����
select emp_seq.currval --.currval ���� �� ��ȯ
from dual;

----������ ���� �� ����
create sequence dept_seq --10���� 10�� ���� �ִ� 30����
start with 10       increment by 10     maxvalue 30;

create table dept01     as      select * from dept where 1=0;

insert into dept01 values(dept_seq.nextval, 'a', 'new'); --�μ���ȣ30������ ����

select * from user_sequences; --������ �����͵�ųʸ�

--������ �����Ϸ��� alter sequence��
alter sequence dept_seq maxvalue 100000; --������ �ִ� ����


----�������� ����
drop sequence dept_seq;


--��ȸ �� ���� ����� ���� index....�Ϲ������� ���������ʰ� pk�� ��
drop table emp01;

create table emp01  as  select * from emp;

select table_name, index_name, column_name from user_ind_columns
where table_name in('EMP','EMP01'); --���� �ε��� Ȯ��

create index index_empno_emp    on  emp01(empno);
select * from user_ind_columns where table_name in('EMP','EMP01');

-----�ε��� ����
drop index index_empno_emp;

----���Ǿ�***�ٸ� ����� ������ ��ü�� �׼��� �Ҷ� �����ϰ�. synonym
--**************************

--PL/SQL************ORACLE'S PROCEDURAL LANGUAGE EXTENSION TO SQL
--SQL���忡�� ��������, ����ó��IF, �ݺ�ó��LOOP WHILE FOR �� ����.
--����Ŭ ��ü�� ����Ǿ��ִ� ���������PROCEDURE LANGUAGE�μ� SQL�� ���� ����
--���� ����, ��ó��, �ݺ�ó��

-----------------------------------------
--PL/SQL��ϱ����� 3�κ�.

--DECLARE
--      �����(DECLARE SECTION)
--      ������ ����� ����
--BEGIN
--      �����(EXECUTABEL SECTION)
--      SQL��
--      ���,�ݺ���
--      Ŀ��
--EXCEPTION
--      ����ó����(EXCEPTION SECTION)
--END;
--/


set serveroutput on; --����Ʈ off. on���� ����

begin
    dbms_output.put_line('hello');
    end;
    /
    
--ȭ�鿡 ��� put_line���ν���. ����Ŭ�� �������ִ� ���ν����� dbms_output��Ű���� �����ִ�.


-----����???
--1 ������ ����. ���������� := ���� ���� ���� ��

set serveroutput on
declare
    no number(4);
    na varchar2(10);
begin
    no:=7788;
    na:='scott';
    dbms_output.put_line('���/�̸�');
    dbms_output.put_line('--------');
    dbms_output.put_line(no||'/'||na);
end;
/


--2 ��Į�󺯼�/ ���۷�������
--��Į�� sql������ �ڷ��������� ����
/*    no number(4);
      na varchar2(10); */

/* ���۷���    %type �Ӽ��� %rowtype �Ӽ� ���.
no emp.empno%type;
na emp.ename%type;
%type�Ӽ��� ����Ͽ� ������ emp���̺��� Į�� �ڷ����� ũ�⸦ �״�� �����ؼ� ����


%rowtype�� �ο���� ����
vemp emp%rowtype;
%rowtype�� ��� �� Ư�� ���̺��� Į�� ������ ������������ �𸣴��� ����. select�������� �ο� �˻� �� ���� */


--3 pl/sql���� sql����
/*  pl/sql�� select���� into���� �ʿ��ѵ�, into������ �����͸� ������ ���� ���
select �����ִ� Į���� into���� �ִ� ������ 1��1 ����. ������ ��������, ���� ��ġ*/

declare
--%type �Ӽ����� Į�� ������ �����͸� ������ �� �ִ� ���۷��� ���� ����
vempno emp.empno%type;
vename emp.ename%type;
begin
--select���� ������ ��� ���� into�ڿ� ����� ������ ����
select empno, ename into vempno, vename --empno=vempno, ename=vename
from emp
where ename='SCOTT';
dbms_output.put_line(vempno||'/'||vename);
end;
/

--4 pl/sql table type
/* pl/sql table type�� �ο쿡 ���� �迭ó�� �׼����ϱ� ���� �⺻Ű���.
�迭�� ����. pl/sql���̺��� �׼����ϱ� ���� binary_integer���������� �⺻Ű��
pl/sql ���̺� ��Ҹ� �����ϴ� ��Į�� �Ǵ� ���ڵ� ���������� Į�� ����.
�������� �����Ӱ� ����. ���Ҹ�? */

declare
--���̺� Ÿ�� ����
type ename_table_type is table of emp.ename%type
index by binary_integer;
type job_table_type is table of emp.job%type
index by binary_integer;
--���̺� Ÿ������ ��������
ename_table     ename_table_type;
job_table       job_table_type;

i binary_integer:=0;
begin
----emp���̺�κ��� ��� �̸�, ���޾��
for k in (select ename, job from emp) loop
i:= i+1; --�ε��� �����ذ���
ename_table(i):= k.ename; --���̺� ���� ����̸�
job_table(i) := k.job; --������ �迭ó�� ����
end loop;
--���̺� ����� ���� ���
dbms_output.put_line(rpad('���',7)||'/'||rpad('�̸�',9));

for j in 1..i loop
dbms_output.put_line(rpad(ename_table(j),7)||'/'||rpad(job_table(j),9));
end loop;
end;
/

-----------------?

--5 pl/sql record type
/*���α׷� ����� ����ü�� ���. filed(item) ������ �ϳ��� ���� ������
ó���� �� �ְ� ���ֹǷ� ���̺� row�� �о�� �� ��...?? */

--���̺��� scott ��� ���� ���

declare
--���ڵ� Ÿ�� ����
type emp_record_type is record(
v_empno emp.empno%type,
v_ename emp.ename%type,
v_job emp.job%type,
V_deptno emp.deptno%type );

--���ڵ�� ���� ����
emp_record emp_record_type;

begin
--scott ��� ������ ���ڵ庯���� ����
select empno, ename, job, deptno
into emp_record
from emp
where ename = upper('scott');

--���ڵ庯���� ����� ����������
dbms_output.put_line(to_char(emp_record.v_empno));
dbms_output.put_line(emp_record.v_ename);
dbms_output.put_line(emp_record.v_job);
dbms_output.put_line(to_char(emp_record.v_deptno));
end;
/
-------------

-----���
/*  pl/sql��    �������� ������� �̿��Ͽ� ������� ���� �帧�� ����
���ǿ� ���� �б��ϴ� ���ù��� �ݺ��� ������ �� �� ����ϰ� ������ �����ϴ� �ݺ��� */

---1 . if~ then ~ end if . Ư�� ������ �����ϸ� �ó�����ϰ� �ƴϸ� ó�����Ѵ�

--��������� ���� �޿�*12+Ŀ�̼�. commĮ���� null�̸� ������ null�̹Ƿ�
--Ŀ�̼��� 0���� �ٲ��ش�

declare

--%rowtype�Ӽ����� �ο츦 ������ �� �ִ� ���۷��� ���� ����
vemp emp%rowtype;
annsal number(7,2);
begin

--king����� ��ü ������ �ο������ ���� vemp�� ����
select * into vemp
from emp
where ename='KING';

--Ŀ�̼� ����
if(vemp.comm is null) then
vemp.comm := 0;
end if;

--��Į�� ������ ���� ����� ����
annsal := vemp.sal*12+vemp.comm;

--���۷��� ������ ��Į�� ������ ����� �� ���
dbms_output.put_line(vemp.empno||vemp.ename||to_char(annsal,'$999999'));
end;
/
-------------
--2 if ~ then ~ else ~ end if
--������ ������ �� ó���� �ƴ� �� ó��, �� ���� ó���� �߿��� �� ���� �����ؾ� �� ���

declare

--%rowtype�Ӽ����� �ο츦 ������ �� �ִ� ���۷��� ���� ����
vemp emp%rowtype;
annsal number(7,2);

begin
--scott����� ��ü������ �ο� ������ ���� vemp�� ����
select * into vemp
from emp where ename='SCOTT';
if(vemp.comm is null) then --Ŀ�̼��� ���̸�
    annsal:=vemp.sal*12;    --�޿��� 12���ϱ�
else            --Ŀ�̼��� ���̾ƴϸ� �޿��� 12�� ���ϱ� Ŀ�̼�
    annsal:=vemp.sal*12+vemp.comm;
end if;
dbms_output.put_line(vemp.empno||vemp.ename||annsal);
end;
/
------------


--3     if ~ then elsif ~ else ~ end if . ������ ���ǿ� ���� ó���� �������϶� ����if��

declare

--%rowtype�Ӽ����� �ο츦 ������ �� �ִ� ���۷��� ���� ����
vemp emp%rowtype;
vdname dept.dname%type;

begin

--scott����� ��ü������ �ο������ ���� vemp�� ����
select * into vemp from emp where empno=7934;

if(vemp.deptno = 10) then
    vdname := 'ACCOUNTING';
elsif(vemp.deptno = 20)then
    vdname := 'RESEARCH';
elsif(vemp.deptno = 30)then
    vdname := 'SALES';
elsif(vemp.deptno = 40)then
    vdname :='OPERATIONS';
end if;

dbms_output.put_line(vemp.empno||vemp.ename||rpad(vemp.deptno,8)||vdname);
end;
/
-------------------------------

--4 �ݺ���
/*sql���� �ݺ������� ������ �����Ҷ�. basic loop, for loop, while loop, exit */


--5 basic loop��
----basic loon��. ���� ���� �帧�� end loop�� ������ ������ 
--�׿� ¦�� �̷�� loop������ ��� �ǵ��ư��� ������������ exit��

declare

v_cnt number :=1;
v_str varchar2(10) :=null;

begin
--v_cnt���� 5���� ũ�� �ݺ��� ������
loop
    v_str := v_str||'*';
    V_cnt := v_cnt + 1;
    dbms_output.put_line(v_str);
    
    if v_cnt >5 then-----
    exit;----------------  = exit when v_cnt > 5;
    end if;--------------
end loop;
end;
/
--------------
--6 for loop��
