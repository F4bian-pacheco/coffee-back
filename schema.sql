-- Active: 1718660884712@@127.0.0.1@3306@cofee_back

drop Table if exists coffee;
drop Table if exists user;
drop Table if exists user_role;
drop Table if exists testimonials;

CREATE Table coffee(
    id_coffee INT AUTO_INCREMENT PRIMARY KEY ,
    description varchar(50) not null,
    image64 varchar(50) not null,
    name VARCHAR(50) not null,
    price INT not null
);

CREATE TABLE user(
    username varchar(50) not null PRIMARY KEY ,
    password varchar(50) not null,
    disabled BOOLEAN not null,
    email varchar(50) not null,
    locked BOOLEAN not null
)

CREATE TABLE user_role (
    role VARCHAR(50) NOT NULL,
    username VARCHAR(50),
    granted_date DATE,
    PRIMARY KEY (role, username),
    FOREIGN KEY (username) REFERENCES user(username)
);

CREATE TABLE testimonials (
    id_testimonial INT AUTO_INCREMENT PRIMARY KEY,
    id_coffee INT,
    testimonial VARCHAR(200) NOT NULL,
    username VARCHAR(50),
    FOREIGN KEY (id_coffee) REFERENCES coffee(id_coffee),
    FOREIGN KEY (username) REFERENCES user(username)
);


INSERT INTO coffee (description, image64, name, price) VALUES 
('Delicious dark roast', 'image_data_1', 'Dark Roast', 500),
('Smooth and rich', 'image_data_2', 'Medium Roast', 450),
('Light and flavorful', 'image_data_3', 'Light Roast', 400);


INSERT INTO user (username, password, disabled, email, locked)
VALUES
    ('admin', 'admin123', false, 'admin@example.com', false),
    ('alice', 'alice123', false, 'alice@example.com', false),
    ('bob', 'bob123', false, 'bob@example.com', false)

INSERT INTO user_role (role, username, granted_date)
VALUES
    ('admin', 'admin', CURDATE()),
    ('customer', 'alice', CURDATE()),
    ('customer', 'bob', CURDATE())

INSERT INTO testimonials (id_coffee, testimonial, username)
VALUES
    (1, 'Great coffee, loved the aroma!', 'alice'),
    (2, 'This coffee is so smooth and rich.', 'bob'),
    (3, 'Excellent quality and flavor.', 'alice')


alter table coffee modify COLUMN image64 MEDIUMBLOB 

alter table coffee modify COLUMN image64 TEXT
