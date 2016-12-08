DROP DATABASE IF exists mandatory4;

CREATE DATABASE mandatory4;
USE mandatory4;

CREATE TABLE UsrRole 
(
RoleId Int(10) NOT NULL,
RoleName varchar(32) NOT NULL,
PRIMARY KEY (RoleId)
);

CREATE TABLE User
(
UserId int NOT NULL AUTO_INCREMENT,
FirstName varchar(50),
LastName varchar(50),
Email varchar(50) UNIQUE,
Passwrd varchar(255),
UsrRole Int(10),
PRIMARY KEY (UserId),
FOREIGN KEY (UsrRole) REFERENCES UsrRole(RoleId)
);

CREATE TABLE Module
(
ModuleNr Int(10) NOT NULL,
ModuleName varchar(255),
ModuleDesc varchar(255),
ModuleGoal varchar(255),
HandinDate TimeStamp,
PRIMARY KEY (ModuleNr)
);

CREATE TABLE Handin
(
Id int NOT NULL AUTO_INCREMENT,
DeliveryDate TimeStamp,
DeliveredBy int NOT NULL,
Content varchar(255),
ModuleNr Int(10) NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (DeliveredBy) REFERENCES User(UserId),
FOREIGN KEY (ModuleNr) REFERENCES Module(ModuleNr)
);

CREATE TABLE Response
(
RespId varchar(255) NOT NULL,
RespComment varchar(255),
RespDate TimeStamp,
WrittenBy int NOT NULL,
Handin int NOT NULL,
PRIMARY KEY (RespId),
FOREIGN KEY (WrittenBy) REFERENCES User(UserId),
FOREIGN KEY (Handin) REFERENCES Handin(Id)
);

CREATE TABLE Evaluation
(
EvalId varchar(255) NOT NULL,
EvalDate TimeStamp,
Evaluation varchar(10),
EvaluatedBy int NOT NULL,
Handin int NOT NULL,
PRIMARY KEY (EvalId),
FOREIGN KEY (EvaluatedBy) REFERENCES User(UserId),
FOREIGN KEY (Handin) REFERENCES Handin(Id) 
);

CREATE TABLE Resources
(
ResourceId varchar(255) NOT NULL,
Content varchar(255),
ResourceType varchar(255),
ModuleNr Int(10) NOT NULL,
PRIMARY KEY (ResourceId),
FOREIGN KEY (ModuleNr) REFERENCES Module(ModuleNr)
);

CREATE TABLE Files
(
FileId varchar(255) NOT NULL,
FileName varchar(255),
FileType varchar(50),
Path varchar(255),
ResourceId varchar(255) NOT NULL,
PRIMARY KEY (FileId),
FOREIGN KEY (ResourceId) REFERENCES Resources(ResourceId)
);

CREATE TABLE Quiz
(
QuizId int NOT NULL AUTO_INCREMENT,
QuizName varchar(255),
ModuleNr Int(10),
PRIMARY KEY (QuizId),
FOREIGN KEY (ModuleNr) REFERENCES Module(ModuleNr)
);

CREATE TABLE Question
(
QuestionId int NOT NULL AUTO_INCREMENT,
Question varchar(255),
QuizId int NOT NULL,
PRIMARY KEY (QuestionId),
FOREIGN KEY (QuizId) REFERENCES Quiz(QuizId)
);

CREATE TABLE Answer 
(
AnswerId int NOT NULL AUTO_INCREMENT,
Answer varchar(255),
RightAnswer boolean,
QuestionId int NOT NULL,
PRIMARY KEY (AnswerId),
FOREIGN KEY (QuestionId) REFERENCES Question(QuestionId)
);

CREATE TABLE QuizResults
(
ResultId int NOT NULL AUTO_INCREMENT,
RightAnswers int(10),
WrongAnswers int(10),
QuizId int NOT NULL,
UserId int NOT NULL,
PRIMARY KEY (ResultId),
FOREIGN KEY (QuizId) REFERENCES Quiz(QuizId),
FOREIGN KEY (UserId) REFERENCES User(UserId)
);
CREATE TABLE Calendar
(
Id varchar(255) NOT NULL,
CalendarTitle varchar(50),
Description varchar(255),
CreatedDate TimeStamp NOT NULL,
EndDate TimeStamp NOT NULL,
Content varchar(255),
OwnerId int NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (OwnerId) REFERENCES User(UserId)
);

CREATE TABLE ModulePlan
(
Id varchar(255) NOT NULL,
HandinDate TimeStamp,
ModuleNr Int(10) NOT NULL,
CalendarId varchar(255) NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (ModuleNr) REFERENCES Module(ModuleNr),
FOREIGN KEY (CalendarId) REFERENCES Calendar(Id)
);

