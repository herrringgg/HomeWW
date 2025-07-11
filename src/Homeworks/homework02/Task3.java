package Homeworks.homework02;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner vvod = new Scanner(System.in);

        System.out.print("Исходная строка: ");
        String slovo = vvod.next();
        System.out.println();

        System.out.print("Сколько раз ввести строку? ");
        int povtor = vvod.nextInt();
        System.out.println();

        System.out.println(slovo.repeat(povtor));

    }
}
