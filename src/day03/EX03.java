package day03;

import java.util.HashMap;

public class EX03 {
    public static void main(String[] args) {
    // class Garden
    // getSound(동물) : 매개변수.cry();
    // class Dog, Cat extends Pet
    // cry()

        Garden garden = new Garden();
        Dog dog = new Dog();
        Cat cat = new Cat();

        HashMap<String,Integer> newMap = new HashMap<>();

    }
}


class Garden{

    void getSound(Pet pet){
        pet.cry();
    }
}

abstract class Pet{
    void cry(){}
}

class Dog extends Pet{

    @Override
    void cry(){
        System.out.println("멍멍");
    }
}

class Cat extends Pet{

    @Override
    void cry(){
        System.out.println("야옹");
    }
}




