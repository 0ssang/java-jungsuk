package jungsuk.ch7;
class MyTv2{
    private boolean isPowerOn;
    private int channel;
    private int volume;

    private int previousChannel;

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public int getChannel(){
        return channel;
    }
    public int getVolume(){
        return volume;
    }
    public void setChannel(int channel){
        previousChannel = this.channel;
        this.channel = channel;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }
    public void gotoPrevChannel(){
        int temp = channel;
        channel = previousChannel;
        previousChannel = temp;
    }
}
public class Ex7_11 {
    public static void main(String[] args) {
        MyTv2 t = new MyTv2();
        t.setChannel(10);
        System.out.println("CH:"+t.getChannel());
        t.setChannel(20);
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:"+t.getChannel());
    }
}
