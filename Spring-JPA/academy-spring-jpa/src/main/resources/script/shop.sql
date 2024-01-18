CREATE TABLE if not exists Categories (
                            category_id BIGINT AUTO_INCREMENT,
                            category_name VARCHAR(50),

                            PRIMARY KEY (category_id)
);

merge into Categories key (category_id) values (1, '상의');
merge into Categories key (category_id) values (2, '하의');
merge into Categories key (category_id) values (3, '신발');
merge into Categories key (category_id) values (4, '모자');

CREATE TABLE if not exists Products (
                          prod_id BIGINT AUTO_INCREMENT,
                          category_id BIGINT,
                          model_number NVARCHAR(10),
                          model_name NVARCHAR(120),
                          prod_image NVARCHAR(30),
                          unit_cost DECIMAL(15),
                          description text,

                          PRIMARY KEY (prod_id),
                          FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

merge into Products key (prod_id) values ( 1, 1, 'number1', 'model_name1', 'image', 123.121212, 'product1' );
merge into Products key (prod_id) values ( 2, 1, 'number2', 'model_name2', 'image', 123.121212, 'product2' );
merge into Products key (prod_id) values ( 3, 1, 'number3', 'model_name3', 'image', 123.121212, 'product3' );
merge into Products key (prod_id) values ( 4, 1, 'number4', 'model_name4', 'image', 123.121212, 'product4' );
merge into Products key (prod_id) values ( 5, 1, 'number5', 'model_name5', 'image', 123.121212, 'product5' );
merge into Products key (prod_id) values ( 6, 1, 'number6', 'model_name6', 'image', 123.121212, 'product6' );
merge into Products key (prod_id) values ( 7, 1, 'number7', 'model_name7', 'image', 123.121212, 'product7' );
merge into Products key (prod_id) values ( 8, 1, 'number8', 'model_name8', 'image', 123.121212, 'product8' );
merge into Products key (prod_id) values ( 9, 1, 'number9', 'model_name9', 'image', 123.121212, 'product9' );

CREATE TABLE if not exists Customers (
                           cus_id BIGINT AUTO_INCREMENT,
                           name VARCHAR(10),
                           email_address VARCHAR(100) UNIQUE,
                           password VARCHAR(12),

                           PRIMARY KEY (cus_id)
);

merge into Customers key (cus_id) values (1, 'name1', 'name1@gmil.com', '123');

CREATE TABLE if not exists Reviews (
                         review_id BIGINT AUTO_INCREMENT,
                         prod_id BIGINT,
                         cus_id BIGINT,
                         rating INT,
                         comments TEXT,

                         PRIMARY KEY (review_id),
                         FOREIGN KEY (prod_id) REFERENCES Products(prod_id),
                         FOREIGN KEY (cus_id) REFERENCES Customers(cus_id)
);

CREATE TABLE if not exists Orders (
                        order_id BIGINT AUTO_INCREMENT,
                        cus_id BIGINT,
                        order_date TIMESTAMP,
                        ship_date TIMESTAMP,

                        PRIMARY KEY (order_id),
                        FOREIGN KEY (cus_id) REFERENCES Customers(cus_id)
);

CREATE TABLE if not exists OrderDetails (
                              order_id BIGINT,
                              prod_id BIGINT,
                              quantity INT,
                              unit_cost DECIMAL(15),

                              PRIMARY KEY (order_id, prod_id),
                              FOREIGN KEY (order_id) REFERENCES Orders(order_id),
                              FOREIGN KEY (prod_id) REFERENCES Products(prod_id)
);