CReate table users (id int primary key not NULL auto_increment,name varchar(50),password varchar(50),email varchar(100),contact varchar(20) );
select * from users;
select * from book_details;
CREATE TABLE book_details (
  book_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  book_name VARCHAR(250),
  author VARCHAR(100),
  quantity INT
);

INSERT INTO book_details (book_id, book_name, author, quantity)
VALUES 
  ('2', 'java', 'authorname', '7');
select * from student_details;
CREATE TABLE student_details (
  student_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  student_name VARCHAR(250), 
  course VARCHAR(100),
  branch VARCHAR(100)
);
INSERT INTO student_details (student_id, student_name, course, branch)
VALUES 
  ('1', 'trieu', 'BSC', 'IS');
  
  select * from issue_book_details;
  CREATE TABLE issue_book_details (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  book_id INT ,
  book_name VARCHAR(250),
  student_id INT,
  student_name VARCHAR(250), 
  issue_date date,
  due_date date,
  status VARCHAR(20)
);
  
  
  
  
  
  
  
  