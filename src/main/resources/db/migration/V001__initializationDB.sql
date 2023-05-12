create table if not exists cryptocurrency
(
    id     bigserial
    constraint cryptocurrency_pk
    primary key,
    symbol varchar(20)    not null
    constraint cryptocurrency_pk2
    unique,
    name varchar(50),
    nameid varchar(50),
    rank integer,
    price_usd varchar(50),
    percent_change_24h varchar(50),
    percent_change_1h varchar(50),
    percent_change_7d varchar(50),
    market_cap_usd varchar(50),
    volume24 varchar(50),
    volume24_native varchar(50),
    csupply varchar(50),
    price_btc varchar(50),
    tsupply varchar(50),
    msupply varchar(50)
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