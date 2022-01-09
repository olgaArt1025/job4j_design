insert into role(role) values ('Admin'), ('User');

insert into rules(rule) values ('Create'), ('Edit'), ('Remove'), ('Update');

insert into rules_for_roles(role_id, rules_id) values (1, 1), (1, 3), (1, 4), (2, 1), (2, 2);

insert into users(name, role_id) values ('Misha', 1), ('Kolya', 2), ('Sasha', 2);

insert into category(name) values ('High'), ('Medium'), ('Low');

insert into state(name) values('New'), ('In work'), ('Completed');

insert into item (name, users_id, category_id, state_id) values ('no contract number', 2, 1, 1);

insert into attachs(filename, item_id) values ('image.jpg', 1);

insert into comments(comment, item_id) values ('help', 1);