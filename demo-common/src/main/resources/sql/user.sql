CREATE DATABASE USER;
use user;
create TABLE USER(
`user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
`name` VARCHAR(120) NOT NULL COMMENT '用户名',
`age` INT NOT NULL COMMENT '年龄',
`sex` CHAR(1) COMMENT '性别',
`addr` VARCHAR (120) COMMENT '地址',
    PRIMARY KEY (user_id),
    KEY idx_age(age)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT  CHARSET=utf8 COMMENT='用户表';
insert into user(name ,age,sex,addr) VALUES
  ('yue1',18,'f',''),
('yue2',18,'m',''),
('yue3',19,'f',''),
('yue4',19,'f',''),
('yue5',20,'m',''),
('yue6',22,'m',''),
('yue7',23,'f',''),
('chuqiao',23,'m','');