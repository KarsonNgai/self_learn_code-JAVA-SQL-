#schemas name is 'week7_db'
#description: create table and insert data

#detail:
#the design is no that good, since there is the repeat data exist, for instance:
#   table jobs: there are two table contain the job_id
#   table department and employee: manager_id meaning is unclear, base on my understanding, they have different meaning
#   column job_history.start_date and employee.hire_date have quite same meaning.

#link: https://n98h15l7z4.larksuite.com/wiki/wikus6pS82NSqY5rvFderQaVbUe

#---------
#create table#
create table week7_db.regions(
	region_id int not null,
    region_name varchar(25),
    primary key(region_id)
);

create table week7_db.job_grades(
	grade_level varchar(2) not null,
    lowest_sal numeric(14,2),
    highest_sal numeric(14,2),
    primary key(grade_level)
);

create table week7_db.jobs(
	job_id varchar(10) not null,
    job_title varchar(35),
    min_salary numeric(14,2),
    max_salary numeric(14,2),
    primary key(job_id)
);

create table week7_db.countries(
	country_id char(2) not null,
    country_name varchar(40),
    region_id int not null,
    primary key(country_id),
    foreign key(region_id) references week7_db.regions(region_id)
);

create table week7_db.locations(
	location_id int not null,
    street_address varchar(25),
    postal_code varchar(12),
    city varchar(30),
    state_province varchar(12),
    country_id char(2) not null,
    primary key(location_id),
    foreign key(country_id) references week7_db.countries(country_id)
);

create table week7_db.departments(
	department_id int not null,
    department_name varchar(30),
    manager_id int,
    location_id int not null,
    primary key(department_id),
    foreign key(location_id) references week7_db.locations(location_id)
);

create table week7_db.job_history(
	employee_id int not null,
    start_date date not null,
    end_date date,
    job_id varchar(10) not null,
    department_id int not null,
    primary key(employee_id,start_date),
    foreign key(job_id) references week7_db.jobs(job_id),
    foreign key(department_id) references week7_db.departments(department_id)
);

create table week7_db.employees(
	employee_id int not null,
    first_name varchar(20),
    last_name varchar(25),
    email varchar(25),
    phone_number varchar(20),
    hire_date date,
    job_id varchar(20),
    salary numeric(14,2),
    commission_pct numeric(14,2),
    manager_id int,
    department_id int not null,
    primary key(employee_id),
    foreign key(employee_id) references week7_db.job_history(employee_id),
    foreign key(job_id) references week7_db.jobs(job_id),
    foreign key(department_id) references week7_db.departments(department_id)
);

#insert data
insert into week7_db.regions(region_id,region_name)	
values	(1,'regionA'),
		(2,'regionB'),
		(3,'regionC');

insert into week7_db.countries(country_id,country_name,region_id)
values	('DE','Germany',1),
		('IT','Italy',1),
        ('JP','Japan',3),
        ('US','United State',2);
        
insert into week7_db.locations(location_id,street_address,postal_code,city,state_province,country_id)
values	(1000,'1297 Via Cola di Rie',989,'Roma',null,'IT'),
		(1100,'93091 Calle della Te',10936,'Venice',null,'IT'),
        (1200,'2017 Shinjuku-ku',1689,'Tokyo','Prefectu','JP'),
        (1300,'2014 Jabberwocky Rd',26192,'Southlake','Texas','US'),
        (1400,null,null,'Chicago','Illinois','US');

insert into week7_db.departments(department_id,department_name,manager_id,location_id)
values	(10,'Administration',200,1100),
		(20,'Marketing',201,1200),
        (30,'Purchasing',202,1400);
        
insert into week7_db.jobs(job_id,job_title,min_salary,max_salary)
values	('IT_PROG','programmer',17000,25000),
		('AC_ACCOUNT','accountant',15000,23000),
        ('AC_MGR','accounting manager',30000,35000),
        ('MK_REP','marketing representative',25000,35000),
        ('ST_CLERK','clerk',14000,20000);

insert into week7_db.job_history(employee_id,start_date,end_date,job_id,department_id)
values	(102,'1993-01-13','1998-07-24','IT_PROG',20),
		(101,'1989-09-21','1993-10-27','AC_ACCOUNT',10),
		(101,'1993-10-28','1997-03-15','AC_MGR',30),
		(100,'1996-02-17','1999-12-19','MK_REP',30),
		(103,'1998-03-24','1999-12-31','ST_CLERK',20);

