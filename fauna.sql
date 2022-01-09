create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('icefish', 90000,  date '1940-01-01');
insert into fauna(name, avg_age, discovery_date) values ('hamster', 220000,  date '1990-01-01');
insert into fauna(name, avg_age, discovery_date) values ('catfishes', 140000,  date '1475-01-01');
insert into fauna(name, avg_age, discovery_date) values ('crocodile', 5800,  date '2014-01-01');
insert into fauna(name, avg_age) values ('fox', 5800);
insert into fauna(name, avg_age, discovery_date) values ('tortoise', 7800,  date '1752-01-01');
insert into fauna(name, avg_age, discovery_date) values ('zebra', 12800,  date '1800-01-01');

select * from fauna where name like '%fish%';
select * from fauna where avg_age >= 10000 and avg_age<=21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date< '1950-01-01';
