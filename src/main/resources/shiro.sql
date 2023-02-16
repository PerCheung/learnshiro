drop database shiro_learn;

create database shiro_learn;

use shiro_learn;

create table user
(
    username    varchar(36) primary key comment '用户名',
    password    varchar(32) not null comment '密码',
    salt        varchar(36) not null comment '盐',
    create_time datetime default now() comment '创建时间',
    update_time datetime default now() comment '修改时间',
    deleted     int      default 0 comment '逻辑删除'
) comment '用户表'
    engine = innodb
    default charset = utf8mb4;

create trigger user_update
    before update
    on user
    for each row set new.update_time = now();

create table role
(
    role        varchar(36) primary key comment '角色',
    create_time datetime default now() comment '创建时间',
    update_time datetime default now() comment '修改时间',
    deleted     int      default 0 comment '逻辑删除'
) comment '角色表'
    engine = innodb
    default charset = utf8mb4;

create trigger role_update
    before update
    on role
    for each row set new.update_time = now();


create table permission
(
    permission  varchar(255) primary key comment '权限',
    create_time datetime default now() comment '创建时间',
    update_time datetime default now() comment '修改时间',
    deleted     int      default 0 comment '逻辑删除'
) comment '权限表'
    engine = innodb
    default charset = utf8mb4;

create trigger permission_update
    before update
    on permission
    for each row set new.update_time = now();

create table user_role
(
    username varchar(36) not null comment '用户名',
    role     varchar(36) not null comment '角色',
    primary key (username, role)
) comment '用户角色连接表'
    engine = innodb
    default charset = utf8mb4;

create table permission_role
(
    permission varchar(255) not null comment '权限',
    role       varchar(36)  not null comment '角色',
    primary key (permission, role)
) comment '权限角色连接表'
    engine = innodb
    default charset = utf8mb4;

INSERT INTO permission(permission)
VALUES ('view'),
       ('edit');

INSERT INTO role(role)
VALUES ('user'),
       ('admin');

INSERT INTO permission_role
VALUES ('view', 'user'),
       ('view', 'admin'),
       ('edit', 'admin');


INSERT INTO user_role
VALUES ('admin', 'admin'),
       ('user', 'user');

# 角色：user, admin
# 调用注册接口注册 POST http://localhost:8081/register