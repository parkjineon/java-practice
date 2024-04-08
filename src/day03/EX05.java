package day03;

public class EX05 {
    public static void main(String[] args) {
        // OTT: Netflix, Tving
        // printOpeningLogo( ) :sout "넷플" "티빙"
        // netflix.play() -> printOpen... "영상 시작"

        //netflix.finish() : sout "다 봤다~"


        Netflix netflix = new Netflix();
        netflix.play();
        netflix.finish();

        Tving tving = new Tving();
        tving.play();
        tving.finish();


    }
}


abstract class OTT{
    OTT(){}
    abstract void printOpenLogo();

    void play(){

        printOpenLogo();
        System.out.println("영상 시작");

    }

    void finish(){

        System.out.println("다 봤다~");

    }
}

class Netflix extends OTT{

    @Override
    void printOpenLogo(){
        System.out.println("Netflix");
    }

}

class Tving extends OTT{

    @Override
    void printOpenLogo(){
        System.out.println("Tving");
    }

}
