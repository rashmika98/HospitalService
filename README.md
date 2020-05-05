# HospitalService

**IT Number: IT18113914**

**Name: L.S.R. De Silva**

**Batch: Y3S1.1.1**

**MicroService: Hospital Service**


DatabaseName: hospital


===========================CREATE TABLE=================================

CREATE TABLE hospital
(
HRegID varchar(11) PRIMARY KEY,
HName varchar(50),
HAddress varchar(70),
HCity varchar(40),
HDestrict varchar(30),
HProvince varchar(40),
HEmail varchar(70),
HContactNum varchar(15),
HUsername varchar(20),
HPassword varchar(20)
);




=================SAMPLE VALUES=================


INSERT INTO hospital VALUES ('0001', 'Royal Hospital', 'No 62 ', 'W. A. Silva Mawatha', 'Colombo', 'Western', 'manager@royalhospitals.com', '0112586581', 'Royal123', 'royal@123');


INSERT INTO hospital  VALUES ('0002', 'Kings Hospital ', 'No:18/A, 05', 'Muhandiram E. D. Dabare Rd', 'Colombo', 'Western', 'nfo@kingshospital.lk', '0117743743', 'Kings', 'Kings@123');


INSERT INTO hospital VALUES ('0003', 'Western Hospital', ' 218', 'Borella', 'Colombo', 'Western', ' info@westernhospital.lk', '0112685413', 'Western', 'Western@123');



