package day01;

import java.util.Scanner;

public class EX01 {

    public static void main(String[]  args){
        Scanner sc = new Scanner(System.in);

        System.out.print("점수를 입력해주세요. : ");
        int score = sc.nextInt();

        if(score  >= 90){
            System.out.println('A');
        }else if(score >= 80){
            System.out.println('B');
        }else if(score >= 70){
            System.out.println('C');
        }else{
            System.out.println('F');
        }
    }

}
