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
