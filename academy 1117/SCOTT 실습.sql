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
--where not comm is null �ε� ǥ��

select ename, job, mgr from emp
where mgr is null; --���ӻ���� ���� ���

--������ ���� orber by ��
