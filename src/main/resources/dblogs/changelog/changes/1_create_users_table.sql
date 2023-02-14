create table users_table
(id    serial
     constraint users_table_pkey
         primary key,
 email varchar(255) not null,
 login varchar(255) not null,
 name  varchar(255) not null
);

alter table users_table
    owner to admin;