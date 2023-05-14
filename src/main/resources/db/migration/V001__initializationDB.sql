create table if not exists cryptocurrencies
(
    id     bigserial
    constraint cryptocurrencies_pk
    primary key,
    symbol varchar(20)    not null
    constraint cryptocurrencies_pk2
    unique,
    name varchar(50),
    nameid varchar(50),
    rank integer,
    price_usd numeric(13,6),
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

alter table cryptocurrencies
    owner to postgres;

create table if not exists "users"
(
    id                bigserial
    constraint users_pk
    primary key,
    username          varchar(50)    not null,
    cryptocurrency_id bigint         not null
    constraint user_cryptocurrencies_id_fk
    references cryptocurrencies,
    starting_price    numeric(13,6) not null,
    constraint users_pk2
    unique (cryptocurrency_id, username)
    );

alter table "users"
    owner to postgres;