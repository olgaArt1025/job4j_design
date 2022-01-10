create table tickets(
    id serial primary key,
	type varchar(255),
    seat_number int
);

create table passenger (
    id serial primary key,
    name varchar(255),
    tickets_id int references tickets(id)
);

insert into tickets(type, seat_number) values ('plane', 56), ('plane', 57), ('bus', 10), ('train', 87);

insert into passenger(name, tickets_id) VALUES ('Катя', 1), ('Саша', 2), ('Миша', 4), ('Ира', 3);
insert into passenger(name) values ('Вася');

select * from passenger inner 
join tickets p 
on passenger.tickets_id = p.id;

select pp.name as Имя, p.type as Вид_транспорта, 
p.seat_number as Номер_места from passenger as pp 
join tickets as p 
on pp.tickets_id = p.id;

select pp.name, p.type, p.seat_number
from passenger as pp
join tickets as p
on pp.tickets_id=p.id;

select pp.name, p.type
from passenger as pp
join tickets as p
on pp.tickets_id=p.id;
