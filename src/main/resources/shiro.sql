drop database shiro_learn;

create database shiro_learn;

use shiro_learn;

create table user
(
    id          int primary key auto_increment comment '主键',
    username    varchar(36) not null unique comment '用户名',
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
    id          int primary key auto_increment comment '主键',
    role_id     varchar(20) not null unique comment '角色id',
    role_name   varchar(36) not null unique comment '角色名',
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
    id            int primary key auto_increment comment '主键',
    permission_id varchar(20) not null unique comment '权限id',
    description   varchar(36) not null unique comment '权限描述',
    create_time   datetime default now() comment '创建时间',
    update_time   datetime default now() comment '修改时间',
    deleted       int      default 0 comment '逻辑删除'
) comment '权限表'
    engine = innodb
    default charset = utf8mb4;

create trigger permission_update
    before update
    on permission
    for each row set new.update_time = now();

create table user_role
(
    id       int primary key auto_increment comment '主键',
    username varchar(36) not null comment '用户名',
    role_id  varchar(20) not null comment '角色id',
    unique (username, role_id)
) comment '用户角色连接表'
    engine = innodb
    default charset = utf8mb4;

create table permission_role
(
    id            int primary key auto_increment comment '主键',
    permission_id varchar(20) not null comment '权限id',
    role_id       varchar(20) not null comment '角色id',
    unique (permission_id, role_id)
) comment '权限角色连接表'
    engine = innodb
    default charset = utf8mb4;

