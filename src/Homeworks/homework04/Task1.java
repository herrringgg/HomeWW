package Homeworks.homework04;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String string = "qwertyuiopasdfghjklzxcvbnm";
        System.out.print("Введите  букву: ");

        char inputt = input.next().charAt(0);
        int index = string.indexOf(inputt);

        if (index > 0) {
            char leftSimvol = string.charAt(index - 1);
            System.out.println(leftSimvol);

        } else if (index == 0) {
            System.out.println(string.charAt(string.length() - 1));
        }
    }
}
