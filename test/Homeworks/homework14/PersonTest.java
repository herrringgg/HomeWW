package Homeworks.homework14;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    void testPositivePurchase() {
        Person person = new Person("Иван", 100);
        Product bread = new Product("Хлеб", 50);

        String result = person.addProducts(bread);

        assertEquals("Иван купил Хлеб", result);
        assertEquals(50, person.getMoney());
        assertEquals(1, person.getProducts().length);
    }

    @Test
    void testNotEnoughMoney() {
        Person person = new Person("Иван", 30);
        Product bread = new Product("Хлеб", 50);

        String result = person.addProducts(bread);

        assertEquals("Иван не может позволить себе Хлеб", result);
        assertEquals(30, person.getMoney());
        assertEquals(0, person.getProducts().length);
    }

    @Test
    void testEmptyNameThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Person("", 100));
    }

    @Test
    void testNegativeMoneyThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Иван", -10));
    }

    @Disabled("Проверка игнорирования теста")
    @Test
    void ignoredTest() {
        assertEquals(2, 1 + 1);
    }
}

