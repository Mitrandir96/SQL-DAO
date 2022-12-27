create table CUSTOMERS (
    id SERIAL,
    name varchar(100),
    surname varchar(100),
    age integer,
    phone_number text,
    PRIMARY KEY (id)
);

INSERT INTO CUSTOMERS (id, name, surname, age, phone_number)
VALUES (1, 'Ivan', 'Fedorov', 24, '8929'),
       (2, 'Vanya', 'Sidorov', 25, '2342');

    create table ORDERS (
    id SERIAL,
    date varchar(100),
    customer_id integer,
    product_name text,
    amount integer,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);

INSERT INTO ORDERS ("date", customer_id, product_name, amount)
VALUES ('2424', 1, 'Вилка', 5),
       ('2525', 1, 'Нож', 6);
