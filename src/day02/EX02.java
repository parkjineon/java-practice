package day02;

public class EX02 {
    public static void main(String[] args) {
        Coffee americano = new Coffee(4500,"ice","tall");
//        americano.setPrice(5000);
//        americano.getInfo();

        Barista chunsik = new Barista("춘식");
        chunsik.getCoffeeIno(americano);
        chunsik.makeCoffee();

    }

}

// 커피
// 필드: 가격, 핫 or 아이스, 사이즈
// 메소드 : getInfo - sout(가격, 핫 or 아이스, 사이즈)
class Coffee{
    private int price;
    private String temperature;
    private String size;

    Coffee(int price, String temperature, String size){
        this.price = price;
        this.temperature = temperature;
        this.size = size;
    }

    void setPrice(int price){
        //필드 값 설정 'set'
        // 변경할 값을 검증하는 용도로도 사용

        if(price >= 3000){
            this.price= price;
        }else{
            System.out.println("3000원 이상 입력하세요!");
        }

    }

    int getPrice(){
        return price;
    }

    void getInfo(){
        System.out.printf("이 커피는\n가격이 %d원이고 \n%s이며\n사이즈는 %s입니다.", this.price,this.temperature,this.size );
    }

}

class Barista{
    String name;

    Barista(String name){
        this.name = name;
    }

    void getCoffeeIno(Coffee coffee){
        System.out.printf("이 커피는 %d원입니다.\n",coffee.getPrice());
    }

    void makeCoffee(){
        System.out.println("커피 여기 있습니다.\n");
    }
}