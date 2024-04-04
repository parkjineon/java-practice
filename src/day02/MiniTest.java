package day02;

public class MiniTest {
    public static void main(String[] args) {
        Store store = new Store();

        Person sony = new Person("쏘니","Korean");
        Person beckham = new Person("베컴", "English");

        Phone sonyPhone = sony.buyPhone(store,"Samsung");
        Phone beckhamPhone = beckham.buyPhone(store,"Apple");

        System.out.println();

        sony.turnOnPhone(sonyPhone);
        beckham.turnOnPhone(beckhamPhone);
    }
}


class Store{

    Store(){
    };


    Phone sellPhone(String lang){
        if(lang == "Samsung"){
            return new SamsungPhone();
        }else if(lang == "Apple"){
            return new ApplePhone();
        }

        return new Phone();
    }
}

class Person{
    private String name;
    private String lang;
    Person(String name, String lang){
        this.name = name;
        this.lang = lang;
    };
    Phone buyPhone(Store store,String brand){
        System.out.printf("%s(는)은 핸드폰을 샀습니다.\n", this.name);
        return store.sellPhone(brand);
    }
    void turnOnPhone(Phone phone){
        System.out.printf("%s(이)가 핸드폰을 켰습니다.\n", this.name);

        if(this.lang.equals("Korean")) {
            System.out.println("내 핸드폰 켜볼게.");
        }else if(this.lang.equals("English")){
            System.out.println("I'll turn on my phone.");
        }

        phone.turnOn();
    }
}


class Phone{

    Phone(){}

    void turnOn(){
        System.out.println("띠리리");
    }
}


class SamsungPhone extends Phone{
    SamsungPhone(){
        super();
    }

    void turnOn(){
        System.out.println("삐삐빅");
    }

}


class ApplePhone extends Phone{
    ApplePhone(){
        super();
    }


    void turnOn(){
        System.out.println("Beep");
    }
}