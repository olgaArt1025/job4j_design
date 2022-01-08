create table car(
	id serial primary key,
	model varchar (40),
	color text,
	mileage int
);
insert into car (model, color, mileage) values ('kia', 'black', 3000);
select * from car;
update car set model='ford';
select * from car;
delete from car;
select * from car;