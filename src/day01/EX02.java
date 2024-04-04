package day01;

import java.util.Scanner;

public class EX02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num <= 9) {
            switch(num){
                case 9:
                    System.out.print('A');
                    break;
                case 8:
                    System.out.print('B');
                    break;
                case 7:
                    System.out.print('C');
                    break;
                default:
                    System.out.print('F');
                    break;
            }
        }

    }
}
