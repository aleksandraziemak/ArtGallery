insert into painting(id, title, year, status, movement, estimated_price, estimated_price_currency)
values (2, 'Some title', 1234, 'SOLD', 'ART_DECO', 10.00, 'PLN');
insert into curator(id, first_name, last_name, salary)
values (4, 'Roger', 'Roger', 5000.00);
insert into client(id, first_name, last_name)
values (3, 'Amy', 'Adams');
insert into bank_account(id, name, account_number, balance, currency)
values (5, 'Account', '11111', 5000000.00,  'PLN');
insert into transaction(id, painting_id, client_id, curator_id, bank_account_id,
type, value, value_currency, original_value, original_value_currency, date)
values (1, 2, 3, 4, 5, 'BUY', 10000.00, 'PLN', 2000.00, 'EUR', '2020-01-01');