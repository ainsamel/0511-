drop table spuser;
drop table spproduct;
drop table spbasket;
drop table board;

create table spuser(
UserNumber number not null constraints user_UserNumber_PK primary key,
UserType varchar2(20) default '일반회원',
UserID varchar2(20) not null,
Password varchar2(20) not null,
UserName varchar2(20) not null,
Tel varchar2(20) not null,
Email varchar2(30) not null,
Address varchar2(50) not null);

insert into spuser values(1000000,'관리자','admin','1234','Admin','010-1234-1234','admin@naver.com','서울 동대문구');
insert into spuser values(1000001,'관리자','manager01','1234','김지혜','010-1234-1235','manager01@naver.com','수원시 권선구');
insert into spuser values(1000002,'관리자','manager02','1234','김지영','010-1234-1236','manager02@naver.com','수원시 팔달구');
insert into spuser values(1000003,'일반회원','dkjfh35','1111','김수란','010-1234-1237','dkjfh35@naver.com','수원시 팔달구');
insert into spuser values(1000004,'일반회원','skjdh200','1111','이승철','010-1234-1238','skjdh200@naver.com','서울 동대문구');
insert into spuser values(1000005,'일반회원','fhjd33','1111','이유나','010-1234-1239','fhjd33@naver.com','수원시 권선구');
insert into spuser(usernumber, UserType, userid, password, username, tel, email, address)
values((select count(usernumber) from spuser)+1, '일반회원','dbtestuser','1234','dbtest','010-1234-1239','fhjd33@naver.com','수원시 권선구');

select * from spuser;
--------------------------------고객DB끝----------------------------------
create table spproduct(
ProductID varchar2(20) not null constraints product_ProductID_PK primary key,
ProductType varchar2(20) not null,
ProductName varchar2(20) not null,
Explanation varchar2(50) not null,
Price number not null,
Inventory number not null);

insert into spproduct values('T00001234','TOP','반팔티','시원함',7900,100);
/*앞으로 몇 개 더 추가할 예정*/

select * from spproduct;
--------------------------------상품DB끝----------------------------------
create table spbasket(
BasketID number constraints basket_BasketID_PK primary key,
UserNumber number not null,
ProductID varchar2(20) not null,
cnt number not null,
price number not null);




select * from spbasket;
--------------------------------장바구니DB끝----------------------------------

create table sppayment(
PaymentID number not null constraints payment_PaymentID_PK primary key,
UserNumber number not null,
ProductID varchar2(20) not null,
cnt number not null,
address varchar2(50) not null,
tel varchar2(20) not null,
CCnumber varchar2(30) not null,
CCpassword number not null
);

insert into sppayment values(1,1000004,'S1308',5,'수원시 팔달구','010-1234-1238','0000-0000-0000-0000',1234);

select * from sppayment;
--------------------------------결제DB끝----------------------------------






------------------------------------------------------------------------
create table board(
	seq number(5) primary key,
	title varchar2(200) not null,
	nickname varchar2(30) not null,
	content varchar2(2000) not null,
	regdate date default sysdate,
	cnt number(5) default 0,
	userid varchar2(8)
);

--------------------------------------
insert into board(seq, title, nickname, content, regdate, userid) 
values(1, '첫 번째 게시물', '홍길동', '첫 번째 게시물 내용.', '2017-02-05', 'hong');

insert into board(seq, title, nickname, content, regdate, userid) 
values(2, '두 번째 게시물', '홍길동', '두 번째 게시물 내용.', '2017-03-15', 'hong');

insert into board(seq, title, nickname, content, regdate, userid) 
values(3, '세 번째 게시물', '홍길동', '세 번째 게시물 내용.', '2017-03-03', 'hong');

insert into board(seq, title, nickname, content, regdate, userid) 
values(4, '네 번째 게시물', '홍길동', '네 번째 게시물 내용.', '2017-05-17', 'hong');

insert into board(seq, title, nickname, content, regdate, userid) 
values(5, '다섯 번째 게시물', '일지매', '다섯 번째 게시물 내용.', '2017-05-19', 'guest');

insert into board(seq, title, nickname, content, regdate, userid) 
values(6, '여섯 번째 게시물', '일지매', '여섯 번째 게시물 내용.', '2017-12-25', 'guest');

insert into board(seq, title, nickname, content, regdate, userid) 
values((select nvl(max(seq), 0)+1 from board), '일곱 번째 게시물', '일지매', '일곱 번째 게시물 내용.', '2017-12-25', 'guest');

select * from board;








