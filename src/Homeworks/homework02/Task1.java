package Homeworks.homework02;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner gradus = new Scanner(System.in);
        System.out.print("Введите степень в градусах Фарингейта: ");
        double faringeit = gradus.nextDouble();
        double celsius = (faringeit - 32) * 5 / 9;
        System.out.println(faringeit + " градусов по Фарингейту равна " + celsius + " по Цельсию");
    }
}