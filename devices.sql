create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices (name, price) values ('Ноутбук', 65600), ('Телефон', 30200), ('Часы', 25000), ('Планшет', 45000), ('Телефон 2', 3000);
insert into people(name) values ('Аня'), ('Ваня'), ('Боря'), ('Коля'), ('Настя');
insert into devices_people (device_id, people_id) values (1, 2), (2, 3), (3, 4), (4, 1), (5, 5);
insert into devices_people (device_id, people_id) values (1, 3), (1, 4), (2, 1), (3, 1), (2, 4), (4, 2);

select avg(price) from devices;

select s.name, avg(ss.price) 
from people as s 
join devices_people dp 
on dp.people_id = s.id
join devices ss 
on dp.device_id = ss.id
group by s.name;


select s.name, avg(ss.price) 
from people as s 
join devices_people dp 
on dp.people_id = s.id
join devices ss 
on dp.device_id = ss.id
group by s.name
having avg(ss.price) > 5000;
