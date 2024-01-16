CREATE TABLE if not exists Categories (
                            category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            category_name VARCHAR(50)
);

CREATE TABLE if not exists Products (
                          prod_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          category_id BIGINT,
                          model_number NVARCHAR(10),
                          model_name NVARCHAR(120),
                          prod_image NVARCHAR(30),
                          unit_cost DECIMAL(15),
                          description text

);

CREATE TABLE if not exists Customers (
                           cus_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(10),
                           email_address VARCHAR(100) UNIQUE,
                           password VARCHAR(12)
);

CREATE TABLE if not exists Reviews (
                         review_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         prod_id BIGINT,
                         cus_id BIGINT,
                         rating INT,
                         comments TEXT,
);

CREATE TABLE if not exists Orders (
                        order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        cus_id BIGINT,
                        order_date TIMESTAMP,
                        ship_date TIMESTAMP,
);

CREATE TABLE if not exists OrderDetails (
                              order_id BIGINT,
                              prod_id BIGINT,
                              quantity INT,
                              unit_cost DECIMAL(15),
);

CREATE TABLE ShoppingCart (
                              record_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              cart_id NVARCHAR(150),
                              quantity INT,
                              prod_id BIGINT,
                              date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
);