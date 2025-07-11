package Homeworks.homework04;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите  строку: ");
        String input = scanner.nextLine();

        int kolvoStrel = 0;
        final String strelavPravo = ">>-->";
        final String strelavLevo = "<--<<";
        final int dlinaStrela = 5;

        if (input.length() < dlinaStrela) {
            System.out.println(0);
        }

        for (int i = 0; i <= input.length() - dlinaStrela; i++) {
            String sstring = input.substring(i, i + dlinaStrela);
            if (sstring.equals(strelavLevo) || sstring.equals(strelavPravo)) {
                kolvoStrel++;
            }
        }
        System.out.println(kolvoStrel);
    }
}
