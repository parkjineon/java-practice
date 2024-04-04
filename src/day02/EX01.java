package day02;

public class EX01 {
    public static void main(String[] args) {
        Animal pig = new Animal("돼지");
        pig.cry("꿀꿀");
    }
}

//동물

class Animal{
    String name;

    Animal(String name){
        this.name = name;
    }

    void cry(String sound){
        System.out.printf("%s는 %s", this.name, sound);
    }
}
