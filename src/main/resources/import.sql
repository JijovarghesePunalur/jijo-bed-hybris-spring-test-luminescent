insert into product(id, name, description) values (1, 'Product 1', 'An awesome product 1');
insert into product(id, name, description) values (2, 'Product 2', 'Product 2 is the best');

insert into price(id, product_id, currency, amount) values (1, 1, 'GBP', 9.99);
insert into price(id, product_id, currency, amount) values (2, 1, 'EUR', 11.99);
insert into price(id, product_id, currency, amount) values (3, 2, 'GBP', 19.99);
insert into price(id, product_id, currency, amount) values (4, 2, 'EUR', 23.50);