package day03;

public class EX01 {
    public static void main(String[] args) {
        //Cow, Chicken: cry() - "음메", "꼬끼오"
        //Farm: getSound()
        //Animal: 상속 - 오버라이딩

        Chicken chicken = new Chicken();
        Cow cow = new Cow();
        Farm farm = new Farm(cow, chicken);
        farm.getSound();
        farm.feed();


    }
}

class Farm{

    Cow cow;
    Chicken chicken;


    Farm(Cow cow, Chicken chicken){
        this.cow = cow;
        this.chicken = chicken;
    }

    void feed(){
        this.cow.eat();
        this.chicken.eat();
    }

    void getSound(){
        this.cow.cry();
        this.chicken.cry();
    }
}

class Animal{

    void eat(){
        System.out.println("냠냠");
    }

    void cry(){
        System.out.println("크아악");
    }
}

class Cow extends Animal{

    @Override
    void cry(){
        System.out.println("음메");
    }
}

class Chicken extends Animal{
    @Override
    void cry(){
        System.out.println("꼬끼오");
    }
}
