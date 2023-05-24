insert into user_account(email, password, first_name, last_name, company_name, short_description) values ('bartko@gmail.com', '{noop}bartko12', null, null, null, null);
insert into user_account(email, password, first_name, last_name, company_name, short_description) values ('michal12@o2.com', '{noop}michal98', null, null, null, null);
insert into user_account(email, password, first_name, last_name, company_name, short_description) values ('halina111@gmail.com', '{noop}halina', null, null, null, null);
insert into user_account(email, password, first_name, last_name, company_name, short_description) values ('tworca@op.pl', '{noop}tworca', null, null, null, null);
insert into user_account(email, password, first_name, last_name, company_name, short_description) values ('oporanku@gmail.com', '{noop}rano12', null, null, null, null);
insert into user_account(email, password, first_name, last_name, company_name, short_description) values ('aviatiaviation199@gmail.com', '{noop}lotnik', null, null, null, null);

insert into
    user_role (name)
values
    ('ADMIN'),
    ('USER');

insert into
    user_roles(user_account_id, role_id)
values
    (1, 1),
    (2, 2),
    (3, 2),
    (4, 2),
    (5, 2),
    (6, 1);
