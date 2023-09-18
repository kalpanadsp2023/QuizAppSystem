CREATE TABLE Questions
(
q_id INT,
q_lang VARCHAR(10),
q_cmpx VARCHAR(10),
q_que VARCHAR(150),
q_op1 VARCHAR(50),
q_op2 VARCHAR(50),
q_op3 VARCHAR(50),
q_op4 VARCHAR(50),
q_ans VARCHAR(50),
UNIQUE KEY uni_question(q_id,q_lang,q_cmpx)
);

INSERT INTO Questions VALUES
(1,"C","EASY", "C was invented by : ","Dennis Rechard","Dennis M. Ritchie","Bjarne Stroustrup","Anders Hejlsberg","Dennis M. Ritchie"),
(2,"C","EASY","In which year C was developed? : ","1962","1978","1979","1972", "1972"),
(3,"C","EASY", "C language is a successor to which language? : ", "Basic","Cobal","CPP","B", "B"),
(1,"C","MEDIUM","In which year C was developed? : ","1962","1978","1979","1972", "1972"),
(2,"C","MEDIUM", "C language is a successor to which language? : ","Basic","Cobal","CPP","B", "B"),
(3,"C","MEDIUM", "C was invented by : ","Dennis Rechard","Dennis M. Ritchie","Bjarne Stroustrup","Anders Hejlsberg", "Dennis M. Ritchie"),
(1,"C","HARD","C language is a successor to which language? : ","Basic","Cobal","CPP","B", "B"),
(2,"C","HARD", "C was invented by : ","Dennis Rechard","Dennis M. Ritchie","Bjarne Stroustrup","Anders Hejlsberg","Dennis M. Ritchie"),
(3,"C","HARD","In which year C was developed? : ","1962","1978","1979","1972", "1972"),
(1,"JAVA","EASY","JDK stands for ____. : ","Java Development kit","Java Deployment kit","Java Script deployment kit","None","Java Development kit"),
(1,"JAVA","MEDIUM","JDK stands for ____. : ","Java Development kit","Java Deployment kit","Java Script deployment kit","None","Java Development kit"),
(1,"JAVA","HARD", "JDK stands for ____. : ","Java Development kit","Java Deployment kit","Java Script deployment kit","None","Java Development kit");

SELECT q_id,q_que,q_op1,q_op2,q_op3,q_op4,q_ans FROM Questions WHERE q_lang="C" AND q_cmpx="EASY" ORDER BY q_id;

SELECT q_id,q_que,q_op1,q_op2,q_op3,q_op4,q_ans FROM Questions WHERE q_lang="C" AND q_cmpx="MEDIUM" ORDER BY q_id;

SELECT q_id,q_que,q_op1,q_op2,q_op3,q_op4,q_ans FROM Questions WHERE q_lang="C" AND q_cmpx="HARD" ORDER BY q_id;

SELECT q_id,q_que,q_op1,q_op2,q_op3,q_op4,q_ans FROM Questions WHERE q_lang="JAVA" AND q_cmpx="EASY" ORDER BY q_id;

SELECT q_id,q_que,q_op1,q_op2,q_op3,q_op4,q_ans FROM Questions WHERE q_lang="JAVA" AND q_cmpx="MEDIUM" ORDER BY q_id;

SELECT q_id,q_que,q_op1,q_op2,q_op3,q_op4,q_ans FROM Questions WHERE q_lang="JAVA" AND q_cmpx="HARD" ORDER BY q_id;
