package day03;

public class EX04 {
    public static void main(String[] args) {
        //레시피 - 슈퍼 : getInfo 이 레시피 00의 레시피
        //파스타레시피 - 자식: makeSource
        //스테이크레시피 : grill

        Pasta pasta = new Pasta("jineon");
        Stake stake = new Stake("jineon");

        pasta.getInfo();
        stake.getInfo();


    }
}

abstract class Recipe{

    String name;

    Recipe(String name){
         this.name = name;
    }

    void getInfo(){
        System.out.printf("%s님의 레시피입니다.", this.name);
    }
}

class Pasta extends Recipe{

    Pasta(String name){
        super(name);
    }

    @Override
    void getInfo() {
        super.getInfo();
        makeSource();
    }

    void makeSource(){
        System.out.println("소스 만들기");
    }

}

class Stake extends Recipe{
    Stake(String name){
        super(name);
    }

    @Override
    void getInfo() {
        super.getInfo();
        grill();
    }

    void grill(){
        System.out.println("스테이크 굽기");
    }
}