CREATE SCHEMA ssafy_test;

use ssafy_test;

#user 라는 테이블이 존재하지 않으면 생성
create table IF NOT EXISTS `user` (
#기본 키 는 id
	`id` varchar(50) not null PRIMARY KEY,
    `pass` varchar(30) not null,
    `name` varchar(50) not null,
    `email` varchar(50) not null
)engine = InnoDB;

#board 라는 테이블이 존재하지 않으면 생성
create table IF NOT EXISTS `board` (
#기본 키 인 게시글 번호는 정수, 생성될 때 자동 증가
	`board_num` int not null PRIMARY KEY AUTO_INCREMENT,
    `title` varchar(50) not null,
    `content` varchar(100) not null,
    `writer_id` varchar(50) not null,
    `create_time` datetime not null,
# writer_id 는 user 테이블의 id 컬럼을 참조하는 외래 키
    _________ `fk_board_user`
		______ ____ (`________`)
        ____________ `______` (`__`)
# 외래키 삭제나 변경시 할 액션
        on delete cascade
        on update cascade
)engine = InnoDB;

# comment 라는 테이블이 존재하지 않으면 생성
create table __ __ _______ `comment` (
	`writer_id` varchar(50) not null,
    `board_num` int not null,
    `writer_name` varchar(50) not null,
    `comment` varchar(50) not null,
    `create_time` datetime not null,
# 기본 키는 writer_id, `board_num`, `create_time` 세가지를 조합
    __________ ___ (`writer_id`, `board_num`, `create_time`),
# board_num 은 board 테이블의 board_num 컬럼을 참조하는 외래 키
    ________ `fk_comment_board`
		________ ______ (`________`)
        ________ `________` (`_________`)
        on delete cascade
        on update cascade,
# writer_id 는 user 테이블의 id 컬럼을 참조하는 외래 키
	__________ `fk_comment_user`
		_________ ____ (`_______`)
        _________ `_____` (`__`)
        on delete cascade
        on update cascade
)engine = InnoDB;