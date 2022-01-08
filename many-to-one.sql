create table bus(
    id serial primary key,
    number int
);

create table passenger(
    id serial primary key,
    name varchar(255),
    bus_id int references bus(id)
);

insert into bus(number) values (1);

insert into passenger(name, bus_id) VALUES ('Катя', 1);
insert into passenger(name, bus_id) VALUES ('Саша', 1);
