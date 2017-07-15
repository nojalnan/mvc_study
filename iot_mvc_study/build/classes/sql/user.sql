/*
1. DDL(Data Definition Language)
데이터베이스, 유저,  테이블등의 구조 정의 및 수정에 관련된 명령어로
Create, Alter, Drop, Truncate 등이 있다.
*/
# iot_test 라는 데이터베이스 생성
create database iot_test;

# iot_test데이터 베이스 선택
# 이후 모든 작업은 데이터베이스를 변경하기 전까지 해당 데이터 베이스에서 이루어짐
use iot_test;


# user_info라는 테이블 생성
create table user_info(
#user_num이라는 컬럼명에 자료형은 int, 자동증가이며 해당테이블의 기본키
#기본키는 중복 불가
user_num int(5) auto_increment primary key,
user_id varchar(30) not null ,
user_pwd varchar(30) not null,
user_name varchar(100) not null,
class_num int(5) not null,
age int(3),
#기본키는 아니지만 user_id로 인덱스가 만들어지며 unique이기 때문에 중복불가
unique index(user_id)
);

# board라는 테이블 삭제
drop table board;

create table board(
board_num int(7) auto_increment primary key,
title varchar(100) not null,
content text,
user_num int(5),
#board테이블의 user_num이 user_info의 user_num을 참조하게 되며
# 이를 외래키라고 부른다
# 외래키를 설정하게 될경우 참조하는 테이블의 컬럼에 값이 없을경우 저장할 수 없다
foreign key (user_num) references user_info(user_num)
)

#user_info테이블을 수정할건데
#class_num이라는 컬럼명의 int타입을 가지고 null을 허용하지 않는 컬럼을 추가하겠다는 문구
alter table user_info
add column class_num int(5) not null;


#user_info테이블을 수정할건데
#num이라는 컬럼의 이름을 user_num으로 바꾸고 int타입으로 선언하겠다는 문구
ALTER TABLE user_info
CHANGE COLUMN num user_num int;


#user_info테이블을 수정할건데
#id컬럼을 중복불가 인덱스로 추가 하겠다는 문구
alter table user_info 
add unique index(user_id);

#외래키를 2개 설정해야 할 경우의 예제
create table comment_info(
ci_num int(5) AUTO_INCREMENT primary key,
content text,
reg_Date datetime not null,
board_num int(7) not null,
user_num int(5) not null,
foreign key (board_num) references board(board_num),
foreign key (user_num) references user_info(user_num)
);


#외래키를 2개 설정해야 할 경우의 예제
create table comment_info(
ci_num int(5) AUTO_INCREMENT primary key,
content text,
reg_Date datetime not null,
board_num int(7) not null,
user_num int(5) not null,
foreign key (board_num) references board(board_num),
foreign key (user_num) references user_info(user_num)
);


#유저 생성 명령어
create user 'test'@'localhost' identified by 'test';

# test라는 유저 삭제
drop user test;

# 유저명@'%' 외부 접속이 가능한 유저 생성
# identified by '비밀번호'
create user test@'%' identified by 'test';

/*
2. DML(Data Manipulation Language)
데이터를 조작하는 명령어로
Select, Insert, Update, Delete가 있다.
*/
# 컬럼에 * 를 사용할경우 from에 명시한 테이블의 모든 컬럼이
# 테이블 생성시 만들어진 컬럼 순서대로 결과에 출력되게 된다.
select * from comment_info;
select * from user_info;
# insert into 테이블명(컬럼 정보들) values(입력할 값 정보들)
# 컬럼정보에서 명시된 순서대로 입력할 값 정보들을 입력하면 해당 테이블에 로우데이터가 1개 저장되게 된다.
insert into user_info(user_id, user_pwd, user_name, class_num, age)
values('red','red','홍길동',1, 30);
insert into board(title, content, user_num)
values('제목2','내용2',1);
insert into comment_info(content, reg_date, board_num, user_num)
values('코멘트2_',now(), 2,1);


/*
3. DCL(Data Control Language)
제어에 관련된 명령어로
Grant, Revoke가 있다.
*/

#권한 명령어 이후 적용사항을 리로드하는 명령어
flush privileges;

#iot_Test 데이터 베이스의 모든 권한을 test@'%'에게 주겠다는 명령어
grant all privileges on iot_test to test@'%';
#iot_Test 데이터 베이스의 모든 권한을 주었던 test@'%'부터 모든 권한을 박탈하겠다는 명령어
revoke all on iot_test from test@'%';
