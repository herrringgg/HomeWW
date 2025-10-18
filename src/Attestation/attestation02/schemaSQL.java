package Attestation.attestation02;

public class schemaSQL {
    /*
    CREATE SCHEMA IF NOT EXISTS shop;

-- удаление старых таблиц,
    DROP TABLE IF EXISTS shop.orders CASCADE;
    DROP TABLE IF EXISTS shop.customers CASCADE;
    DROP TABLE IF EXISTS shop.products CASCADE;

-- создание таблиц
    CREATE TABLE IF NOT EXISTS shop.customers (
            id SERIAL PRIMARY KEY,
            full_name VARCHAR(255) NOT NULL
);
    COMMENT ON TABLE shop.customers IS 'Таблица покупателей (клиентов)';

    CREATE TABLE IF NOT EXISTS shop.products (
            id SERIAL PRIMARY KEY,
            description TEXT,
            price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
    quantity INTEGER NOT NULL CHECK (quantity >= 0)
);
    COMMENT ON TABLE shop.products IS 'Таблица товаров (продукция на складе)';

    CREATE TABLE IF NOT EXISTS shop.orders (
            id SERIAL PRIMARY KEY,
            customer_id INTEGER NOT NULL REFERENCES shop.customers(id) ON DELETE RESTRICT,
    product_id INTEGER NOT NULL REFERENCES shop.products(id) ON DELETE RESTRICT,
    order_date TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    quantity INTEGER NOT NULL CHECK (quantity > 0)
);
    COMMENT ON TABLE shop.orders IS 'Таблица заказов (связь покупателей и товаров)';

-- Индексы
    CREATE INDEX IF NOT EXISTS idx_shop_orders_customer ON shop.orders(customer_id);
    CREATE INDEX IF NOT EXISTS idx_shop_orders_product ON shop.orders(product_id);
    CREATE INDEX IF NOT EXISTS idx_shop_orders_date ON shop.orders(order_date);




-- Заполнение "Покупателей"
    INSERT INTO customers (full_name) VALUES
('Иван Иванов'),
        ('Петр Петров'),
        ('Мария Сидорова'),
        ('Елена Кузнецова'),
        ('Алексей Смирнов'),
        ('Дмитрий Васильев'),
        ('Ольга Михайлова'),
        ('Сергей Новиков'),
        ('Анна Попова'),
        ('Николай Лебедев');

-- Заполнение "Товаров"
    INSERT INTO products (description, price, quantity) VALUES
('Ноутбук "Горизонт-15"', 75000.50, 15),
        ('Смартфон "Сигма-X"', 32000.00, 50),
        ('Мышь беспроводная "Кликер-3"', 1500.99, 120),
        ('Клавиатура механическая "Тайпер-Про"', 8990.00, 30),
        ('Монитор 27" "Визуал-QHD"', 24500.00, 25),
        ('Наушники "Аудиофил-900"', 11200.75, 40),
        ('Жесткий диск SSD 1TB "Скорость"', 9800.00, 70),
        ('Видеокарта "Графикон-RTX"', 55000.00, 10),
        ('Веб-камера "Стрим-HD"', 4300.00, 60),
        ('Коврик для мыши "Про-Гейм"', 990.50, 200);

-- Заполнение "Заказов"
    INSERT INTO orders (customer_id, product_id, quantity, order_date) VALUES
(1, 2, 1, '2025-10-01 10:30:00'),
        (3, 5, 1, '2025-10-02 11:00:00'),
        (2, 3, 2, '2025-10-02 14:15:00'),
        (5, 1, 1, '2025-10-03 09:05:00'),
        (4, 9, 1, '2025-10-04 16:20:00'),
        (7, 6, 1, '2025-10-05 18:00:00'),
        (1, 10, 1, '2025-10-06 11:30:00'),
        (8, 7, 1, '2025-10-06 12:45:00'),
        (10, 4, 1, '2025-10-07 15:00:00'),
        (3, 8, 1, '2025-10-08 10:10:00');
     */
}
