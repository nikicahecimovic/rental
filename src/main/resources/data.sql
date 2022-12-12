

INSERT INTO User (username, password, role, active)
VALUES ('admin', 'admin', 'ROLE_ADMIN', true);
INSERT INTO User (username, password, role, active)
VALUES ('user', 'user', 'ROLE_USER', true);

INSERT INTO Vhs (name, available_for_rent)
VALUES ('Star Wars: Episode V - The Empire Strikes Back', true);
INSERT INTO Vhs (name, available_for_rent)
VALUES ('Forrest Gump', true);
INSERT INTO Vhs (name, available_for_rent)
VALUES ('Shrek', true);
INSERT INTO Vhs (name, available_for_rent)
VALUES ('Home Alone', false);
INSERT INTO Rental (user_id, vhs_id, start_date, end_date)
VALUES (2, 4, '2022-10-07', '2022-10-14');
