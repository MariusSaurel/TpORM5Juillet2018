insert INTO COMPTE_BANCAIRE values('FR7630001007941234567890185','Azerty', 'BOUSFRPP');
insert INTO COMPTE_BANCAIRE values('FR7630004000031234567890143','toto', 'BOUSFRPP');
insert INTO COMPTE_BANCAIRE values('FR7630006000011234567890189','toto', 'HSBCFRPP');

insert into CLIENT  (nom) values ('cathy cathou');
insert into CLIENT  (nom) values ('toto cathou');

insert INTO AssuranceAuto values (NULL,'AADDD',23);

insert INTO ASSURANCE (Numero,DateSouscription,DateAnniversaire,DatePrelevement) values(12,'04-07-2018','08-08-1995','05-07-2018');

INSERT INTO CLIENT_ASSURANCE(idClient, idAssurance)
      values ((SELECT idClient from client where nom='cathy cathou'),
              (SELECT idAssurance from ASSURANCE where Numero=12));

INSERT INTO COMPTE_CLIENT (idClient, iban) VALUES ((SELECT idClient from client where nom='cathy cathou'),'FR7630001007941234567890185');