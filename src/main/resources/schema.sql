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

insert into users(username, password, enabled) VALUES ('fatma','{bcrypt}$2a$10$ytl1unaYmPxLiGM7IjFm9eRLIepFeNI2C4DJctZoojIZrXjB369ye',true)
insert into users(username, password, enabled) VALUES ('ahmet','{bcrypt}$2a$10$KCB11wQ1upYG2WbtdVr8quS5RRww7l1./oYdXPw6rThxX2iZarmci',true)
insert into users(username, password, enabled) VALUES ('cansu','{bcrypt}$2a$10$LDAjZbJfltB10EryGFY2M.LDP3RqJbXllqTb17eSzCqxqYOAwzNwe',true)
insert into users(username, password, enabled) VALUES ('mehmet','{bcrypt}$2a$10$SIlmVRE3uO8srv2nE7PQu.jhqc4oI9qi8oq.TkeFF8IxP.khj6Axa',true)
insert into users(username, password, enabled) VALUES ('erkan','{bcrypt}$2a$10$8GOGX4J027ULLC6hO2eiw.8inRhUtyvc0UhGKlkr5TSO20AjH6dlG',true)
insert into users(username, password, enabled) VALUES ('ilker','{bcrypt}$2a$10$nT4LrqwduaZdAbnz/iocKuFPxBeV0Tjxud0ZEiOxqJdibK8.eSbhW',true)