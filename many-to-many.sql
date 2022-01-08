create table customer(
     id serial primary key,
     name varchar(255)
 );
 
 create table products(
     id serial primary key,
     name varchar(255)
 );
 
 create table ordering(
     id serial primary key,
     customer_id int references customer(id),
     products_id int references products (id)
 );
 
insert into customer (name) values ('Иванов И.И.');
insert into customer (name) values ('Петров П.Г.');
insert into customer (name) values ('Смирнова В.Л.');

insert into products (name) values ('Молоко');
insert into products (name) values ('Хлеб');
insert into products (name) values ('Гречка');
insert into products (name) values ('Рис');
insert into products (name) values ('Торт');

insert into ordering (customer_id, products_id) values (2, 1);
insert into ordering (customer_id, products_id) values (3, 4);
insert into ordering (customer_id, products_id) values (2, 5);
insert into ordering (customer_id, products_id) values (1, 2);
insert into ordering (customer_id, products_id) values (1, 3);