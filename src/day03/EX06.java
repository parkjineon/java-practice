package day03;

public class EX06 {
    public static void main(String[] args) {

        //ApplePhone : 배터리용량(100), isOn : 전원 켜짐 여부 확인
            //charge() - 10
            //useKakaotalk() -5
            //useYoutube() -10
            //배터리 용량 확인
            //turnOn
            //turnOff

        //Person => ApplePhone 모든 기능을 사용

        // SamsungPhone: 배터리용량(120)




        ApplePhone applePhone = new ApplePhone();
        Person person = new Person(applePhone);
        person.chargePhone();
        person.turnOnPhone();
        person.sendMessage();
        person.watchYoutube();
        person.getPhoneBattery();
        person.turnOffPhone();

        System.out.println("삼성 폰으로 바꾸자!");

        SamsungPhone samsungPhone = new SamsungPhone();
        person.setPhone(samsungPhone);
        person.chargePhone();
        person.turnOnPhone();
        person.sendMessage();
        person.watchYoutube();
        person.getPhoneBattery();
        person.turnOffPhone();

    }
}

interface Phone{
    // 1. 구현체가 어떤 게 오든 받아줄 수 있게 타입형태로 제시하기 위함
    //    => implemts Phone
    //    * 추상 클래스는 extends 공통 기능 상속
    //    * 인터페이스는 implements 공통 규약, 구현

    // 2. 구형체(객체)를 필요 = 구현체 사용 = 메소드를 호출
    //    메소드를 호출
    //    메소드 선언(명, 매개변수) 통일
    //    * 인터페이스는 implements 공통 규약, 구현
    void isBatteryOverZero(int usage);

    void charge();

    void operateKakaotalk();

    void operateYoutube();

    void getBattery();

    void turnOn();

    void turnOff();
}



class ApplePhone implements Phone{
    private final int BATTERY_CAPA = 100;

    private int batteryStatus = 70;
    private boolean isOn = false;

    public void isBatteryOverZero(int usage){
        if(this.isOn){
            if(this.batteryStatus - usage < 0){
                System.out.printf("배터리 %d%% 부족으로 사용이 불가능합니다.\n",usage-this.batteryStatus);
            }else if(this.batteryStatus - usage == 0){
                this.batteryStatus = 0;
                System.out.println("배터리 0%입니다..");
                turnOff();
            }else{
                this.batteryStatus -= usage;
                System.out.printf("배터리 %d%% 사용하였습니다.\n", usage);
            }
        }else{
            System.out.println("전원이 꺼져있습니다.");
        }

    }


    @Override
    public void charge() {

        this.batteryStatus += 10;

        if(this.batteryStatus > BATTERY_CAPA){
            this.batteryStatus = BATTERY_CAPA;
        }

        System.out.printf("배터리 %d%% 충전 완료되었습니다.\n", this.batteryStatus);
    }

    @Override
    public void operateKakaotalk() {
        isBatteryOverZero(5);
    }

    @Override
    public void operateYoutube() {
        isBatteryOverZero(10);
    }

    @Override
    public void getBattery() {
        System.out.printf("남은 배터리는 %d%%입니다.\n",this.batteryStatus);
    }

    @Override
    public void turnOn() {
        if(this.batteryStatus <= 0){
            System.out.println("배터리 0%로 전원을 켤 수 없습니다..");
        }else if(!this.isOn){
            System.out.println("전원이 켜집니다.");
            this.isOn = true;
        }else{
            System.out.println("전원이 켜져있습니다.");
        }

    }

    @Override
    public void turnOff() {
        if(!this.isOn){
            this.isOn = true;
            System.out.println("전원이 꺼집니다.");
        }else{
            System.out.println("전원이 꺼져있습니다.");
        }

    }
}


class SamsungPhone implements Phone{
    private final int BATTERY_CAPA = 120;

    private int batteryStatus = 80;
    private boolean isOn = false;

    public void isBatteryOverZero(int usage){
        if(this.isOn){
            if(this.batteryStatus - usage < 0){
                System.out.printf("배터리 %d%% 부족으로 사용이 불가능합니다.\n",usage-this.batteryStatus);
            }else if(this.batteryStatus - usage == 0){
                this.batteryStatus = 0;
                System.out.println("배터리 0%입니다..");
                turnOff();
            }else{
                this.batteryStatus -= usage;
                System.out.printf("배터리 %d%% 사용하였습니다.\n", usage);
            }
        }else{
            System.out.println("전원이 꺼져있습니다.");
        }

    }


    @Override
    public void charge() {

        this.batteryStatus += 10;

        if(this.batteryStatus > BATTERY_CAPA){
            this.batteryStatus = BATTERY_CAPA;
        }

        System.out.printf("배터리 %d%% 충전 완료되었습니다.\n", this.batteryStatus);
    }

    @Override
    public void operateKakaotalk() {
        isBatteryOverZero(10);
    }

    @Override
    public void operateYoutube() {
        isBatteryOverZero(20);
    }

    @Override
    public void getBattery() {
        System.out.printf("남은 배터리는 %d%%입니다.\n",this.batteryStatus);
    }

    @Override
    public void turnOn() {
        if(this.batteryStatus <= 0){
            System.out.println("배터리 0%로 전원을 켤 수 없습니다..");
        }else if(!this.isOn){
            System.out.println("전원이 켜집니다.");
            this.isOn = true;
        }else{
            System.out.println("전원이 켜져있습니다.");
        }

    }

    @Override
    public void turnOff() {
        if(!this.isOn){
            this.isOn = true;
            System.out.println("전원이 꺼집니다.");
        }else{
            System.out.println("전원이 꺼져있습니다.");
        }

    }
}



class Person{

    Phone phone;

    Person(Phone phone){
        this.phone = phone;
    }

    void setPhone(Phone phone) { this.phone = phone; }
    void chargePhone(){
        phone.charge();
    }

    void sendMessage(){
        phone.operateKakaotalk();
    }

    void watchYoutube(){
        phone.operateYoutube();
    }

    void getPhoneBattery(){
        phone.getBattery();
    }

    void turnOnPhone(){
        phone.turnOn();
    }

    void turnOffPhone(){
        phone.turnOff();
    }
}

