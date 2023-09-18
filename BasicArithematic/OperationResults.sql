USE calcdb;

DROP TABLE OperationResults;

CREATE TABLE OperationResults
( 
op_id INT, 
sum INT,
diff INT,
prod INT,
divi DECIMAL(5,2),
FOREIGN KEY (op_id) REFERENCES OperandsTracker(op_id) 
ON DELETE CASCADE
);

SELECT * FROM OperationResults;
SELECT sum,diff,prod,divi FROM OperationResults WHERE op_id=17;
DELETE  FROM 	OperationResults WHERE op_id<26;								

DROP PROCEDURE IF EXISTS fetch_update_operands;



CALL fetch_update_operands(1,1);
CALL fetch_update_operands(1,1);
CALL fetch_update_operands(1,1);
CALL fetch_update_operands(2,4);
CALL fetch_update_operands(1,1);
CALL fetch_update_operands(1,1);
CALL fetch_update_operands(3,1);
CALL fetch_update_operands(4,1);
CALL fetch_update_operands(10,1);
