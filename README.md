# eCommerce
This Application is created using spring and hibernate using Maven-Project in eclipse.

This Application is created using Spring and Hibernate using Maven.

This E-Commerce Application is able to add Products in the cart and check the Products List.
Both Anonymous user and Authorized user can add the products. 
And Most Important the products are added from the Back-end.
This application is created using Maven.

The Data-Config is as follows:

show databases; create database cart; use cart; commit;

show tables;

select * from item; select * from user; select * from hibernate_sequence;

insert into item (productId,description,name,price) values ('1','Skinny Men Blue Jeans','Metronaut ','800');
insert into item (productId,description,name,price) values ('2','Slim Men Blue Jeans','Billion ','700'); 
insert into item (productId,description,name,price) values ('3','Slim Men Blue Jeans','Numero Uno','600');
insert into item (productId,description,name,price) values ('4','Skinny Men Blue Jeans','Wrangler ','900');
