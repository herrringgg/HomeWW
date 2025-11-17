
CREATE SCHEMA IF NOT EXISTS SurfSkateShop;

CREATE TABLE IF NOT EXISTS SurfSkateShop.products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    product_type VARCHAR(50),
    brand VARCHAR(100),
    price numeric(12,2),
    stock integer,
    deleted boolean DEFAULT false,
    created_at timestamptz,
    updated_at timestamptz
);


INSERT INTO SurfSkateShop.products (name, description, product_type, brand, price, stock, deleted, created_at, updated_at)
VALUES
 ('Classic Surfboard', '9ft longboard, epoxy', 'SURF', 'WaveCraft', 499.99, 5, false, now(), now()),
 ('Street Skate Deck', '8.0" maple deck', 'SKATE', 'StreetPro', 59.99, 20, false, now(), now());