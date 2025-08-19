package Homeworks.homework10;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {12, 7, 25, 18, 33, 40, 21};


        int[] evens = Sequence.filter(array, number -> number % 2 == 0);
        System.out.println("Четные числа: " + Arrays.toString(evens));


        int[] sumEvenDigits = Sequence.filter(array, number -> {
            int sum = 0;
            int n = number;
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum % 2 == 0;
        });
        System.out.println("Числа с четной суммой цифр: " + Arrays.toString(sumEvenDigits));
    }
}

