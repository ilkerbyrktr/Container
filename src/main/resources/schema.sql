create table  users
(
    username varchar(50) not null
        primary key,
    password varchar(68) not null,
    enabled  boolean     not null
);

create table container
(
    id             serial
        primary key,
    container_code varchar(7)  not null
        unique,
    company        varchar(30) not null
);

create table authorities
(
    username  varchar(50) not null
        constraint fk_authorities_users
            references users,
    authority varchar(50) not null
);

create unique index ix_auth_username
    on authorities (username, authority);


create table items
(
    item_id        serial
        primary key,
    item_name      varchar(100) not null
        unique,
    is_flammable   boolean default false,
    is_fragile     boolean default false,
    is_corrosive   boolean default false,
    is_radioactive boolean default false,
    is_explosive   boolean default false
);

create table locations
(
    loc_id         serial
        primary key,
    container_code varchar(10)
        references container (container_code),
    loc            varchar(20) not null
);

create table cargo
(
    cargo_id       serial
        primary key,
    container_code varchar(10)
        references container (container_code),
    item_name      varchar(100)
        references items (item_name)
);

insert into users(username, password, enabled) VALUES ('fatma','{bcrypt}$2a$10$ytl1unaYmPxLiGM7IjFm9eRLIepFeNI2C4DJctZoojIZrXjB369ye',true);
insert into users(username, password, enabled) VALUES ('ahmet','{bcrypt}$2a$10$KCB11wQ1upYG2WbtdVr8quS5RRww7l1./oYdXPw6rThxX2iZarmci',true);
insert into users(username, password, enabled) VALUES ('cansu','{bcrypt}$2a$10$LDAjZbJfltB10EryGFY2M.LDP3RqJbXllqTb17eSzCqxqYOAwzNwe',true);
insert into users(username, password, enabled) VALUES ('mehmet','{bcrypt}$2a$10$SIlmVRE3uO8srv2nE7PQu.jhqc4oI9qi8oq.TkeFF8IxP.khj6Axa',true);
insert into users(username, password, enabled) VALUES ('erkan','{bcrypt}$2a$10$8GOGX4J027ULLC6hO2eiw.8inRhUtyvc0UhGKlkr5TSO20AjH6dlG',true);
insert into users(username, password, enabled) VALUES ('ilker','{bcrypt}$2a$10$nT4LrqwduaZdAbnz/iocKuFPxBeV0Tjxud0ZEiOxqJdibK8.eSbhW',true);



insert into container(container_code,company) VALUES ('ATC345','NYK');
insert into container(container_code,company) VALUES ('DEF456','COSCO');
insert into container(container_code,company) VALUES ('ACD336','HANJIN');
insert into container(container_code,company) VALUES ('AED345','COSCO');
insert into container(container_code,company) VALUES ('DET456','HAPAG-LLOYD');
insert into container(container_code,company) VALUES ('HKZ345','NYK');
insert into container(container_code,company) VALUES ('DES956','NYK');
insert into container(container_code,company) VALUES ('UYT556','HANJIN');
insert into container(container_code,company) VALUES ('HED556','HANJIN');
insert into container(container_code,company) VALUES ('BCE436','ATM');

insert into authorities(username, authority) VALUES ('ahmet','ROLE_WORKER');
insert into authorities(username, authority) VALUES ('fatma','ROLE_WORKER');
insert into authorities(username, authority) VALUES ('mehmet','ROLE_WORKER');
insert into authorities(username, authority) VALUES ('cansu','ROLE_WORKER');
insert into authorities(username, authority) VALUES ('ilker','ROLE_WORKER');
insert into authorities(username, authority) VALUES ('erkan','ROLE_WORKER');
insert into authorities(username, authority) VALUES ('mehmet','ROLE_LEADER');
insert into authorities(username, authority) VALUES ('cansu','ROLE_LEADER');
insert into authorities(username, authority) VALUES ('ilker','ROLE_LEADER');
insert into authorities(username, authority) VALUES ('erkan','ROLE_LEADER');
insert into authorities(username, authority) VALUES ('ilker','ROLE_MANAGER');
insert into authorities(username, authority) VALUES ('erkan','ROLE_MANAGER');

INSERT INTO items (item_name, is_flammable, is_fragile, is_corrosive, is_radioactive, is_explosive)
VALUES ('technological-product' ,TRUE, FALSE, TRUE, TRUE, TRUE);

INSERT INTO items (item_name, is_flammable, is_fragile, is_corrosive, is_radioactive, is_explosive)
VALUES ('food', FALSE, TRUE, FALSE, FALSE, FALSE);

INSERT INTO items (item_name, is_flammable, is_fragile, is_corrosive, is_radioactive, is_explosive)
VALUES ('plastic', TRUE, FALSE, FALSE, FALSE, FALSE);

INSERT INTO items (item_name, is_flammable, is_fragile, is_corrosive, is_radioactive, is_explosive)
VALUES ('Radioactive-Material', TRUE, FALSE, TRUE, TRUE, TRUE);

INSERT INTO items (item_name, is_flammable, is_fragile, is_corrosive, is_radioactive, is_explosive)
VALUES ('glass-product', FALSE, TRUE, FALSE, FALSE, FALSE);

INSERT INTO items (item_name, is_flammable, is_fragile, is_corrosive, is_radioactive, is_explosive)
VALUES ('clothes', TRUE, FALSE, FALSE, FALSE, FALSE);

INSERT INTO items (item_name, is_flammable, is_fragile, is_corrosive, is_radioactive, is_explosive)
VALUES ('cotton', TRUE, FALSE, FALSE, FALSE, FALSE);

INSERT INTO items (item_name, is_flammable, is_fragile, is_corrosive, is_radioactive, is_explosive)
VALUES ('iron', FALSE, FALSE, FALSE, FALSE, FALSE);


insert into cargo(cargo_id,container_code, item_name) VALUES ('1','ATC345','food');
insert into cargo(cargo_id,container_code, item_name) VALUES ('1','ATC345','iron');
insert into cargo(cargo_id,container_code, item_name) VALUES ('1','ATC345','clothes');

insert into locations(container_code,loc) values ('ATC345','mersin');
insert into locations(container_code,loc) values ('DEF456','mersin');
insert into locations(container_code,loc) values ('ACD336','mersin');
insert into locations(container_code,loc) values ('AED345','izmir');
insert into locations(container_code,loc) values ('DET456','izmir');
insert into locations(container_code,loc) values ('BCE436','izmir');
insert into locations(container_code,loc) values ('HKZ346','samsun');
insert into locations(container_code,loc) values ('DES956','samsun');
insert into locations(container_code,loc) values ('UYT556','samsun');
insert into locations(container_code,loc) values ('HED556','samsun');