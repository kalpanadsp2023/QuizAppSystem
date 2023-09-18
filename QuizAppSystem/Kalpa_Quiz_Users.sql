CREATE DATABASE Kalpa_Quiz;

USE Kalpa_Quiz;

CREATE TABLE Users
(u_id INT PRIMARY KEY AUTO_INCREMENT,
u_role VARCHAR(15),
u_name VARCHAR(25),
u_pwd VARCHAR(25)
);

INSERT INTO Users(u_role,u_name,u_pwd) VALUES
("Admin", "Harsh", "admin"),
("Organizer", "Navin", "navin"),
("Organizer", "Hyder", "abbas"),
("Player", "Kalpana", "kalpana"),
("Player", "Lakshmi", "lakshmi"),
("Player", "Roopa", "roopa");

SELECT * FROM Users;

