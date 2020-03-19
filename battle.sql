create schema battle;

create table battle.people(
person_id int primary key auto_increment,
person_name varchar(20),
person_strength int not null,
person_resistance int not null
);

create table battle.trolls(
troll_id int primary key auto_increment,
troll_name varchar(20),
troll_strength int not null,
troll_resistance int not null
);

create table battle.batlle_information(
id int primary key,
people_number int not null,
trolls_number int not null,
people_points int default 0,
trolls_points int default 0
);

insert into battle.people
(person_name, person_strength, person_resistance)
values ("Peter", 10, 20);

insert into battle.people
(person_name, person_strength, person_resistance)
values ("Nikola", 8, 22);

insert into battle.people
(person_name, person_strength, person_resistance)
values ("Marin", 5, 30);

insert into battle.people
(person_name, person_strength, person_resistance)
values ("Alexander", 7, 19);

insert into battle.people
(person_name, person_strength, person_resistance)
values ("Dragomir", 6, 22);

insert into battle.people
(person_name, person_strength, person_resistance)
values ("Darin", 11, 29);

insert into battle.people
(person_name, person_strength, person_resistance)
values ("Martin", 12, 32);

insert into battle.people
(person_name, person_strength, person_resistance)
values ("Ivan", 6, 22);

insert into battle.people
(person_name, person_strength, person_resistance)
values ("Hristo", 10, 28);

insert into battle.people
(person_name, person_strength, person_resistance)
values ("Ivailo", 5, 17);

insert into battle.trolls
(troll_name, troll_strength, troll_resistance)
values ("Cra", 6, 30);

insert into battle.trolls
(troll_name, troll_strength, troll_resistance)
values ("Dragon", 5, 25);

insert into battle.trolls
(troll_name, troll_strength, troll_resistance)
values ("Ecaflip", 4, 18);

insert into battle.trolls
(troll_name, troll_strength, troll_resistance)
values ("Eliatrope", 7, 19);

insert into battle.trolls
(troll_name, troll_strength, troll_resistance)
values ("Feca", 3, 15);

insert into battle.trolls
(troll_name, troll_strength, troll_resistance)
values ("Foggernaut", 7, 17);

insert into battle.trolls
(troll_name, troll_strength, troll_resistance)
values ("Jaryaya", 5, 20);

insert into battle.trolls
(troll_name, troll_strength, troll_resistance)
values ("Jalai", 4, 21);

insert into battle.trolls
(troll_name, troll_strength, troll_resistance)
values ("Kelraz", 10, 17);

insert into battle.trolls
(troll_name, troll_strength, troll_resistance)
values ("Rujin", 6, 26);
