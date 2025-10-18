package Attestation.attestation02;

public class testQueriesSQL {
    /* --Все покупатели
SELECT * FROM shop.customers ORDER BY id;

-- Товары дешевле 10000
SELECT * FROM shop.products WHERE price < 10000 ORDER BY price;

-- Товары с остатком меньше 20
SELECT description, quantity FROM shop.products WHERE quantity < 20 ORDER BY quantity ASC;

--  Список заказов с именами и описанием товаров и общей стоимостью позиции
SELECT
  o.id AS order_id,
  o.order_date,
  c.full_name AS customer,
  p.description AS product,
  o.quantity AS qty,
  p.price AS unit_price,
  (o.quantity * p.price) AS total_price
FROM shop.orders o
JOIN shop.customers c ON o.customer_id = c.id
JOIN shop.products p ON o.product_id = p.id
ORDER BY o.order_date;

-- Сумма всех заказов по каждому клиенту
SELECT
  c.full_name AS customer,
  SUM(o.quantity * p.price) AS total_spent
FROM shop.orders o
JOIN shop.customers c ON o.customer_id = c.id
JOIN shop.products p ON o.product_id = p.id
GROUP BY c.full_name
ORDER BY total_spent DESC;


-- изменить имя покупателя id=2
UPDATE shop.customers SET full_name = 'Петр C. Петров' WHERE id = 2;

-- увеличить цену видеокарты (id=8) на 15% (и округлить до копеек)
UPDATE shop.products
SET price = ROUND(price * 1.15::numeric, 2)
WHERE id = 8;

-- уменьшить количество смартфонов (id=2) на 1
UPDATE shop.products SET quantity = quantity - 1 WHERE id = 2;
-- Удалить заказ id=10 (если есть)
DELETE FROM shop.orders WHERE id = 10;

-- Безопасное удаление товара, неиспользуемого в заказах:
INSERT INTO shop.products (description, price, quantity) VALUES ('Товар на удаление', 1.00, 1);
DELETE FROM shop.products WHERE description = 'Товар на удаление';

-- Проверочные счётчики
SELECT COUNT(*) AS products_count FROM shop.products;
SELECT COUNT(*) AS customers_count FROM shop.customers;
SELECT COUNT(*) AS orders_count FROM shop.orders;
     */
}
