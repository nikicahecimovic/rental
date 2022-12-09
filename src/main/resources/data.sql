TRUNCATE TABLE rental;

INSERT INTO User (username, password, role)
VALUES ('admin', '$2a$04$jg2WB/1zO0WNOPA0AiI15eKSlYG83jFtj.JB1Kj77s9SVeII7tBSS', 'ROLE_ADMIN');
INSERT INTO User (username, password, role)
VALUES ('user', '$2a$04$U1QGlZ7foUA0Yo9xqbmFxe2upJkyM3a1aNZj/1XBBWnWscXSKBYu2', 'ROLE_USER');

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
