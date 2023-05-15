insert into painting(id, title, year, status, movement, estimated_price, estimated_price_currency)
values (998, 'Some title', 1234, 'SOLD', 'ART_DECO', 10000.00, 'PLN');
insert into painting(id, title, year, status, movement, estimated_price, estimated_price_currency)
values (999, 'Some Other title', 1256, 'SOLD', 'ART_DECO', 10000.00, 'PLN');
insert into author(id, first_name, second_name, last_name, country)
values (998, 'Marc', 'Something', 'Something', 'France');
insert into author(id, first_name, second_name, last_name, country)
values (999, 'Paul', 'Marc', 'Atryda', 'Arrakis');
insert into curator(id, first_name, last_name, salary)
values (998, 'Roger', 'Roger', 5000.00);
insert into curator(id, first_name, last_name, salary)
values (999, 'Denis', 'Janice', 5000.00);
insert into collection_entry(id, painting_id, author_id, curator_id)
values (999, 998, 998, 998);