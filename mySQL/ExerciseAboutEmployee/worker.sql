#exercise 2, more advance in select

-- create new database
CREATE SCHEMA ORG;
-- show all database;
SHOW DATABASES;
-- get into database
USE ORG;
# get into左,no need to write database name in front of table

#SHOW tables;

-- create table worker
CREATE TABLE WORKER (
	WORKER_ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FIRST_NAME CHAR(25),
	LAST_NAME CHAR(25),
	SALARY NUMERIC(15),
	JOINING_DATE DATETIME,
	DEPARTMENT CHAR(25)
);

-- inesrt data to worker
INSERT INTO WORKER 
	(FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
		('Monika', 'Arora', 100000, '21-02-20 09:00:00', 'HR'),
		('Niharika', 'Verma', 80000, '21-06-11 09:00:00', 'Admin'),
		('Vishal', 'Singhal', 300000, '21-02-20 09:00:00', 'HR'),
		('Amitabh', 'Singh', 500000, '21-02-20 09:00:00', 'Admin'),
		('Vivek', 'Bhati', 490000, '21-06-11 09:00:00', 'Admin'),
		('Vipul', 'Diwan', 200000, '21-06-11 09:00:00', 'Account'),
		('Satish', 'Kumar', 75000, '21-01-20 09:00:00', 'Account'),
		('Geetika', 'Chauhan', 90000, '21-04-11 09:00:00', 'Admin');

#another insert for task 4
INSERT INTO WORKER 
	(FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
		('Lin', 'Wong', 70000, '21-01-20 09:00:00', 'Account'),
        ('Hei', 'Chan', 70000, '21-01-20 09:00:00', 'Account');
-- create table bonus
CREATE TABLE BONUS (
	WORKER_REF_ID INTEGER,
	BONUS_AMOUNT NUMERIC(10),
	BONUS_DATE DATETIME,
	FOREIGN KEY (WORKER_REF_ID)
		REFERENCES Worker(WORKER_ID)
);

-- Task 1:
-- Vivek, with amount 32000 and bonus date 2021 Nov 02
-- Vivek, with amount 20000 and bonus date 2022 Nov 02
-- Amitabh, with amount 21000 and bonus date 2021 Nov 02
-- Geetika, with amount 30000 and bonus date 2021 Nov 02
-- Satish, with amount 4500 and bonus date 2022 Nov 02
#logic, find the index of the worker, then insert
#find
#SELECT * FROM WORKER WHERE FIRST_NAME={name};
SELECT * FROM WORKER WHERE FIRST_NAME='Satish';
INSERT INTO BONUS
	(WORKER_REF_ID,BONUS_AMOUNT,BONUS_DATE) VALUES
		(5,32000,'21-11-02 00:00:00'),
        (5,20000,'22-11-02 00:00:00'),
        (4,21000,'21-11-02 00:00:00'),
        (8,30000,'21-11-02 00:00:00'),
        (7,4500,'22-11-02 00:00:00');

-- Task 2:
-- Write an SQL query to show the second highest salary among all workers.
SELECT * FROM worker ORDER BY salary DESC LIMIT 1,1;

-- Task 3:
-- Write an SQL query to print the name of employees having the highest salary in each department.
# logic: divide to different portion to finish 1. find the highest value in different departments and set it to variable 2.select

#set variable with different department if needed
SET @dep1 = 'Admin';
SET @dep2 = 'HR';
SET @dep3 = 'Account';

#find the highest salary and assign as local variable
SET @highest_salary_1 = (select max(salary) from worker group by department having department = @dep1);
SET @highest_salary_2 = (select max(salary) from worker group by department having department = @dep2);
SET @highest_salary_3= (select max(salary) from worker group by department having department = @dep3);

#select it with condition
SELECT concat(first_name,' ',last_name) as 'name', salary,department
FROM worker
where	
	(salary=@highest_salary_1 and department=@dep1) or
	(salary=@highest_salary_2 and department=@dep2) or
	(salary=@highest_salary_3 and department=@dep3)
order by salary desc;


/*
expected output:
Amitabh 500000 admin
vishal 300000 hr 
vipul 200000 account
*/

-- Task 4:
-- Write an SQL query to fetch the list of employees with the same salary.
# logic: find the duplicate salary first, then use the duplicated salary as the condition to get the list
select concat(w.first_name,' ',w.last_name) as 'worker who have same salary'
from worker as w
left join
	(select salary from worker group by salary having count(salary)>1) as a
on w.salary = a.salary
where w.salary = a.salary;

-- Task 5:
-- Write an SQL query to find the worker names with salaries + bonus in 2021
#先整好一個table,先再join
#noted, 後面for checking
select concat(w2.first_name,' ',w2.last_name) as 'name', ifnull(w2.salary+ a.added_bonus,w2.salary) as total_salaries, w2.salary,a.added_bonus
from worker as w2 
left join	(
				select w.worker_id as id, sum(b.bonus_amount) as 'added_bonus'
				from worker as w
				left join bonus as b
				on w.worker_id=b.worker_ref_id
				where b.bonus_date like '2021%'
				group by w.worker_id
			) as a
on w2.worker_id = a.id
order by total_salaries desc limit 1;

#reminder: task 6 and 7 would be disfunction, answer would be assign with '###'
-- Task 6 (Please complete Task 1-5 first):
-- Try to delete all the records in table WORKER
#delete from worker; #error
-- Study the reason why the data cannot be deleted 
	#contain foreign key, need to delete bonus first
-- Try to delete all the records in table BONUS
###delete from bonus;
-- Try to delete all the records in table WORKER
###delete from worker;

-- Task 7 (Please complete Task 6 first):
-- Try to drop table WORKER
#drop table worker; #error
-- Study the reason why the table cannot be deleted
#foreign as well
-- Try to drop table BONUS
###drop table bonus;
-- Try to drop table WORKER
###drop table worker;

#checking:
#select * from worker;
#select * from bonus;
