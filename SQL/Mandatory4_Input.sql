INSERT INTO UsrRole VALUES (
0,
'Teacher'
);

INSERT INTO UsrRole VALUES (
1,
'Teaching Assistant'
);

INSERT INTO UsrRole VALUES (
2,
'Student'
);

INSERT INTO User VALUES (
NULL,
'Even Aby',
'Larsen',
'even.larsen@uia.no',
'password',
0
);

INSERT INTO User VALUES (
NULL,
'John Martin',
'Dahl',
'john.martin@gmail.com',
'password',
1
);

INSERT INTO User VALUES (
NULL,
'Håkon',
'Methi',
'hakon.methi@gmail.com',
'password',
2
);

INSERT INTO User VALUES (
NULL,
'Andrei',
'Tanase',
'atanase@student.uia.no',
'password',
2
);


INSERT INTO Module VALUES (
1,
'BlueJ, Klasser og Objekter',
'I denne modulen skal du først og fremst lære å bruke verktøyene du skal bruke i resten av kurset. I tillegg skal du begynne å lære litt om objektorientert programmering og java.',
'Bruke BlueJ, bl.a. til å: Åpne, lagre, og lukke prosjekter. Lage objekter. Kalle metoder i objektene, med og uten parametere .Bruke editoren til å se på kildekoden til en klasse Kunne kompilere prosjektet.',
'2016-12-01 00:00:01'
);

INSERT INTO Module VALUES (
2,
'Klassedefinisjoner',
'I denne modulen skal du lære å lese java klassedefinisjoner. Java programmer består av klasser, så du skal egentlig lære å lese javaprogrammer. Du skal også få prøve å skrive enkle programmer.',
'lese en klassedefinisjon, og kunne fortelle: 
hva klassen heter
hvilke felt den har, hva de heter og hvilken type de har
hvilke metoder den har, og hva metodene heter
beskrive parametere (med navn og type) og returverdi for alle metodene',
'2016-12-01 00:00:01'
);

INSERT INTO Module VALUES (
3,
'Flere objekter',
'Virkelige bruksområder for programmer er nesten alltid så kompliserte at programmene ikke kan skrives som en klasse. Den ville bli for komplisert. I denne modulen skal du lære om hvordan du kan bruke flere klasser og objekter i samme program.',
'kan forklare hva som menes med abstraksjon og modularisering
kan bruke debuggeren i BlueJ
har lært litt mer java, og kan:
forklare forskjellen på primitive typer og objekttyper
kan skrive kode som lager nye objekter',
'2016-12-13 00:00:01'
);

INSERT INTO Handin VALUES (
'0',
'2016-11-17 15:40:43',
3,
'I denne modulen har jeg lært å bruke bluej til å programmere i java, se vedlagt video fil.',
1
);

INSERT INTO Handin VALUES ( 
'1',
'2016-11-15 15:30:09',
4,
'I denne modulen har jeg lært java.',
1
);

INSERT INTO Handin VALUES (
'2',
'2016-11-20 12:21:23',
3,
'I denne modulen har jeg lært om klasser og metoder.',
2
);

INSERT INTO Response VALUES (
'0',
'Dette ser bra ut',
'2016-11-19 15:40:43',
2,
'0'
);

INSERT INTO Response VALUES (
'1',
'Dette ser helt ok ut',
'2016-11-19 20:40:43',
1,
'0'
);

INSERT INTO Response VALUES (
'2',
'Dette må du jobbe litt mer med',
'2016-11-20 20:10:43',
1,
'1'
);

INSERT INTO Response VALUES (
'3',
'Dette ser bra ut, godt jobba!',
'2016-11-21 04:40:43',
1,
'2'
);

INSERT INTO Evaluation VALUE (
'0',
'2016-11-21 04:42:43',
'A',
1,
'2'
);

INSERT INTO Evaluation VALUE (
'1',
'2016-11-21 14:42:43',
'E',
1,
'1'
);

INSERT INTO Resources VALUE (
'0',
'Some resources and shit',
'Video',
1
);

INSERT INTO Resources VALUE (
'1',
'Some resources and shit',
'Tutorial document',
1
);

INSERT INTO Resources VALUE (
'2',
'Some resources and shit',
'Tutorial document',
1
);

INSERT INTO Resources VALUE (
'3',
'Some resources and shit',
'Video',
2
);

INSERT INTO Resources VALUE (
'4',
'Some resources and shit',
'Tutorial document',
2
);

INSERT INTO Resources VALUE (
'5',
'Some resources and shit',
'Tutorial document',
3
);

INSERT INTO Resources VALUE (
'6',
'Some resources and shit',
'Tutorial document',
3
);

