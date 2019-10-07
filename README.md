# eCommerce
This Application is created using spring and hibernate using Maven-Project in eclipse.

This Application is created using Spring and Hibernate using Maven.

This E-Commerce Application is able to add Products in the cart and check the Products List.
Both Anonymous user and Authorized user can add the products. 
And Most Important the products are added from the Back-end.
This application is created using Maven.

The Data-Config is as follows:

show databases;

create database cart;
use cart;
commit;
show tables;
select * from item;
select * from user;
select * from hibernate_sequence;


insert into item (productId,description,name,price) values ('31','The all new Mi Band 3 has an OLED touch display allowing you to read messages and many other useful data with just one touch of a finger','Mi Unisex Black Band 3 ','1999');
insert into item (productId,description,name,price) values ('32','Display: Analogue
Movement: Quartz
Power source: Battery
Dial style: Solid round stainless steel dial
Features: Reset Time
Strap style: Black bracelet style, metal strap with a foldover closure
Water resistance: 30 m', 'Daniel Women Watch','1125');
insert into item (productId,description,name,price) values ('33','Display: Analogue
Movement: Quartz
Power source: Battery
Dial style: Colourblocked round stainless steel dial
Warranty provided by brand/manufacturer','MINI Men Silver','16990');
insert into item (productId,description,name,price) values ('34','Display: Analogue
Movement: Quartz
Power source: Battery
Dial style: Solid round stainless steel dial
Features: Reset Time, Calendar
Warranty: 1 year','Fossil Men Blue Watch','4799');

insert into item (productId,description,name,price) values ('35','Display: Analogue
Movement: Quartz
Power source: Battery
Dial style: Embellished round alloy dial
Features: Reset Time
Strap style: Rose Gold-Toned bracelet style, metal strap with a foldover closure
Water resistance: Water Resistant
Warranty: 2 years','bebe Women Rose Gold  ','4099');
insert into item (productId,description,name,price) values ('36','Display: Analogue
Movement: Quartz
Power source: Battery
Dial style: Solid round stainless steel dial
Features: Reset Time
Strap style: Black regular, synthetic strap with a tang closure
Water Resistant
Size & Fit
Dial width: 35 mm
Strap Width: 20 mm','Roadster ','899');

insert into item (productId,description,name,price) values ('37','Display: Analogue
Movement: Quartz
Power source: Battery
Dial style: Textured round metal dial
Features: Reset Time
Strap style: Pink regular, leather strap with a tang closure
Water resistance: Water Resistant
Comes in a signature CASIO case','CASIO Watch','3295');
insert into item (productId,description,name,price) values ('38','Exceptionally crafted for the lovers for exclusive timepieces, this gold coloured analog watch from Tommy Hilfiger will lend a luxe finish to your corporate look. Featuring stainless steel case and strap for durability,2 sub-dials.','Tommy Hilfiger ','624');

insert into item (productId,description,name,price) values ('39','Display: Analogue
Movement: Quartz
Power source: Battery
Dial style: Solid round stainless steel dial
Features: Reset Time
Strap style: Black regular, synthetic strap with a tang closure
Comes in a Fastrack case','Fastrack','624');

insert into item (productId,description,name,price) values ('40','Case style: Analogue watch, has a circular case and a stainless steel back
Dial style: Black dial
Features: A screw to reset the time, a mock subdial
Strap style: Brown genuine leathernbsp;strap, secured with a tang clasp
Water-resistant','Mast & Harbour','624');

insert into item (productId,description,name,price) values ('41','Keep up your routine for even longer. 
With plenty of power to last throughout your daily workouts, you can pack in those longer hours to reach your fitness goals
Dial width: 18.9 mm.','Samsung Unisex White ','2490');

insert into item (productId,description,name,price) values ('42','Display: Analogue
Movement: Mechanical
Power source: Battery
Dial style: Solid round stainless steel dial
Features: Reset Time
Strap style: Rose Gold-Toned bracelet style, stainless steel strap with a foldover closure
Water Resistant','DressBerry ','1799');

insert into item (productId,description,name,price) values ('33','Display: Analogue Movement: Quartz Power source: Battery Dial style: Solid round stainless steel dial Features: Reset Time Strap style: Black regular, synthetic strap with a tang closure Comes in a Fastrack case','Mini ','1190');


Somethings wrong!!
If you find that something's wrong with this package, you can let me know by raising an issue on the GitHub issue tracker

Contribution
Contributors are most welcome.
