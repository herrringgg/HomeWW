package Homeworks.homework18;

public class Table {
   /* CREATE SCHEMA IF NOT EXISTS shop;


    CREATE TABLE IF NOT EXISTS shop.customers (
            id SERIAL PRIMARY KEY,
            first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    discount_percent NUMERIC(5,2) DEFAULT 0.00 CHECK (discount_percent >= 0 AND discount_percent <= 100),
    created_at TIMESTAMPTZ DEFAULT now()
);


    CREATE TABLE IF NOT EXISTS shop.orders (
            id SERIAL PRIMARY KEY,
            customer_id INT NOT NULL REFERENCES shop.customers(id) ON DELETE CASCADE,
    order_date TIMESTAMPTZ DEFAULT now(),
    total_amount NUMERIC(12,2) NOT NULL CHECK (total_amount >= 0),
    created_at TIMESTAMPTZ DEFAULT now()
);


    CREATE INDEX IF NOT EXISTS idx_orders_customer_id ON shop.orders(customer_id);


    CREATE OR REPLACE VIEW shop.customer_order_summary AS
    SELECT
    c.id,
    c.first_name,
    c.last_name,
    c.discount_percent,
    COUNT(o.id) AS orders_count,
    COALESCE(SUM(o.total_amount),0) AS total_spent
    FROM shop.customers c
    LEFT JOIN shop.orders o ON o.customer_id = c.id
    GROUP BY c.id, c.first_name, c.last_name, c.discount_percent;
    */

    int d = 6;
}
