-- auto-generated definition
create table transaction_table
(
    id        serial
        constraint transaction_table_pkey
            primary key,
    amount    double precision,
    date      timestamp(6),
    status    smallint,
    wallet_id integer
        references wallet_table
);

alter table transaction_table
    owner to admin;