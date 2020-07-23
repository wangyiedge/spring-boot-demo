## spring-boot-security

#### 介绍:
  Spring Boot security整合JWT实现Demo。
  用户权限信息使用了postgres数据库存储。
  ORM框架采用了mybatis-plus。
  
#### 数据库DDL:

```sql
create table tbl_auth_user
(
	id bigint not null
		constraint tbl_auth_user_pk
			primary key,
	user_name varchar(36),
	password varchar(128),
	enable boolean default true,
	create_user_id varchar(64),
	create_time bigint,
	update_user_id varchar(64),
	update_time bigint,
	locked boolean default false,
	expired_time bigint,
	phone varchar(15),
	available boolean,
	email varchar(128),
	type integer
);

comment on table tbl_auth_user is '用户信息表';

comment on column tbl_auth_user.user_name is '用户名';

comment on column tbl_auth_user.password is '加密后的密码';

comment on column tbl_auth_user.enable is '有效标示';

comment on column tbl_auth_user.create_user_id is '创建用户';

comment on column tbl_auth_user.create_time is '创建时间';

comment on column tbl_auth_user.update_user_id is '更新者';

comment on column tbl_auth_user.update_time is '修改时间';

comment on column tbl_auth_user.locked is '是否锁定';

comment on column tbl_auth_user.expired_time is '过期时间';

comment on column tbl_auth_user.phone is '电话号码';

comment on column tbl_auth_user.available is '数据有效';

comment on column tbl_auth_user.email is '邮箱';

comment on column tbl_auth_user.type is '类型';

alter table tbl_auth_user owner to postgres;

create table tbl_auth_role
(
	id bigint not null
		constraint tbl_auth_role_pkey
			primary key,
	name varchar(128) not null,
	enable boolean default true,
	memos text,
	create_user_id varchar(32) not null,
	create_time bigint not null,
	update_user_id varchar(32) not null,
	update_time bigint not null,
	available boolean default true not null
);

comment on table tbl_auth_role is '角色表';

comment on column tbl_auth_role.id is '主键ID';

comment on column tbl_auth_role.name is '角色名称';

comment on column tbl_auth_role.enable is '启用，禁用';

comment on column tbl_auth_role.memos is '备注';

comment on column tbl_auth_role.create_user_id is '创建人';

comment on column tbl_auth_role.create_time is '创建时间';

comment on column tbl_auth_role.update_user_id is '更新人';

comment on column tbl_auth_role.update_time is '更新时间';

comment on column tbl_auth_role.available is '有效标识,TRUE:有效,FALSE:无效';

alter table tbl_auth_role owner to postgres;

create table tbl_auth_user_role
(
	id bigint not null
		constraint tbl_auth_user_role_pkey
			primary key,
	user_id bigint not null,
	role_id bigint not null,
	create_user_id varchar(32) not null,
	create_time bigint not null,
	update_user_id varchar(32) not null,
	update_time bigint not null,
	available boolean default true not null
);

comment on table tbl_auth_user_role is '用户角色关系表';

comment on column tbl_auth_user_role.id is '主键ID';

comment on column tbl_auth_user_role.user_id is '用户id';

comment on column tbl_auth_user_role.role_id is '角色Id';

comment on column tbl_auth_user_role.create_user_id is '创建人';

comment on column tbl_auth_user_role.create_time is '创建时间';

comment on column tbl_auth_user_role.update_user_id is '更新人';

comment on column tbl_auth_user_role.update_time is '更新时间';

comment on column tbl_auth_user_role.available is '有效标识,TRUE:有效,FALSE:无效';

alter table tbl_auth_user_role owner to postgres;

create table tbl_auth_resource
(
	id bigint not null
		constraint tbl_auth_resource_func_pkey
			primary key,
	name varchar(256) not null,
	code varchar(256) not null,
	create_user_id varchar(32) not null,
	create_time bigint not null,
	update_user_id varchar(32) not null,
	update_time bigint not null,
	available boolean default true not null
);

comment on table tbl_auth_resource is '资源数据表';

comment on column tbl_auth_resource.id is '主键ID';

comment on column tbl_auth_resource.name is '资源名称';

comment on column tbl_auth_resource.code is '资源编码';

comment on column tbl_auth_resource.create_user_id is '创建人';

comment on column tbl_auth_resource.create_time is '创建时间';

comment on column tbl_auth_resource.update_user_id is '更新人';

comment on column tbl_auth_resource.update_time is '更新时间';

comment on column tbl_auth_resource.available is '有效标识,TRUE:有效,FALSE:无效';

alter table tbl_auth_resource owner to postgres;

create table tbl_auth_role_resource
(
	id bigint not null
		constraint tbl_auth_role_resource_pkey
			primary key,
	role_id bigint not null,
	resource_id bigint not null,
	create_user_id varchar(32) not null,
	create_time bigint not null,
	update_user_id varchar(32) not null,
	update_time bigint not null,
	available boolean default true not null
);

comment on table tbl_auth_role_resource is '角色资源关联表';

comment on column tbl_auth_role_resource.id is '主键ID';

comment on column tbl_auth_role_resource.role_id is '角色id';

comment on column tbl_auth_role_resource.resource_id is '资源id';

comment on column tbl_auth_role_resource.create_user_id is '创建人';

comment on column tbl_auth_role_resource.create_time is '创建时间';

comment on column tbl_auth_role_resource.update_user_id is '更新人';

comment on column tbl_auth_role_resource.update_time is '更新时间';

comment on column tbl_auth_role_resource.available is '有效标识,TRUE:有效,FALSE:无效';

alter table tbl_auth_role_resource owner to postgres;

```