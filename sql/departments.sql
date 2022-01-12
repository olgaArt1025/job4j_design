create table departments (
	id serial primary key,
	name varchar(255)
);

create table emploers (
	id serial primary key,
	name varchar(255),
 	departments_id int references departments(id)
);

insert into departments (name) values ('Администрация'),('Продажи'),('Программисты'), ('Закуп');
insert into emploers (name, departments_id) values ('Петя', 1),('Таня', 1),('Слава', 2), ('Миша', 2), ('Андрей', 3),('Паша', 3); 

select * from departments d left join emploers e on d.id=e.departments_id;

select * from departments d right join emploers e on d.id = e.departments_id;

select * from emploers e left join departments d on d.id = e.departments_id;

select * from emploers e right join departments  d on d.id = e.departments_id;

select * from departments d full join emploers e on d.id = e.departments_id;

select * from departments d cross join emploers e;

select * from departments d left join emploers e on d.id = e.departments_id where departments_id is null;

select d.name, e.name from emploers  e right join departments  d on e.departments_id = d.id;

select d.name, e.name from departments  d left join emploers  e on e.departments_id = d.id;

 create table  teens (
 id serial primary key,
	name varchar(100),
	gender varchar(10)
);

insert into teens (name, gender) values ('Sergey', 'male'), ('Irina', 'female'), ('Ivan', 'male'), ('Nikita','male'), ('Olga', 'female');

select t1.name as female, t2.name as male from  teens t1 cross  join  teens t2 where t1.gender!=t2.gender and t1.gender = 'female'; 
 