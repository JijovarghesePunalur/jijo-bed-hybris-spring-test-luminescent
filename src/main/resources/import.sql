insert into category(id, name) values (1, 'Category1');
insert into category(id, name) values (2, 'Category2');
insert into category(id, name) values (3, 'Category3');

insert into subcategory(id, category_id, name) values (1, 1, 'SubCategory1');
insert into subcategory(id, category_id, name) values (2, 1, 'SubCategory2');
insert into subcategory(id, category_id, name) values (3, 2, 'SubCategory3');
insert into subcategory(id, category_id, name) values (4, 2, 'SubCategory4');
insert into subcategory(id, category_id, name) values (5, 3, 'SubCategory5');
insert into subcategory(id, category_id, name) values (6, 3, 'SubCategory6');

insert into product(id, name, description, sub_id) values (1, 'Product 1', 'An awesome product 1', 1);
insert into product(id, name, description, sub_id) values (2, 'Product 2', 'Product 2 is the best', 2);

insert into price(id, product_id, currency, amount) values (1, 1, 'GBP', 9.99);
insert into price(id, product_id, currency, amount) values (2, 1, 'EUR', 11.99);
insert into price(id, product_id, currency, amount) values (3, 2, 'GBP', 19.99);
insert into price(id, product_id, currency, amount) values (4, 2, 'EUR', 23.50);
