create TABLE company(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
    );

create TABLE person(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

select c.id, c.name as "Название компании", p.name as "Ф.И.О"
from person as p join company as c
on p.company_id = c.id
where c.id != 5;

select c.name as "Название компании",  count(p.name)  as "Количество человек"
from person as p join company as c
on p.company_id = c.id
group by c.name
having count(p.name) =
        (select count(company_id)
		 from person
         group by company_id
         order by company_id desc
         LIMIT 1
         );