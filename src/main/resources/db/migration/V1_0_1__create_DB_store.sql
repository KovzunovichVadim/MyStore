create table if not exists accounts
(
    id         bigserial
        constraint accounts_pk
            primary key,
    first_name varchar(20)                         not null,
    last_name  varchar(20)                         not null,
    email      varchar(100),
    created    timestamp default CURRENT_TIMESTAMP not null
);

alter table accounts
    owner to postgres;

create table if not exists security
(
    id          bigserial
        constraint security_pk
            primary key,
    id_accounts bigint      not null
        constraint security_accounts_id_fk
            references accounts,
    username    varchar(20) not null,
    password    varchar(20) not null,
    role        varchar(20)
);

alter table security
    owner to postgres;

create table if not exists products
(
    id       bigserial
        constraint products_pk
            primary key,
    name     varchar(100) not null,
    price    integer      not null,
    quantity integer      not null
);

alter table products
    owner to postgres;

create table if not exists cart
(
    id          bigserial
        constraint cart_pk
            primary key,
    id_accounts bigint  not null
        constraint cart_accounts_id_fk
            references accounts,
    id_products bigint  not null
        constraint cart_products_id_fk
            references products,
    quantity    integer not null
);

alter table cart
    owner to postgres;

create table if not exists category
(
    id            bigserial
        constraint category_pk
            primary key,
    product_group varchar(255)
);

alter table category
    owner to postgres;

create table if not exists link_products_category
(
    id          bigserial
        constraint link_products_category_pk
            primary key,
    id_products bigint not null
        constraint link_products_category_products_id_fk
            references products,
    id_category bigint not null
        constraint link_products_category_category_id_fk
            references category
);

alter table link_products_category
    owner to postgres;

create table if not exists orders
(
    id            bigserial
        constraint orders_pk
            primary key,
    id_accounts   bigint    not null
        constraint orders_accounts_id_fk
            references accounts,
    order_date    timestamp not null,
    total_ammount integer
);

alter table orders
    owner to postgres;

create table if not exists orders_detail
(
    id          bigserial
        constraint orders_detail_pk
            primary key,
    id_orders   bigint  not null
        constraint orders_detail_orders_id_fk
            references orders,
    id_products bigint  not null
        constraint orders_detail_products_id_fk
            references products,
    quantity    integer not null,
    unit_price  integer not null
);

alter table orders_detail
    owner to postgres;

