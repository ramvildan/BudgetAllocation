-- auto-generated definition
create table wallet_table
(
    id                   serial
        constraint wallet_table_pkey
            primary key,
    name                 varchar(255),
    percentage_of_income integer,
    user_id              integer
        references users_table
);

alter table wallet_table
    owner to admin;