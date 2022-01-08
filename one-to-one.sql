create table discount_card(
    id serial primary key,
   number int
);

create table people(
    id serial primary key,
    name varchar(255),
   discount_card_id int references discount_card(id) unique
);
