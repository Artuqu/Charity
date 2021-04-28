create database CharityDonation CHARACTER SET utf8;
use CharityDonation;
describe donation;
insert into category(name) values ('ubrania'), ('zabawki'), ('sprzęt'), ('inne');
insert into institution(name, description) values ('Fundacja "Dbam o Zdrowie"', ' Pomoc dzieciom z ubogich rodzin'),
('Fundacja "A kogo"', ' Pomoc wybudzaniu dzieci ze śpiączki'), ('Fundacja “Dla dzieci"', ' Pomoc osobom znajdującym się w trudnej sytuacji życiowej'),
 ('Fundacja “Bez domu”', ' Pomoc dla osób nie posiadających miejsca zamieszkania');