create table book (
   id bigint not null,
    author varchar(255) not null,
    available boolean,
    description varchar(255) not null,
    title varchar(255) not null,
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
    publish_house varchar(255) not null,
    book_id bigint,
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

create table user (
   id bigint not null,
    email varchar(255) not null,
    name varchar(255) not null,
    password varchar(255) not null,
    surname varchar(255) not null,
    primary key (id)
);

create sequence hibernate_sequence start with 1 increment by 1;

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