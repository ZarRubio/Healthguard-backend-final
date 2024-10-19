-- Insert initial data into type_of_user table
INSERT IGNORE INTO typeofuser (type_id, description) VALUES (1, 'ADMIN');
INSERT IGNORE INTO typeofuser (type_id, description) VALUES (2, 'USER');

-- Insert initial data into users table
INSERT IGNORE INTO users (user_id, first_name, last_name, email, password, type_id) VALUES
                                                                                (1, 'John', 'Doe', 'john.doe@example.com', '$2a$10$DowJonesFomJlnWpzm5QQROxG6k1/PAF80Q5kghP5T4/SrBQ.9THM6', 1), -- password: password123
                                                                                (2, 'Jane', 'Doe', 'jane.doe@example.com', '$2a$10$DowJonesFomJlnWpzm5QQROxG6k1/PAF80Q5kghP5T4/SrBQ.9THM6', 2); -- password: password123
