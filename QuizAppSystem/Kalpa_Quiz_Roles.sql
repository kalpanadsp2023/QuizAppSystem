CREATE TABLE Roles
(
r_name VARCHAR(15),
r_id INT,
r_op VARCHAR(30),
UNIQUE KEY uni_role_op(r_name,r_id)
);

INSERT INTO Roles VALUES
("Role",1,"Admin"),            
("Role",2,"Organizer"),      
("Role",3,"Player"),           
("AdminOp",1, "Add Organizer"),   
("AdminOp",2, "Update Organizer"),
("AdminOp",3, "Delete Organizer"),
("OrganizerOp",1, "Add Quiz"),      
("OrganizerOp",2, "Update Quiz"),    
("OrganizerOp",3, "Delete Quiz"),   
("OrganizerOp",4, "Add Player"),    
("OrganizerOp",5, "Update Player"),   
("OrganizerOp",6, "Delete Player"), 
("PlayerOp",1, "Play Quiz"),      
("PlayerOp",2, "Revisit Quiz");

SELECT r_id,r_op FROM Roles WHERE r_name="Role";

SELECT r_id,r_op FROM Roles WHERE r_name="AdminOp";

SELECT r_id,r_op FROM Roles WHERE r_name="OrganizerOp";

SELECT r_id,r_op FROM Roles WHERE r_name="PlayerOp";  


