package day01;

import java.util.Scanner;

public class EX03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if (age < 40) {
            switch (age / 10) {
                case 3:
                    System.out.print("30대입니다.");
                    break;
                case 2:
                    System.out.print("20대입니다.");
                    break;
                case 1:
                    System.out.print("10대입니다.");
                    break;
                default:
                    System.out.print("어린이입니다.");
                    break;
            }
        }

    }
}