--���̺� �����
create table MEMBER(
MEMBERID VARCHAR2(10) NOT NULL PRIMARY KEY,
PASSWROD VARCHAR2(10) NOT NULL,
NAME VARCHAR(20) NOT NULL,
EMAIL VARCHAR(80)
);

--������ �Է��ϱ�
insert into member values('SSOL','1234','ȫ�浿','hh@daum.net');
insert into member values('SSL','1234','ȫ�浿��','hhh@daum.net');
insert into member values('SSs','1234','ȫ�浿����','11hh@daum.net');
insert into member values('SSss','1234','ȫ�浿�Ƶ�','h22h@daum.net');
insert into member values('SSLL','1234','ȫ�浿��','hhhh@daum.net');


--������ ������
select * from member; --��ü ������

select * from member --���� �˻�
where memberid = 'SSOL';

--�����ͼ���
update member
set name = 'ȫ�浿����'
where memberid = 'SSs';
--�����ͻ���
delete from member
where memberid = 'SSLL';