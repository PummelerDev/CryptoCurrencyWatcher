create table if not exists cryptocurrency
(
    id     bigserial
    constraint cryptocurrency_pk
    primary key,
    symbol varchar(20)    not null
    constraint cryptocurrency_pk2
    unique,
    price  numeric(12, 6) default 0 not null
    );

alter table cryptocurrency
    owner to postgres;

create table if not exists "user"
(
    id                bigserial
    constraint user_pk
    primary key,
    username          varchar(50)    not null,
    cryptocurrency_id bigint         not null
    constraint user_cryptocurrency_id_fk
    references cryptocurrency,
    starting_price    numeric(12, 6) not null
    );

alter table "user"
    owner to postgres;