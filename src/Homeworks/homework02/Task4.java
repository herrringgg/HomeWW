package Homeworks.homework02;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner vvod = new Scanner(System.in);

        System.out.print("Введите число строк: ");
        int ctroka = vvod.nextInt();
        System.out.println();

        System.out.print("Введите число столбцов: ");
        int ctolb = vvod.nextInt();
        System.out.println();

        System.out.print("Введите  повторяемый элемент сетки: ");
        String element = vvod.next();
        System.out.println();

        System.out.println("Сетка по запросу 10 на 10");
        System.out.println(((element.repeat(ctroka)) + "\n").repeat(ctolb));
    }
}