insert into week7_db.employees(employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id)
values	(100,'Steven','King','SKING','515-1234567','1987-06-17','ST_CLERK',24000.00,0.00,109,10),
		(101,'Neena','Kochhar','NKOCHHAR','515-1234568','1987-06-18','MK_REP',17000.00,0.00,103,20),
        (102,'Lex','De Haan','LDEHAAN','515-1234569','1987-06-19','AC_ACCOUNT',17000.00,0.00,108,30),
        (103,'Alexander','Hunold','AHUNOLD','590-4234567','1987-06-20','MK_REP',9000.00,0.00,105,20);
        
#additional insert to answer question
insert into week7_db.job_history(employee_id,start_date,end_date,job_id,department_id)
values	(200,'1991-1-1',null,'ST_CLERK',10),(201,'1991-1-1',null,'MK_REP',20),(202,'1991-1-1',null,'AC_MGR',30);

insert into week7_db.employees(employee_id, first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id)
values	(200,'Ken','Wong',null,null,'1991-1-1','ST_CLERK',40000,0.00,0,10),
		(201,'Peter','Chan',null,null,'1991-1-1','MK_REP',40000,0.00,0,20),
        (202,'John','Chun',null,null,'1991-1-1','AC_MGR',40000,0.00,0,30);

select * from week7_db.job_history;
/*Question:
1. Create all the above tables, with the provided structures and PK/ FK if required.
2. Insert some data, you can add your own data.
12. Create table JOBS
1&2&12 in above code
*/
#3. Write a query to find the location_id, street_address, city, state_province, country_name of locations
select location_id, street_address, city, state_province, c.country_name from week7_db.locations as l
left join week7_db.countries as c
on l.country_id = c.country_id;

#4. Write a query to find the first_name, last name, department ID of all the employees.
select first_name,last_name,department_id from week7_db.employees;

#5. Write a query to find the first_name, last_name, job_id, department ID of the employees who works in Japan.
select first_name,last_name,e.department_id,h.job_id 
from week7_db.employees as e
left join week7_db.job_history as h
on e.employee_id = h.employee_id
left join week7_db.departments as d
on d.department_id=e.department_id
left join week7_db.locations as l
on l.location_id = d.location_id
where country_id = 'JP';

#6. Write a query to find the employee id, last_name along with their manager_id and last_name.
select e1.employee_id, e1.last_name as 'employee_last_name', e1.manager_id, e2.last_name as 'manager_last_name' 
from week7_db.employees as e1 left join week7_db.employees as e2 on e1.manager_id=e2.employee_id;


#7. Write a query to find the first_name, last_name and hire date of the employees who was hired after 'Lex De Haan'.
select first_name,last_name,hire_date 
from week7_db.employees
where hire_date > (select hire_date from week7_db.employees where first_name='Lex' and last_name = 'De Haan');

#8. Write a query to get the department name and number of employees for each the department.
select d.department_name,count(*) as 'number of employees'
from week7_db.departments as d
left join week7_db.employees as e
on d.department_id = e.department_id
group by d.department_id;


#9. Write a query to find the employee ID, job title, number of days between ending date and starting date for all jobs in department 30.
#looking for purchasing in departments with department_id
#job title in jobs with job_id
select h.employee_id, j.job_title, datediff(end_date,start_date) as 'number of days' 
from week7_db.job_history as h
left join week7_db.jobs as j
on j.job_id = h.job_id
where h.department_id = 30; 


#10. Write a query to display all department name, manager name, and city.
#since manager_id did not really mean manager by all mean, in department table, it mean the id is manager, but in employees table, it only mean who is the manager to the employee
select d.department_name, concat(e.first_name,' ',e.last_name) as 'manager name',l.city
from week7_db.departments as d
left join week7_db.employees as e
on d.manager_id = e.employee_id
left join week7_db.locations as l
on d.location_id = l.location_id;

#13. Write a query to display the average salary of each department.
select d.department_name, avg(e.salary) as 'average salary'
from week7_db.employees as e
left join week7_db.departments as d
on e.department_id = d.department_id
group by e.department_id;
