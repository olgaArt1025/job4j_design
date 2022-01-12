create table body (
	id serial primary key,
	name varchar(100)
);

create table engine (
	id serial primary key,
	name varchar(100)
);

create table gearbox (
id serial primary key,
	name varchar(100)
);

create table car (
id serial primary key,
	name varchar(100),
	body_id int references body(id),
	engine_id int references engine(id),
	gearbox_id int references gearbox(id)	
);

insert into body(name) values 
('седан'), ('хэтчбек'), ('лифтбек'), ('универсал'), ('купе');

insert into engine (name) values 
('двигатель v4'), ('двигатель v5'), ('двигатель v6'), ('двигатель v8'), ('двигатель v12');

insert into gearbox (name) values
('механическая'), ('автоматическая'), ('роботизированная'), ('вариатор'), ('преселективная');

insert into car ( name, body_id, engine_id, gearbox_id) values
('car1', 2, 3, 3), ('car2', 1, 4, 1), ('car3', 2, 1, 1), ('car4', 3, 3, 3), ('car5', 4, 5, 2); 

select 
	c.name as машина,
	b.name as кузов,
	e.name as двигатель,
	g.name as коробка
from car c
join body b on b.id=c.body_id
join engine e on e.id=c.engine_id
join gearbox g on g.id=c.gearbox_id; 

select b.name as кузов_не_используется, c.name as машина 
from body b
left join car c on b.id=c.body_id
where c.body_id is null;

select e.name as двигатель_не_используется, c.name as машина 
from engine e
left join car c on e.id=c.engine_id
where c.engine_id is null;

select g.name as коробка_не_используется, c.name as машина 
from gearbox g
left join car c on g.id=c.gearbox_id
where c.gearbox_id is null;
