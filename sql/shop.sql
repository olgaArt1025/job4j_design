create table type (
	id serial primary key,
	name varchar(150)
);

create table product (
	id serial primary key,
	name varchar(150),
	type_id int references type(id),
	expired_date date,
	price float	
);

insert into type (name) values ('Сыр'), ('Мясо и мясные товары'), ('Зерно-мучные товары'), ('Плодоовощные товары'), ('Молоко');
insert into product(name, type_id, expired_date, price) values
	('Рокфор сыр', 1, date '24-02-2022', 300.00),
	('Российский сыр', 1, date '24-02-2022', 300.00),
	('Голландский сыр', 1, date '05-08-2022', 400.90),
	('Пармезан сыр', 1, date '12-12-2022', 1000.00),
	('Свинина', 2, date '20-02-2022', 320.00),
	('Говядина', 2, date '29-01-2022', 640.40),
	('Колбаса', 2, date '14-03-2022', 700.00),
	('Курица', 2, date '25-01-2022', 219),
	('Сосиски', 2, date '10-01-2022', 300),
	('Рис', 3, date '17-02-2022', 89.20),
	('Греча', 3, date '15-04-2023', 95.50),
	('Макароны', 3, date '12-07-2022', 65.00),
	('Яблоки', 4, date '20-05-2022', 65.00),
	('Картошка', 4, date '20-08-2022', 72.00),
	('Апельсины', 4, date '05-02-2022', 68.50),
	('Мороженое пломбир', 5, date '07-10-2022', 60.00),
	('Мороженое шоколадное', 5, date '16-08-2022', 50),
	('Мороженое фисташковое', 5, date '13-09-2022', 100),
 	('Молоко', 5, date '06-01-2022', 56.70);

select * from product where type_id = (select type.id from type where name = 'Сыр');

select * from product where name like 'Мороженое%';

select * from product where expired_date < CURRENT_DATE; 

select * from product where price = (select max(price) from product);

select t.name, count(t.name)
from type as t
join product as p
on p.type_id=t.id
group by t.name;

select * from product where type_id  in (select type.id from type where name  in ('Сыр', 'Молоко'));

select t.name, count(t.name)
from type as t
join product as p
on p.type_id=t.id
group by t.name
having count(t.name) < 10;

select p.name as Продукты, t.name as Тип_продуктов
from product as p
join type as t
on p.type_id=t.id;
