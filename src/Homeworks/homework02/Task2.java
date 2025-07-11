package Homeworks.homework02;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner nu = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int numb1 = nu.nextInt();
        System.out.println("Введите второе число: ");
        int numb2 = nu.nextInt();
        System.out.println("Сумма двух целых чисел: " + (numb1 + numb2));
        System.out.println("Разница двух целых чисел: " + (numb1 - numb2));
        System.out.println("Произведение из двух целых чисел: " + (numb1 * numb2));
        int s = (numb1 + numb2);
        double n = (double) s / 2;
        System.out.print("Среднее из двух целых чисел: ");
        System.out.printf("%.2f", n);
        System.out.println();
        System.out.println("Расстояние двух целых чисел: " + Math.abs(numb1 - numb2));
        System.out.println("Максимальное целое число: " + Math.max(numb1, numb2));
        System.out.println("Минимальное целое число: " + Math.min(numb1, numb2));
    }
}
