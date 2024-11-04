CREATE TABLE t_rooms (
                         id SERIAL PRIMARY KEY,
                         room_name VARCHAR(255) NOT NULL UNIQUE,
                         capacity INTEGER NOT NULL,
                         building VARCHAR(255) NOT NULL,
                         floor VARCHAR(50) NOT NULL,
                         room_type VARCHAR(50) NOT NULL,
                         status VARCHAR(50) NOT NULL,
                         is_active BOOLEAN DEFAULT TRUE,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table to hold room features for each room
CREATE TABLE room_features (
                               room_id BIGINT REFERENCES t_rooms(id) ON DELETE CASCADE,
                               feature VARCHAR(50),
                               PRIMARY KEY (room_id, feature)
);
