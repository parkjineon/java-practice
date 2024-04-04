package day01;

public class EX07 {
    public static void main(String[] args) {
        // 객체 생성
        // 객체의 변수 출력

        Notebook Samsung = new Notebook("삼성");
        Notebook LG = new Notebook("엘지");

        System.out.println(Samsung.brand);
        System.out.println(LG.brand);

    }
}

class Notebook{
    String brand;

    Notebook(String brand){
        this.brand = brand;
    }
}