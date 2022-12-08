TRUNCATE TABLE rental;

INSERT INTO User (username, password, role)
VALUES ('admin', 'admin', 'ADMIN_ROLE');
INSERT INTO User (username, password, role)
VALUES ('user', 'user', 'USER_ROLE');
INSERT INTO Vhs (name, is_available_for_rent)
VALUES ('Star Wars: Episode V - The Empire Strikes Back', true);
INSERT INTO Vhs (name, is_available_for_rent)
VALUES ('Forrest Gump', true);
INSERT INTO Vhs (name, is_available_for_rent)
VALUES ('Shrek', true);
INSERT INTO Vhs (name, is_available_for_rent)
VALUES ('Home Alone', true);
INSERT INTO Rental (user_id, vhs_id, start_date, end_date)
VALUES (2, 4, '2022-10-07', '2022-10-14');
