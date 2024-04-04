package day02;

public class EX03 {
    public static void main(String[] args) {
        Person1 dragon = new Person1("dragon", 5000, "010-1234-5678");
    }
}


class Person1{
    String name;
    int age;
    String phone;

    Person1(String name, int age, String phone){
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
}
