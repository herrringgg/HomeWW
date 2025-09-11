package Homeworks.homework14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProductTest {
    @Test
    void testValidProduct() {
        Product product = new Product("Молоко", 70);
        assertEquals("Молоко", product.getNameProduct());
        assertEquals(70, product.getPrice());
    }

    @Test
    void testEmptyNameThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Product("", 50));
    }

    @Test
    void testNegativePriceThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Хлеб", -10));
    }

    @Test
    void testToString() {
        Product product = new Product("Сыр", 150);
        assertEquals("Сыр", product.toString());
    }
}

/*Вопросы:
1.Какие исключения ожидаются. IllegalArgumentException (пустое имя, отрицательные деньги, отрицательная цена).
NumberFormatException (если строка не преобразуется в число при парсинге).

2.Можно ли их избежать. Да, проверки входных данных (if... throw), валидация строк перед парсингом.

3.Вся ли программа покрыта тестами. Нет, тестами не охвачена работа с консольным вводом (Task1.main)
 */
