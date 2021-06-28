// E_USER
DROP TABLE IF EXISTS E_USER;
CREATE SEQUENCE teams_id_seq INCREMENT by 1 START with 1000;
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
   ROLEID int NOT NULL,
  UNIQUE (CUSTOMERID,USEREMAIL, USERPHONE,USERADDRESS)
) ;

INSERT INTO E_USER (NAME,USEREMAIL,USERPHONE,USERADDRESS,CUSTOMERID,PASSWORD,ROLEID) VALUES('Naresh','naresh12@gmail.com','9994194883','chennai','Admin1','Admin@123',1);
 select *from E_USER;


 //E_CALBILL
 DROP TABLE IF EXISTS E_CALBILL;
CREATE TABLE E_CALBILL (
   ID SERIAL PRIMARY KEY,
   USERID int DEFAULT NULL,
   UNIT DOUBLE PRECISION DEFAULT NULL,
   TYPE varchar(30) DEFAULT NULL,
   ZONE varchar(225) DEFAULT NULL,
   MONTH varchar(20) DEFAULT NULL,
   TAMT DOUBLE PRECISION  DEFAULT NULL,
   NAME varchar(50) DEFAULT NULL,
   CUSTOMERID varchar(25) DEFAULT NULL,
   CONSUMERNO varchar(20)DEFAULT NULL,
   STATUS varchar(10) DEFAULT NULL,
   YEAR varchar(15) DEFAULT NULL,
   DUES DOUBLE PRECISION  DEFAULT NULL,
   AMTPAID DOUBLE PRECISION  DEFAULT NULL,
   DATEANDTIME TIMESTAMPTZ NOT NULL DEFAULT NOW() 
);


select *from E_CALBILL;

//Pricing_List 

create table Pricing_List(
type varchar(45) DEFAULT NULL,
min_unit DOUBLE PRECISION  DEFAULT NULL,
max_unit DOUBLE PRECISION  DEFAULT NULL,
price DOUBLE PRECISION  DEFAULT NULL
);
select *from Pricing_List;

Insert into Pricing_List(type,min_unit,max_unit,price)values('HOME',0,100,0);
Insert into Pricing_List(type,min_unit,max_unit,price)values('HOME',100,400,20);
Insert into Pricing_List(type,min_unit,max_unit,price)values('HOME',400,1000,30);

Insert into Pricing_List(type,min_unit,max_unit,price)values('COMMERCIAL',0,100,10);
Insert into Pricing_List(type,min_unit,max_unit,price)values('COMMERCIAL',100,400,40);
Insert into Pricing_List(type,min_unit,max_unit,price)values('COMMERCIAL',400,1000,60);


Insert into Pricing_List(type,min_unit,max_unit,price)values('AGRICULTURE',0,100,5);
Insert into Pricing_List(type,min_unit,max_unit,price)values('AGRICULTURE',100,400,10);
Insert into Pricing_List(type,min_unit,max_unit,price)values('AGRICULTURE',400,1000,20);