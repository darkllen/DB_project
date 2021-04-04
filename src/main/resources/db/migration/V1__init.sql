create table Category
(
    category_number     int primary key auto_increment,
    category_name       varchar (50) not null
);

insert into Category (category_name) values
('aaa'),
('bbb');

create table Employee
(
    id_employee     varchar (10) primary key,
    empl_surname    varchar (50) not null,
    empl_name       varchar (50) not null,
    empl_patronymic varchar (50) not null,
    role            varchar (50) not null,
    salary          decimal (13,4) not null,
    date_of_birth   date not null,
    date_of_start   date not null,
    phone_number    varchar (13) not null,
    city            varchar (50) not null,
    street          varchar (50) not null,
    zip_code        varchar (9) not null
);

insert into Employee (id_employee, empl_surname, empl_name, empl_patronymic, role, salary, date_of_birth, date_of_start, phone_number, city, street, zip_code) values
('a', 'A', 'A', 'A', 'kassir', '5000', CURDATE(), CURDATE(), '0123', 'K', 'L', 'L'),
('b', 'B', 'B', 'B', 'kassir', '10000', CURDATE(), CURDATE(), '1234', 'A', 'F', 'S');

create table Customer_Card
(
    card_number     varchar (13) primary key,
    cust_surname    varchar (50) not null,
    cust_name       varchar (50) not null,
    cust_patronymic varchar (50) not null,
    phone_number    varchar (13) not null,
    city            varchar (50) null,
    street          varchar (50) null,
    zip_code        varchar (9)  null,
    percent         int not null
);

insert into Customer_Card (card_number, cust_surname, cust_name, cust_patronymic, phone_number, percent, city) values
('aaa', 'Yankin', 'Ihor', 'Serhiyovich', '0661534986', '5', 'O'),
('bbb', 'Hinkul', 'Anna', 'Oleksandrivna', '0666666666', '10', 'K');

create table Product
(
    id_product          int primary key auto_increment,
    category_number     int not null,
    constraint fk_product_to_category foreign key (category_number) references Category(category_number) on update CASCADE on delete NO ACTION,
    product_name        varchar(50) not null,
    characteristics     varchar(100) not null
);

insert into Product (category_number, product_name, characteristics) values
(1,'a','a'),
(2,'b','b'),
(2,'c','c');


create table Recipe
(
  check_number      varchar (10) primary key,
  id_employee       varchar (10) not null,
  constraint fk_check_to_employee foreign key (id_employee) references Employee(id_employee) on update CASCADE on delete NO ACTION,
  card_number       varchar (13) null,
  constraint fk_check_to_customer foreign key (card_number) references Customer_Card(card_number) on update CASCADE on delete NO ACTION,
  print_date        date not null,
  sum_total         decimal (13,4) not null,
  vat               decimal (13,4) not null
);

insert into Recipe (check_number, id_employee, card_number, print_date, sum_total, vat) values
('1','a','aaa',CURDATE(), 200.2, 10.3),
('2','b','bbb', CURDATE(), 100, 9.2),
('3','a','aaa', CURDATE(), 50.2, 11);

create table Store_Product
(
    UPC                 varchar (12) primary key,
    UPC_prom            varchar (12) null,
    constraint fk_store_product_to_store_product foreign key (UPC) references Store_Product(UPC) on update CASCADE on delete SET NULL,
    id_product          int not null,
    constraint fk_store_product_to_product foreign key (id_product) references Product(id_product) on update CASCADE on delete NO ACTION,
    selling_price       decimal (13,4) not null,
    products_number     int not null,
    promotional_product bit not null
);

insert into Store_Product (UPC, id_product, selling_price, products_number, promotional_product) values
('1',1,50, 200, 0),
('2',2, 20, 100, 0),
('3',3, 30, 50, 1);

create table Sale
(
    UPC             varchar (12) not null,
    constraint fk_sale_to_store_product foreign key (UPC) references Store_Product(UPC) on update CASCADE on delete NO ACTION,
    check_number    varchar (10) not null,
    constraint fk_sale_to_check foreign key (check_number) references Recipe(check_number) on update CASCADE on delete CASCADE,
    constraint PK_Sale primary key (UPC,check_number),
    product_number  int not null,
    selling_price   decimal (13,4) not null
);

insert into Sale (UPC, check_number, product_number, selling_price) values
('1','1',4, 200),
('2','2', 3, 60),
('3','3', 5, 150);