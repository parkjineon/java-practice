package day02;

// 상속
public class EX04 {
    public static void main(String[] args) {
        Car bus = new Bus();
        bus.ride();
        bus.getWheelNum();
//        bus.ring();

        Taxi taxi = new Taxi();
        taxi.ride();
        bus.getWheelNum();

    }
}

class  Car{
    int wheel;

    Car(int wheel){
        this.wheel = wheel;
    }

    void getWheelNum(){
        System.out.printf("바퀴 수는 %d개입니다.\n",wheel);
    }

    void ride(){
        System.out.println("부아아앙");
    }

}

class Bus extends Car{
    Bus(){
        super(4);
    }
    void ride(){
        System.out.println("부릉부릉");
    }

    void ring(){
        System.out.println("삐이");
    }
}

class Taxi extends Car{

    Taxi(){
        super(4);
    }


    void ride(){
        System.out.println("빵빵");
    }
}
