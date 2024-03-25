create table if not exists link_product_orders_detail
(
    id               bigserial
        constraint link_product_orders_detail_pk
            primary key,
    id_products      bigint  not null
        constraint link_product_orders_detail_products_id_fk
            references public.products,
    id_orders_detail integer not null
        constraint link_product_orders_detail_orders_detail_id_fk
            references public.orders_detail
);

alter table link_product_orders_detail
    owner to postgres;

create table if not exists link_products_cart
(
    id          bigserial not null
        constraint link_products_cart_pk
            primary key,
    id_products bigint    not null
        constraint link_products_cart_products_id_fk
            references products,
    id_cart     bigint    not null
        constraint link_products_cart_cart_id_fk
            references cart
);

alter table link_products_cart
    owner to postgres;


