drop table spuser;
drop table spproduct;
drop table spbasket;

create table spuser(
UserNumber number not null constraints user_UserNumber_PK primary key,
UserType varchar2(20) not null,
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
insert into spuser values(1000006,'일반회원','sf243567','1111','이사랑','010-1234-1240','sf243567@naver.com','서울 동대문구');
insert into spuser values(1000007,'일반회원','dddd335','1111','박수현','010-1234-1241','dddd335@naver.com','서울 동대문구');
insert into spuser values(1000008,'일반회원','shccc772','1111','박소리','010-1234-1242','shccc772@naver.com','수원시 영통구');
insert into spuser values(1000009,'일반회원','ttggxxee2222','1111','박지영','010-1234-1243','ttggxxee2222@naver.com','수원시 권선구');
insert into spuser values(1000010,'일반회원','dtw3gd4','1111','최민철','010-1234-1244','dtw3gd4@naver.com','수원시 팔달구');
insert into spuser values(1000011,'일반회원','sssgg844','1111','최민수','010-1234-1245','sssgg844@naver.com','수원시 권선구');
insert into spuser values(1000012,'일반회원','shexc33ys','1111','최영희','010-1234-1246','shexc33ys@naver.com','서울 동대문구');
insert into spuser values(1000013,'일반회원','ghss445','1111','유민호','010-1234-1247','ghss445@naver.com','서울 동대문구');
insert into spuser values(1000014,'일반회원','uuiihh112233','1111','유인하','010-1234-1248','uuiihh112233@naver.com','서울 동대문구');


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
