package Homeworks.homework01;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {

        Random r = new Random();
        int Ole = r.nextInt( 3);
        int Eha = r.nextInt(3);

        System.out.println("камень-0, ножницы-1, бумага-2");

        System.out.println("Ole выбрал: " + Ole);
        System.out.println("Eha выбрал: " + Eha);

        if (Ole == Eha) {
            System.out.println("Ничья!");
        } else if ((Ole == 0 && Eha == 1) || (Ole == 1 && Eha == 2) || (Ole == 2 && Eha == 0)) {
            System.out.println("Ole выйграл, красавчик!");
        } else {
            System.out.println("Ole продул, Eha красавчик!");
        }
    }
}

