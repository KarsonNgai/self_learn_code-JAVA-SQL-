use interview_db;

CREATE TABLE DEPARTMENT (
  ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  DEPT_CODE VARCHAR(3) NOT NULL,
  DEPT_NAME VARCHAR(200) NOT NULL
);

CREATE TABLE EMPLOYEE (
  ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  EMPLOYEE_NAME VARCHAR(30) NOT NULL,
  SALARY NUMERIC(8,2),
  PHONE NUMERIC(15),
  EMAIL VARCHAR(50),
  DEPT_ID INTEGER NOT NULL,
  foreign key (DEPT_ID) references department(ID)
);

INSERT INTO DEPARTMENT VALUES (1, 'HR', 'HUMAN RESOURCES');
INSERT INTO DEPARTMENT VALUES (2, '9UP', '9UP DEPARTMENT');
INSERT INTO DEPARTMENT VALUES (3, 'IT', 'INFORMATION TECHNOLOGY DEPARTMENT');
INSERT INTO DEPARTMENT VALUES (4, 'SA', 'SALES DEPARTMENT');

INSERT INTO EMPLOYEE VALUES (1, 'JOHN', 20000, 90234567, 'JOHN@GMAIL.COM', 1);
INSERT INTO EMPLOYEE VALUES (2, 'MARY', 10000, 90234561, 'MARY@GMAIL.COM', 1);
INSERT INTO EMPLOYEE VALUES (3, 'STEVE', 30000, 90234562, 'STEVE@GMAIL.COM', 3);
INSERT INTO EMPLOYEE VALUES (4, 'SUNNY', 40000, 90234563, 'SUNNY@GMAIL.COM', 4);


-- question
-- find the number of employees in each department
-- the row order should be in number of employees from high to low
-- if the number of employees are same, then order department code alphabetically
-- select 2 column in total: 'Department Code' and 'number of employees'

-- expected:
-- Department Code | number of employees
-- HR |2
-- IT |1
-- SA |1
-- 9upper|0 <<this would be one of the challenge point

select d.dept_code as 'Department Code', count(e.dept_id) as 'number of employee' from department as d
left join employee as e 
on d.id = e.dept_id
group by d.id
order by count(e.dept_id) desc, d.dept_code;



