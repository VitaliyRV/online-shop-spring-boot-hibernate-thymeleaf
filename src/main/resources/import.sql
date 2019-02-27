INSERT INTO role(name) VALUES ('USER');

-- username/login = simpleUser/simpleUser
INSERT INTO user(id, username, password) VALUES (1, 'simpleUser', '$2a$10$1tnRy5H6/FXd28lvUZR85eYUX6I1P6lBjySDPT6ngyBdaI.Aqwa8W');
INSERT INTO user_role VALUES (1,'USER');

INSERT INTO products (id, name, price) VALUES (1, 'Product 01', 11);
INSERT INTO products (id, name, price) VALUES (2, 'Product 02', 5);
INSERT INTO products (id, name, price) VALUES (3, 'Product 03', 7);
INSERT INTO products (id, name, price) VALUES (4, 'Product 04', 14);
INSERT INTO products (id, name, price) VALUES (5, 'Product 05', 53);
INSERT INTO products (id, name, price) VALUES (6, 'Product 06', 28);