INSERT INTO Resources VALUE (
'7',
'Some resources and shit',
'Tutorial document',
1
);


INSERT INTO Quiz VALUE (
'0',
'Quiz 1',
1
);

INSERT INTO Quiz VALUE (
'1',
'Quiz 2',
2
);

INSERT INTO Quiz VALUE (
'2',
'Quiz 3',
3
);

INSERT INTO Question VALUE (
'0',
'Some Question',
'0'
);
INSERT INTO Question VALUE (
'1',
'Some Question',
'0'
);
INSERT INTO Question VALUE (
'2',
'Some Question',
'0'
);
INSERT INTO Question VALUE (
'3',
'Some Question',
'0'
);
INSERT INTO Question VALUE (
'4',
'Some Question',
'0'
);
INSERT INTO Question VALUE (
'5',
'Some Question',
'0'
);
INSERT INTO Question VALUE (
'6',
'Some Question',
'0'
);
INSERT INTO Question VALUE (
'7',
'Some Question',
'0'
);
INSERT INTO Question VALUE (
'8',
'Some Question',
'0'
);
INSERT INTO Question VALUE (
'9',
'Some Question',
'0'
);

INSERT INTO Question VALUE (
'10',
'Some Question',
'1'
);
INSERT INTO Question VALUE (
'11',
'Some Question',
'1'
);
INSERT INTO Question VALUE (
'12',
'Some Question',
'1'
);
INSERT INTO Question VALUE (
'13',
'Some Question',
'1'
);
INSERT INTO Question VALUE (
'14',
'Some Question',
'1'
);
INSERT INTO Question VALUE (
'15',
'Some Question',
'1'
);
INSERT INTO Question VALUE (
'16',
'Some Question',
'1'
);
INSERT INTO Question VALUE (
'17',
'Some Question',
'1'
);

INSERT INTO Question VALUE (
'18',
'Some Question',
'2'
);
INSERT INTO Question VALUE (
'19',
'Some Question',
'2'
);
INSERT INTO Question VALUE (
'20',
'Some Question',
'2'
);
INSERT INTO Question VALUE (
'21',
'Some Question',
'2'
);
INSERT INTO Question VALUE (
'22',
'Some Question',
'2'
);

INSERT INTO Answer VALUE (
'0',
'Some Answer',
True,
'0'
);
INSERT INTO Answer VALUE (
'1',
'Some Answer',
False,
'1'
);
INSERT INTO Answer VALUE (
'2',
'Some Answer',
False,
'2'
);
INSERT INTO Answer VALUE (
'3',
'Some Answer',
False,
'3'
);
INSERT INTO Answer VALUE (
'4',
'Some Answer',
True,
'4'
);
INSERT INTO Answer VALUE (
'5',
'Some Answer',
False,
'5'
);
INSERT INTO Answer VALUE (
'6',
'Some Answer',
False,
'6'
);
INSERT INTO Answer VALUE (
'7',
'Some Answer',
False,
'7'
);
INSERT INTO Answer VALUE (
'8',
'Some Answer',
True,
'8'
);
INSERT INTO Answer VALUE (
'9',
'Some Answer',
False,
'9'
);
INSERT INTO Answer VALUE (
'10',
'Some Answer',
False,
'10'
);
INSERT INTO Answer VALUE (
'11',
'Some Answer',
False,
'11'
);
INSERT INTO Answer VALUE (
'12',
'Some Answer',
True,
'12'
);
INSERT INTO Answer VALUE (
'13',
'Some Answer',
False,
'13'
);
INSERT INTO Answer VALUE (
'14',
'Some Answer',
False,
'14'
);
INSERT INTO Answer VALUE (
'15',
'Some Answer',
False,
'15'
);
INSERT INTO Answer VALUE (
'16',
'Some Answer',
True,
'16'
);
INSERT INTO Answer VALUE (
'17',
'Some Answer',
False,
'17'
);
INSERT INTO Answer VALUE (
'18',
'Some Answer',
False,
'18'
);
INSERT INTO Answer VALUE (
'19',
'Some Answer',
False,
'19'
);
INSERT INTO Answer VALUE (
'20',
'Some Answer',
True,
'20'
);
INSERT INTO Answer VALUE (
'21',
'Some Answer',
False,
'21'
);
INSERT INTO Answer VALUE (
'22',
'Some Answer',
False,
'22'
);




INSERT INTO QuizResults VALUE (
'0',
8,
2,
'0',
3
);

INSERT INTO QuizResults VALUE (
'1',
5,
5,
'0',
4
);

INSERT INTO QuizResults VALUE (
'2',
8,
0,
'1',
3
);

INSERT INTO QuizResults VALUE (
'3',
8,
0,
'1',
4
);




SELECT * FROM user;












