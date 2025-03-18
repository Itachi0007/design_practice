CREATE TABLE Customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Cars (
    car_id INT PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    year INT NOT NULL
);

CREATE TABLE Rentals (
    rental_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    car_id INT,
    rental_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id) ON DELETE SET NULL,
    FOREIGN KEY (car_id) REFERENCES Cars(car_id) ON DELETE CASCADE
);

CREATE TABLE Maintenance (
    maintenance_id INT PRIMARY KEY AUTO_INCREMENT,
    car_id INT,
    maintenance_date DATE NOT NULL,
    details TEXT NOT NULL,
    FOREIGN KEY (car_id) REFERENCES Cars(car_id) ON DELETE CASCADE
);

-- Q1. Customers who have not rented any car
SELECT c.name, c.email
FROM Customers c
LEFT JOIN Rentals r ON c.customer_id = r.customer_id
WHERE r.customer_id IS NULL;

--Q2. Total rentals for each car by make model and year
SELECT c.make, c.model, c.year, COUNT(r.rental_id) AS total_rentals
FROM Cars c
LEFT JOIN Rentals r ON c.car_id = r.car_id
GROUP BY c.car_id, c.make, c.model, c.year;

--Q3. Customers who have rented more than 3 cars
SELECT c.name
FROM Customers c
JOIN Rentals r ON c.customer_id = r.customer_id
GROUP BY c.customer_id, c.name
HAVING COUNT(DISTINCT r.car_id) > 3;