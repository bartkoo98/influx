insert into user_account(email, password) values ('bartko@gmail.com', '{noop}bartko12');
insert into user_account(email, password) values ('michal12@o2.com', '{noop}michal98');
insert into user_account(email, password) values ('halina111@gmail.com', '{noop}halina');
insert into user_account(email, password) values ('tworca@op.pl', '{noop}tworca');
insert into user_account(email, password) values ('oporanku@gmail.com', '{noop}rano12');
insert into user_account(email, password) values ('aviatiaviation199@gmail.com', '{noop}lotnik');

insert into
    user_role (name)
values
    ('ADMIN'),
    ('USER'),
    ('CREATOR');

insert into
    user_roles(user_account_id, role_id)
values
    (1, 1),
    (2, 2),
    (3, 2),
    (4, 3),
    (5, 3),
    (6, 3);
