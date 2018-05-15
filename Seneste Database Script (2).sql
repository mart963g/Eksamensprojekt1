DROP DATABASE IF EXISTS kartotek_db;
CREATE DATABASE kartotek_db;
USE kartotek_db;

###################
##TABLE CREATIONS##
###################

CREATE TABLE activityTypes
(
	activityType VARCHAR(30) PRIMARY KEY
);

CREATE TABLE memberTypes
(
	memberType VARCHAR(8) PRIMARY KEY
);

CREATE TABLE contributions
(
	contributionId INT PRIMARY KEY AUTO_INCREMENT,
    activityType VARCHAR(30) NOT NULL,
    amount DOUBLE NOT NULL,
    paymentDate DATE NOT NULL,
    FOREIGN KEY (activityType) REFERENCES activityTypes(activityType)
);

CREATE TABLE members
(
	memberId INT PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    mail VARCHAR(100),
    phoneNumber INT,
    creationDate DATE,
    memberType VARCHAR(8),
    isBoard BIT,
    FOREIGN KEY(memberType) REFERENCES memberTypes(memberType)
);

CREATE TABLE subscriptions
(
	memberId INT PRIMARY KEY,
    payDate DATE,
    FOREIGN KEY (memberId) REFERENCES members(memberId)
);

CREATE TABLE addresses
(
	memberId INT PRIMARY KEY,
    streetName VARCHAR(50),
    zipCode INT,
    city VARCHAR(50),
    FOREIGN KEY (memberId) REFERENCES members(memberId)
);

CREATE TABLE userTypes
(
	userType VARCHAR(13) PRIMARY KEY
);

CREATE TABLE users
(
	username VARCHAR(20) PRIMARY KEY,
    userPassword VARCHAR(50) NOT NULL,
    userType VARCHAR(13) NOT NULL,
    FOREIGN KEY (userType) REFERENCES userTypes(userType)
);

CREATE TABLE logEntries
(
	logId INT PRIMARY KEY AUTO_INCREMENT,
    edit VARCHAR(26) NOT NULL,
    memberId INT,
    editDate DATE NOT NULL,
    username VARCHAR(20) NOT NULL,
    FOREIGN KEY(memberId) REFERENCES members(memberId),
    FOREIGN KEY(username) REFERENCES users(username)
);

###########
##INSERTS##
###########

INSERT INTO memberTypes VALUES
		    ('Primær'),
		    ('Sekundær'),
		    ('Ekstern');

INSERT INTO members VALUES
			(1, 'Christian', 'Grye Skydt', NULL, 27131428, '2018-05-20', 'Primær', 1),
            (2, 'Martin', 'Borup Larsen', NULL, 12321248, '2018-05-20', 'Ekstern', 0),
            (3, 'Mikkel', 'Pieler', NULL, 97937285, '2018-05-20', 'Sekundær', 1),
            (4, 'Jakob', 'Wulff', NULL, 63462132, '2018-01-19', 'Primær', 0);

INSERT INTO addresses VALUES
			(1, 'Mosevej 32', 7700, 'Thisted'),
            (2, 'Katholmvej 34', 7700, 'Thisted'),
            (3, 'Nordre Fasanvej 194', 2000, 'Frederiksberg'),
            (4, 'Snejstrupvej 173', 3246, 'Ishøj');

INSERT INTO subscriptions VALUES
			(1, '2018-05-20'),
			(2, '2018-04-20'),
			(3, '2018-03-20'),
            (4, '2018-12-30');


INSERT INTO activityTypes VALUES
			('Foredrag'), ('Bowling'),
            ('Biograftur'), ('Svømning'),
            ('Indkøb'), ('Ishockey'), ('Ture_ud_af_huset'),
            ('Museumstur'), ('Fodboldkampe'),
            ('Vinterbadning'), ('Gaver'), ('Jul_og_nytårs_arrangement'), ('Agromek'),
            ('Kurbad'), ('Besøge_andre_huse'), ('Skitur'), ('Tipi_rejsning'), ('Diverse');
            
INSERT INTO contributions VALUES
			(DEFAULT, 'Svømning', 33.54, '2018-05-20'),
            (DEFAULT, 'Fodboldkampe', 23.75, '2018-03-18'),
            (DEFAULT, 'Bowling', 55.95, '2018-01-14');

INSERT INTO userTypes VALUES
			('Administrator'),
            ('Standard');            

INSERT INTO users VALUES
			('Leo', '123456', 'Administrator'),
            ('Britta', '123456', 'Administrator'),
            ('Flemming', '123456', 'Standard');

INSERT INTO logEntries VALUES
			(DEFAULT, 'Status sat til betalt', 1, '2018-03-12', 'Britta'),
            (DEFAULT, 'Status sat til ikke betalt', 2, '2018-07-12', 'Leo'),
            (DEFAULT, 'Status sat til betalt', 2, '2018-08-13', 'Leo');
             
SELECT * FROM members m
JOIN Subscriptions s USING (memberId)
JOIN addresses a USING(memberId);   

SELECT mail FROM members WHERE memberType = 'Primær' AND CHAR_LENGTH(mail) > 0 AND mail IS NOT NULL;

SELECT * FROM Members m
JOIN addresses a USING(memberId)
JOIN subscriptions s USING (memberId)

WHERE MemberId = 1;
    
SELECT CONCAT (m.firstName, ' ', m.lastName) AS 'Navn', l.edit AS 'Ændring', l.editDate AS 'Ændringsdato', l.username AS 'Ændret Af'
	FROM members AS m
	JOIN logEntries AS l ON m.memberId = l.memberId;
    
SELECT mail FROM members WHERE memberType = 'Primær';
    
SELECT * FROM contributions;
SELECT MAX(memberId) FROM members