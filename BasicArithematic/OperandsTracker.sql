CREATE DATABASE CalcDB;

USE CalcDB;

DROP TABLE OperandsTracker;

CREATE TABLE OperandsTracker
(
op_id INT PRIMARY KEY AUTO_INCREMENT,
num1 INT,
num2 INT,
freq INT DEFAULT 0,
UNIQUE KEY  oprnds_uni (num1, num2)
);
DROP TRIGGER update_op_results;
DELIMITER $$
CREATE TRIGGER update_op_results AFTER INSERT ON OperandsTracker
FOR EACH ROW
BEGIN
	INSERT INTO OperationResults(op_id,sum,diff,prod,divi) 
    VALUES (new.op_id, new.num1+new.num2, new.num1-new.num2, new.num1*new.num2, new.num1/new.num2);
END $$		

INSERT INTO OperandsTracker(num1,num2) VALUES (1,1), (2,2), (3,3), (4,4), (5,5);
INSERT INTO OperandsTracker(num1,num2) VALUES (2,4),(4,2);
SELECT * FROM OperandsTracker;
desc OperandsTracker;


SELECT op_id FROM OperandsTracker WHERE num1 = 66 AND num2 = 55;
SELECT op_id FROM OperandsTracker WHERE num1 = 87 AND num2 = 65;
SELECT op_id FROM OperandsTracker WHERE num1 = 20 AND num2 = 10;

SELECT op_id FROM OperandsTracker WHERE num1 = 45 AND num2 = 76;


DELETE  FROM 	OperandsTracker WHERE op_id<17;								