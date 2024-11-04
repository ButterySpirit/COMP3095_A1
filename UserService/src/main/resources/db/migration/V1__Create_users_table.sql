CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) UNIQUE NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       phone_number VARCHAR(20),
                       user_type VARCHAR(50),
                       role VARCHAR(50),
                       is_active BOOLEAN DEFAULT true
);

