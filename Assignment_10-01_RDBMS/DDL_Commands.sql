create database taxi_management;

use taxi_management;

create table location (
	location_id int primary key,
    street_name varchar(255),
    city_name varchar(255)
);

create table taxi (
	taxi_no varchar(10) primary key,
    taxi_model varchar(255),
    taxi_type varchar(255) not null
);

create table customer (
	customer_id int primary key,
    customer_name varchar(255) not null,
    customer_address varchar(255),
    customer_phno bigint not null,
    customer_location int,
    foreign key(customer_location) references location(location_id)
);

create table driver (
	driver_id int primary key,
    driver_name varchar(255) not null,
    driver_address varchar(255),
    driver_phno bigint not null,
    driver_rating decimal(2, 0),
    driver_location int not null,
    taxi_no varchar(10),
    foreign key(driver_location) references location(location_id),
    foreign key(taxi_no) references taxi(taxi_no)
);

create table orders (
	order_id int primary key,
    customer_id int, 
    driver_id int,
    order_date datetime not null,
    order_amount int not null,
    order_start_loc int not null,
    order_end_loc int,
    foreign key(customer_id) references customer(customer_id),
    foreign key(driver_id) references driver(driver_id),
    foreign key(order_start_loc) references location(location_id),
    foreign key(order_end_loc) references location(location_id)
);

create table payment (
	payment_id int primary key,
    customer_id int,
    order_id int,
    payment_status varchar(10) not null,
    payment_type varchar(10),
    payment_date datetime not null,
    foreign key(customer_id) references customer(customer_id),
    foreign key(order_id) references orders(order_id)
);

