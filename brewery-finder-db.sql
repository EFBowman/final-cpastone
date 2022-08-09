BEGIN TRANSACTION;

DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS beer;
DROP TABLE IF EXISTS brewery;
DROP TABLE IF EXISTS users;


CREATE TABLE users(
	--columns
	user_id serial,
	username varchar(100) not null unique,
	password varchar(50) not null unique,
	activated boolean,
	authorities varchar(25) not null,
	--constraints
	CONSTRAINT pk_account primary key (user_id),
	CONSTRAINT check_min_length_password check (length(password) >= 8)
);


CREATE TABLE brewery(
	--columns
	brewery_id serial,
	brewer_id int not null,
	name varchar(100) not null,
	phone_number varchar(15) not null unique,
	email_address varchar(50) unique,
	address varchar(100) not null unique,
	history varchar(2000),
	open_hours varchar(300) not null,
	image varchar(1000),
	brewery_type varchar(50) not null,
	--constraints
	CONSTRAINT pk_brewery primary key (brewery_id),
	CONSTRAINT fk_brewery_account foreign key (brewer_id) references users(user_id)
);

CREATE TABLE beer(
	--columns
	beer_id serial,
	brewery_id int not null,
	beer_name varchar(50) not null,
	beer_description varchar(1000),
	image varchar(1000),
	abv decimal,
	beer_type varchar(50) not null,
	--constraints
	CONSTRAINT pk_beer primary key (beer_id),
	CONSTRAINT fk_beer_brewery foreign key (brewery_id) references brewery(brewery_id)
);

CREATE TABLE review (
	--columns
	review_id serial,
	user_id int not null,
	beer_id int not null,
	beer_name varchar(50) not null,
	brewery_name varchar(100) not null,
	description varchar(1000),
	rating int not null,
	
	CONSTRAINT pk_review primary key (review_id),
	CONSTRAINT fk_review_account foreign key (user_id) references users(user_id),
	CONSTRAINT fk_review_beer foreign key (beer_id) references beer(beer_id)
);



COMMIT;


ROLLBACK;