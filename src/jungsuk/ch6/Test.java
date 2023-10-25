package jungsuk.ch6;
class MyTv{
    boolean isPowerOn;
    int volume;
    final int MAX_VOL = 100;
    void turnOff(){
        isPowerOn = !isPowerOn;
    }
    void volumeUp(){
        if(volume < MAX_VOL) volume++;
    }
}
public class Test {
    public static void main(String[] args) {
    }
}
