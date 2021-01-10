CREATE DATABASE nwhacks;

CREATE USER IF NOT EXISTS 'test'@'localhost' IDENTIFIED BY 'test';
CREATE USER IF NOT EXISTS 'test'@'%' IDENTIFIED BY 'test';
GRANT ALL ON records.* TO 'test'@'localhost';
GRANT ALL ON records.* TO 'test'@'%';

USE nwhacks;

DROP TABLE IF EXISTS employees;
CREATE TABLE employees(id TINYTEXT, empname TINYTEXT, salary DECIMAL(10,2), benefits DECIMAL(10,2), 
	netrate SMALLINT);

INSERT INTO employees VALUES("aa6c8f7f-69dd-4d8e-9c31-2f965e7f4673", "ivaganov", 90000, 10000, 10);
INSERT INTO employees VALUES("0655b016-afe9-47c8-928e-127672787ae7", "sreid", 90000, 10000, 10);

DROP TABLE IF EXISTS timesheets;
CREATE TABLE timesheets(sheetid TINYTEXT, empid TINYTEXT, 
	timesheetdate DATE);
	
INSERT INTO timesheets VALUES("91904ad0-ec2f-4482-abbe-767996e0a7b7", "aa6c8f7f-69dd-4d8e-9c31-2f965e7f4673", '2021-01-01');
INSERT INTO timesheets VALUES("d06b8fca-ee62-4882-b5d2-698a6367e056", "aa6c8f7f-69dd-4d8e-9c31-2f965e7f4673", '2021-01-08');
INSERT INTO timesheets VALUES("9deb6a7d-d13d-4f08-a2a4-94d29eda9d51", "0655b016-afe9-47c8-928e-127672787ae7", '2021-01-01');
INSERT INTO timesheets VALUES("2538e899-3d25-49ce-8adf-9a24590ddcea", "0655b016-afe9-47c8-928e-127672787ae7", '2021-01-08');
	
DROP TABLE IF EXISTS timesheetrow;
CREATE TABLE timesheetrow(sheetid TINYTEXT, rowid TINYTEXT, hours SMALLINT, 
	projectid TINYTEXT);
	
INSERT INTO timesheetrow VALUES("91904ad0-ec2f-4482-abbe-767996e0a7b7", "cc466c2f-35d0-4341-9218-5cbb16679589", 5, "2e656e94-7ba9-4220-bef7-5fec8228cd08");
INSERT INTO timesheetrow VALUES("91904ad0-ec2f-4482-abbe-767996e0a7b7", "61219023-6b30-406f-8acc-163bf6e5728f", 5, "0ccc5e65-e521-4978-ae72-faf6aa5d1d92");
INSERT INTO timesheetrow VALUES("d06b8fca-ee62-4882-b5d2-698a6367e056", "1b260328-9c55-49f2-adaf-459d4c13acc5", 10, "2e656e94-7ba9-4220-bef7-5fec8228cd08");
INSERT INTO timesheetrow VALUES("d06b8fca-ee62-4882-b5d2-698a6367e056", "434231a3-eae9-4258-a5bd-b0e207d5cca1", 10, "0ccc5e65-e521-4978-ae72-faf6aa5d1d92");
	
DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts(accountid TINYTEXT, accountname TINYTEXT, 
	accountbalance DECIMAL(10,2));
	
INSERT INTO accounts VALUES("wp", "Wages Payable", 0);
INSERT INTO accounts VALUES("we", "Wage Expense", 0);
INSERT INTO accounts VALUES("mp", "Materials Payable", 0);
INSERT INTO accounts VALUES("me", "Materials Expense", 0);
	
DROP TABLE IF EXISTS project;
CREATE TABLE project(projectid TINYTEXT, projectname TINYTEXT);

INSERT INTO project VALUES("2e656e94-7ba9-4220-bef7-5fec8228cd08", "Shaklee Consolidated Reporting");
INSERT INTO project VALUES("0ccc5e65-e521-4978-ae72-faf6aa5d1d92", "Realm of Champions");

DROP TABLE IF EXISTS wagecost;
CREATE TABLE wagecost(costid TINYTEXT, projectid TINYTEXT, costdate DATE, 
	costamount DECIMAL(10,2), injournal BOOLEAN, empid TINYTEXT);
	
INSERT INTO wagecost VALUES("8dfb2b3b-a6e9-4bb4-aaa5-2ca362e4e8c2", "2e656e94-7ba9-4220-bef7-5fec8228cd08", '2021-01-01', 216.34, false, "aa6c8f7f-69dd-4d8e-9c31-2f965e7f4673");
INSERT INTO wagecost VALUES("25ea7879-c5f7-4caf-b4b7-899c9cc05674", "0ccc5e65-e521-4978-ae72-faf6aa5d1d92", '2021-01-01', 216.34, false, "aa6c8f7f-69dd-4d8e-9c31-2f965e7f4673");
INSERT INTO wagecost VALUES("09e02bba-e07e-4c85-999d-00fa1e554485", "2e656e94-7ba9-4220-bef7-5fec8228cd08", '2021-01-08', 432.69, false, "aa6c8f7f-69dd-4d8e-9c31-2f965e7f4673");
INSERT INTO wagecost VALUES("6ec7acb9-19d3-4b7c-be0e-55454674a2b8", "0ccc5e65-e521-4978-ae72-faf6aa5d1d92", '2021-01-08', 432.69, false, "aa6c8f7f-69dd-4d8e-9c31-2f965e7f4673");

DROP TABLE IF EXISTS materialcost;
CREATE TABLE materialcost(materialcostid TINYTEXT, projectid TINYTEXT, costdate DATE, 
	costamount DECIMAL(10,2), injournal BOOLEAN, materialname TINYTEXT);

INSERT INTO materialcost VALUES("98d346e9-ee1c-4535-9fa4-7d678ebeb767", "2e656e94-7ba9-4220-bef7-5fec8228cd08", '2021-01-01', 1000.00, false, "Barcode Scanners");
INSERT INTO materialcost VALUES("904df4ec-1a6e-4a0d-9dbd-e982003e3c7e", "0ccc5e65-e521-4978-ae72-faf6aa5d1d92", '2021-01-01', 1000.00, false, "Gaming PCs");