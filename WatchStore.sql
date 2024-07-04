CREATE DATABASE WatchStore;

USE WatchStore;

CREATE TABLE Watches (
    WatchID INT PRIMARY KEY IDENTITY,
    WatchName VARCHAR(100),
    Brand VARCHAR(50),
    Price DECIMAL(10, 2),
    Description TEXT,
    ImageURL VARCHAR(255)
);

CREATE TABLE Clients (
    ClientID INT PRIMARY KEY IDENTITY,
    Username VARCHAR(50) UNIQUE,
    Password VARCHAR(255),
    Email VARCHAR(100),
    Address VARCHAR(255)
);

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY IDENTITY,
    ClientID INT,
    WatchID INT,
    Quantity INT,
    OrderDate DATETIME,
    Shipped BIT,
    FOREIGN KEY (ClientID) REFERENCES Clients(ClientID),
    FOREIGN KEY (WatchID) REFERENCES Watches(WatchID)
);

CREATE TABLE Admin (
    AdminID INT PRIMARY KEY,
    Username VARCHAR(50) UNIQUE,
    Password VARCHAR(255)
);

USE WatchStore;

-- Sample data for Watches table
INSERT INTO Watches (WatchName, Brand, Price, Description, ImageURL) VALUES
('Classic Black', 'Rolex', 8999.99, 'A classic black Rolex with a leather strap.', 'images/rolex_classic_black.jpg'),
('Silver Diver', 'Omega', 5999.99, 'A durable Omega watch for diving.', 'images/omega_silver_diver.jpg'),
('Gold Luxury', 'Cartier', 12999.99, 'An elegant gold watch from Cartier.', 'images/cartier_gold_luxury.jpg');

-- Sample data for Clients table
INSERT INTO Clients (Username, Password, Email, Address) VALUES
('john_doe', 'password123', 'john@example.com', '123 Elm Street, Springfield, IL'),
('jane_smith', 'securePass!@#', 'jane@example.com', '456 Oak Avenue, Riverside, CA'),
('alex_jones', 'alexJones98', 'alex@example.com', '789 Pine Road, Fairview, NY');

-- Sample data for Orders table
INSERT INTO Orders (ClientID, WatchID, Quantity, OrderDate, Shipped) VALUES
(1, 1, 1, '2024-06-01', 0),
(2, 2, 2, '2024-06-15', 1),
(3, 3, 1, '2024-06-20', 0);

-- Sample data for Admin table
INSERT INTO Admin (AdminID, Username, Password) VALUES
(1, 'anthien', 'anthien2004');
