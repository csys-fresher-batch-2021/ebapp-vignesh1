//E_USER_TABLE
CREATE SEQUENCE table_name_id_seq START with 1000 INCREMENT by 1;
CREATE TABLE E_USER (
   USERID  integer NOT NULL DEFAULT nextval('teams_id_seq'),
   NAME varchar(225) NOT NULL,
   USEREMAIL varchar(225) NOT NULL,
   USERPHONE varchar(225) NOT NULL,
   CONSUMERNO varchar(225),
   USERADDRESS varchar(225) NOT NULL,
   CUSTOMERID varchar(225) NOT NULL,
   PASSWORD varchar(225) NOT NULL,
   CONFIRMPASSWORD varchar(225),
   ROLEID int NOT NULL
) ;
//ADMIN_DETAILS
INSERT INTO E_USER (NAME,USEREMAIL,USERPHONE,USERADDRESS,CUSTOMERID,PASSWORD,ROLEID) VALUES('Naresh','naresh12@gmail.com','9994194773','chennai','Admin1','Admin@123',1);

// E_CALBILL_TABLE
CREATE TABLE E_CALBILL (
   ID SERIAL PRIMARY KEY,
   USERID int DEFAULT NULL,
   UNIT DOUBLE PRECISION DEFAULT NULL,
   TYPE varchar(45) DEFAULT NULL,
   ZONE varchar(45) DEFAULT NULL,
   MONTH varchar(45) DEFAULT NULL,
   TAMT DOUBLE PRECISION  DEFAULT NULL,
   NAME varchar(45) DEFAULT NULL,
   CUSTOMERID varchar(45) DEFAULT NULL,
   STATUS varchar(45) DEFAULT NULL,
   YEAR varchar(45) DEFAULT NULL,
   DUES DOUBLE PRECISION  DEFAULT NULL,
   AMTPAID DOUBLE PRECISION  DEFAULT NULL,
   DATEANDTIME TIMESTAMPTZ NOT NULL DEFAULT NOW() ,
   MODIFIED TIMESTAMPTZ NOT NULL DEFAULT NOW() 
);