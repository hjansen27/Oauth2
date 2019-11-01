create table users(
	username varchar(50) not null,
	password varchar(200) not null,
	enabled boolean not null,
        primary key(username)
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
        primary key(username),
        FOREIGN KEY (username) REFERENCES users(username)
);