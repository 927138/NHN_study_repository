CREATE TABLE Categories (
                            CategoryID INT AUTO_INCREMENT PRIMARY KEY,
                            CategoryName VARCHAR(50)
);

CREATE TABLE Products (
                          ProductID INT AUTO_INCREMENT PRIMARY KEY,
                          CategoryID INT,
                          ModelNumber NVARCHAR(10),
                          ModelName NVARCHAR(120),
                          ProductImage NVARCHAR(30),
                          UnitCost DECIMAL(15),
                          Description TEXT,
                          CategoryReference INT, -- Foreign key reference to Categories(CategoryID)

                          CONSTRAINT fk_Products_Categories FOREIGN KEY (CategoryReference) REFERENCES Categories(CategoryID)
);

CREATE TABLE Customers (
                           CustomerID INT AUTO_INCREMENT PRIMARY KEY,
                           Name VARCHAR(10),
                           EmailAddress VARCHAR(100) UNIQUE,
                           Password VARCHAR(12)
);

CREATE TABLE Reviews (
                         ReviewID INT AUTO_INCREMENT PRIMARY KEY,
                         ProductID INT,
                         CustomerID INT,
                         Rating INT,
                         Comments TEXT,
                         ProductReference INT, -- Foreign key reference to Products(ProductID)
                         CustomerReference INT, -- Foreign key reference to Customers(CustomerID)

                         CONSTRAINT fk_Review_Products FOREIGN KEY (ProductReference) REFERENCES Products(ProductID),
                         CONSTRAINT fk_Review_Customer FOREIGN KEY (CustomerReference) REFERENCES Customers(CustomerID)
);

CREATE TABLE Orders (
                        OrderID INT AUTO_INCREMENT PRIMARY KEY,
                        CustomerID INT,
                        OrderDate TIMESTAMP,
                        ShipDate TIMESTAMP,
                        CustomerReference INT, -- Foreign key reference to Customers(CustomerID)

                        CONSTRAINT fk_Orders_CustomerID FOREIGN KEY (CustomerReference) REFERENCES Customers(CustomerID)
);

CREATE TABLE OrderDetails (
                              OrderID INT,
                              ProductID INT,
                              Quantity INT,
                              UnitCost DECIMAL(15),
                              OrderReference INT, -- Foreign key reference to Orders(OrderID)
                              ProductReference INT, -- Foreign key reference to Products(ProductID)

                              CONSTRAINT fk_OrderDetails_Orders FOREIGN KEY (OrderReference) REFERENCES Orders(OrderID),
                              CONSTRAINT fk_OrderDetails_Products FOREIGN KEY (ProductReference) REFERENCES Products(ProductID)
);

CREATE TABLE ShoppingCart (
                              RecordID INT AUTO_INCREMENT PRIMARY KEY,
                              CartID NVARCHAR(150),
                              Quantity INT,
                              ProductID INT,
                              DateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              ProductReference INT, -- Foreign key reference to Products(ProductID)

                              CONSTRAINT fk_cart_ProductID FOREIGN KEY (ProductReference) REFERENCES Products(ProductID)
);