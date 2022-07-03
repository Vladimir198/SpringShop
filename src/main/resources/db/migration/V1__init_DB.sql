
-- USERS
create sequence user_seq start 1 increment 1;

create table users (
                       id int8 not null,
                       archive boolean not null,
                       email varchar(255),
                       name varchar(255),
                       password varchar(255),
                       role varchar(255),
                       buket_id int8,
                       primary key (id)
);
-- BUCKET
create sequence buket_seq start 1 increment 1;

create table bukets (
                         id int8 not null,
                         user_id int8,
                         primary key (id)
);

-- LINK BETWEEN BUCKET AND USER
alter table if exists bukets
    add constraint buket_fk_user
        foreign key (user_id) references users;

-- CATEGORY
create sequence category_seq start 1 increment 1;

create table categories (
                            id int8 not null,
                            title varchar(255),
                            primary key (id)
);
-- PRODUCTS
create sequence product_seq start 1 increment 1;

create table products (
                          id int8 not null,
                          price numeric(19, 2),
                          title varchar(255),
                          primary key (id)
);

-- CATEGORY AND PRODUCT
create table products_categories (
                                     product_id int8 not null,
                                     category_id int8 not null
);

alter table if exists products_categories
    add constraint products_categories_fk_category
        foreign key (category_id) references categories;

alter table if exists products_categories
    add constraint products_categories_fk_product
        foreign key (product_id) references products;

-- PRODUCTS IN BUCKET
create table bukets_products (
                                 buket_id int8 not null,
                                 product_id int8 not null
);

alter table if exists bukets_products
    add constraint bukets_products_fk_product
        foreign key (product_id) references products;

alter table if exists bukets_products
    add constraint buket_products_fk_buket
        foreign key (buket_id) references bukets;

-- ORDERS
create sequence order_seq start 1 increment 1;

create table orders (
                        id int8 not null,
                        address varchar(255),
                        updated timestamp,
                        created timestamp,
                        status varchar(255),
                        sum numeric(19, 2),
                        user_id int8,
                        primary key (id)
);

alter table if exists orders
    add constraint orders_fk_user
        foreign key (user_id) references users;

-- DETAILS OF ORDER
create sequence order_details_seq start 1 increment 1;

create table orders_details (
                                id int8 not null,
                                order_id int8 not null,
                                product_id int8 not null,
                                amount numeric(19, 2),
                                price numeric(19, 2),
                                details_id int8,
                                primary key (id)
);

alter table if exists orders_details
    add constraint orders_details_fk_order
        foreign key (order_id) references orders;

alter table if exists orders_details
    add constraint orders_details_fk_product
        foreign key (product_id) references products;
        













