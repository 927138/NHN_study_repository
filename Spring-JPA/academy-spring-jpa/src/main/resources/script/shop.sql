CREATE TABLE if not exists Categories (
                            category_id BIGINT AUTO_INCREMENT,
                            category_name VARCHAR(50),

                            PRIMARY KEY (category_id)
);

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

CREATE TABLE if not exists Customers (
                           cus_id BIGINT AUTO_INCREMENT,
                           name VARCHAR(10),
                           email_address VARCHAR(100) UNIQUE,
                           password VARCHAR(12),

                           PRIMARY KEY (cus_id)
);

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

CREATE TABLE ShoppingCart (
                              record_id BIGINT AUTO_INCREMENT,
                              cart_id NVARCHAR(150),
                              quantity INT,
                              prod_id BIGINT,
                              date_created TIMESTAMP,

                              PRIMARY KEY (record_id),
                              FOREIGN KEY (prod_id) REFERENCES Products(prod_id)
);