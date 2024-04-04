package day01;

public class EX06 {

    public static void main(String[] args) {

        Person jineon = new Person("진언");
        Person kelly = new Person("켈리");
        Person jason = new Person("제이슨");


        System.out.print(kelly.name);
    }
}

class Person{
    // 변수 (= 부품)
    String name;


    // 생성자
    Person(String name){
        this.name = name;
    };
}
