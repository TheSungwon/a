--계정 생성 oracle, scott 끝에 비밀번호
create user ezen2 identified by oracle;
create user scott identified by tiger;

--권한부여
grant resource, connect to ezen2;
grant resource, connect to scott;