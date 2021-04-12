create table Category
(
    category_number     int primary key auto_increment,
    category_name       varchar (50) not null
);

insert into Category (category_name) values
('Fruits'),
('Vegetables'),
('Cakes');

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
    zip_code        varchar (9) not null,
    password        varchar (100) not null
);

insert into Employee (id_employee, empl_surname, empl_name, empl_patronymic, role, salary, date_of_birth, date_of_start, phone_number, city, street, zip_code, password) values
('aaaa', 'Cvetkova', 'Marina', 'Vladislavivna', 'KASSIR', '5000', '2000-01-03', CURDATE(), '0660123590', 'Kyiv', 'Skovorodi', '03903', '$2a$10$.MNgzVZB2.s.cNbOlpdC8OIJD3bucuIbf/LVZamwNOT25AariYTAi'),
('bbbb', 'Sirov', 'Volodimir', 'Tarasovich', 'KASSIR', '10000', '1998-05-03', CURDATE(), '0661234243', 'Odessa', 'Deribasivska', '93402', '$2a$10$.MNgzVZB2.s.cNbOlpdC8OIJD3bucuIbf/LVZamwNOT25AariYTAi'),
('cccc', 'Retova', 'Inna', 'Denisovna', 'MANAGER', '30000', '1987-12-06', CURDATE(), '0665462356', 'Odessa', 'Great Arnautska', '42144', '$2a$10$.MNgzVZB2.s.cNbOlpdC8OIJD3bucuIbf/LVZamwNOT25AariYTAi');


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
('0001', 'Yankin', 'Ihor', 'Serhiyovich', '0661534986', '5', 'Kyiv'),
('0002', 'Hinkul', 'Anna', 'Oleksandrivna', '0666666666', '10', 'Odessa'),
('0003', 'Ivanov', 'Bohdan', 'Olegovich', '0668937821', '15', 'Kyiv');

create table Product
(
    id_product          int primary key auto_increment,
    category_number     int not null,
    constraint fk_product_to_category foreign key (category_number) references Category(category_number) on update CASCADE on delete NO ACTION,
    product_name        varchar(50) not null,
    characteristics     varchar(100) not null
);

insert into Product (category_number, product_name, characteristics) values
(1,'Apple','Sour'),
(1,'Red apple','Sweet'),
(2,'Cucumber','Green'),
(3,'Napoleon','Not chocolate cake');


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
('1','aaaa','0001',CURDATE(), 300, 10),
('2','bbbb','0002', CURDATE(), 185, 9),
('3','aaaa','0001', CURDATE(), 50, 11),
('4','aaaa','0003', CURDATE(), 283.5, 12);


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

insert into Store_Product (UPC, UPC_prom, id_product, selling_price, products_number, promotional_product) values
('1','2', 1,50, 200, 0),
('4','5', 3,30, 200, 0);


insert into Store_Product (UPC, id_product, selling_price, products_number, promotional_product) values
('2',1,40, 100, 1),
('3',2, 20, 100, 0),
('5',3, 20, 50, 1),
('6',4, 120, 10, 0);



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
('1','1',3, 40),
('5','1',2, 30),
('6','1',1, 120),
('2','2', 3, 35),
('3','2', 4, 20),
('1','3', 1, 50),
('2','4', 7, 40.5);