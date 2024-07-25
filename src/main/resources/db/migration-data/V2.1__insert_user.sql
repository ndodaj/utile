
INSERT INTO users (username, password, email, first_name, last_name, birthday, mobilePhone, account_type, created_by, last_modified_by)
VALUES
    ('user1', '{noop}password1', 'user1@example.com', 'John', 'Doe', '1985-01-15', '123-456-7890', 'STANDARD', 'admin', 'admin'),
    ('admin1', '{noop}adminpassword1', 'admin1@example.com', 'Admin', 'User', '1975-12-20', '123-456-7891', 'ADMIN', 'admin', 'admin');
-- $2a$10$fAb5yDYznme2vPNov0KY1eyJfNFo4yteoeC/V1oRhJNgwwvzn52B6