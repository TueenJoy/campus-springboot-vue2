drop database if exists USERDBspringBM;
create database USERDBspringBM;
use USERDBspringBM;
CREATE TABLE mx_user (
  `user_id` bigint NOT NULL COMMENT '用户主键ID' auto_increment primary key,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',-- 默认空
  `user_acc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',-- 默认空
  `user_age` int(16) NULL DEFAULT NULL COMMENT '年龄',-- 默认空
  `user_gender` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',-- 默认空
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',-- 默认空
  `user_mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',-- 默认空
  `user_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',-- 默认空
  `user_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',-- 默认空
  `user_status` tinyint(4) NULL DEFAULT 1 COMMENT '状态  0：禁用   1：正常', -- 默认1 正常
  `user_permission` varchar(32) NULL DEFAULT 'user' COMMENT 'user用户 suser超级用户 admin管理员' -- 默认user
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- SET FOREIGN_KEY_CHECKS = 1;
insert into mx_user(user_name,user_acc,user_age,user_gender,user_password,user_mobile,user_email,user_image,user_status)
value (substr(md5(rand()),1,6),floor(100+rand() * 999999899),11,'男',substr(md5(rand()),1,9)
,'1306660221','xxx@mail.com','www.xxx.jpg',1);

insert into mx_user(user_name,user_acc,user_age,user_gender,user_password,user_mobile,user_email,user_image,user_status,user_permission)
value ('admin',10001,20,'男',123456
,'1306660221','123mail@163.com','www.thisisatestjpgtorealizesupportshowuserimage.jpg',1,'admin');
-- 校园公告表
CREATE TABLE inf_notice (
  `inf_num` int(4) NOT NULL COMMENT '用户主键ID' auto_increment primary key,
  `inf_title` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',-- 默认空
  `inf_author` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',-- 默认空
  `inf_date` datetime,
  `inf_detail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章详情',-- 默认空
  `inf_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL 
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- SET FOREIGN_KEY_CHECKS = 1;
insert into inf_notice(inf_title,inf_author,inf_date,inf_detail,inf_img)
value ('学校复课通知','发布号',CURRENT_TIMESTAMP,'这是一篇文章详情detail 12345','http://qwertyuioasdf.img');
insert into inf_notice(inf_title,inf_author,inf_date,inf_detail,inf_img)
value ('停课通知','发布号2',CURRENT_TIMESTAMP,'这是一篇文章详情detail2','http://qwertyuioasdf.img');
insert into inf_notice(inf_title,inf_author,inf_date,inf_detail,inf_img)
value ('加入新生群','发布号3',CURRENT_TIMESTAMP,'这是一篇文章详情','http://qwertyuioasdf.img');

-- 活动表Regi
CREATE TABLE regi_act (
  `regi_id` int(4) NOT NULL COMMENT '用户主键ID' auto_increment primary key,
  `regi_title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动标名称',-- 默认空
  `regi_author` varchar(42) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布者',-- 默认空
  `regi_datetime` datetime,
  `regi_starttime` datetime,
  `regi_overtime` datetime,
  `regi_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动详情',-- 默认空
  `regi_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `regi_number` int(4) NOT NULL,
  `regi_maxnum` int(12) NULL DEFAULT 0,
  `regi_alnum` int(12) NULL DEFAULT 0   
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- SET FOREIGN_KEY_CHECKS = 1;
insert into regi_act(regi_title,regi_author,regi_starttime,regi_overtime,regi_content,regi_img,regi_number,regi_maxnum,regi_alnum)
value ('学校复课通知','发布号',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'这是一篇文章详情content detail 12345','https://news.cqu.edu.cn/uploadfile/2023/0908/20230908110648598.jpg',11111,30,2);

-- 发布管理表record_act
CREATE TABLE record_act (
  `rec_id` int(4) NOT NULL COMMENT '用户主键ID' auto_increment primary key,
  `rec_title` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动名称',
  `rec_number` int(4) NOT NULL COMMENT '编号',
  
  `rec_userAcc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报名用户账号'
  
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- SET FOREIGN_KEY_CHECKS = 1;
insert into record_act(rec_title,rec_number,rec_userAcc)
value ('学校复课通知',11111,'用户1');

-- 记录活动报名用户表
CREATE TABLE sign_act (
  `sign_id` int(4) NOT NULL COMMENT '用户主键ID' auto_increment primary key,
  `sign_title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动名称',
  `sign_number` int(4) NOT NULL COMMENT '编号',
  `sign_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报名用户',
  `sign_uname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报名用户名'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- SET FOREIGN_KEY_CHECKS = 1;
insert into sign_act(sign_title,sign_number,sign_user,sign_uname)
value ('学校复课通知',311957,'admin','我是测试用户1');

-- 新闻表list_news
CREATE TABLE list_news (
  `list_id` int(4) NOT NULL COMMENT '用户主键ID' auto_increment primary key,
  `list_title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动名称',-- 默认空
  `list_author` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布者',-- 默认空
  `list_datetime` datetime,
    `list_number` int(24) NOT NULL COMMENT '编号',
  `list_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动详情',-- 默认空
  `list_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `list_type` int(4) NOT NULL COMMENT '文章类型0-学校通知1-校内热点'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- SET FOREIGN_KEY_CHECKS = 1;
insert into list_news(list_title,list_author,list_datetime,list_number,list_content,list_img,list_type)
value ('学校复课通知','发布号',CURRENT_TIMESTAMP,'111111','这是一篇文章详情content detail 12345','https://news.cqu.edu.cn/uploadfile/2023/0908/20230908110648598.jpg','0'
);

