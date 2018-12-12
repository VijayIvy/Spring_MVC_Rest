CREATE OR REPLACE DATABASE NM_JML;

CREATE TABLE NM_USER_LOGIN (
	USER_ID INT NOT NULL AUTO_INCREMENT ,
	FIRST_NAME Varchar(240) ,
	LAST_NAME Varchar(240) ,
	USER_NAME Varchar(240) ,
	PASSWORD Varchar(240) ,
	CTS_EMAIL_ID Varchar(240) ,
	ROLE_ID INT FOREIGN KEY REFERENCES NM_USER_ROLE(ROLE_ID),	
	LOCATION_ID INT FOREIGN KEY REFERENCES NM_USER_LOCATION(LOCATION_ID),
	PROJECT_NAME Varchar(240) ,
	UPDATED_DATE Date ,
	LOGIN_STATUS Varchar(20) ,
	LAST_LOGIN_DATE Date		
);

CREATE TABLE NM_USER_ROLE (
	ROLE_ID INT NOT NULL PRIMARY KEY,
	ROLE_NAME Varchar(240)
);

CREATE TABLE NM_USER_LOCATION (
	LOCATION_ID INT NOT NULL PRIMARY KEY,
	LOCATION_NAME Varchar(240),
	LOCATION_PDL Varchar(240)
);

CREATE TABLE NM_CONFIG (
	ID INT NOT NULL PRIMARY KEY,
	KEY Varchar(240),
	VALUE Varchar(240)
);

CREATE TABLE NM_WORKFLOW_DETAILS (
	WORK_FLOW_ID INT IDENTITY NOT NULL PRIMARY KEY,
	FIRST_NAME Varchar(240) ,
	LAST_NAME Varchar(240) ,
	CTS_EMP_ID INT,
	CTS_EMAIL_ID Varchar(240) ,
	ONBOARD_STATUS Varchar(240) ,
	ONBOARD_COORDINATOR Varchar(240) ,
	PROJECT_NAME Varchar(240) ,
	CTS_JOIN_DATE Date ,
	NM_JOIN_DATE Date ,
	NM_END_DATE Date ,
	TEAM_NAME Varchar(240) ,
	LOCATION Varchar(240) ,
	LOCATION_ID INT FOREIGN KEY REFERENCES NM_USER_LOCATION(LOCATION_ID) ,
	PROJECT_ROLE Varchar(240) ,
	UNIT Varchar(240) ,
	SUB_UNIT Varchar(240) ,
	DIRECTORS Varchar(240) ,
	ANCHORS Varchar(240) ,
	NM_PROJECT_TYPE Varchar(240) ,	
	NM_SOW Varchar(240) ,	
	NM_LAN_ID Varchar(240) ,
	NM_IS_MANGAGER Varchar(240) ,
	CLASSIFICATION Varchar(240) ,	
	REASON Varchar(240) ,
	ASSIGN_TO Varchar(240),
	NM_OFFBOARD_STATUS varchar(240),
	NM_OFFBOARD_COORDINATOR varchar(240),
	UPDATED_DATE Date,
	LAST_UPDATED_DATE Date,
	NM_DETAILS varbinary(MAX)
);

--NM_USER_ROLE
insert into NM_USER_ROLE values(1, 'SuperAdmin');
insert into NM_USER_ROLE values(2, 'Assigner');
insert into NM_USER_ROLE values(3, 'Assignee');

--NM_USER_LOCATION
insert into NM_USER_LOCATION values(1, 'OFF-CHENNAI', '');
insert into NM_USER_LOCATION values(2, 'OFF-KOCHI', '');
insert into NM_USER_LOCATION values(3, 'OFF-COIMBATORE', '');
insert into NM_USER_LOCATION values(4, 'ON-MILWAUKEE', '');

--NM_CONFIG
insert into NM_CONFIG values(1, 'UNIT', 'EPS');
insert into NM_CONFIG values(2, 'UNIT', 'EIRC');
insert into NM_CONFIG values(3, 'UNIT', 'ETM');
insert into NM_CONFIG values(4, 'UNIT', 'Planning Experience');


insert into NM_CONFIG values(5, 'SUB_UNIT', 'Shared Services');
insert into NM_CONFIG values(6, 'SUB_UNIT', 'CTS');
insert into NM_CONFIG values(7, 'SUB_UNIT', 'EVF');
insert into NM_CONFIG values(8, 'SUB_UNIT', 'IRP');
insert into NM_CONFIG values(9, 'SUB_UNIT', 'Consulting');
insert into NM_CONFIG values(10, 'SUB_UNIT', 'Projects');
insert into NM_CONFIG values(11, 'SUB_UNIT', 'Support');
insert into NM_CONFIG values(12, 'SUB_UNIT', 'Transition');


insert into NM_CONFIG values(13, 'NM_PROJECT_TYPE', 'Agile');
insert into NM_CONFIG values(14, 'NM_PROJECT_TYPE', 'FB');
insert into NM_CONFIG values(15, 'NM_PROJECT_TYPE', 'FC');
insert into NM_CONFIG values(16, 'NM_PROJECT_TYPE', 'Non Billable');
insert into NM_CONFIG values(17, 'NM_PROJECT_TYPE', 'T&M');
insert into NM_CONFIG values(18, 'NM_PROJECT_TYPE', 'Support');
insert into NM_CONFIG values(19, 'NM_PROJECT_TYPE', 'Transition');

insert into NM_CONFIG values(20, 'DIRECTORS', 'Jessup');
insert into NM_CONFIG values(21, 'DIRECTORS', 'Bryan K');
insert into NM_CONFIG values(22, 'DIRECTORS', 'John H Knecht');
insert into NM_CONFIG values(23, 'DIRECTORS', 'Dick C');
insert into NM_CONFIG values(24, 'DIRECTORS', 'Burgarino');

insert into NM_CONFIG values(17, 'ANCHORS', 'Vivek / Albert');
insert into NM_CONFIG values(18, 'ANCHORS', 'Bunt');
insert into NM_CONFIG values(19, 'ANCHORS', 'Vivek / Siji');


COMMIT;