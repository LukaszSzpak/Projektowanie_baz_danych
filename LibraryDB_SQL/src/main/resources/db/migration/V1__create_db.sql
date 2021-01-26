create table author (
   id bigint not null,
    name varchar(255) not null,
    primary key (id)
);


create table book (
   id bigint not null,
    available boolean,
    description varchar(255) not null,
    title varchar(255) not null,
    author_id bigint,
    primary key (id)
);


create table book_user_wish_list (
   wish_list_id bigint not null,
    user_wish_list_id bigint not null,
    primary key (wish_list_id, user_wish_list_id)
);


create table employee (
   id bigint not null,
    email varchar(255) not null,
    name varchar(255) not null,
    password varchar(255) not null,
    role varchar(255),
    surname varchar(255) not null,
    primary key (id)
);

create table item (
   id bigint not null,
    available boolean,
    condition varchar(255) not null,
    book_id bigint,
    publish_house_id bigint,
    primary key (id)
);


create table loan (
   id bigint not null,
    additional_cost float,
    date_planning_return timestamp,
    days_after_return_date integer,
    is_back boolean,
    rent_date timestamp not null,
    employee_id bigint,
    item_id bigint,
    user_id bigint,
    primary key (id)
);


create table publish_house (
   id bigint not null,
    name varchar(255) not null,
    primary key (id)
);


create table user (
   id bigint not null,
    email varchar(255) not null,
    name varchar(255) not null,
    password varchar(255) not null,
    surname varchar(255) not null,
    primary key (id)
);


alter table author
   drop constraint if exists UK_or6k6jmywerxbme223c988bmg;


alter table author
   add constraint UK_or6k6jmywerxbme223c988bmg unique (name);


alter table publish_house
   drop constraint if exists UK_pvaci3qwv3uqr51ambyxhf2be;


alter table publish_house
   add constraint UK_pvaci3qwv3uqr51ambyxhf2be unique (name);

create sequence hibernate_sequence start with 1 increment by 1;


alter table book
   add constraint FKklnrv3weler2ftkweewlky958
   foreign key (author_id)
   references author;

alter table book_user_wish_list
   add constraint FKcr7kns4cevie2at7at8cj335h
   foreign key (user_wish_list_id)
   references user;

alter table book_user_wish_list
   add constraint FKo05esgdg5r5goromx7tv7106a
   foreign key (wish_list_id)
   references book;

alter table item
   add constraint FKr7awym4wjcuf2qytjfnvmjjw4
   foreign key (book_id)
   references book;

alter table item
   add constraint FKgqn511smm8tgxd5wl4t6s6e5v
   foreign key (publish_house_id)
   references publish_house;


alter table loan
   add constraint FKldelgmf98lfdsspa79vo5syqb
   foreign key (employee_id)
   references employee;


alter table loan
   add constraint FKn8knyhu6lqb2prwx5bqp9bm37
   foreign key (item_id)
   references item;


alter table loan
   add constraint FKxxm1yc1xty3qn1pthgj8ac4f
   foreign key (user_id)
   references user;