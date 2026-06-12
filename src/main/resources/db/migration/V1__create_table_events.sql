-- V1_create_table_events.sql
CREATE TABLE events(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    identification VARCHAR(255) NOT NULL UNIQUE,
    data_start TIMESTAMP NOT NULL,
    data_end TIMESTAMP NOT NULL,
    venue VARCHAR(255) NOT NULL,
    capacity INTEGER NOT NULL,
    organizer VARCHAR(255) NOT NULL,
    sponsor VARCHAR(255),
    type VARCHAR(50) NOT NULL
);